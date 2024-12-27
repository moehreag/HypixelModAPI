package net.hypixel.modapi.fabric.event;

import net.hypixel.modapi.packet.ClientboundHypixelPacket;
import net.ornithemc.osl.core.api.events.Event;

/**
 * Callback for when a Hypixel Mod API packet is received.
 */
public interface HypixelModAPICallback {

    Event<HypixelModAPICallback> EVENT = Event.of(l -> p -> l.forEach(c -> c.onPacketReceived(p)));

    void onPacketReceived(ClientboundHypixelPacket packet);

}
