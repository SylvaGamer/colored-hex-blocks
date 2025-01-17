package net.sylvagamer.coloredhexblocks.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.TexturedModel;
import net.minecraft.client.render.item.tint.DyeTintSource;
import net.minecraft.client.render.item.tint.TintSource;
import net.minecraft.client.render.item.tint.TintSourceTypes;
import net.minecraft.util.Identifier;
import net.sylvagamer.coloredhexblocks.block.ModBlocks;
import org.w3c.dom.Text;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.HEX_BLOCK);

        //blockStateModelGenerator.registerTintedBlockAndItem(ModBlocks.HEX_BLOCK, TexturedModel.CUBE_ALL,0);


        //DyeTintSource dye = new DyeTintSource(0);
        //blockStateModelGenerator.registerTintedItemModel(ModBlocks.HEX_BLOCK, Identifier.of("hex_block"),dye);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        DyeTintSource dye = new DyeTintSource(0);
        itemModelGenerator.registerWithTintedLayer(ModBlocks.HEX_BLOCK.asItem(),"_overlay", dye);
    }
}
