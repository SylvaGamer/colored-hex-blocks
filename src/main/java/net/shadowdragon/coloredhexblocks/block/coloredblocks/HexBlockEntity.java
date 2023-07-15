package net.shadowdragon.coloredhexblocks.block.coloredblocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.shadowdragon.coloredhexblocks.ColoredHexBlocks;
import org.jetbrains.annotations.Nullable;

public class HexBlockEntity extends BlockEntity {

    public static final int DEFAULT_COLOR = 16777215;
    public int color = DEFAULT_COLOR;
    public HexBlockEntity(BlockPos pos, BlockState state) {
        super(ColoredHexBlocks.HEX_BLOCK_ENTITY, pos, state);
    }


    @Override
    public void writeNbt(NbtCompound nbt) {
        //nbt.putInt("number", number);
        nbt.putInt("color", color);
        super.writeNbt(nbt);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        color = nbt.getInt("color");
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }

    public static int getColor(BlockView world, BlockPos pos){
        if(world==null){
            return HexBlockEntity.DEFAULT_COLOR;
        }
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if(blockEntity instanceof HexBlockEntity hexBlockEntity){
            return hexBlockEntity.color;
        } else {
            return HexBlockEntity.DEFAULT_COLOR;
        }
    }
}
