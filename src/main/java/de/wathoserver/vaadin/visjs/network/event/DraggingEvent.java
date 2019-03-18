package de.wathoserver.vaadin.visjs.network.event;

import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;

import de.wathoserver.vaadin.visjs.network.NetworkDiagram;
import elemental.json.JsonException;
import elemental.json.JsonObject;

@SuppressWarnings("serial")
@DomEvent("vaadin-dragging")
public class DraggingEvent extends EventWithGenericParams {
  public DraggingEvent(final NetworkDiagram source, boolean fromClient,
      @EventData("event.detail") final JsonObject params) throws JsonException {
    super(source, fromClient, params);
  }
}
