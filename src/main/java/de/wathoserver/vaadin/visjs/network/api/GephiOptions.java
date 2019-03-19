package de.wathoserver.vaadin.visjs.network.api;

import javax.annotation.Nonnull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Options for GephiConverter. See <a href=
 * "http://visjs.org/docs/network/#importGephi">http://visjs.org/docs/network/#importGephi</a>
 *
 * @author watho
 *
 */
@JsonDeserialize(builder = GephiOptions.Builder.class)
public class GephiOptions {

  @JsonProperty("edges.inheritColors")
  private boolean inheritColors = false;
  @JsonProperty("nodes.fixed")
  private boolean fixed = true;
  @JsonProperty("nodes.parseColor")
  private boolean parseColor = false;

  private GephiOptions(Builder builder) {
    this.inheritColors = builder.inheritColors;
    this.fixed = builder.fixed;
    this.parseColor = builder.parseColor;
  }

  public GephiOptions() {}

  public boolean isInheritColors() {
    return inheritColors;
  }

  public void setInheritColors(boolean inheritColors) {
    this.inheritColors = inheritColors;
  }

  public boolean isFixed() {
    return fixed;
  }

  public void setFixed(boolean fixed) {
    this.fixed = fixed;
  }

  public boolean isParseColor() {
    return parseColor;
  }

  public void setParseColor(boolean parseColor) {
    this.parseColor = parseColor;
  }

  /**
   * Creates builder to build {@link GephiOptions}.
   *
   * @return created builder
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Builder to build {@link GephiOptions}.
   */
  public static final class Builder {
    private boolean inheritColors;
    private boolean fixed;
    private boolean parseColor;

    private Builder() {}

    @Nonnull
    public Builder withInheritColors(boolean inheritColors) {
      this.inheritColors = inheritColors;
      return this;
    }

    @Nonnull
    public Builder withFixed(boolean fixed) {
      this.fixed = fixed;
      return this;
    }

    @Nonnull
    public Builder withParseColor(boolean parseColor) {
      this.parseColor = parseColor;
      return this;
    }

    @Nonnull
    public GephiOptions build() {
      return new GephiOptions(this);
    }
  }
}
