package net.shadowdragon.coloredhexblocks.block.coloredblocks;

import net.minecraft.block.*;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.BlockView;
import net.shadowdragon.coloredhexblocks.block.HexBlockInterface;
import org.jetbrains.annotations.Nullable;

public class HexGlassBlock extends StainedGlassBlock implements HexBlockInterface,BlockEntityProvider {

    public HexGlassBlock(DyeColor color, Settings settings) {
        super(color, settings);
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
