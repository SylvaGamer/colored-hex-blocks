package net.sylvagamer.coloredhexblocks;

import net.fabricmc.api.ModInitializer;
import net.sylvagamer.coloredhexblocks.block.ModBlocks;
import net.sylvagamer.coloredhexblocks.item.ModItemGroups;
import net.sylvagamer.coloredhexblocks.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ColoredHexBlocks implements ModInitializer {
	public static final String MOD_ID = "coloredhexblocks";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);







	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModBlockEntities.initialize();
	}


}