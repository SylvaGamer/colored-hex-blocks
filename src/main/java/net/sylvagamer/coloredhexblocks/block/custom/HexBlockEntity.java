package net.sylvagamer.coloredhexblocks.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.sylvagamer.coloredhexblocks.ColoredHexBlocks;

public class HexBlockEntity extends BlockEntity {

    public static final int DEFAULT_COLOR = 16777215;
    public int color = DEFAULT_COLOR;
    public HexBlockEntity(BlockPos pos, BlockState state){
        super(ColoredHexBlocks.HEX_BLOCK_ENTITY, pos, state);
    }



}
