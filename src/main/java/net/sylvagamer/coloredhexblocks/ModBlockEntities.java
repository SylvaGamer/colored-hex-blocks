package net.sylvagamer.coloredhexblocks;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sylvagamer.coloredhexblocks.block.custom.*;

import static net.sylvagamer.coloredhexblocks.block.ModBlocks.*;

public class ModBlockEntities {

    public static final BlockEntityType<HexBlockEntity> HEX_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(ColoredHexBlocks.MOD_ID, "hex_block_entity"),
            FabricBlockEntityTypeBuilder.create(HexBlockEntity::new, HEX_BLOCK).build()
    );

    public static final BlockEntityType<HexFenceEntity> HEX_FENCE_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(ColoredHexBlocks.MOD_ID, "hex_fence_entity"),
            FabricBlockEntityTypeBuilder.create(HexFenceEntity::new, HEX_FENCE).build()
    );

    public static final BlockEntityType<HexButtonEntity> HEX_BUTTON_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(ColoredHexBlocks.MOD_ID, "hex_button_entity"),
            FabricBlockEntityTypeBuilder.create(HexButtonEntity::new, HEX_BUTTON).build()
    );

    public static final BlockEntityType<HexIronDoorEntity> HEX_IRON_DOOR_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(ColoredHexBlocks.MOD_ID, "hex_iron_door_entity"),
            FabricBlockEntityTypeBuilder.create(HexIronDoorEntity::new, HEX_IRON_DOOR).build()
    );
    public static final BlockEntityType<HexIronTrapdoorEntity> HEX_IRON_TRAPDOOR_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(ColoredHexBlocks.MOD_ID, "hex_iron_trapdoor_entity"),
            FabricBlockEntityTypeBuilder.create(HexIronTrapdoorEntity::new, HEX_IRON_TRAPDOOR).build()
    );

    public static final BlockEntityType<HexWoodenDoorEntity> HEX_WOODEN_DOOR_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(ColoredHexBlocks.MOD_ID, "hex_wooden_door_entity"),
            FabricBlockEntityTypeBuilder.create(HexWoodenDoorEntity::new, HEX_WOODEN_DOOR).build()
    );
    public static final BlockEntityType<HexWoodenTrapdoorEntity> HEX_WOODEN_TRAPDOOR_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(ColoredHexBlocks.MOD_ID, "hex_wooden_trapdoor_entity"),
            FabricBlockEntityTypeBuilder.create(HexWoodenTrapdoorEntity::new, HEX_WOODEN_TRAPDOOR).build()
    );

    public static final BlockEntityType<HexStairsEntity> HEX_STAIRS_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(ColoredHexBlocks.MOD_ID, "hex_stairs_entity"),
            FabricBlockEntityTypeBuilder.create(HexStairsEntity::new, HEX_STAIRS).build()
    );

    public static final BlockEntityType<HexWallEntity> HEX_WALL_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(ColoredHexBlocks.MOD_ID, "hex_wall_entity"),
            FabricBlockEntityTypeBuilder.create(HexWallEntity::new, HEX_WALL).build()
    );

    public static final BlockEntityType<HexSlabEntity> HEX_SLAB_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(ColoredHexBlocks.MOD_ID, "hex_slab_entity"),
            FabricBlockEntityTypeBuilder.create(HexSlabEntity::new, HEX_SLAB).build()
    );
    public static final BlockEntityType<HexFenceGateEntity> HEX_FENCE_GATE_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(ColoredHexBlocks.MOD_ID, "hex_fence_gate_entity"),
            FabricBlockEntityTypeBuilder.create(HexFenceGateEntity::new, HEX_FENCE_GATE).build()
    );

    public static final BlockEntityType<HexPressurePlateEntity> HEX_PRESSURE_PLATE_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(ColoredHexBlocks.MOD_ID, "hex_pressure_plate_entity"),
            FabricBlockEntityTypeBuilder.create(HexPressurePlateEntity::new, HEX_PRESSURE_PLATE).build()
    );

    public static void initialize(){

    }

}
