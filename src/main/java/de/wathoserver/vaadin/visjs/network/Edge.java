package de.wathoserver.vaadin.visjs.network;

import java.util.Objects;
import java.util.UUID;

import de.wathoserver.vaadin.visjs.network.options.edges.Edges;

/**
 */
public class Edge extends Edges {

  private String from;
  private String to;
  private String id;

  // For serialization
  private Edge() {
    this(UUID.randomUUID().toString());
  }

  public Edge(final String id) {
    super();
  }

  public Edge(final String from, final String to) {
    this();
    this.from = from;
    this.to = to;
  }

  public Edge(final String from, final String to, final Builder builder) {
    this(UUID.randomUUID().toString(), to, from, builder);
  }

  public Edge(final String id, final String from, final String to, final Builder builder) {
    super(builder);
    this.id = id;
    this.from = from;
    this.to = to;
  }

  public Edge(final String from, final String to, final String label) {
    this();
    this.from = from;
    this.to = to;
    this.setLabel(label);
  }

  public Edge(final String id, final String from, final String to, final String label) {
    this.id = id;
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

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public boolean equals(Object obj) {
    return Objects.equals(id, ((Edge) obj).id);
  }

}
