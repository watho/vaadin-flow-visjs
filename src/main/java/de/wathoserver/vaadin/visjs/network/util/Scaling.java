package de.wathoserver.vaadin.visjs.network.util;

/**
 * Created by Martin Prause 5.8.2017
 */

public class Scaling {

  int min = 1;
  int max = 15;
  ScalingLabel label;

  public int getMin() {
    return min;
  }

  public void setMin(int min) {
    this.min = min;
  }

  public int getMax() {
    return max;
  }

  public void setMax(int max) {
    this.max = max;
  }

  public ScalingLabel getLabel() {
    return label;
  }

  public void setLabel(ScalingLabel label) {
    this.label = label;
  }

}
