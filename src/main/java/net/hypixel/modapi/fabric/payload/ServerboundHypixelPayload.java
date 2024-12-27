package net.hypixel.modapi.fabric.payload;

import net.fabricmc.fabric.api.networking.v1.FabricPacket;
import net.fabricmc.fabric.api.networking.v1.PacketType;
import net.hypixel.modapi.packet.HypixelPacket;
import net.hypixel.modapi.serializer.PacketSerializer;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;

public class ServerboundHypixelPayload implements FabricPacket {
    private final PacketType<ServerboundHypixelPayload> type;
    private final HypixelPacket packet;

    public ServerboundHypixelPayload(HypixelPacket packet) {
        super();
        type = PacketType.create(new Identifier(packet.getIdentifier()), b -> {
            throw new UnsupportedOperationException("Cannot read ServerboundHypixelPayload");
        });
        this.packet = packet;
    }

    public void write(PacketByteBuf buf) {
        PacketSerializer serializer = new PacketSerializer(buf);
        packet.write(serializer);
    }

    @Override
    public PacketType<?> getType() {
        return type;
    }
}
