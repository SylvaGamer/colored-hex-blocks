package net.shadowdragon.coloredhexblocks;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockRenderView;
import net.shadowdragon.coloredhexblocks.block.ModHexBlocks;
import net.shadowdragon.coloredhexblocks.block.custom.HexBlockEntity;
import net.shadowdragon.coloredhexblocks.item.custom.HexBlockItem;
import org.jetbrains.annotations.Nullable;


public class ColoredHexBlocksClient implements ClientModInitializer {


    public void onInitializeClient() {
        registerBlockColor(ModHexBlocks.HEX_BLOCK);
        registerBlockColor(ModHexBlocks.HEX_STAIRS);
        registerBlockColor(ModHexBlocks.HEX_SLAB);
    }


    private void registerBlockColor(Block ModHexBlocksItems) {
        registerItemColor(ModHexBlocksItems);
        ColorProviderRegistry.BLOCK.register(new BlockColorProvider() {
            @Override
            public int getColor(BlockState state, @Nullable BlockRenderView world, @Nullable BlockPos pos, int tintIndex) {

                int color = HexBlockEntity.getColor(world,pos);
                return color;
            }
    },ModHexBlocksItems);
    }

    private void registerItemColor(Block ModHexBlocksItems) {
        ColorProviderRegistry.ITEM.register(new ItemColorProvider() {
            @Override
            public int getColor(ItemStack stack, int tintIndex)
            {
                NbtCompound nbtCompound = stack.getSubNbt(HexBlockItem.DISPLAY_KEY);
                if (nbtCompound != null && nbtCompound.contains(HexBlockItem.COLOR_KEY, NbtElement.NUMBER_TYPE)) {
                    return nbtCompound.getInt(HexBlockItem.COLOR_KEY);
                }
                return HexBlockEntity.DEFAULT_COLOR;
            }
        },ModHexBlocksItems);
    }

}