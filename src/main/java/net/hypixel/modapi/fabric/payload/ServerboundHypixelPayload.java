package net.hypixel.modapi.fabric.payload;

import java.io.IOException;

import net.hypixel.modapi.packet.HypixelPacket;
import net.hypixel.modapi.serializer.PacketSerializer;
import net.ornithemc.osl.networking.api.PacketBuffer;
import net.ornithemc.osl.networking.api.PacketPayload;

public class ServerboundHypixelPayload implements PacketPayload {
	private final HypixelPacket packet;

	public ServerboundHypixelPayload(HypixelPacket packet) {
		this.packet = packet;
	}

	@Override
	public void read(PacketBuffer buffer) throws IOException {
		throw new UnsupportedOperationException("Cannot read ServerboundHypixelPayload");
	}

	public void write(PacketBuffer buf) {
		PacketSerializer serializer = new PacketSerializer(buf);
		packet.write(serializer);
	}
}
