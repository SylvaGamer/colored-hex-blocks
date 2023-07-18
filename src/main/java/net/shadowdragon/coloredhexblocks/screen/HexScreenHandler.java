package net.shadowdragon.coloredhexblocks.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.shadowdragon.coloredhexblocks.ColoredHexBlocks;

public class HexScreenHandler {
    public static final ScreenHandlerType<DyeingStationScreenHandler> DYEING_STATION_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(ColoredHexBlocks.MOD_ID, "dying_station_screen_handler"),
                    new ExtendedScreenHandlerType<>(DyeingStationScreenHandler::new));
    public static void registerScreenHandler(){
        ColoredHexBlocks.LOGGER.info("Registering Screen Handler for " + ColoredHexBlocks.MOD_ID);
    }
}
