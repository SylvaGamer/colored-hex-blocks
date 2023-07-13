package net.shadowdragon.coloredhexblocks.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.shadowdragon.coloredhexblocks.ColoredHexBlocks;
import net.shadowdragon.coloredhexblocks.block.ModHexBlocks;


public class HexItems {

    private static void addItemsToBuildingBlocksItemGroup(FabricItemGroupEntries entries){
        entries.add(ModHexBlocks.HEX_BLOCK);
    }
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(ColoredHexBlocks.MOD_ID, name), item);
    }

    public static void registerModItems(){
        ColoredHexBlocks.LOGGER.info("Registering Mod Items for " + ColoredHexBlocks.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(HexItems::addItemsToBuildingBlocksItemGroup);
    }



}
