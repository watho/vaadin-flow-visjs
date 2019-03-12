package de.wathoserver.vaadin.visjs.network.options.edges;

public class Arrows {

  private ArrowHead to;
  private ArrowHead middle;
  private ArrowHead from;

  public Arrows() {}

  public Arrows(final ArrowHead to) {
    this.to = to;
  }

  public Arrows(final ArrowHead to, final ArrowHead middle) {
    this.to = to;
    this.middle = middle;
  }

  public Arrows(final ArrowHead to, final ArrowHead middle, final ArrowHead from) {
    this.to = to;
    this.middle = middle;
    this.from = from;
  }

  public ArrowHead getTo() {
    return to;
  }

  public void setTo(final ArrowHead to) {
    this.to = to;
  }

  public ArrowHead getMiddle() {
    return middle;
  }

  public void setMiddle(final ArrowHead middle) {
    this.middle = middle;
  }

  public ArrowHead getFrom() {
    return from;
  }

  public void setFrom(final ArrowHead from) {
    this.from = from;
  }
}
