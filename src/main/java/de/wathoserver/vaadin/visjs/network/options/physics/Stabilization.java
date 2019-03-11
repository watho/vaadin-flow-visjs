package de.wathoserver.vaadin.visjs.network.options.physics;

import javax.annotation.Nonnull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = Stabilization.Builder.class)
public class Stabilization {
  private Boolean enabled;
  private Integer iterations;
  private Integer updateInterval;
  private Boolean onlyDynamicEdges;
  private Boolean fit;

  private Stabilization(Builder builder) {
    this.enabled = builder.enabled;
    this.iterations = builder.iterations;
    this.updateInterval = builder.updateInterval;
    this.onlyDynamicEdges = builder.onlyDynamicEdges;
    this.fit = builder.fit;
  }

  public Stabilization() {}

  public Boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  public Integer getIterations() {
    return iterations;
  }

  public void setIterations(Integer iterations) {
    this.iterations = iterations;
  }

  public Integer getUpdateInterval() {
    return updateInterval;
  }

  public void setUpdateInterval(Integer updateInterval) {
    this.updateInterval = updateInterval;
  }

  public Boolean isOnlyDynamicEdges() {
    return onlyDynamicEdges;
  }

  public void setOnlyDynamicEdges(Boolean onlyDynamicEdges) {
    this.onlyDynamicEdges = onlyDynamicEdges;
  }

  public Boolean isFit() {
    return fit;
  }

  public void setFit(Boolean fit) {
    this.fit = fit;
  }

  /**
   * Creates builder to build {@link Stabilization}.
   *
   * @return created builder
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Builder to build {@link Stabilization}.
   */
  public static final class Builder {
    private Boolean enabled;
    private Integer iterations;
    private Integer updateInterval;
    private Boolean onlyDynamicEdges;
    private Boolean fit;

    private Builder() {}

    @Nonnull
    public Builder withEnabled(Boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    @Nonnull
    public Builder withIterations(Integer iterations) {
      this.iterations = iterations;
      return this;
    }

    @Nonnull
    public Builder withUpdateInterval(Integer updateInterval) {
      this.updateInterval = updateInterval;
      return this;
    }

    @Nonnull
    public Builder withOnlyDynamicEdges(Boolean onlyDynamicEdges) {
      this.onlyDynamicEdges = onlyDynamicEdges;
      return this;
    }

    @Nonnull
    public Builder withFit(Boolean fit) {
      this.fit = fit;
      return this;
    }

    @Nonnull
    public Stabilization build() {
      return new Stabilization(this);
    }
  }
}
