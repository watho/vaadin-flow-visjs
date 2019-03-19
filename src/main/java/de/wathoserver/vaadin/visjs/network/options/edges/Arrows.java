package de.wathoserver.vaadin.visjs.network.options.edges;

import javax.annotation.Nonnull;

import org.apache.commons.lang3.ObjectUtils;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;

public class Arrows {

  @JsonIgnore
  private ArrowHead toObject;
  @JsonIgnore
  private Boolean toBoolean;
  @JsonIgnore
  private ArrowHead middleObject;
  @JsonIgnore
  private Boolean middleBoolean;
  @JsonIgnore
  private ArrowHead fromObject;
  @JsonIgnore
  private Boolean fromBoolean;

  private Arrows(Builder builder) {
    this.toObject = builder.toObject;
    this.toBoolean = builder.toBoolean;
    this.middleObject = builder.middleObject;
    this.middleBoolean = builder.middleBoolean;
    this.fromObject = builder.fromObject;
    this.fromBoolean = builder.fromBoolean;
  }

  public Arrows() {}

  @JsonGetter
  public Object getTo() {
    return ObjectUtils.firstNonNull(toObject, toBoolean);
  }

  @JsonSetter(nulls = Nulls.SKIP, contentNulls = Nulls.SKIP)
  private void setTo(final Object to) {
    if (to != null) {
      if (to instanceof ArrowHead) {
        setTo(((ArrowHead) to));
      }
      if (to instanceof Boolean) {
        setTo(((Boolean) to));
      }
    }
  }

  public void setTo(final ArrowHead to) {
    this.toObject = to;
    this.toBoolean = null;
  }

  public void setTo(final Boolean to) {
    this.toObject = null;
    this.toBoolean = to;
  }

  public ArrowHead getToObject() {
    return toObject;
  }

  public Boolean getToBoolean() {
    return toBoolean;
  }

  @JsonGetter
  public Object getMiddle() {
    return ObjectUtils.firstNonNull(middleObject, middleBoolean);
  }

  @JsonSetter(nulls = Nulls.SKIP, contentNulls = Nulls.SKIP)
  private void setMiddle(final Object middle) {
    if (middle != null) {
      if (middle instanceof ArrowHead) {
        setMiddle(((ArrowHead) middle));
      }
      if (middle instanceof Boolean) {
        setMiddle(((Boolean) middle));
      }
    }
  }

  public void setMiddle(final ArrowHead middle) {
    this.middleObject = middle;
    this.middleBoolean = null;
  }

  public void setMiddle(final Boolean middle) {
    this.middleObject = null;
    this.middleBoolean = middle;
  }

  public ArrowHead getMiddleObject() {
    return middleObject;
  }

  public Boolean getMiddleBoolean() {
    return middleBoolean;
  }

  @JsonGetter
  public Object getFrom() {
    return ObjectUtils.firstNonNull(fromObject, fromBoolean);
  }

  @JsonSetter(nulls = Nulls.SKIP, contentNulls = Nulls.SKIP)
  private void setFrom(final Object from) {
    if (from != null) {
      if (from instanceof ArrowHead) {
        setFrom(((ArrowHead) from));
      }
      if (from instanceof Boolean) {
        setFrom(((Boolean) from));
      }
    }
  }

  public void setFrom(final ArrowHead from) {
    this.fromObject = from;
    this.fromBoolean = null;
  }

  public void setFrom(final Boolean from) {
    this.fromObject = null;
    this.fromBoolean = from;
  }

  public ArrowHead getFromObject() {
    return fromObject;
  }

  public Boolean getFromBoolean() {
    return fromBoolean;
  }

  /**
   * Creates builder to build {@link Arrows}.
   *
   * @return created builder
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Builder to build {@link Arrows}.
   */
  public static final class Builder {
    private ArrowHead toObject;
    private Boolean toBoolean;
    private ArrowHead middleObject;
    private Boolean middleBoolean;
    private ArrowHead fromObject;
    private Boolean fromBoolean;

    private Builder() {}

    @Nonnull
    public Builder withTo(ArrowHead toObject) {
      this.toObject = toObject;
      return this;
    }

    @Nonnull
    public Builder withTo(Boolean toBoolean) {
      this.toBoolean = toBoolean;
      return this;
    }

    @Nonnull
    public Builder withMiddle(ArrowHead middleObject) {
      this.middleObject = middleObject;
      return this;
    }

    @Nonnull
    public Builder withMiddle(Boolean middleBoolean) {
      this.middleBoolean = middleBoolean;
      return this;
    }

    @Nonnull
    public Builder withFrom(ArrowHead fromObject) {
      this.fromObject = fromObject;
      return this;
    }

    @Nonnull
    public Builder withFrom(Boolean fromBoolean) {
      this.fromBoolean = fromBoolean;
      return this;
    }

    @Nonnull
    public Arrows build() {
      return new Arrows(this);
    }
  }
}
