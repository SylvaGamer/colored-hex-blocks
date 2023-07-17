package net.shadowdragon.coloredhexblocks.recipe;

import net.minecraft.recipe.CraftingRecipe;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public interface HexRecipeTypes<T extends RecipeType<?>> {
    public static final RecipeType<HexBlockRecipe> DYING_STATION = RecipeType.register("dying_station");
}