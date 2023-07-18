package net.shadowdragon.coloredhexblocks.compat;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.shadowdragon.coloredhexblocks.recipe.HexBlockRecipe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DyeingStationDisplay extends BasicDisplay {
        public DyeingStationDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs) {
                super(inputs, outputs);
        }

        public DyeingStationDisplay(HexBlockRecipe recipe){
                super(getInputList(recipe), List.of(EntryIngredient.of(EntryStacks.of(recipe.getOutput(null)))));

        }

        private static List<EntryIngredient> getInputList(HexBlockRecipe recipe) {
                if(recipe==null) return Collections.emptyList();
                List<EntryIngredient> list = new ArrayList<>();
                list.add(EntryIngredients.ofIngredient(recipe.getIngredients().get(0)));
                return list;
        }

        @Override
        public CategoryIdentifier<?> getCategoryIdentifier() {
                return DyeingStationCategory.DYING_STATION;
        }
}
