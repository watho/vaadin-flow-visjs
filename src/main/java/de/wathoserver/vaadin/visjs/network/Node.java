package de.wathoserver.vaadin.visjs.network;

import java.util.Objects;
import java.util.UUID;

import de.wathoserver.vaadin.visjs.network.options.nodes.Nodes;

public class Node extends Nodes {

  private String id;

  public Node() {
    this(UUID.randomUUID().toString());
  };

  public Node(final String id) {
    this.id = id;
  }

  public Node(final String id, Builder builder) {
    super(builder);
    this.id = id;
  }

  public Node(String id, String label) {
    this.id = id;
    this.setLabel(label);
  }

  public Node(String id, String label, final Builder builder) {
    super(builder);
    this.id = id;
    this.setLabel(label);
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public boolean equals(Object obj) {
    return Objects.equals(id, ((Node) obj).id);
  }

}
