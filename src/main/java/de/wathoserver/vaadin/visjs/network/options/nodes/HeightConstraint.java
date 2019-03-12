package de.wathoserver.vaadin.visjs.network.options.nodes;

import javax.annotation.Nonnull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Heightconstraints for nodes.
 *
 * @author watho
 *
 */
@JsonDeserialize(builder = HeightConstraint.Builder.class)
public class HeightConstraint {
  private Integer minimum;
  private Valign valign;

  private HeightConstraint(Builder builder) {
    this.minimum = builder.minimum;
    this.valign = builder.valign;
  }

  public HeightConstraint() {}

  public Integer getMinimum() {
    return minimum;
  }

  public void setMinimum(Integer minimum) {
    this.minimum = minimum;
  }

  /**
   * Valid values are 'top', 'middle', and 'bottom'. When specified, if the height of the label text
   * is less than the minimum (including any top or bottom margins), it will be offset vertically to
   * the designated position.
   *
   * @return
   */
  public Valign getValign() {
    return valign;
  }

  public void setValign(Valign valign) {
    this.valign = valign;
  }

  public static enum Valign {
    top, middle, bottom;
  }

  /**
   * Creates builder to build {@link HeightConstraint}.
   *
   * @return created builder
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Builder to build {@link HeightConstraint}.
   */
  public static final class Builder {
    private Integer minimum;
    private Valign valign;

    private Builder() {}

    @Nonnull
    public Builder withMinimum(Integer minimum) {
      this.minimum = minimum;
      return this;
    }

    @Nonnull
    public Builder withValign(Valign valign) {
      this.valign = valign;
      return this;
    }

    @Nonnull
    public HeightConstraint build() {
      return new HeightConstraint(this);
    }
  }
}
