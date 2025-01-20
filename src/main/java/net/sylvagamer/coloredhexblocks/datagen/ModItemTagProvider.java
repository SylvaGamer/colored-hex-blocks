package net.sylvagamer.coloredhexblocks.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.sylvagamer.coloredhexblocks.block.ModBlocks;
import net.sylvagamer.coloredhexblocks.block.custom.HexFence;
import net.sylvagamer.coloredhexblocks.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {


    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.DYE_ITEMS)
                .add(Items.WHITE_DYE)
                .add(Items.LIGHT_GRAY_DYE)
                .add(Items.GRAY_DYE)
                .add(Items.BLACK_DYE)
                .add(Items.BROWN_DYE)
                .add(Items.RED_DYE)
                .add(Items.ORANGE_DYE)
                .add(Items.YELLOW_DYE)
                .add(Items.LIME_DYE)
                .add(Items.GREEN_DYE)
                .add(Items.CYAN_DYE)
                .add(Items.LIGHT_BLUE_DYE)
                .add(Items.BLUE_DYE)
                .add(Items.PURPLE_DYE)
                .add(Items.MAGENTA_DYE)
                .add(Items.PINK_DYE);

        getOrCreateTagBuilder(ItemTags.DYEABLE)
                .add(ModBlocks.HEX_BLOCK.asItem())
                .add(ModBlocks.HEX_FENCE.asItem())
                .add(ModBlocks.HEX_FENCE_GATE.asItem())
                .add(ModBlocks.HEX_WALL.asItem())
                .add(ModBlocks.HEX_WOODEN_DOOR.asItem())
                .add(ModBlocks.HEX_WOODEN_TRAPDOOR.asItem())
                .add(ModBlocks.HEX_IRON_TRAPDOOR.asItem())
                .add(ModBlocks.HEX_IRON_DOOR.asItem())
                .add(ModBlocks.HEX_SLAB.asItem())
                .add(ModBlocks.HEX_BUTTON.asItem())
                .add(ModBlocks.HEX_PRESSURE_PLATE.asItem())
                .add(ModBlocks.HEX_STAIRS.asItem())
                ;
    }
}
