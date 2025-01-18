package net.sylvagamer.coloredhexblocks.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.loot.v3.FabricLootPoolBuilder;
import net.minecraft.block.Block;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.function.ConditionalLootFunction;
import net.minecraft.loot.function.CopyComponentsLootFunction;
import net.minecraft.loot.function.LootFunction;
import net.minecraft.loot.function.SetLootTableLootFunction;
import net.minecraft.registry.RegistryWrapper;
import net.sylvagamer.coloredhexblocks.block.ModBlocks;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {

    }
}
