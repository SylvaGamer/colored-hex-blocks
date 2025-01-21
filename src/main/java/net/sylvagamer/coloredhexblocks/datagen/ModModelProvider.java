package net.sylvagamer.coloredhexblocks.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.HEX_BLOCK);
        //blockStateModelGenerator.registerTintedBlockAndItem(ModBlocks.HEX_BLOCK, TexturedModel.CUBE_ALL,0);
        //DyeTintSource dye = new DyeTintSource(0);
        //blockStateModelGenerator.registerTintedItemModel(ModBlocks.HEX_BLOCK, Identifier.of("hex_block"),dye);
        //blockStateModelGenerator.registerTintableCross(ModBlocks.HEX_FENCE, BlockStateModelGenerator.CrossType.TINTED);


/*
        BlockStateModelGenerator.BlockTexturePool hexTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.HEX_BLOCK);
        hexTexturePool.stairs(ModBlocks.HEX_STAIRS);
        hexTexturePool.slab(ModBlocks.HEX_SLAB);
        hexTexturePool.button(ModBlocks.HEX_BUTTON);
        hexTexturePool.pressurePlate(ModBlocks.HEX_PRESSURE_PLATE);
        hexTexturePool.fence(ModBlocks.HEX_FENCE);
        hexTexturePool.fenceGate(ModBlocks.HEX_FENCE_GATE);
        hexTexturePool.wall(ModBlocks.HEX_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.HEX_WOODEN_DOOR);
        blockStateModelGenerator.registerDoor(ModBlocks.HEX_IRON_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.HEX_WOODEN_TRAPDOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.HEX_IRON_TRAPDOOR);
*/
    }


    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        //DyeTintSource dye = new DyeTintSource(0);
        //itemModelGenerator.registerWithTintedLayer(ModBlocks.HEX_BLOCK.asItem(),"_overlay", dye);
    }
}
