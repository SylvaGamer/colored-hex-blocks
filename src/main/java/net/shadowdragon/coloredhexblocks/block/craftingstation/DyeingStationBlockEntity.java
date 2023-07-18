package net.shadowdragon.coloredhexblocks.block.craftingstation;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.shadowdragon.coloredhexblocks.block.ModHexBlockEntities;
import net.shadowdragon.coloredhexblocks.screen.DyeingStationScreenHandler;
import org.jetbrains.annotations.Nullable;

public class DyeingStationBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory{
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);


    public DyeingStationBlockEntity(BlockPos pos, BlockState state) {
        super(ModHexBlockEntities.DYEING_STATION_BE, pos, state);
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
    }


    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new DyeingStationScreenHandler(syncId, playerInventory, this);
    }

    public void tick(World world, BlockPos pos, BlockState state) {


    }
}
