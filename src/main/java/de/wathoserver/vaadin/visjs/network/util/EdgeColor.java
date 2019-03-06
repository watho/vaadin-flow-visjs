package de.wathoserver.vaadin.visjs.network.util;

public class EdgeColor {

  private String hover;
  private String highlight = "#D2E5FF";
  private String color = "#df6b1d";
  private int opacity = 1;

  public EdgeColor() {}

  /**
   * @param color
   */
  public EdgeColor(final String color) {
    this.color = color;
  }

  public EdgeColor(final String color, final String highlightColor) {
    this.color = color;
    highlight = highlightColor;
  }

  public EdgeColor(final String color, final String hoverColor, final String highlightColor) {
    this.color = color;
    highlight = highlightColor;
    hover = hoverColor;
  }

  public int getOpacity() {
    return opacity;
  }

  public void setOpacity(final int opacity) {
    this.opacity = opacity;
  }

  public String getHoverColor() {
    return hover;
  }

  public void setHoverColor(final String hover) {
    this.hover = hover;
  }

  public String getHighlight() {
    return highlight;
  }

  public void setHighlightColor(final String highlight) {
    this.highlight = highlight;
  }

  public String getColor() {
    return color;
  }

  public void setColor(final String color) {
    this.color = color;
  }

  public String getHover() {
    return hover;
  }

  public void setHover(final String hover) {
    this.hover = hover;
  }

  public void setHighlight(final String highlight) {
    this.highlight = highlight;
  }
}
