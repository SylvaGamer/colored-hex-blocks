package net.shadowdragon.coloredhexblocks.block;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.shadowdragon.coloredhexblocks.ColoredHexBlocks;
import net.shadowdragon.coloredhexblocks.block.craftingstation.DyeingStationBlockEntity;

public class ModHexBlockEntities {
    public static final BlockEntityType<DyeingStationBlockEntity> DYEING_STATION_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(ColoredHexBlocks.MOD_ID, "dyeing_station_block_entity"),
                    FabricBlockEntityTypeBuilder.create(DyeingStationBlockEntity::new,
                            ModHexBlocks.DYEING_STATION).build(null));
    public static void registerBlockEntities(){
        ColoredHexBlocks.LOGGER.info("Registering Block Entities for " + ColoredHexBlocks.MOD_ID);
    }

}
