package net.sylvagamer.coloredhexblocks.block;

import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.sylvagamer.coloredhexblocks.ColoredHexBlocks;
import net.sylvagamer.coloredhexblocks.block.custom.HexBlockEntity;

public interface HexBlockInterface extends BlockEntityProvider {
    default BlockEntity createBlockEntity(BlockPos pos, BlockState state){
        return new HexBlockEntity(pos, state);
    }

    default ItemStack pickBlock(BlockView world, BlockPos pos, ItemStack stack){
        HexBlockEntity blockEntity = ColoredHexBlocks.HEX_BLOCK_ENTITY.get(world,pos);
        int color = HexBlockEntity.DEFAULT_COLOR;
        if(blockEntity != null){
            color = blockEntity.color;
        }
        return stack;
    }

}
