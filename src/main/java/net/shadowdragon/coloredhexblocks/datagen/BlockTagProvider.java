package net.shadowdragon.coloredhexblocks.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.shadowdragon.coloredhexblocks.block.ModHexBlocks;
import java.util.concurrent.CompletableFuture;

public class BlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public BlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {


        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModHexBlocks.HEX_BLOCK)
                .add(ModHexBlocks.HEX_SLAB)
                .add(ModHexBlocks.HEX_WALL_BLOCK)
                .add(ModHexBlocks.HEX_FENCE_GATE_BLOCK)
                .add(ModHexBlocks.HEX_STAIRS)
                .add(ModHexBlocks.HEX_FENCE_BLOCK);

        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModHexBlocks.HEX_FENCE_BLOCK);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModHexBlocks.HEX_FENCE_GATE_BLOCK);
        getOrCreateTagBuilder(BlockTags.IMPERMEABLE)
                .add(ModHexBlocks.HEX_GLASS_BLOCK);
        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(ModHexBlocks.HEX_SLAB);
        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(ModHexBlocks.HEX_STAIRS);
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModHexBlocks.HEX_WALL_BLOCK);
    }



}
