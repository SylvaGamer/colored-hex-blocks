package net.shadowdragon.coloredhexblocks.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.shadowdragon.coloredhexblocks.ColoredHexBlocks;
import net.shadowdragon.coloredhexblocks.block.custom.HexBlock;
import net.shadowdragon.coloredhexblocks.block.custom.HexStairsBlock;
import net.shadowdragon.coloredhexblocks.item.custom.HexBlockItem;


public class ModHexBlocks {
    public static final Block HEX_BLOCK = registerBlock("hex_block",
        new HexBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE)));
    public static final Block HEX_STAIRS = registerBlock("hex_stairs",
    new HexStairsBlock(HEX_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(ColoredHexBlocks.MOD_ID, name), block);

    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(ColoredHexBlocks.MOD_ID, name),
                new HexBlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks(){
        ColoredHexBlocks.LOGGER.info("Registering ModBlocks for " + ColoredHexBlocks.MOD_ID);
    }
}
