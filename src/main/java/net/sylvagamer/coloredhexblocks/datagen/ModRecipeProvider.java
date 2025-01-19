package net.sylvagamer.coloredhexblocks.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.registry.RegistryWrapper;
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

                /* BASIC HEX BLOCK
                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HEX_BLOCK)
                        .input(ItemTags.TERRACOTTA)
                        .input(Items.WHITE_DYE)
                        .criterion(hasItem(Items.WHITE_DYE),conditionsFromItem(Items.WHITE_DYE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(ColoredHexBlocks.MOD_ID,"hex_block_shapeless")));
                 */
            }
        };
    }

    @Override
    public String getName() {
        return "Colored Hex Blocks Recipes";
    }
}
