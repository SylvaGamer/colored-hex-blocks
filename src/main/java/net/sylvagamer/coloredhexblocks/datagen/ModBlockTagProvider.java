package net.sylvagamer.coloredhexblocks.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.sylvagamer.coloredhexblocks.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.HEX_BLOCK)
                .add(ModBlocks.HEX_FENCE)
                .add(ModBlocks.HEX_WALL)
                .add(ModBlocks.HEX_FENCE_GATE)
                .add(ModBlocks.HEX_IRON_DOOR)
                .add(ModBlocks.HEX_IRON_TRAPDOOR)
                .add(ModBlocks.HEX_FENCE_GATE)
                .add(ModBlocks.HEX_BUTTON)
                .add(ModBlocks.HEX_PRESSURE_PLATE)
                .add(ModBlocks.HEX_SLAB)
                .add(ModBlocks.HEX_WOODEN_DOOR)
                .add(ModBlocks.HEX_WOODEN_TRAPDOOR)
                .add(ModBlocks.HEX_STAIRS);

        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.HEX_FENCE);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.HEX_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.HEX_WALL);

    }
}
