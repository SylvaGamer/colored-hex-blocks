package net.shadowdragon.coloredhexblocks.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.shadowdragon.coloredhexblocks.HexTags;
import java.util.concurrent.CompletableFuture;
import static net.minecraft.item.Item.fromBlock;

public class ItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(HexTags.Items.CONCRETE)
                .add(fromBlock(Blocks.CYAN_CONCRETE))
                .add(fromBlock(Blocks.BLACK_CONCRETE))
                .add(fromBlock(Blocks.BLUE_CONCRETE))
                .add(fromBlock(Blocks.WHITE_CONCRETE))
                .add(fromBlock(Blocks.GRAY_CONCRETE))
                .add(fromBlock(Blocks.BROWN_CONCRETE))
                .add(fromBlock(Blocks.GREEN_CONCRETE))
                .add(fromBlock(Blocks.LIGHT_BLUE_CONCRETE))
                .add(fromBlock(Blocks.LIGHT_GRAY_CONCRETE))
                .add(fromBlock(Blocks.LIME_CONCRETE))
                .add(fromBlock(Blocks.MAGENTA_CONCRETE))
                .add(fromBlock(Blocks.ORANGE_CONCRETE))
                .add(fromBlock(Blocks.PINK_CONCRETE))
                .add(fromBlock(Blocks.PURPLE_CONCRETE))
                .add(fromBlock(Blocks.RED_CONCRETE))
                .add(fromBlock(Blocks.YELLOW_CONCRETE));

        getOrCreateTagBuilder(HexTags.Items.TERRACOTTA)
                .add(fromBlock(Blocks.TERRACOTTA))
                .add(fromBlock(Blocks.CYAN_TERRACOTTA))
                .add(fromBlock(Blocks.BLACK_TERRACOTTA))
                .add(fromBlock(Blocks.BLUE_TERRACOTTA))
                .add(fromBlock(Blocks.WHITE_TERRACOTTA))
                .add(fromBlock(Blocks.GRAY_TERRACOTTA))
                .add(fromBlock(Blocks.BROWN_TERRACOTTA))
                .add(fromBlock(Blocks.GREEN_TERRACOTTA))
                .add(fromBlock(Blocks.LIGHT_BLUE_TERRACOTTA))
                .add(fromBlock(Blocks.LIGHT_GRAY_TERRACOTTA))
                .add(fromBlock(Blocks.LIME_TERRACOTTA))
                .add(fromBlock(Blocks.MAGENTA_TERRACOTTA))
                .add(fromBlock(Blocks.ORANGE_TERRACOTTA))
                .add(fromBlock(Blocks.PINK_TERRACOTTA))
                .add(fromBlock(Blocks.PURPLE_TERRACOTTA))
                .add(fromBlock(Blocks.RED_TERRACOTTA))
                .add(fromBlock(Blocks.YELLOW_TERRACOTTA));
    }
}
