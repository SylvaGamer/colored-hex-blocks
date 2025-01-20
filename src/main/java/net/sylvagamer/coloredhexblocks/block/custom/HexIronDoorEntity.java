package net.sylvagamer.coloredhexblocks.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.component.ComponentMap;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.DyedColorComponent;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockRenderView;
import net.sylvagamer.coloredhexblocks.ModBlockEntities;
import org.jetbrains.annotations.Nullable;

public class HexIronDoorEntity extends BlockEntity {

    public static final int DEFAULT_COLOR = 16777215;
    public int color = DEFAULT_COLOR;

    public HexIronDoorEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.HEX_IRON_DOOR_ENTITY,pos, state);
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
            return HexIronDoorEntity.DEFAULT_COLOR;
        }
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if(blockEntity instanceof HexIronDoorEntity hexBlockEntity){
            return hexBlockEntity.color;
        } else {
            return HexIronDoorEntity.DEFAULT_COLOR;
        }

    }
}
