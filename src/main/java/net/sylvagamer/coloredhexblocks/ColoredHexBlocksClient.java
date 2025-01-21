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
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> HexBlock.HexBlockEntity.getColor(world,pos), ModBlocks.HEX_BLOCK);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> HexFence.HexFenceEntity.getColor(world,pos), ModBlocks.HEX_FENCE);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> HexButton.HexButtonEntity.getColor(world,pos), ModBlocks.HEX_BUTTON);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> HexIronDoor.HexIronDoorEntity.getColor(world,pos), ModBlocks.HEX_IRON_DOOR);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> HexWoodenDoor.HexWoodenDoorEntity.getColor(world,pos), ModBlocks.HEX_WOODEN_DOOR);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> HexWoodenTrapdoor.HexWoodenTrapdoorEntity.getColor(world,pos), ModBlocks.HEX_WOODEN_TRAPDOOR);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> HexIronTrapdoor.HexIronTrapdoorEntity.getColor(world,pos), ModBlocks.HEX_IRON_TRAPDOOR);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> HexPressurePlate.HexPressurePlateEntity.getColor(world,pos), ModBlocks.HEX_PRESSURE_PLATE);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> HexSlab.HexSlabEntity.getColor(world,pos), ModBlocks.HEX_SLAB);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> HexStairs.HexStairsEntity.getColor(world,pos), ModBlocks.HEX_STAIRS);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> HexWall.HexWallEntity.getColor(world,pos), ModBlocks.HEX_WALL);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> HexFenceGate.HexFenceGateEntity.getColor(world,pos), ModBlocks.HEX_FENCE_GATE);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> HexGlassBlock.HexGlassBlockEntity.getColor(world,pos), ModBlocks.HEX_GLASS_BLOCK);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> HexGlassPaneBlock.HexGlassPaneEntity.getColor(world,pos), ModBlocks.HEX_GLASS_PANE);



        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HEX_GLASS_BLOCK, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HEX_GLASS_PANE, RenderLayer.getTranslucent());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HEX_IRON_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HEX_IRON_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HEX_WOODEN_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HEX_WOODEN_TRAPDOOR, RenderLayer.getCutout());
    }



}
