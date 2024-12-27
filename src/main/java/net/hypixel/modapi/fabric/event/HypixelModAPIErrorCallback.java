package net.hypixel.modapi.fabric.event;

import net.hypixel.modapi.error.ErrorReason;
import net.ornithemc.osl.core.api.events.Event;

/**
 * Callback for when a Hypixel Mod API error reason is received.
 */
public interface HypixelModAPIErrorCallback {

    Event<HypixelModAPIErrorCallback> EVENT = Event.of(l -> (s, r) -> l.forEach(c -> c.onError(s, r)));

    void onError(String identifier, ErrorReason reason);

}
