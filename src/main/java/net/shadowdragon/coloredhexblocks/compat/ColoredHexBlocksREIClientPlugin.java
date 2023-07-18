package net.shadowdragon.coloredhexblocks.compat;

import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.shadowdragon.coloredhexblocks.block.ModHexBlocks;
import net.shadowdragon.coloredhexblocks.recipe.HexBlockRecipe;
import net.shadowdragon.coloredhexblocks.screen.DyeingStationScreen;

public class ColoredHexBlocksREIClientPlugin implements REIClientPlugin {
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new DyeingStationCategory());

        registry.addWorkstations(DyeingStationCategory.DYING_STATION, EntryStacks.of(ModHexBlocks.DYEING_STATION));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(HexBlockRecipe.class, HexBlockRecipe.Type.INSTANCE,
                DyeingStationDisplay::new);
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerClickArea(screen -> new Rectangle(((screen.width - 176)/2)+78,
                        ((screen.height - 166)/2)+30,20,30), DyeingStationScreen.class,
                DyeingStationCategory.DYING_STATION);
    }
}
