package de.wathoserver.vaadin.visjs.network.event;

import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;

import de.wathoserver.vaadin.visjs.network.NetworkDiagram;
import elemental.json.JsonException;
import elemental.json.JsonObject;

@SuppressWarnings("serial")
@DomEvent("vaadin-hidePopup")
public class HidePopupEvent extends EventWithGenericParams {
  public HidePopupEvent(final NetworkDiagram source, boolean fromClient,
      @EventData("event.detail") final JsonObject params) throws JsonException {
    super(source, fromClient, params);
  }
}
