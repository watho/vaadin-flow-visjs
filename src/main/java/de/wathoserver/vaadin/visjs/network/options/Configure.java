package de.wathoserver.vaadin.visjs.network.options;

import javax.annotation.Nonnull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = Configure.Builder.class)
public class Configure {

  private Boolean enabled;
  private Boolean showButton;
  private String filter;
  private String container;

  private Configure(Builder builder) {
    this.enabled = builder.enabled;
    this.showButton = builder.showButton;
    this.filter = builder.filter;
    this.container = builder.container;
  }

  public Configure() {}

  public Boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  public Boolean isShowButton() {
    return showButton;
  }

  public void setShowButton(Boolean showButton) {
    this.showButton = showButton;
  }

  public String getFilter() {
    return filter;
  }

  public void setFilter(String filter) {
    this.filter = filter;
  }

  public String getContainer() {
    return container;
  }

  public void setContainer(String container) {
    this.container = container;
  }

  /**
   * Creates builder to build {@link Configure}.
   *
   * @return created builder
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Builder to build {@link Configure}.
   */
  public static final class Builder {
    private Boolean enabled;
    private Boolean showButton;
    private String filter;
    private String container;

    private Builder() {}

    @Nonnull
    public Builder withEnabled(Boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    @Nonnull
    public Builder withShowButton(Boolean showButton) {
      this.showButton = showButton;
      return this;
    }

    @Nonnull
    public Builder withFilter(String filter) {
      this.filter = filter;
      return this;
    }

    @Nonnull
    public Builder withContainer(String container) {
      this.container = container;
      return this;
    }

    @Nonnull
    public Configure build() {
      return new Configure(this);
    }
  }
}
