package de.wathoserver.vaadin.visjs.network.event;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;

import de.wathoserver.vaadin.visjs.network.NetworkDiagram;
import de.wathoserver.vaadin.visjs.network.api.NetworkDiagramEvent;
import elemental.json.JsonException;
import elemental.json.JsonString;

@SuppressWarnings("serial")
@DomEvent("vaadin-showPopup")
public class ShowPopupEvent extends ComponentEvent<NetworkDiagram> implements NetworkDiagramEvent {
  private final String itemId;

  public ShowPopupEvent(final NetworkDiagram source, boolean fromClient,
      @EventData("event.detail") final JsonString itemId) throws JsonException {
    super(source, fromClient);
    this.itemId = itemId.asString();
  }

  public String getItemId() {
    return itemId;
  }
}
