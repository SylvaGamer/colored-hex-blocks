package net.shadowdragon.coloredhexblocks;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.shadowdragon.coloredhexblocks.block.ModHexBlockEntities;
import net.shadowdragon.coloredhexblocks.block.ModHexBlocks;
import net.shadowdragon.coloredhexblocks.block.coloredblocks.HexBlockEntity;
import net.shadowdragon.coloredhexblocks.item.HexItemGroups;
import net.shadowdragon.coloredhexblocks.item.HexItems;
import net.shadowdragon.coloredhexblocks.networking.HexMessages;
import net.shadowdragon.coloredhexblocks.recipe.HexRecipes;
import net.shadowdragon.coloredhexblocks.screen.HexScreenHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static net.shadowdragon.coloredhexblocks.block.ModHexBlocks.HEX_BLOCK;
import static net.shadowdragon.coloredhexblocks.block.ModHexBlocks.registerModBlocks;

public class ColoredHexBlocks implements ModInitializer {

	public static final String MOD_ID = "colored-hex-blocks";
    public static final Logger LOGGER = LoggerFactory.getLogger("colored-hex-blocks");

	public static final BlockEntityType<HexBlockEntity> HEX_BLOCK_ENTITY = Registry.register(
			Registries.BLOCK_ENTITY_TYPE,
			new Identifier(ColoredHexBlocks.MOD_ID, "hex_block_entity"),
			FabricBlockEntityTypeBuilder.create(HexBlockEntity::new, HEX_BLOCK).build()
	);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		HexItems.registerModItems();
		HexItemGroups.registerItemGroups();
		ModHexBlocks.registerModBlocks();
		ModHexBlockEntities.registerBlockEntities();
		HexScreenHandler.registerScreenHandler();
		HexRecipes.registerRecipes();
		HexMessages.registerC2SPackets();
	}
}