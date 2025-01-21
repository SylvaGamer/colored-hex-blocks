package net.sylvagamer.coloredhexblocks.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.sylvagamer.coloredhexblocks.ColoredHexBlocks;
import net.sylvagamer.coloredhexblocks.block.ModBlocks;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
//
//
//                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HEX_BLOCK)
//                        .input(ItemTags.TERRACOTTA)
//                        .input(Items.WHITE_DYE)
//                        .criterion(hasItem(Items.WHITE_DYE),conditionsFromItem(Items.WHITE_DYE))
//                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(ColoredHexBlocks.MOD_ID,"hex_block_shapeless")));
//
//                createButtonRecipe(ModBlocks.HEX_BUTTON, Ingredient.ofItem(ModBlocks.HEX_BLOCK));
//                getWallRecipe(RecipeCategory.BUILDING_BLOCKS,ModBlocks.HEX_WALL,Ingredient.ofItem(ModBlocks.HEX_BLOCK));
//                offerStainedGlassPaneRecipe(ModBlocks.HEX_GLASS_PANE,ModBlocks.HEX_GLASS_BLOCK);
//
//                offerSmelting(List.of(ModBlocks.HEX_BLOCK),RecipeCategory.BUILDING_BLOCKS,ModBlocks.HEX_GLASS_BLOCK,0.5f,50,"hex_glass_group");
//
//                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS,ModBlocks.HEX_SLAB, Ingredient.ofItem(ModBlocks.HEX_BLOCK));
//                createPressurePlateRecipe(RecipeCategory.REDSTONE,ModBlocks.HEX_PRESSURE_PLATE,Ingredient.ofItem(ModBlocks.HEX_BLOCK));
//
//                createStairsRecipe(ModBlocks.HEX_STAIRS, Ingredient.ofItem(ModBlocks.HEX_BLOCK));
//                createFenceRecipe(ModBlocks.HEX_FENCE, Ingredient.ofItem(ModBlocks.HEX_BLOCK));
//                createFenceGateRecipe(ModBlocks.HEX_FENCE_GATE, Ingredient.ofItem(ModBlocks.HEX_BLOCK));
//
//                createTrapdoorRecipe(ModBlocks.HEX_IRON_TRAPDOOR, Ingredient.ofItem(ModBlocks.HEX_BLOCK));
//                createTrapdoorRecipe(ModBlocks.HEX_WOODEN_TRAPDOOR, Ingredient.ofItem(ModBlocks.HEX_BLOCK));
//                createDoorRecipe(ModBlocks.HEX_IRON_DOOR, Ingredient.ofItem(ModBlocks.HEX_BLOCK));
//                createDoorRecipe(ModBlocks.HEX_WOODEN_DOOR, Ingredient.ofItem(ModBlocks.HEX_BLOCK));
//
//                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS,ModBlocks.HEX_WALL,ModBlocks.HEX_BLOCK,1);
//                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS,ModBlocks.HEX_SLAB,ModBlocks.HEX_BLOCK,2);
//                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS,ModBlocks.HEX_STAIRS,ModBlocks.HEX_BLOCK,1);
            }
        };
    }

    @Override
    public String getName() {
        return "Colored Hex Blocks Recipes";
    }
}
