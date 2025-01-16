package sylvagamer.coloredhexblocks.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import sylvagamer.coloredhexblocks.ColoredHexBlocks;
import sylvagamer.coloredhexblocks.block.ModBlocks;

public class ModItemGroups {

    public static final ItemGroup HEX_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ColoredHexBlocks.MOD_ID, "colored_hex_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.HEX_BLOCK)).displayName(Text.translatable("itemgroup.coloredhexblocks.colored_hex_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.HEX_BLOCK);

                    }).build()
    );


    public static void registerItemGroups(){
        ColoredHexBlocks.LOGGER.info("Regestering Item Groups for " + ColoredHexBlocks.MOD_ID);
    }


}