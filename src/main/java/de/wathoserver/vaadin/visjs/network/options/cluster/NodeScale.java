package de.wathoserver.vaadin.visjs.network.options.cluster;

import javax.annotation.Nonnull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = NodeScale.Builder.class)
public class NodeScale {

  private Integer width;
  private Integer height;
  private Integer radius;

  private NodeScale(Builder builder) {
    this.width = builder.width;
    this.height = builder.height;
    this.radius = builder.radius;
  }

  public NodeScale() {}

  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public Integer getRadius() {
    return radius;
  }

  public void setRadius(Integer radius) {
    this.radius = radius;
  }

  /**
   * Creates builder to build {@link NodeScale}.
   *
   * @return created builder
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Builder to build {@link NodeScale}.
   */
  public static final class Builder {
    private Integer width;
    private Integer height;
    private Integer radius;

    private Builder() {}

    @Nonnull
    public Builder withWidth(Integer width) {
      this.width = width;
      return this;
    }

    @Nonnull
    public Builder withHeight(Integer height) {
      this.height = height;
      return this;
    }

    @Nonnull
    public Builder withRadius(Integer radius) {
      this.radius = radius;
      return this;
    }

    @Nonnull
    public NodeScale build() {
      return new NodeScale(this);
    }
  }
}
