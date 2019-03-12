package de.wathoserver.vaadin.visjs.network.util;

import javax.annotation.Nonnull;

import org.apache.commons.lang3.ObjectUtils;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = ShapeProperties.Builder.class)
public class ShapeProperties {
  @JsonIgnore
  private Boolean borderDashesBoolean;
  @JsonIgnore
  private Integer borderDashesArray[];
  private Integer borderRadius;
  private Boolean interpolation;
  private Boolean useImageSize;
  private Boolean useBorderWithImage;

  private ShapeProperties(Builder builder) {
    this.borderDashesBoolean = builder.borderDashesBoolean;
    this.borderDashesArray = builder.borderDashesArray;
    this.borderRadius = builder.borderRadius;
    this.interpolation = builder.interpolation;
    this.useImageSize = builder.useImageSize;
    this.useBorderWithImage = builder.useBorderWithImage;
  }

  public ShapeProperties() {}

  @JsonGetter
  public Object getBorderDashes() {
    return ObjectUtils.firstNonNull(borderDashesArray, borderDashesBoolean);
  }

  public Boolean getBorderDashesBoolean() {
    return borderDashesBoolean;
  }

  public Integer[] getBorderDashesArray() {
    return borderDashesArray;
  }

  public void setBorderDashes(Boolean borderDashes) {
    this.borderDashesBoolean = borderDashes;
    this.borderDashesArray = null;
  }

  public void setBorderDashes(Integer[] borderDashes) {
    this.borderDashesBoolean = null;
    this.borderDashesArray = borderDashes;
  }

  public Integer getBorderRadius() {
    return borderRadius;
  }

  public void setBorderRadius(Integer borderRadius) {
    this.borderRadius = borderRadius;
  }

  public Boolean isInterpolation() {
    return interpolation;
  }

  public void setInterpolation(Boolean interpolation) {
    this.interpolation = interpolation;
  }

  public Boolean isUseImageSize() {
    return useImageSize;
  }

  public void setUseImageSize(Boolean useImageSize) {
    this.useImageSize = useImageSize;
  }

  public Boolean isUseBorderWithImage() {
    return useBorderWithImage;
  }

  public void setUseBorderWithImage(Boolean useBorderWithImage) {
    this.useBorderWithImage = useBorderWithImage;
  }

  /**
   * Creates builder to build {@link ShapeProperties}.
   *
   * @return created builder
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Builder to build {@link ShapeProperties}.
   */
  public static final class Builder {
    private Boolean borderDashesBoolean;
    private Integer[] borderDashesArray;
    private Integer borderRadius;
    private Boolean interpolation;
    private Boolean useImageSize;
    private Boolean useBorderWithImage;

    private Builder() {}

    @Nonnull
    public Builder withBorderDashes(Boolean borderDashes) {
      this.borderDashesBoolean = borderDashes;
      this.borderDashesArray = null;
      return this;
    }

    @Nonnull
    public Builder withBorderDashes(Integer[] borderDashes) {
      this.borderDashesBoolean = null;
      this.borderDashesArray = borderDashes;
      return this;
    }

    @Nonnull
    public Builder withBorderRadius(Integer borderRadius) {
      this.borderRadius = borderRadius;
      return this;
    }

    @Nonnull
    public Builder withInterpolation(Boolean interpolation) {
      this.interpolation = interpolation;
      return this;
    }

    @Nonnull
    public Builder withUseImageSize(Boolean useImageSize) {
      this.useImageSize = useImageSize;
      return this;
    }

    @Nonnull
    public Builder withUseBorderWithImage(Boolean useBorderWithImage) {
      this.useBorderWithImage = useBorderWithImage;
      return this;
    }

    @Nonnull
    public ShapeProperties build() {
      return new ShapeProperties(this);
    }
  }
}
