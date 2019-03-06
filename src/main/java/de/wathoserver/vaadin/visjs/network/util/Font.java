package de.wathoserver.vaadin.visjs.network.util;

/**
 * Created by Martin Prause 5.8.2017
 */
public class Font {

  String color = "#343434";
  int size = 14;
  String face = "arial";
  String background = null;
  int strokeWidth = 2;
  String strokeColor = "#ffffff";
  String align = "horizontal";
  String vadjust = "0";
  String multi = null;
  FontStyle bold = null;
  FontStyle ital = null;
  FontStyle boldital = null;
  FontStyle mono = null;

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

  public String getBackground() {
    return background;
  }

  public void setBackground(String background) {
    this.background = background;
  }

  public int getStrokeWidth() {
    return strokeWidth;
  }

  public void setStrokeWidth(int strokeWidth) {
    this.strokeWidth = strokeWidth;
  }

  public String getStrokeColor() {
    return strokeColor;
  }

  public void setStrokeColor(String strokeColor) {
    this.strokeColor = strokeColor;
  }

  public String getAlign() {
    return align;
  }

  public void setAlign(String align) {
    this.align = align;
  }

  public String getVadjust() {
    return vadjust;
  }

  public void setVadjust(String vadjust) {
    this.vadjust = vadjust;
  }

  public String getMulti() {
    return multi;
  }

  public void setMulti(String multi) {
    this.multi = multi;
  }

  public FontStyle getBold() {
    return bold;
  }

  public void setBold(FontStyle bold) {
    this.bold = bold;
  }

  public FontStyle getItal() {
    return ital;
  }

  public void setItal(FontStyle ital) {
    this.ital = ital;
  }

  public FontStyle getBoldital() {
    return boldital;
  }

  public void setBoldital(FontStyle boldital) {
    this.boldital = boldital;
  }

  public FontStyle getMono() {
    return mono;
  }

  public void setMono(FontStyle mono) {
    this.mono = mono;
  };

}
