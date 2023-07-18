package net.shadowdragon.coloredhexblocks.screen;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.shadowdragon.coloredhexblocks.block.craftingstation.DyeingStationBlockEntity;

public class DyeingStationScreenHandler extends ScreenHandler {
    public static int color;
    public static boolean validPacket;

    private ItemStack inputStack = ItemStack.EMPTY;
    Runnable contentsChangedListener = () -> {};
    public final Inventory input = new SimpleInventory(1){

        @Override
        public void markDirty() {
            super.markDirty();
            DyeingStationScreenHandler.this.onContentChanged(this);
            DyeingStationScreenHandler.this.contentsChangedListener.run();
        }
    };
    final CraftingResultInventory output = new CraftingResultInventory();
    private final Inventory inventory;
    public final DyeingStationBlockEntity blockEntity;
    Slot inputSlot;
    final Slot outputSlot;
    final Slot dyeSlot;

    PlayerInventory playerInventory;





    protected DyeingStationScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf buf) {
        this(syncId, inventory, inventory.player.getWorld().getBlockEntity(buf.readBlockPos()));
        playerInventory = inventory;
    }

    public DyeingStationScreenHandler(int syncId, PlayerInventory playerInventory,
                                      BlockEntity blockEntity) {
        super(HexScreenHandler.DYEING_STATION_SCREEN_HANDLER, syncId);
        checkSize(((Inventory) blockEntity),3);
        this.inventory = (Inventory) blockEntity;
        this.blockEntity = ((DyeingStationBlockEntity) blockEntity);
        this.inputSlot = this.addSlot(new Slot(this.input, 0, 62, 50));
        this.outputSlot = this.addSlot(new Slot(this.output, 1,116,50){



            @Override
            public boolean canInsert(ItemStack stack) {
                return false;
            }

            @Override
            public void onTakeItem(PlayerEntity player, ItemStack stack) {
                stack.onCraft(player.getWorld(), player, stack.getCount());
                ItemStack itemStack = DyeingStationScreenHandler.this.inputSlot.takeStack(stack.getCount());
                if(!itemStack.isEmpty()){
                    DyeingStationScreenHandler.this.populateResult();
                }
                super.onTakeItem(player, stack);
            }


        });




        dyeSlot = this.addSlot(new Slot(this.inventory, 2,33,19));

        addPlayerHotbar(playerInventory);
        addPlayerInventory(playerInventory);


    }

    private void populateResult() {
        this.sendContentUpdates();
        ItemStack itemStack = this.inputSlot.getStack();
        this.outputSlot.setStackNoCallbacks(itemStack);

    }


    @Override
    public boolean onButtonClick(PlayerEntity player, int id) {
        this.populateResult();
        return true;
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

    @Override
    public void onContentChanged(Inventory inventory) {
        ItemStack itemStack = this.inputSlot.getStack();
        if(itemStack.isEmpty() ){
            this.outputSlot.setStack(ItemStack.EMPTY);
        }
        if (!itemStack.isOf(this.inputStack.getItem())) {
            //this.inputStack = itemStack.copy();
            //this.outputSlot.setStack(this.inputSlot.getStack());

            ItemStack newStack = this.inputSlot.getStack().copy();
            this.outputSlot.setStack(newStack);
            this.outputSlot.getStack().getOrCreateSubNbt("display").putInt("color", color);
            //System.out.println(color + " The Color property should be this - - - - - -");
        }
        this.sendContentUpdates();
    }


    private void updateResult() {
        ItemStack itemStack = this.inputSlot.getStack();
        if(itemStack.isEmpty()){
            this.outputSlot.setStack(ItemStack.EMPTY);
            return;
        }
        if (!itemStack.isOf(this.inputStack.getItem())) {
            ItemStack newStack = this.inputSlot.getStack().copy();
            this.outputSlot.setStack(newStack);
            this.outputSlot.getStack().getOrCreateSubNbt("display").putInt("color", color);
        }
    }
}
