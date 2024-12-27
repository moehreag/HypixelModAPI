package net.hypixel.modapi.fabric.payload;

import java.io.IOException;

import net.hypixel.modapi.packet.HypixelPacket;
import net.hypixel.modapi.serializer.PacketSerializer;
import net.minecraft.network.PacketByteBuf;
import net.ornithemc.osl.networking.api.CustomPayload;

public class ServerboundHypixelPayload implements CustomPayload {
    private final HypixelPacket packet;

    public ServerboundHypixelPayload(HypixelPacket packet) {
        this.packet = packet;
    }

    @Override
    public void read(PacketByteBuf buffer) throws IOException {
        throw new UnsupportedOperationException("Cannot read ServerboundHypixelPayload");
    }

    public void write(PacketByteBuf buf) {
        PacketSerializer serializer = new PacketSerializer(buf);
        packet.write(serializer);
    }
}
