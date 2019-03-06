package de.wathoserver.vaadin.visjs.network;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.wathoserver.vaadin.visjs.network.options.nodes.Nodes;
import de.wathoserver.vaadin.visjs.network.util.Shape;

public class Node extends Nodes {

  private String id;
  private String label;
  private String group;

  private transient List<Edge> edgeList = new ArrayList<>();;
  private transient Map<String, Edge> edgeMap = new HashMap<>();;

  public Node() {

  }

  public Node(int id, String label) {
    this.id = Integer.toString(id);
    this.label = label;
  }

  public Node(String id, String label) {
    this.id = id;
    this.label = label;
  }

  public Node(int id, String label, String image) {
    this.id = Integer.toString(id);
    this.label = label;
    setImage(image);
    setShape(Shape.image);
  }

  public Node(String id, String label, String image) {
    this.id = id;
    this.label = label;
    setImage(image);
    setShape(Shape.image);
  }

  public Node(int id, String label, Shape shape, String group) {
    this.id = Integer.toString(id);;
    this.label = label;
    setShape(shape);
    this.group = group;
  }

  public Node(String id, String label, Shape shape, String group) {
    this.id = id;
    this.label = label;
    setShape(shape);
    this.group = group;
  }

  public Node(int id, String label, Shape shape, String group, String image) {
    this.id = Integer.toString(id);;
    this.label = label;
    this.group = group;
    setImage(image);
    setShape(shape);
  }

  public Node(String id, String label, Shape shape, String group, String image) {
    this.id = id;
    this.label = label;
    this.group = group;
    setImage(image);
    setShape(shape);
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getGroup() {
    return group;
  }

  public void setGroup(String group) {
    this.group = group;
  }

  public List<Edge> getConnectedEdges() {
    return edgeList;
  }

  public void setConnectedEdges(List<Edge> edgeList) {
    this.edgeList = edgeList;
  }

  public void addEdgeToList(Edge edge) {
    edgeList.add(edge);
  }

  public void removeEdgeFromList(Edge edge) {
    edgeList.remove(edge);
  }

  public Map<String, Edge> getEdgeMap() {
    return edgeMap;
  }

  public void setEdgeMap(Map<String, Edge> edgeMap) {
    this.edgeMap = edgeMap;
  }

}
