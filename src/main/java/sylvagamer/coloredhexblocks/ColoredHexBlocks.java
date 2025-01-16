package sylvagamer.coloredhexblocks;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sylvagamer.coloredhexblocks.block.ModBlocks;
import sylvagamer.coloredhexblocks.item.ModItemGroups;
import sylvagamer.coloredhexblocks.item.ModItems;

public class ColoredHexBlocks implements ModInitializer {
	public static final String MOD_ID = "coloredhexblocks";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}