package net.hypixel.modapi.fabric.payload;

import java.io.IOException;

import net.hypixel.modapi.HypixelModAPI;
import net.hypixel.modapi.error.ErrorReason;
import net.hypixel.modapi.packet.ClientboundHypixelPacket;
import net.hypixel.modapi.serializer.PacketSerializer;
import net.minecraft.network.PacketByteBuf;
import net.ornithemc.osl.networking.api.CustomPayload;

public class ClientboundHypixelPayload implements CustomPayload {
    private final String id;
    private ClientboundHypixelPacket packet;
    private ErrorReason errorReason;

    public ClientboundHypixelPayload(String identifier) {
        this.id = identifier;
    }

    public boolean isSuccess() {
        return packet != null;
    }

    public ClientboundHypixelPacket getPacket() {
        return packet;
    }

    public ErrorReason getErrorReason() {
        return errorReason;
    }

    @Override
    public void read(PacketByteBuf buf) throws IOException {
        PacketSerializer serializer = new PacketSerializer(buf);
        boolean success = serializer.readBoolean();
        if (!success) {
            this.errorReason = ErrorReason.getById(serializer.readVarInt());
            return;
        }

        this.packet = HypixelModAPI.getInstance().getRegistry().createClientboundPacket(id, serializer);
    }

    @Override
    public void write(PacketByteBuf buffer) throws IOException {
        throw new UnsupportedOperationException("Cannot write ClientboundHypixelPayload");
    }
}
