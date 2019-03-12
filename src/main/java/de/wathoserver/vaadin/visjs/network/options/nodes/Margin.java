package de.wathoserver.vaadin.visjs.network.options.nodes;

import javax.annotation.Nonnull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = Margin.Builder.class)
public class Margin {

  private Integer top;
  private Integer right;
  private Integer bottom;
  private Integer left;

  private Margin(Builder builder) {
    this.top = builder.top;
    this.right = builder.right;
    this.bottom = builder.bottom;
    this.left = builder.left;
  }

  public Margin() {}

  public Integer getTop() {
    return top;
  }

  public void setTop(Integer top) {
    this.top = top;
  }

  public Integer getRight() {
    return right;
  }

  public void setRight(Integer right) {
    this.right = right;
  }

  public Integer getBottom() {
    return bottom;
  }

  public void setBottom(Integer bottom) {
    this.bottom = bottom;
  }

  public Integer getLeft() {
    return left;
  }

  public void setLeft(Integer left) {
    this.left = left;
  }

  /**
   * Creates builder to build {@link Margin}.
   *
   * @return created builder
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Builder to build {@link Margin}.
   */
  public static final class Builder {
    private Integer top;
    private Integer right;
    private Integer bottom;
    private Integer left;

    private Builder() {}

    @Nonnull
    public Builder withTop(Integer top) {
      this.top = top;
      return this;
    }

    @Nonnull
    public Builder withRight(Integer right) {
      this.right = right;
      return this;
    }

    @Nonnull
    public Builder withBottom(Integer bottom) {
      this.bottom = bottom;
      return this;
    }

    @Nonnull
    public Builder withLeft(Integer left) {
      this.left = left;
      return this;
    }

    @Nonnull
    public Margin build() {
      return new Margin(this);
    }
  }
}
