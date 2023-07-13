package net.shadowdragon.coloredhexblocks.block.custom;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class HexBlock extends Block implements BlockEntityProvider {
    public HexBlock(Settings settings) {
        super(settings);
    }
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new HexBlockEntity(pos, state);
    }

    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        ItemStack stack = super.getPickStack(world, pos, state);
        int color = HexBlockEntity.getColor(world, pos);
        NbtCompound nbt = new NbtCompound();
        nbt.putInt("color", color);
        stack.setNbt(nbt);
        return stack;
    }

}
