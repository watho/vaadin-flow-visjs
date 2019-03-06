package de.wathoserver.vaadin.visjs.network.util;

/**
 * Created by Martin Prause 5.8.2017
 */

public class ScalingLabel {

  private boolean enabled = true;
  private int min = 14;
  private int max = 30;
  private int maxVisible = 30;
  private int drawThreshold = 5;

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

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

  public int getMaxVisible() {
    return maxVisible;
  }

  public void setMaxVisible(int maxVisible) {
    this.maxVisible = maxVisible;
  }

  public int getDrawThreshold() {
    return drawThreshold;
  }

  public void setDrawThreshold(int drawThreshold) {
    this.drawThreshold = drawThreshold;
  }

}
