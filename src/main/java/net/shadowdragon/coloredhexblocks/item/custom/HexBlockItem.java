package net.shadowdragon.coloredhexblocks.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import net.shadowdragon.coloredhexblocks.block.coloredblocks.HexBlockEntity;
import java.util.List;

public class HexBlockItem extends BlockItem implements DyeableItem{

    public int DefColor = HexBlockEntity.DEFAULT_COLOR;

    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
        setColor(stack, getColor(stack));
        super.onCraft(stack, world, player);
    }


    public HexBlockItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public int getColor(ItemStack stack) {
        NbtCompound nbtCompound = stack.getSubNbt(DISPLAY_KEY);
        if (nbtCompound != null && nbtCompound.contains(COLOR_KEY, NbtElement.NUMBER_TYPE)) {
            return nbtCompound.getInt(COLOR_KEY);
        }
        return DefColor;
    }

    @Override
    public ActionResult place(ItemPlacementContext context) {
        ActionResult result = super.place(context);
        BlockEntity blockEntity = context.getWorld().getBlockEntity(context.getBlockPos());
        if(blockEntity instanceof HexBlockEntity hexBlockEntity){
            hexBlockEntity.color = getColor(context.getStack());
        }
        return result;
    }
    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {


        /*var c = getColor(itemStack);
        var r = Math.floor(c / (256*256));
        var g = Math.floor(c / 256) % 256;
        var b = c % 256;*/

        tooltip.add(Text.translatable("Color: " + getColor(itemStack)));

        /*
        tooltip.add(Text.translatable("Red: "  + r).formatted(Formatting.RED));
        tooltip.add(Text.translatable("Green: " + g).formatted(Formatting.GREEN));
        tooltip.add(Text.translatable("Blue: " + b).formatted(Formatting.BLUE));*/

    }
}


