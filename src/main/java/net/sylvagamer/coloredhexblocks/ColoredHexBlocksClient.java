package net.sylvagamer.coloredhexblocks;


import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.render.RenderLayer;
import net.sylvagamer.coloredhexblocks.block.ModBlocks;
import net.sylvagamer.coloredhexblocks.block.custom.*;

public class ColoredHexBlocksClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> HexBlockEntity.getColor(world,pos), ModBlocks.HEX_BLOCK);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> HexFenceEntity.getColor(world,pos), ModBlocks.HEX_FENCE);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> HexButtonEntity.getColor(world,pos), ModBlocks.HEX_BUTTON);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> HexIronDoorEntity.getColor(world,pos), ModBlocks.HEX_IRON_DOOR);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> HexWoodenDoorEntity.getColor(world,pos), ModBlocks.HEX_WOODEN_DOOR);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> HexWoodenTrapdoorEntity.getColor(world,pos), ModBlocks.HEX_WOODEN_TRAPDOOR);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> HexIronTrapdoorEntity.getColor(world,pos), ModBlocks.HEX_IRON_TRAPDOOR);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> HexPressurePlateEntity.getColor(world,pos), ModBlocks.HEX_PRESSURE_PLATE);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> HexSlabEntity.getColor(world,pos), ModBlocks.HEX_SLAB);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> HexStairsEntity.getColor(world,pos), ModBlocks.HEX_STAIRS);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> HexWallEntity.getColor(world,pos), ModBlocks.HEX_WALL);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> HexFenceGateEntity.getColor(world,pos), ModBlocks.HEX_FENCE_GATE);


        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HEX_IRON_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HEX_IRON_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HEX_WOODEN_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HEX_WOODEN_TRAPDOOR, RenderLayer.getCutout());
    }



}
