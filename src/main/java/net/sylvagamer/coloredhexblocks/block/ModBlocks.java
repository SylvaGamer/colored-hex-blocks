package net.sylvagamer.coloredhexblocks.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.sylvagamer.coloredhexblocks.ColoredHexBlocks;
import net.sylvagamer.coloredhexblocks.block.custom.HexBlock;

public class ModBlocks {

    public static final Block HEX_BLOCK = registerBlock("hex_block",
            new HexBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ColoredHexBlocks.MOD_ID,"hex_block")))
                    .strength(1.8f).requiresTool().sounds(BlockSoundGroup.STONE)));


    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK,Identifier.of(ColoredHexBlocks.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(ColoredHexBlocks.MOD_ID, name),
                new BlockItem(block, new Item.Settings()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ColoredHexBlocks.MOD_ID,name)))
                        .useBlockPrefixedTranslationKey()));
    }

    public static void registerModBlocks(){
        ColoredHexBlocks.LOGGER.info("Registering Mod Blocks for " + ColoredHexBlocks.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.HEX_BLOCK);
        });
    }
}
