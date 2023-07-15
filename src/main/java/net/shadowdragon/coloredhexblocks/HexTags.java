package net.shadowdragon.coloredhexblocks;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class HexTags {
    public static class Blocks{

        private static TagKey<Block> createBlockTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(ColoredHexBlocks.MOD_ID, name));
        }

        private static TagKey<Block> createCommonBlockTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, new Identifier("c", name));
        }
    }

    public static class Items{
        public static final TagKey<Item> CONCRETE =
                createBlockTag("concrete");

        public static final TagKey<Item> TERRACOTTA =
                createBlockTag("terracotta");
        private static TagKey<Item> createBlockTag(String name){
            return TagKey.of(RegistryKeys.ITEM, new Identifier(ColoredHexBlocks.MOD_ID, name));
        }

        private static TagKey<Item> createCommonBlockTag(String name){
            return TagKey.of(RegistryKeys.ITEM, new Identifier("c", name));
        }
    }

}
