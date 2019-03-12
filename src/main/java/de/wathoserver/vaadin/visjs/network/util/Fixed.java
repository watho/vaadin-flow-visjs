package de.wathoserver.vaadin.visjs.network.util;

import javax.annotation.Nonnull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = Fixed.Builder.class)
public class Fixed {
  Boolean x;
  Boolean y;

  private Fixed(Builder builder) {
    this.x = builder.x;
    this.y = builder.y;
  }

  public Fixed() {}

  public Boolean isX() {
    return x;
  }

  public void setX(final Boolean x) {
    this.x = x;
  }

  public Boolean isY() {
    return y;
  }

  public void setY(final Boolean y) {
    this.y = y;
  }

  /**
   * Creates builder to build {@link Fixed}.
   *
   * @return created builder
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Builder to build {@link Fixed}.
   */
  public static final class Builder {
    private Boolean x;
    private Boolean y;

    private Builder() {}

    @Nonnull
    public Builder withx(Boolean x) {
      this.x = x;
      return this;
    }

    @Nonnull
    public Builder withy(Boolean y) {
      this.y = y;
      return this;
    }

    @Nonnull
    public Fixed build() {
      return new Fixed(this);
    }
  }
}
