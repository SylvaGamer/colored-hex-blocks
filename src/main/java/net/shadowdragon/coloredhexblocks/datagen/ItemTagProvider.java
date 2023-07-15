package net.shadowdragon.coloredhexblocks.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.shadowdragon.coloredhexblocks.HexTags;
import java.util.concurrent.CompletableFuture;

public class ItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(HexTags.Items.CONCRETE)
                .add(Item.fromBlock(Blocks.CYAN_CONCRETE))
                .add(Item.fromBlock(Blocks.BLACK_CONCRETE))
                .add(Item.fromBlock(Blocks.BLUE_CONCRETE))
                .add(Item.fromBlock(Blocks.WHITE_CONCRETE))
                .add(Item.fromBlock(Blocks.GRAY_CONCRETE))
                .add(Item.fromBlock(Blocks.BROWN_CONCRETE))
                .add(Item.fromBlock(Blocks.GREEN_CONCRETE))
                .add(Item.fromBlock(Blocks.LIGHT_BLUE_CONCRETE))
                .add(Item.fromBlock(Blocks.LIGHT_GRAY_CONCRETE))
                .add(Item.fromBlock(Blocks.LIME_CONCRETE))
                .add(Item.fromBlock(Blocks.MAGENTA_CONCRETE))
                .add(Item.fromBlock(Blocks.ORANGE_CONCRETE))
                .add(Item.fromBlock(Blocks.PINK_CONCRETE))
                .add(Item.fromBlock(Blocks.PURPLE_CONCRETE))
                .add(Item.fromBlock(Blocks.RED_CONCRETE))
                .add(Item.fromBlock(Blocks.YELLOW_CONCRETE));

        getOrCreateTagBuilder(HexTags.Items.TERRACOTTA)
                .add(Item.fromBlock(Blocks.TERRACOTTA))
                .add(Item.fromBlock(Blocks.CYAN_TERRACOTTA))
                .add(Item.fromBlock(Blocks.BLACK_TERRACOTTA))
                .add(Item.fromBlock(Blocks.BLUE_TERRACOTTA))
                .add(Item.fromBlock(Blocks.WHITE_TERRACOTTA))
                .add(Item.fromBlock(Blocks.GRAY_TERRACOTTA))
                .add(Item.fromBlock(Blocks.BROWN_TERRACOTTA))
                .add(Item.fromBlock(Blocks.GREEN_TERRACOTTA))
                .add(Item.fromBlock(Blocks.LIGHT_BLUE_TERRACOTTA))
                .add(Item.fromBlock(Blocks.LIGHT_GRAY_TERRACOTTA))
                .add(Item.fromBlock(Blocks.LIME_TERRACOTTA))
                .add(Item.fromBlock(Blocks.MAGENTA_TERRACOTTA))
                .add(Item.fromBlock(Blocks.ORANGE_TERRACOTTA))
                .add(Item.fromBlock(Blocks.PINK_TERRACOTTA))
                .add(Item.fromBlock(Blocks.PURPLE_TERRACOTTA))
                .add(Item.fromBlock(Blocks.RED_TERRACOTTA))
                .add(Item.fromBlock(Blocks.YELLOW_TERRACOTTA));
    }
}
