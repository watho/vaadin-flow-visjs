package de.wathoserver.vaadin.visjs.network.options.nodes;

import javax.annotation.Nonnull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Width constraints for nodes.
 *
 * @author watho
 *
 */
@JsonDeserialize(builder = WidthConstraint.Builder.class)
public class WidthConstraint {
  private Integer minimum;
  private Integer maximum;

  private WidthConstraint(Builder builder) {
    this.minimum = builder.minimum;
    this.maximum = builder.maximum;
  }

  public WidthConstraint() {}

  public Integer getMinimum() {
    return minimum;
  }

  public void setMinimum(Integer minimum) {
    this.minimum = minimum;
  }

  public Integer getMaximum() {
    return maximum;
  }

  public void setMaximum(Integer maximum) {
    this.maximum = maximum;
  }

  /**
   * Creates builder to build {@link WidthConstraint}.
   *
   * @return created builder
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Builder to build {@link WidthConstraint}.
   */
  public static final class Builder {
    private Integer minimum;
    private Integer maximum;

    private Builder() {}

    @Nonnull
    public Builder withMinimum(Integer minimum) {
      this.minimum = minimum;
      return this;
    }

    @Nonnull
    public Builder withMaximum(Integer maximum) {
      this.maximum = maximum;
      return this;
    }

    @Nonnull
    public WidthConstraint build() {
      return new WidthConstraint(this);
    }
  }
}
