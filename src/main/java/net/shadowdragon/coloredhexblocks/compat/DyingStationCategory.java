package net.shadowdragon.coloredhexblocks.compat;

import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.shadowdragon.coloredhexblocks.ColoredHexBlocks;
import net.shadowdragon.coloredhexblocks.block.ModHexBlocks;

import java.util.LinkedList;
import java.util.List;

public class DyingStationCategory implements DisplayCategory<BasicDisplay> {
    public static final Identifier TEXTURE =
            new Identifier(ColoredHexBlocks.MOD_ID, "textures/gui/dying_station_gui.png");
    public static final CategoryIdentifier<DyingStationDisplay> DYING_STATION =
            CategoryIdentifier.of(ColoredHexBlocks.MOD_ID,"dying_station");
    @Override
    public CategoryIdentifier<? extends BasicDisplay> getCategoryIdentifier() {
        return DYING_STATION;
    }

    @Override
    public Text getTitle() {
        return Text.literal("Dying Station");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(ModHexBlocks.DYING_STATION.asItem().getDefaultStack());
    }

    @Override
    public List<Widget> setupDisplay(BasicDisplay display, Rectangle bounds) {
        Point startPoint = new Point(bounds.getCenterX() - 87, bounds.getCenterY()  -35);
        List<Widget> widgets = new LinkedList<>();
        widgets.add(Widgets.createTexturedWidget(TEXTURE,
                new Rectangle(startPoint.x, startPoint.y, 175,82)));

        widgets.add(Widgets.createSlot(new Point(startPoint.x + 62, startPoint.y +50))
                .entries(display.getInputEntries().get(0)));

        widgets.add(Widgets.createSlot(new Point(startPoint.x + 116, startPoint.y +50))
                .markOutput().entries(display.getOutputEntries().get(0)));

        return widgets;
    }

    @Override
    public int getDisplayHeight() {
        return 90;
    }
}
