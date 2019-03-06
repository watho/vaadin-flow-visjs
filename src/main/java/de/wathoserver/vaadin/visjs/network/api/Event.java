package de.wathoserver.vaadin.visjs.network.api;

import com.vaadin.flow.component.ComponentEvent;

import de.wathoserver.vaadin.visjs.network.NetworkDiagram;
import elemental.json.JsonObject;

@SuppressWarnings("serial")
public abstract class Event extends ComponentEvent<NetworkDiagram> {

  private final JsonObject params;

  /**
   * TODO parse jsonParameter
   *
   * @param source
   * @param fromClient
   * @param jsonObject
   */
  public Event(NetworkDiagram source, boolean fromClient, final JsonObject params) {
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
