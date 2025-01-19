package net.sylvagamer.coloredhexblocks;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sylvagamer.coloredhexblocks.block.custom.HexBlock;
import net.sylvagamer.coloredhexblocks.block.custom.HexBlockEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.sylvagamer.coloredhexblocks.block.ModBlocks;
import net.sylvagamer.coloredhexblocks.item.ModItemGroups;
import net.sylvagamer.coloredhexblocks.item.ModItems;
import static net.sylvagamer.coloredhexblocks.block.ModBlocks.HEX_BLOCK;
import static net.sylvagamer.coloredhexblocks.block.ModBlocks.HEX_FENCE;

public class ColoredHexBlocks implements ModInitializer {
	public static final String MOD_ID = "coloredhexblocks";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final BlockEntityType<HexBlockEntity> HEX_BLOCK_ENTITY = Registry.register(
			Registries.BLOCK_ENTITY_TYPE,
			Identifier.of(ColoredHexBlocks.MOD_ID, "hex_block_entity"),
			FabricBlockEntityTypeBuilder.create(HexBlockEntity::new, HEX_BLOCK).build()
	);



	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}


}