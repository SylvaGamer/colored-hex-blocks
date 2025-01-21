package net.sylvagamer.coloredhexblocks.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sylvagamer.coloredhexblocks.ColoredHexBlocks;

public class ModItems {
    //ITEM EXAMPLE \/
    //public static final Item HEX_BLOCK = regesterItem("hex_block", new Item(new Item.Settings()));

    private static Item regesterItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(ColoredHexBlocks.MOD_ID, name), item);
    }

    public static void registerModItems(){
        ColoredHexBlocks.LOGGER.info("Registering Mod Items for " + ColoredHexBlocks.MOD_ID);

        //ITEM GROUP EXAMPLE
        //ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
        //    entries.add(HEX_BLOCK);
        //});


    }



}
