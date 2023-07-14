package net.shadowdragon.coloredhexblocks.block.custom;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.BlockView;
import net.shadowdragon.coloredhexblocks.ColoredHexBlocks;
import net.shadowdragon.coloredhexblocks.block.HexBlockInterface;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class HexBlock extends Block implements HexBlockInterface,BlockEntityProvider {
    public HexBlock(Settings settings) {
        super(settings);
    }
    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        ItemStack stack = super.getPickStack(world, pos, state);
        return pickBlock(world,pos,stack);
    }
    @Override
    public BlockState getAppearance(BlockState state, BlockRenderView renderView, BlockPos pos, Direction side, @Nullable BlockState sourceState, @Nullable BlockPos sourcePos) {
        return super.getAppearance(state, renderView, pos, side, sourceState, sourcePos);
    }
}
