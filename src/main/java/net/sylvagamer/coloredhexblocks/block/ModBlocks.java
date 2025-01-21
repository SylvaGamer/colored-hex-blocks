package net.sylvagamer.coloredhexblocks.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.sylvagamer.coloredhexblocks.ColoredHexBlocks;
import net.sylvagamer.coloredhexblocks.block.custom.*;

public class ModBlocks {

    public static final Block HEX_BLOCK = registerBlock("hex_block",
            new HexBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ColoredHexBlocks.MOD_ID,"hex_block")))
                    .strength(1.8f).requiresTool().sounds(BlockSoundGroup.STONE)));

    public static final Block HEX_STAIRS = registerBlock("hex_stairs",
            new HexStairs(ModBlocks.HEX_BLOCK.getDefaultState(),
                    AbstractBlock.Settings.create()
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ColoredHexBlocks.MOD_ID,"hex_stairs")))
                            .strength(1.8f).requiresTool()));

    public static final Block HEX_SLAB = registerBlock("hex_slab",
            new HexSlab(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ColoredHexBlocks.MOD_ID,"hex_slab")))
                    .strength(1.8f).requiresTool()));

    public static final Block HEX_BUTTON = registerBlock("hex_button",
            new HexButton(BlockSetType.IRON, 2,
                    AbstractBlock.Settings.create()
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ColoredHexBlocks.MOD_ID,"hex_button")))
                            .strength(1.8f).requiresTool().noCollision()));

    public static final Block HEX_PRESSURE_PLATE = registerBlock("hex_pressure_plate",
            new HexPressurePlate(BlockSetType.IRON,
                    AbstractBlock.Settings.create()
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ColoredHexBlocks.MOD_ID,"hex_pressure_plate")))
                            .strength(1.8f).requiresTool()));

    public static final Block HEX_FENCE = registerBlock("hex_fence",
            new HexFence(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ColoredHexBlocks.MOD_ID,"hex_fence")))
                    .strength(1.8f).requiresTool()));

    public static final Block HEX_FENCE_GATE = registerBlock("hex_fence_gate",
            new HexFenceGate(WoodType.ACACIA,
                    AbstractBlock.Settings.create()
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ColoredHexBlocks.MOD_ID,"hex_fence_gate")))
                            .strength(1.8f).requiresTool()));

    public static final Block HEX_WALL = registerBlock("hex_wall",
            new HexWall(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ColoredHexBlocks.MOD_ID,"hex_wall")))
                    .strength(1.8f).requiresTool()));

    public static final Block HEX_IRON_DOOR = registerBlock("hex_iron_door",
            new HexIronDoor(BlockSetType.IRON,
                    AbstractBlock.Settings.create()
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ColoredHexBlocks.MOD_ID,"hex_iron_door")))
                            .strength(1.8f).requiresTool().nonOpaque()));

    public static final Block HEX_IRON_TRAPDOOR = registerBlock("hex_iron_trapdoor",
            new HexIronTrapdoor(BlockSetType.IRON,
                    AbstractBlock.Settings.create()
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ColoredHexBlocks.MOD_ID,"hex_iron_trapdoor")))
                            .strength(1.8f).requiresTool().nonOpaque()));

    public static final Block HEX_WOODEN_DOOR = registerBlock("hex_wooden_door",
            new HexWoodenDoor(BlockSetType.ACACIA,
                    AbstractBlock.Settings.create()
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ColoredHexBlocks.MOD_ID,"hex_wooden_door")))
                            .strength(1.8f).requiresTool().nonOpaque()));

    public static final Block HEX_WOODEN_TRAPDOOR = registerBlock("hex_wooden_trapdoor",
            new HexWoodenTrapdoor(BlockSetType.ACACIA,
                    AbstractBlock.Settings.create()
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ColoredHexBlocks.MOD_ID,"hex_wooden_trapdoor")))
                            .strength(1.8f).requiresTool().nonOpaque()));

    public static final Block HEX_GLASS_BLOCK = registerBlock("hex_glass",
            new HexGlassBlock(AbstractBlock.Settings.copy(Blocks.WHITE_STAINED_GLASS)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ColoredHexBlocks.MOD_ID, "hex_glass")))));

    public static final Block HEX_GLASS_PANE = registerBlock("hex_glass_pane",
            new HexGlassPaneBlock(AbstractBlock.Settings.copy(Blocks.WHITE_STAINED_GLASS_PANE)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ColoredHexBlocks.MOD_ID, "hex_glass_pane")))));

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
            entries.add(ModBlocks.HEX_FENCE);
            entries.add(ModBlocks.HEX_IRON_TRAPDOOR);
            entries.add(ModBlocks.HEX_WOODEN_TRAPDOOR);
            entries.add(ModBlocks.HEX_IRON_DOOR);
            entries.add(ModBlocks.HEX_WOODEN_DOOR);
            entries.add(ModBlocks.HEX_WALL);
            entries.add(ModBlocks.HEX_BUTTON);
            entries.add(ModBlocks.HEX_SLAB);
            entries.add(ModBlocks.HEX_FENCE_GATE);
            entries.add(ModBlocks.HEX_PRESSURE_PLATE);
            entries.add(ModBlocks.HEX_STAIRS);
            entries.add(ModBlocks.HEX_GLASS_BLOCK);
            entries.add(ModBlocks.HEX_GLASS_PANE);
        });
    }
}
