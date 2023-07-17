package net.shadowdragon.coloredhexblocks;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.shadowdragon.coloredhexblocks.block.ModHexBlocks;
import net.shadowdragon.coloredhexblocks.block.coloredblocks.HexBlockEntity;
import net.shadowdragon.coloredhexblocks.item.custom.HexBlockItem;
import net.shadowdragon.coloredhexblocks.screen.DyingStationScreen;
import net.shadowdragon.coloredhexblocks.screen.HexScreenHandler;


public class ColoredHexBlocksClient implements ClientModInitializer {


    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModHexBlocks.HEX_GLASS_PANE_BLOCK, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModHexBlocks.HEX_GLASS_BLOCK, RenderLayer.getTranslucent());
        registerBlockColor(ModHexBlocks.HEX_BLOCK);
        registerBlockColor(ModHexBlocks.HEX_STAIRS);
        registerBlockColor(ModHexBlocks.HEX_SLAB);
        registerBlockColor(ModHexBlocks.HEX_WALL_BLOCK);
        registerBlockColor(ModHexBlocks.HEX_FENCE_BLOCK);
        registerBlockColor(ModHexBlocks.HEX_FENCE_GATE_BLOCK);
        registerBlockColor(ModHexBlocks.HEX_GLASS_BLOCK);
        registerBlockColor(ModHexBlocks.HEX_GLASS_PANE_BLOCK);

        HandledScreens.register(HexScreenHandler.DYING_STATION_SCREEN_HANDLER, DyingStationScreen::new);
    }


    private void registerBlockColor(Block ModHexBlocksItems) {
        registerItemColor(ModHexBlocksItems);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> HexBlockEntity.getColor(world,pos),ModHexBlocksItems);
    }

    private void registerItemColor(Block ModHexBlocksItems) {
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
            NbtCompound nbtCompound = stack.getSubNbt(HexBlockItem.DISPLAY_KEY);
            if (nbtCompound != null && nbtCompound.contains(HexBlockItem.COLOR_KEY, NbtElement.NUMBER_TYPE)) {
                return nbtCompound.getInt(HexBlockItem.COLOR_KEY);
            }
            return HexBlockEntity.DEFAULT_COLOR;
        },ModHexBlocksItems);
    }

}