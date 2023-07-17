package net.shadowdragon.coloredhexblocks.screen;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.shadowdragon.coloredhexblocks.block.ModHexBlockEntities;
import net.shadowdragon.coloredhexblocks.block.craftingstation.DyingStationBlock;
import net.shadowdragon.coloredhexblocks.block.craftingstation.DyingStationBlockEntity;

public class DyingStationScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    private final PropertyDelegate propertyDelegate;
    public final DyingStationBlockEntity blockEntity;

    protected DyingStationScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf buf) {
        this(syncId, inventory, inventory.player.getWorld().getBlockEntity(buf.readBlockPos()),
                new ArrayPropertyDelegate(5));
    }

    public DyingStationScreenHandler(int syncId, PlayerInventory playerInventory,
                                     BlockEntity blockEntity, PropertyDelegate propertyDelegate) {
        super(HexScreenHandler.DYING_STATION_SCREEN_HANDLER, syncId);
        checkSize(((Inventory) blockEntity),4);
        this.inventory = (Inventory) blockEntity;
        this.propertyDelegate = propertyDelegate;
        this.blockEntity = ((DyingStationBlockEntity) blockEntity);

        this.addSlot(new Slot(inventory, 0,33,19));
        this.addSlot(new Slot(inventory, 1,62,50));
        this.addSlot(new Slot(inventory, 2,116,50));
        addPlayerHotbar(playerInventory);
        addPlayerInventory(playerInventory);


        addProperties(propertyDelegate);

    }
    public boolean isCrafting(){
        return propertyDelegate.get(0) > 0;
    }



    public int getScaledProgress(){
        int progress = this.propertyDelegate.get(0);
        int maxProgress = this.propertyDelegate.get(1);
        int progressArrowSize = 22;
        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress:0;
    }

    public int getRedColor(){
        return this.propertyDelegate.get(2);
    }

    public int getGreenColor(){
    return this.propertyDelegate.get(3);
    }
    public int getBlueColor(){
        return this.propertyDelegate.get(4);
    }

    public void setRedColor(int redColor){
        System.out.println(this.propertyDelegate.get(2) + " old red");
        this.propertyDelegate.set(2, redColor);
        System.out.println(this.propertyDelegate.get(2) + " new red");
    }

    public void setGreenColor(int greenColor){
        System.out.println(this.propertyDelegate.get(3) + " old green");
        this.propertyDelegate.set(3, greenColor);
        System.out.println(this.propertyDelegate.get(3) + " new green");

    }
    public void setBlueColor(int blueColor){
        System.out.println(this.propertyDelegate.get(4) + " old blue");
        this.propertyDelegate.set(4,blueColor);
        System.out.println(this.propertyDelegate.get(4) + " new blue");
    }


    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 1, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }
        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }
    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

}
