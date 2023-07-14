package net.shadowdragon.coloredhexblocks.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.shadowdragon.coloredhexblocks.ColoredHexBlocks;
import net.shadowdragon.coloredhexblocks.block.ModHexBlocks;

public class HexItemGroups {


        public static final ItemGroup HEX_GROUP = Registry.register(Registries.ITEM_GROUP,
                new Identifier(ColoredHexBlocks.MOD_ID, "hex_blocks"),
                FabricItemGroup.builder().displayName(Text.translatable("itemgroup.hex_blocks"))
                        .icon(() -> new ItemStack(ModHexBlocks.HEX_BLOCK)).entries((displayContext, entries) -> {
                            entries.add(ModHexBlocks.HEX_BLOCK);
                            entries.add(ModHexBlocks.HEX_STAIRS);
                            entries.add(ModHexBlocks.HEX_SLAB);
                        }).build());

        public static void registerItemGroups(){
            ColoredHexBlocks.LOGGER.info("Registering Item Groups for " +ColoredHexBlocks.MOD_ID);
        }
    }
