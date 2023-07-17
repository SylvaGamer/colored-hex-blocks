package net.shadowdragon.coloredhexblocks.recipe;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.shadowdragon.coloredhexblocks.ColoredHexBlocks;

public class HexRecipes {
    public static void registerRecipes(){

        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(ColoredHexBlocks.MOD_ID, HexBlockRecipe.Serializer.ID),
                HexBlockRecipe.Serializer.INSTANCE);

        Registry.register(Registries.RECIPE_TYPE, new Identifier(ColoredHexBlocks.MOD_ID, HexBlockRecipe.Type.ID),
                HexBlockRecipe.Type.INSTANCE);
    }
}
