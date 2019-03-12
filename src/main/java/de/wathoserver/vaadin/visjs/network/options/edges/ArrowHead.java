package de.wathoserver.vaadin.visjs.network.options.edges;

import javax.annotation.Nonnull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = ArrowHead.Builder.class)
public class ArrowHead {
  private Boolean enabled;
  private Integer scaleFactor;
  private Type type;

  private ArrowHead(Builder builder) {
    this.enabled = builder.enabled;
    this.scaleFactor = builder.scaleFactor;
    this.type = builder.type;
  }

  public ArrowHead() {}

  public Boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(final Boolean enabled) {
    this.enabled = enabled;
  }

  public Integer getScaleFactor() {
    return scaleFactor;
  }

  public void setScaleFactor(final Integer scaleFactor) {
    this.scaleFactor = scaleFactor;
  }

  public Type getType() {
    return type;
  }

  public void setType(final Type type) {
    this.type = type;
  }

  public static enum Type {
    arrow, bar, circle;
  }

  /**
   * Creates builder to build {@link ArrowHead}.
   *
   * @return created builder
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Builder to build {@link ArrowHead}.
   */
  public static final class Builder {
    private Boolean enabled;
    private Integer scaleFactor;
    private Type type;

    private Builder() {}

    @Nonnull
    public Builder withEnabled(Boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    @Nonnull
    public Builder withScaleFactor(Integer scaleFactor) {
      this.scaleFactor = scaleFactor;
      return this;
    }

    @Nonnull
    public Builder withType(Type type) {
      this.type = type;
      return this;
    }

    @Nonnull
    public ArrowHead build() {
      return new ArrowHead(this);
    }
  }
}
