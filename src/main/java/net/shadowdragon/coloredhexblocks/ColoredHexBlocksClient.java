package net.shadowdragon.coloredhexblocks;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.shadowdragon.coloredhexblocks.block.ModHexBlocks;
import net.shadowdragon.coloredhexblocks.block.custom.HexBlockEntity;
import net.shadowdragon.coloredhexblocks.item.custom.HexBlockItem;


public class ColoredHexBlocksClient implements ClientModInitializer {


    public void onInitializeClient() {
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) ->
                HexBlockEntity.getColor(world,pos), ModHexBlocks.HEX_BLOCK);

        ColorProviderRegistry.ITEM.register(new ItemColorProvider() {
            @Override
            public int getColor(ItemStack stack, int layer)
            {
                NbtCompound nbtCompound = stack.getSubNbt(HexBlockItem.DISPLAY_KEY);
                if (nbtCompound != null && nbtCompound.contains(HexBlockItem.COLOR_KEY, NbtElement.NUMBER_TYPE)) {
                    return nbtCompound.getInt(HexBlockItem.COLOR_KEY);
                }
                return HexBlockEntity.DEFAULT_COLOR;
            }
        }, ModHexBlocks.HEX_BLOCK);
    }
}