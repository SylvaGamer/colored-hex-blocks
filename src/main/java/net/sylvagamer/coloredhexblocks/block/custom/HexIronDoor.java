package net.sylvagamer.coloredhexblocks.block.custom;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.DyedColorComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.sylvagamer.coloredhexblocks.ColoredHexBlocks;
import net.sylvagamer.coloredhexblocks.ModBlockEntities;
import org.jetbrains.annotations.Nullable;

public class HexIronDoor extends DoorBlock implements BlockEntityProvider {
    public HexIronDoor(BlockSetType type, Settings settings) {
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
        return new HexIronDoorEntity(pos, state);
    }



    public ItemStack pickBlock(BlockView world, BlockPos pos, ItemStack stack, boolean includeData){
        HexIronDoorEntity blockEntity = ModBlockEntities.HEX_IRON_DOOR_ENTITY.get(world,pos);
        int color = HexIronDoorEntity.DEFAULT_COLOR;
        if(blockEntity != null){
            color = blockEntity.color;
        }
        DyedColorComponent dyeComponent = new DyedColorComponent(color,true);
        stack.set(DataComponentTypes.DYED_COLOR, dyeComponent);
        return stack;
    }
}
