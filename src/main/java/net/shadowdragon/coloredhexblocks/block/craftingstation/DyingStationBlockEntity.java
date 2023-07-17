package net.shadowdragon.coloredhexblocks.block.craftingstation;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.shadowdragon.coloredhexblocks.block.ModHexBlockEntities;
import net.shadowdragon.coloredhexblocks.recipe.HexBlockRecipe;
import net.shadowdragon.coloredhexblocks.screen.DyingStationScreen;
import net.shadowdragon.coloredhexblocks.screen.DyingStationScreenHandler;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class DyingStationBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory{
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);

    private static final int INPUT_SLOT = 1;
    private static final int DYE_SLOT = 0;
    private  static final int OUTPUT_SLOT = 2;
    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;
    private int redColor = 255;
    private int greenColor = 255;
    private int blueColor = 255;



    public DyingStationBlockEntity(BlockPos pos, BlockState state) {
        super(ModHexBlockEntities.DYING_STATION_BE, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                if (index == 0) {
                    return DyingStationBlockEntity.this.progress;
                } else if (index == 1) {
                    return DyingStationBlockEntity.this.maxProgress;
                } else if (index == 2) {
                    return DyingStationBlockEntity.this.redColor;
                } else if (index == 3) {
                    return DyingStationBlockEntity.this.greenColor;
                } else if (index == 4) {
                    return DyingStationBlockEntity.this.blueColor;
                }
                throw new IllegalStateException("Unexpected value: " + index);
            }

            @Override
            public void set(int index, int value) {
                if (index == 0) {
                    DyingStationBlockEntity.this.progress = value;
                    System.out.println(index + " " + value);
                } else if (index == 1) {
                    DyingStationBlockEntity.this.maxProgress = value;
                    System.out.println(index + " " + value);
                } else if (index == 2) {
                    DyingStationBlockEntity.this.redColor = value;
                    System.out.println(index + " " + value);
                } else if (index == 3) {
                    DyingStationBlockEntity.this.greenColor = value;
                    System.out.println(index + " " + value);
                } else if (index == 4) {
                    DyingStationBlockEntity.this.blueColor = value;
                    System.out.println(index + " " + value);
                } else {
                    throw new IllegalStateException("Unexpected value: " + index);
                }
            }

            @Override
            public int size() {
                return 5;
            }
        };
    }



    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction side) {
        Direction localDir = this.getWorld().getBlockState(pos).get(DyingStationBlock.FACING);

        if(side==Direction.DOWN){
            return false;
        }
        if (side==Direction.UP){
            return slot == INPUT_SLOT;
        }

        return switch(localDir){
            default -> //North
                side.getOpposite() == Direction.NORTH && slot == INPUT_SLOT ||
                        side.getOpposite() == Direction.WEST && slot == INPUT_SLOT;

            case EAST ->
                    side.rotateYClockwise() == Direction.NORTH && slot == INPUT_SLOT ||
                            side.rotateYClockwise() == Direction.WEST && slot == INPUT_SLOT;

            case SOUTH ->
                    side == Direction.NORTH && slot == INPUT_SLOT ||
                            side == Direction.WEST && slot == INPUT_SLOT;

            case WEST ->
                    side.rotateYCounterclockwise() == Direction.NORTH && slot == INPUT_SLOT ||
                            side.rotateYCounterclockwise() == Direction.WEST && slot == INPUT_SLOT;
        };
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction side) {
        Direction localDir = this.getWorld().getBlockState(pos).get(DyingStationBlock.FACING);

        if(side==Direction.DOWN){
            return slot == OUTPUT_SLOT;
        }
        if (side==Direction.UP){
            return false;
        }

        return switch(localDir){
            default -> //North
                    side.getOpposite() == Direction.SOUTH && slot == OUTPUT_SLOT ||
                            side.getOpposite() == Direction.EAST && slot == OUTPUT_SLOT;

            case EAST ->
                    side.rotateYClockwise() == Direction.SOUTH&& slot == OUTPUT_SLOT ||
                            side.rotateYClockwise() == Direction.EAST && slot == OUTPUT_SLOT;

            case SOUTH ->
                    side == Direction.SOUTH && slot == OUTPUT_SLOT ||
                            side == Direction.EAST && slot == OUTPUT_SLOT;

            case WEST ->
                    side.rotateYCounterclockwise() == Direction.SOUTH && slot == OUTPUT_SLOT ||
                            side.rotateYCounterclockwise() == Direction.EAST && slot == OUTPUT_SLOT;
        };
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Dying Station");
    }


    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("dying_station.progress", progress);
        nbt.putInt("dying_station.redColor", redColor);
        nbt.putInt("dying_station.greenColor", greenColor);
        nbt.putInt("dying_station.blueColor", blueColor);
    }


    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        progress = nbt.getInt("dying_station.progress");
        redColor = nbt.getInt("dying_station.redColor");
        greenColor = nbt.getInt("dying_station.greenColor");
        blueColor = nbt.getInt("dying_station.blueColor");
        super.readNbt(nbt);
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new DyingStationScreenHandler(syncId, playerInventory, this, propertyDelegate);
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if(DyingStationScreen.isValid1 && DyingStationScreen.isValid2 && DyingStationScreen.isValid3){
            if(canInsertIntoOutputSlot() && hasRecipe()){
                increaseCraftingProgress();
                markDirty(world, pos, state);
                if(hasCraftingFinished()){
                    craftItem();
                    resetProgress();
                }
            } else {
                resetProgress();
            }
        } else {
            resetProgress();
        }

    }


    private void craftItem() {
        Optional<HexBlockRecipe> recipe = getCurrentRecipe();

        this.removeStack(INPUT_SLOT, 1);


        ItemStack output = recipe.get().getOutput(null);
        this.setStack(OUTPUT_SLOT, new ItemStack(output.getItem(),
                this.getStack(OUTPUT_SLOT).getCount() + output.getCount()));

        int color = this.redColor * 65536 + this.greenColor * 256 + this.blueColor;
        this.getStack(OUTPUT_SLOT).getOrCreateSubNbt("display").putInt("color", color);
    }

    private void resetProgress() {
        this.progress=0;
    }

    private boolean hasCraftingFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increaseCraftingProgress() {
        this.progress ++;
    }

    private boolean hasRecipe() {
        Optional<HexBlockRecipe> recipe = getCurrentRecipe();


        if (recipe.isEmpty()) return false;
        ItemStack output = recipe.get().getOutput(null);


        return canInsertAmmountIntoOutputSlot(output.getCount())
                && canInsertItemIntoOutputSlot(output);
    }

    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
        return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getItem() == output.getItem();
    }

    private boolean canInsertAmmountIntoOutputSlot(int count) {
        return this.getStack(OUTPUT_SLOT).getMaxCount() >= this.getStack(OUTPUT_SLOT).getCount() + count;
    }

    private Optional<HexBlockRecipe> getCurrentRecipe() {
        SimpleInventory inventory = new SimpleInventory(this.size());
        for(int i = 0; i<this.size(); i ++){
            inventory.setStack(i, this.getStack(i));
        }
        return this.getWorld().getRecipeManager().getFirstMatch(HexBlockRecipe.Type.INSTANCE, inventory, this.getWorld());
    }

    private boolean canInsertIntoOutputSlot() {
        return this.getStack(OUTPUT_SLOT).isEmpty() ||
                this.getStack(OUTPUT_SLOT).getCount() < this.getStack(OUTPUT_SLOT).getMaxCount();
    }
}
