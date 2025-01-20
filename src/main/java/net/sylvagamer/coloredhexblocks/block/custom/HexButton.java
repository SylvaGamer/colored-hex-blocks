package net.sylvagamer.coloredhexblocks.block.custom;

import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ButtonBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.DyedColorComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import net.sylvagamer.coloredhexblocks.ColoredHexBlocks;
import net.sylvagamer.coloredhexblocks.ModBlockEntities;
import org.jetbrains.annotations.Nullable;

public class HexButton extends ButtonBlock implements BlockEntityProvider {
    public HexButton(BlockSetType blockSetType, int pressTicks, Settings settings) {
        super(blockSetType, pressTicks, settings);
    }

    @Override
    protected ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state, boolean includeData) {
        ItemStack stack = super.getPickStack(world,pos,state,includeData);
        return pickBlock(world, pos, stack, includeData);
    }

    @Override
    public BlockState getAppearance(BlockState state, BlockRenderView renderView, BlockPos pos, Direction side, @Nullable BlockState sourceState, @Nullable BlockPos sourcePos) {
        return super.getAppearance(state, renderView, pos, side, sourceState, sourcePos);
    }


    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new HexButtonEntity(pos, state);
    }

    public ItemStack pickBlock(BlockView world, BlockPos pos, ItemStack stack, boolean includeData){
        HexButtonEntity blockEntity = ModBlockEntities.HEX_BUTTON_ENTITY.get(world,pos);
        int color = HexButtonEntity.DEFAULT_COLOR;
        if(blockEntity != null){
            color = blockEntity.color;
        }
        DyedColorComponent dyeComponent = new DyedColorComponent(color,true);
        stack.set(DataComponentTypes.DYED_COLOR, dyeComponent);
        return stack;
    }
}
