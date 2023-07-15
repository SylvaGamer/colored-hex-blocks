package net.shadowdragon.coloredhexblocks;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.shadowdragon.coloredhexblocks.datagen.BlockTagProvider;
import net.shadowdragon.coloredhexblocks.datagen.ItemTagProvider;
import net.shadowdragon.coloredhexblocks.datagen.RecipeProvider;

public class DataGeneration implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        // This is where providers are added
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(BlockTagProvider::new);
        pack.addProvider(ItemTagProvider::new);
        pack.addProvider(RecipeProvider::new);
    }
}