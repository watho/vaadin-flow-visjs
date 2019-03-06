package de.wathoserver.vaadin.visjs.network.util;

/**
 * Created by Martin Prause 5.8.2017
 */
public class FontStyle {

  private String color = "#343434";
  private int size = 14;
  private String face = "arial";
  private int vadjust = 0;
  private Style mod = Style.bold;

  FontStyle(Style style) {
    this.mod = style;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public String getFace() {
    return face;
  }

  public void setFace(String face) {
    this.face = face;
  }

  public int getVadjust() {
    return vadjust;
  }

  public void setVadjust(int vadjust) {
    this.vadjust = vadjust;
  }

  public Style getMod() {
    return mod;
  }

  public void setMod(Style mod) {
    this.mod = mod;
  }

  public static enum Style {
    bold, italic, bolditalic, mono;
  }

}
