package de.wathoserver.vaadin.visjs.network.event;

import com.vaadin.flow.component.ComponentEvent;

import de.wathoserver.vaadin.visjs.network.NetworkDiagram;
import elemental.json.JsonException;

@SuppressWarnings("serial")
public class NodesChangedEvent extends ComponentEvent<NetworkDiagram> {

  private final EventType eventType;

  public NodesChangedEvent(final NetworkDiagram source, boolean fromClient,
      final EventType eventType) throws JsonException {
    super(source, fromClient);
    this.eventType = eventType;
  }

  public EventType getEventType() {
    return eventType;
  }

  public static enum EventType {
    add, update, remove
  };
}
