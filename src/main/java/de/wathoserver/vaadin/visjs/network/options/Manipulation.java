package de.wathoserver.vaadin.visjs.network.options;

import javax.annotation.Nonnull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = Manipulation.Builder.class)
public class Manipulation {

  private Boolean enabled;

  private Manipulation(Builder builder) {
    this.enabled = builder.enabled;
  }

  public Manipulation() {}

  public Manipulation(final boolean enabled) {
    this.enabled = enabled;
  }

  public Boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(final Boolean enabled) {
    this.enabled = enabled;
  }

  /**
   * Creates builder to build {@link Manipulation}.
   *
   * @return created builder
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Builder to build {@link Manipulation}.
   */
  public static final class Builder {
    private Boolean enabled;

    private Builder() {}

    @Nonnull
    public Builder withEnabled(Boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    @Nonnull
    public Manipulation build() {
      return new Manipulation(this);
    }
  }
}
