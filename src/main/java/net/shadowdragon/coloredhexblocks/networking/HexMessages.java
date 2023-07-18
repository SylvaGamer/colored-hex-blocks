package net.shadowdragon.coloredhexblocks.networking;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;
import net.shadowdragon.coloredhexblocks.ColoredHexBlocks;

public class HexMessages {
    public static  final Identifier COLOR_ID = new Identifier(ColoredHexBlocks.MOD_ID, "color");
    public static  final Identifier VALID_ID = new Identifier(ColoredHexBlocks.MOD_ID, "valid");
    public final static Identifier BLOCK_POS_ID = new Identifier(ColoredHexBlocks.MOD_ID, "block_pos");

    public static void registerC2SPackets(){
       // ServerPlayNetworking.registerGlobalReceiver(COLOR_ID, ColorC2SPacket::receive);


        ServerPlayNetworking.registerGlobalReceiver(VALID_ID, (server, player, handler, buf, responseSender) ->{

        });

    }

    public static void registerS2CPackets(){

    }
}
