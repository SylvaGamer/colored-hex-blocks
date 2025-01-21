package net.sylvagamer.coloredhexblocks;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sylvagamer.coloredhexblocks.block.custom.*;

import static net.sylvagamer.coloredhexblocks.block.ModBlocks.*;

public class ModBlockEntities {

    public static final BlockEntityType<HexBlock.HexBlockEntity> HEX_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(ColoredHexBlocks.MOD_ID, "hex_block_entity"),
            FabricBlockEntityTypeBuilder.create(HexBlock.HexBlockEntity::new, HEX_BLOCK).build()
    );

    public static final BlockEntityType<HexFence.HexFenceEntity> HEX_FENCE_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(ColoredHexBlocks.MOD_ID, "hex_fence_entity"),
            FabricBlockEntityTypeBuilder.create(HexFence.HexFenceEntity::new, HEX_FENCE).build()
    );

    public static final BlockEntityType<HexButton.HexButtonEntity> HEX_BUTTON_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(ColoredHexBlocks.MOD_ID, "hex_button_entity"),
            FabricBlockEntityTypeBuilder.create(HexButton.HexButtonEntity::new, HEX_BUTTON).build()
    );

    public static final BlockEntityType<HexIronDoor.HexIronDoorEntity> HEX_IRON_DOOR_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(ColoredHexBlocks.MOD_ID, "hex_iron_door_entity"),
            FabricBlockEntityTypeBuilder.create(HexIronDoor.HexIronDoorEntity::new, HEX_IRON_DOOR).build()
    );
    public static final BlockEntityType<HexIronTrapdoor.HexIronTrapdoorEntity> HEX_IRON_TRAPDOOR_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(ColoredHexBlocks.MOD_ID, "hex_iron_trapdoor_entity"),
            FabricBlockEntityTypeBuilder.create(HexIronTrapdoor.HexIronTrapdoorEntity::new, HEX_IRON_TRAPDOOR).build()
    );

    public static final BlockEntityType<HexWoodenDoor.HexWoodenDoorEntity> HEX_WOODEN_DOOR_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(ColoredHexBlocks.MOD_ID, "hex_wooden_door_entity"),
            FabricBlockEntityTypeBuilder.create(HexWoodenDoor.HexWoodenDoorEntity::new, HEX_WOODEN_DOOR).build()
    );
    public static final BlockEntityType<HexWoodenTrapdoor.HexWoodenTrapdoorEntity> HEX_WOODEN_TRAPDOOR_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(ColoredHexBlocks.MOD_ID, "hex_wooden_trapdoor_entity"),
            FabricBlockEntityTypeBuilder.create(HexWoodenTrapdoor.HexWoodenTrapdoorEntity::new, HEX_WOODEN_TRAPDOOR).build()
    );

    public static final BlockEntityType<HexStairs.HexStairsEntity> HEX_STAIRS_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(ColoredHexBlocks.MOD_ID, "hex_stairs_entity"),
            FabricBlockEntityTypeBuilder.create(HexStairs.HexStairsEntity::new, HEX_STAIRS).build()
    );

    public static final BlockEntityType<HexWall.HexWallEntity> HEX_WALL_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(ColoredHexBlocks.MOD_ID, "hex_wall_entity"),
            FabricBlockEntityTypeBuilder.create(HexWall.HexWallEntity::new, HEX_WALL).build()
    );

    public static final BlockEntityType<HexSlab.HexSlabEntity> HEX_SLAB_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(ColoredHexBlocks.MOD_ID, "hex_slab_entity"),
            FabricBlockEntityTypeBuilder.create(HexSlab.HexSlabEntity::new, HEX_SLAB).build()
    );
    public static final BlockEntityType<HexFenceGate.HexFenceGateEntity> HEX_FENCE_GATE_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(ColoredHexBlocks.MOD_ID, "hex_fence_gate_entity"),
            FabricBlockEntityTypeBuilder.create(HexFenceGate.HexFenceGateEntity::new, HEX_FENCE_GATE).build()
    );

    public static final BlockEntityType<HexPressurePlate.HexPressurePlateEntity> HEX_PRESSURE_PLATE_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(ColoredHexBlocks.MOD_ID, "hex_pressure_plate_entity"),
            FabricBlockEntityTypeBuilder.create(HexPressurePlate.HexPressurePlateEntity::new, HEX_PRESSURE_PLATE).build()
    );

    public static final BlockEntityType<HexGlassBlock.HexGlassBlockEntity> HEX_GLASS_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(ColoredHexBlocks.MOD_ID, "hex_glass_entity"),
            FabricBlockEntityTypeBuilder.create(HexGlassBlock.HexGlassBlockEntity::new, HEX_GLASS_BLOCK).build()
    );

    public static final BlockEntityType<HexGlassPaneBlock.HexGlassPaneEntity> HEX_GLASS_PANE_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(ColoredHexBlocks.MOD_ID, "hex_glass_pane_entity"),
            FabricBlockEntityTypeBuilder.create(HexGlassPaneBlock.HexGlassPaneEntity::new, HEX_GLASS_PANE).build()
    );
    public static void initialize(){

    }

}
