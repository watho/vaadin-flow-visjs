package de.wathoserver.vaadin.visjs.network;

import de.wathoserver.vaadin.visjs.network.options.edges.Edges;

/**
 */
public class Edge extends Edges {

  private String from;
  private String to;
  private String id;

  public Edge(final Node from, final Node to) {
    this.from = from.getId();
    this.to = to.getId();
  }

  public Edge(final Node from, final Node to, final Builder builder) {
    super(builder);
    this.from = from.getId();
    this.to = to.getId();
  }

  public Edge(final String from, final String to) {
    this.from = from;
    this.to = to;
  }

  public Edge(final String from, final String to, final Builder builder) {
    super(builder);
    this.from = from;
    this.to = to;
  }

  public Edge(final Node from, final Node to, final String label) {
    this.from = from.getId();
    this.to = to.getId();
    this.setLabel(label);
  }

  public Edge(final String from, final String to, final String label) {
    this.from = from;
    this.to = to;
    this.setLabel(label);
  }

  public String getId() {
    return id;
  }

  public void setId(final String id) {
    this.id = id;
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(final String from) {
    this.from = from;
  }

  public String getTo() {
    return to;
  }

  public void setTo(final String to) {
    this.to = to;
  }

}
