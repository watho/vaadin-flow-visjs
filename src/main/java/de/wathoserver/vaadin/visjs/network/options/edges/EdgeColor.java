package de.wathoserver.vaadin.visjs.network.options.edges;

import javax.annotation.Nonnull;

import org.apache.commons.lang3.ObjectUtils;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = EdgeColor.Builder.class)
public class EdgeColor {

  private String color;
  private String highlight;
  private String hover;
  @JsonIgnore
  private Boolean inheritBoolean;
  @JsonIgnore
  private Inherit inheritEnum;
  private Double opacity;

  private EdgeColor(Builder builder) {
    this.color = builder.color;
    this.highlight = builder.highlight;
    this.hover = builder.hover;
    this.inheritEnum = builder.inheritEnum;
    this.inheritBoolean = builder.inheritBoolean;
    this.opacity = builder.opacity;
  }

  public EdgeColor() {}

  public Double getOpacity() {
    return opacity;
  }

  public void setOpacity(final Double opacity) {
    this.opacity = opacity;
  }

  public String getHover() {
    return hover;
  }

  public void setHover(final String hover) {
    this.hover = hover;
  }

  public String getHighlight() {
    return highlight;
  }

  public void setHighlight(final String highlight) {
    this.highlight = highlight;
  }

  public String getColor() {
    return color;
  }

  public void setColor(final String color) {
    this.color = color;
  }

  @JsonGetter
  public Object getInherit() {
    return ObjectUtils.firstNonNull(inheritBoolean, inheritEnum);
  }

  public void setInherit(Inherit inherit) {
    this.inheritEnum = inherit;
    this.inheritBoolean = null;
  }

  public void setInherit(Boolean inherit) {
    this.inheritBoolean = inherit;
    this.inheritEnum = null;
  }

  public enum Inherit {
    from, to, both
  }

  /**
   * Creates builder to build {@link EdgeColor}.
   *
   * @return created builder
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Builder to build {@link EdgeColor}.
   */
  public static final class Builder {
    private String color;
    private String highlight;
    private String hover;
    private Inherit inheritEnum;
    private Boolean inheritBoolean;
    private Double opacity;

    private Builder() {}

    @Nonnull
    public Builder withColor(String color) {
      this.color = color;
      return this;
    }

    @Nonnull
    public Builder withHighlight(String highlight) {
      this.highlight = highlight;
      return this;
    }

    @Nonnull
    public Builder withHover(String hover) {
      this.hover = hover;
      return this;
    }

    @Nonnull
    public Builder withInherit(Inherit inherit) {
      this.inheritEnum = inherit;
      return this;
    }

    @Nonnull
    public Builder withInherit(Boolean inherit) {
      this.inheritBoolean = inherit;
      return this;
    }

    @Nonnull
    public Builder withOpacity(Double opacity) {
      this.opacity = opacity;
      return this;
    }

    @Nonnull
    public EdgeColor build() {
      return new EdgeColor(this);
    }
  }
}
