package de.wathoserver.vaadin.visjs.network.event;

import com.vaadin.flow.component.ComponentEvent;

import de.wathoserver.vaadin.visjs.network.NetworkDiagram;
import de.wathoserver.vaadin.visjs.network.api.NetworkDiagramEvent;
import elemental.json.JsonObject;

@SuppressWarnings("serial")
public abstract class EventWithGenericParams extends ComponentEvent<NetworkDiagram> implements NetworkDiagramEvent {

  private final JsonObject params;

  /**
   * TODO parse jsonParameter
   *
   * @param source
   * @param fromClient
   * @param params
   */
  public EventWithGenericParams(NetworkDiagram source, boolean fromClient, final JsonObject params) {
    super(source, fromClient);
    this.params = params;
  }

  /**
   * Event parameter. See http://visjs.org/docs/network/#Events
   *
   * @return
   */
  public JsonObject getParams() {
    return params;
  }

}
