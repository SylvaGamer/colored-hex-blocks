package net.shadowdragon.coloredhexblocks.networking;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;
import net.shadowdragon.coloredhexblocks.ColoredHexBlocks;
import net.shadowdragon.coloredhexblocks.networking.packet.ColorC2SPacket;

public class HexMessages {
    public static  final Identifier COLOR_ID = new Identifier(ColoredHexBlocks.MOD_ID, "color");

    public static void registerC2SPackets(){
        ServerPlayNetworking.registerGlobalReceiver(COLOR_ID, ColorC2SPacket::recive);
    }

    public static void registerS2CPackets(){

    }
}
