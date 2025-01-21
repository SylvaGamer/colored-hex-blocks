package net.sylvagamer.coloredhexblocks;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.sylvagamer.coloredhexblocks.datagen.ModBlockTagProvider;
import net.sylvagamer.coloredhexblocks.datagen.ModItemTagProvider;
import net.sylvagamer.coloredhexblocks.datagen.ModModelProvider;
import net.sylvagamer.coloredhexblocks.datagen.ModRecipeProvider;

public class ColoredHexBlocksDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		//pack.addProvider(ModLootTableProvider::new);
		//pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);



	}
}
