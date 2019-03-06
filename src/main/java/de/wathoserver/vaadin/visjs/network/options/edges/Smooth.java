package de.wathoserver.vaadin.visjs.network.options.edges;

/**
 * Created by Martin Prause 5.8.2017
 */

public class Smooth {

  private boolean enabled = true;
  private Type type = Type.dynamic;
  private double roundness = 0.5;

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }

  public double getRoundness() {
    return roundness;
  }

  public void setRoundness(double roundness) {
    this.roundness = roundness;
  }

  public static enum Type {
    dynamic, continuous, diagonalCross, straightCross, horizontal, vertical, curvedCW, curvedCCW, cubicBezier, discrete,
  }

}
