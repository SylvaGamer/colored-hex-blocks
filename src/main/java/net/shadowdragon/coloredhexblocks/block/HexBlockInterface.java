package net.shadowdragon.coloredhexblocks.block;

import net.minecraft.block.BlockEntityProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.shadowdragon.coloredhexblocks.block.custom.HexBlockEntity;

public interface HexBlockInterface extends BlockEntityProvider {

    public default ItemStack pickBlock(BlockView world, BlockPos pos, ItemStack stack){
        int color = HexBlockEntity.getColor(world, pos);
        NbtCompound nbt = new NbtCompound();
        nbt.putInt("color", color);
        stack.setNbt(nbt);
        return stack;
    }
}
