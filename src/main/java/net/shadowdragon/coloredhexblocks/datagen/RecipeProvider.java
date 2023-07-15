package net.shadowdragon.coloredhexblocks.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.shadowdragon.coloredhexblocks.HexTags;
import net.shadowdragon.coloredhexblocks.block.ModHexBlocks;
import java.util.List;
import java.util.function.Consumer;

public class RecipeProvider extends FabricRecipeProvider {
    public RecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModHexBlocks.HEX_BLOCK)
                .pattern("SSS")
                .pattern("SPS")
                .pattern("SSS")
                .input('S', Items.WHITE_DYE)
                .input('P', HexTags.Items.TERRACOTTA)
                .criterion(hasItem(Items.WHITE_CONCRETE), conditionsFromItem(Items.WHITE_CONCRETE))
                .criterion(hasItem(ModHexBlocks.HEX_BLOCK), conditionsFromItem(ModHexBlocks.HEX_BLOCK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModHexBlocks.HEX_GLASS_PANE_BLOCK)
                .pattern("SSS")
                .pattern("SSS")
                .input('S', ModHexBlocks.HEX_GLASS_BLOCK)
                .criterion(hasItem(ModHexBlocks.HEX_GLASS_BLOCK), conditionsFromItem(ModHexBlocks.HEX_GLASS_BLOCK))
                .offerTo(exporter);

        offerSmelting(exporter, List.of(ModHexBlocks.HEX_BLOCK),
                RecipeCategory.MISC,ModHexBlocks.HEX_GLASS_BLOCK,0.25f,200,"hex_glass");


        createStairsRecipe(ModHexBlocks.HEX_STAIRS, Ingredient.ofItems(ModHexBlocks.HEX_BLOCK))
                .criterion(hasItem(ModHexBlocks.HEX_BLOCK), conditionsFromItem(ModHexBlocks.HEX_BLOCK)).offerTo(exporter);

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModHexBlocks.HEX_SLAB, Ingredient.ofItems(ModHexBlocks.HEX_BLOCK))
                .criterion(hasItem(ModHexBlocks.HEX_BLOCK), conditionsFromItem(ModHexBlocks.HEX_BLOCK)).offerTo(exporter);

        createFenceRecipe(ModHexBlocks.HEX_FENCE_BLOCK,Ingredient.ofItems(ModHexBlocks.HEX_BLOCK))
                .criterion(hasItem(ModHexBlocks.HEX_BLOCK), conditionsFromItem(ModHexBlocks.HEX_BLOCK)).offerTo(exporter);

        createFenceGateRecipe(ModHexBlocks.HEX_FENCE_GATE_BLOCK,Ingredient.ofItems(ModHexBlocks.HEX_BLOCK))
                .criterion(hasItem(ModHexBlocks.HEX_BLOCK), conditionsFromItem(ModHexBlocks.HEX_BLOCK)).offerTo(exporter);

        offerWallRecipe(exporter,RecipeCategory.BUILDING_BLOCKS,ModHexBlocks.HEX_WALL_BLOCK,ModHexBlocks.HEX_BLOCK);
        offerStonecuttingRecipe(exporter,RecipeCategory.BUILDING_BLOCKS,ModHexBlocks.HEX_WALL_BLOCK,ModHexBlocks.HEX_BLOCK);
        offerStonecuttingRecipe(exporter,RecipeCategory.BUILDING_BLOCKS,ModHexBlocks.HEX_SLAB,ModHexBlocks.HEX_BLOCK);
        offerStonecuttingRecipe(exporter,RecipeCategory.BUILDING_BLOCKS,ModHexBlocks.HEX_STAIRS,ModHexBlocks.HEX_BLOCK);
    }
}
