package net.sylvagamer.coloredhexblocks.block.custom;

import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.component.ComponentMap;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.DyedColorComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import net.sylvagamer.coloredhexblocks.ModBlockEntities;
import org.jetbrains.annotations.Nullable;

public class HexWoodenDoor extends DoorBlock implements BlockEntityProvider {
    public HexWoodenDoor(BlockSetType type, Settings settings) {
        super(type, settings);
    }


    @Override
    protected ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state, boolean includeData) {
        ItemStack stack = super.getPickStack(world,pos,state,includeData);
        return pickBlock(world, pos, stack, includeData);


    }

    @Override
    public BlockState getAppearance(BlockState state, BlockRenderView renderView, BlockPos pos, Direction side, @Nullable BlockState sourceState, @Nullable BlockPos sourcePos) {
        return super.getAppearance(state, renderView, pos, side, sourceState, sourcePos);
    }


    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new HexWoodenDoorEntity(pos, state);
    }

    public ItemStack pickBlock(BlockView world, BlockPos pos, ItemStack stack, boolean includeData){
        HexWoodenDoorEntity blockEntity = ModBlockEntities.HEX_WOODEN_DOOR_ENTITY.get(world,pos);
        int color = HexWoodenDoorEntity.DEFAULT_COLOR;
        if(blockEntity != null){
            color = blockEntity.color;
        }
        DyedColorComponent dyeComponent = new DyedColorComponent(color,true);
        stack.set(DataComponentTypes.DYED_COLOR, dyeComponent);
        return stack;
    }

    public static class HexWoodenDoorEntity extends BlockEntity {

        public static final int DEFAULT_COLOR = 16777215;
        public int color = DEFAULT_COLOR;

        public HexWoodenDoorEntity(BlockPos pos, BlockState state) {
            super(ModBlockEntities.HEX_WOODEN_DOOR_ENTITY,pos, state);
        }


        @Override
        protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
            nbt.putInt("color", color);
            super.writeNbt(nbt, registries);
        }


        @Override
        protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
            super.readNbt(nbt, registries);
            color = nbt.getInt("color");
        }

        @Override
        public void removeFromCopiedStackNbt(NbtCompound nbt) {
            nbt.remove("color");
        }

        @Override
        protected void addComponents(ComponentMap.Builder builder) {
            super.addComponents(builder);
            DyedColorComponent dyedComponent = new DyedColorComponent(color,true);
            builder.add(DataComponentTypes.DYED_COLOR,dyedComponent);
        }

        @Override
        protected void readComponents(ComponentsAccess components) {
            super.readComponents(components);
            DyedColorComponent dyedComponent = new DyedColorComponent(DEFAULT_COLOR, true); //used if default
            color = components.getOrDefault(DataComponentTypes.DYED_COLOR,dyedComponent).rgb();
        }

        @Nullable
        @Override
        public Packet<ClientPlayPacketListener> toUpdatePacket() {
            return BlockEntityUpdateS2CPacket.create(this);
        }

        @Override
        public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registries) {
            return createNbt(registries);
        }

        public static int getColor(BlockRenderView world, BlockPos pos) {
            if(world==null){
                return HexWoodenDoorEntity.DEFAULT_COLOR;
            }


            BlockEntity blockEntity = world.getBlockEntity(pos);


            if(blockEntity instanceof HexWoodenDoorEntity hexBlockEntity){
                return hexBlockEntity.color;
            } else {
                return HexWoodenDoorEntity.DEFAULT_COLOR;
            }

        }
    }
}
