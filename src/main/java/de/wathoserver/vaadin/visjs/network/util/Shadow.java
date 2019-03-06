package de.wathoserver.vaadin.visjs.network.util;

/**
 * Created by Martin Prause 5.8.2017
 */

public class Shadow {
  private boolean enabled = false;
  private String color = "#000000";
  private int size = 10;
  private int x = 5;
  private int y = 5;

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
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

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

}
