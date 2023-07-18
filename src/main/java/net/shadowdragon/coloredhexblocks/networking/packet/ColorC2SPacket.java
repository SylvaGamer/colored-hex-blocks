package net.shadowdragon.coloredhexblocks.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.shadowdragon.coloredhexblocks.screen.DyingStationScreenHandler;

public class ColorC2SPacket {
    public static void recive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                              PacketByteBuf buf, PacketSender responseSender){
            //Everything here happens only on the server


        int[] array = buf.readIntArray(4);
        DyingStationScreenHandler.color = array[0];
    }
}
