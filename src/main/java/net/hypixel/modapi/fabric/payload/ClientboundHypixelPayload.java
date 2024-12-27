package net.hypixel.modapi.fabric.payload;

import net.fabricmc.fabric.api.networking.v1.FabricPacket;
import net.fabricmc.fabric.api.networking.v1.PacketType;
import net.hypixel.modapi.HypixelModAPI;
import net.hypixel.modapi.error.ErrorReason;
import net.hypixel.modapi.packet.ClientboundHypixelPacket;
import net.hypixel.modapi.serializer.PacketSerializer;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;

public class ClientboundHypixelPayload implements FabricPacket {

    private final PacketType<ClientboundHypixelPayload> type;
    private ClientboundHypixelPacket packet;
    private ErrorReason errorReason;

    private ClientboundHypixelPayload(Identifier id, PacketByteBuf buf) {
        type = createPacketType(id);
        PacketSerializer serializer = new PacketSerializer(buf);
        boolean success = serializer.readBoolean();
        if (!success) {
            this.errorReason = ErrorReason.getById(serializer.readVarInt());
            return;
        }

        this.packet = HypixelModAPI.getInstance().getRegistry().createClientboundPacket(id.toString(), serializer);
    }

    public static PacketType<ClientboundHypixelPayload> createPacketType(Identifier id) {
        return PacketType.create(id, b -> new ClientboundHypixelPayload(id, b));
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
    public void write(PacketByteBuf buf) {
        throw new UnsupportedOperationException("Cannot write ClientboundHypixelPayload");
    }

    @Override
    public PacketType<?> getType() {
        return type;
    }
}
