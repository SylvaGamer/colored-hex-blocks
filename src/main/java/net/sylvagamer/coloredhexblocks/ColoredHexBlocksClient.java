package net.sylvagamer.coloredhexblocks;


import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.sylvagamer.coloredhexblocks.block.ModBlocks;
import net.sylvagamer.coloredhexblocks.block.custom.HexBlockEntity;

public class ColoredHexBlocksClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> HexBlockEntity.getColor(world,pos), ModBlocks.HEX_BLOCK);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> HexBlockEntity.getColor(world,pos), ModBlocks.HEX_FENCE);
    }



}
