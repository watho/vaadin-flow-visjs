package de.wathoserver.vaadin.visjs.network.options.nodes;

import javax.annotation.Nonnull;

import org.apache.commons.lang3.ObjectUtils;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.wathoserver.vaadin.visjs.network.util.Fixed;
import de.wathoserver.vaadin.visjs.network.util.Font;
import de.wathoserver.vaadin.visjs.network.util.Scaling;
import de.wathoserver.vaadin.visjs.network.util.Shadow;
import de.wathoserver.vaadin.visjs.network.util.Shape;
import de.wathoserver.vaadin.visjs.network.util.ShapeProperties;

/**
 */
@JsonDeserialize(builder = Nodes.Builder.class)
public class Nodes {

  private Integer borderWidth;
  private Integer borderWidthSelected;
  private Boolean chosen;
  // Color needs special handling for object versus string
  @JsonIgnore
  private NodeColor color;
  @JsonIgnore
  private String colorStr;
  @JsonIgnore
  private Fixed fixedObject;
  @JsonIgnore
  private Boolean fixedBoolean;
  @JsonIgnore
  private Font fontObject;
  @JsonIgnore
  private String fontStr;
  // group
  @JsonIgnore
  private HeightConstraint heightConstraintObject;
  @JsonIgnore
  private Integer heightConstraintInteger;
  @JsonIgnore
  private Boolean heightConstraintBoolean;
  private Boolean hidden;
  private Icon icon;
  private String image;
  private String brokenImage;
  private String group;
  private String label;
  private Boolean labelHighlightBold;
  private Integer level;
  @JsonIgnore
  private Margin marginObject;
  @JsonIgnore
  private Integer marginInteger;
  private Integer mass;
  private Boolean physics;
  private Scaling scaling;
  @JsonIgnore
  private Shadow shadowObject;
  @JsonIgnore
  private Boolean shadowBoolean;
  private Shape shape;
  private ShapeProperties shapeProperties;

  private Integer size;
  private String title;
  private String value;
  @JsonIgnore
  private WidthConstraint widthConstraintObject;
  @JsonIgnore
  private Integer widthConstraintInteger;
  @JsonIgnore
  private Boolean widthConstraintBoolean;
  private Integer x;
  private Integer y;

  protected Nodes(Builder builder) {
    this.borderWidth = builder.borderWidth;
    this.borderWidthSelected = builder.borderWidthSelected;
    this.chosen = builder.chosen;
    this.color = builder.color;
    this.colorStr = builder.colorStr;
    this.fixedObject = builder.fixedObject;
    this.fixedBoolean = builder.fixedBoolean;
    this.fontObject = builder.fontObject;
    this.fontStr = builder.fontStr;
    this.heightConstraintObject = builder.heightConstraintObject;
    this.heightConstraintInteger = builder.heightConstraintInteger;
    this.heightConstraintBoolean = builder.heightConstraintBoolean;
    this.hidden = builder.hidden;
    this.icon = builder.icon;
    this.image = builder.image;
    this.brokenImage = builder.brokenImage;
    this.group = builder.group;
    this.label = builder.label;
    this.labelHighlightBold = builder.labelHighlightBold;
    this.level = builder.level;
    this.marginObject = builder.marginObject;
    this.marginInteger = builder.marginInteger;
    this.mass = builder.mass;
    this.physics = builder.physics;
    this.scaling = builder.scaling;
    this.shadowBoolean = builder.shadowBoolean;
    this.shadowObject = builder.shadowObject;
    this.shape = builder.shape;
    this.shapeProperties = builder.shapeProperties;
    this.size = builder.size;
    this.title = builder.title;
    this.value = builder.value;
    this.widthConstraintObject = builder.widthConstraintObject;
    this.widthConstraintInteger = builder.widthConstraintInteger;
    this.widthConstraintBoolean = builder.widthConstraintBoolean;
    this.x = builder.x;
    this.y = builder.y;
  }

  public Nodes() {}

  public boolean isChosen() {
    return chosen;
  }

  public void setChosen(final boolean chosen) {
    this.chosen = chosen;
  }

  public Integer getLevel() {
    return level;
  }

  public void setLevel(final Integer level) {
    this.level = level;
  }

  public int getBorderWidth() {
    return borderWidth;
  }

  public void setBorderWidth(final int borderWidth) {
    this.borderWidth = borderWidth;
  }

  public int getBorderWidthSelected() {
    return borderWidthSelected;
  }

  public void setBorderWidthSelected(final int borderWidthSelected) {
    this.borderWidthSelected = borderWidthSelected;
  }

  /**
   * if set colorStr returns
   *
   * @return colorStr if set, else color else null
   */
  @JsonGetter(value = "color")
  protected Object getColorJson() {
    if (color != null) {
      return color;
    } else if (colorStr != null) {
      return colorStr;
    }
    return null;
  }

  public String getColorStr() {
    return colorStr;
  }

  public NodeColor getColor() {
    return color;
  }

  public void setColor(final NodeColor color) {
    this.color = color;
    this.colorStr = null;
  }

  public void setColor(final String color) {
    this.colorStr = color;
    this.color = null;
  }

  @JsonGetter
  public Object getFixed() {
    return ObjectUtils.firstNonNull(fixedObject, fixedBoolean);
  }

  public Boolean getFixedBoolean() {
    return fixedBoolean;
  }

  public Fixed getFixedObject() {
    return fixedObject;
  }

  public void setFixed(final Boolean fixed) {
    this.fixedObject = null;
    this.fixedBoolean = fixed;
  }

  public void setFixed(final Fixed fixed) {
    this.fixedObject = fixed;
    this.fixedBoolean = null;
  }

  @JsonGetter
  public Object getFont() {
    return ObjectUtils.firstNonNull(fontObject, fontStr);
  }

  public Font getFontObject() {
    return fontObject;
  }

  public String getFontStr() {
    return fontStr;
  }

  public void setFont(Font font) {
    this.fontObject = font;
    this.fontStr = null;
  }

  public void setFont(String font) {
    this.fontStr = font;
    this.fontObject = null;
  }

  @JsonGetter
  public Object getHeightConstraint() {
    return ObjectUtils.firstNonNull(heightConstraintObject, heightConstraintInteger,
        heightConstraintBoolean);
  }

  public void setHeightConstraint(HeightConstraint heightConstraintObject) {
    this.heightConstraintObject = heightConstraintObject;
  }

  public void setHeightConstraint(Integer heightConstraintInteger) {
    this.heightConstraintInteger = heightConstraintInteger;
  }

  public void setHeightConstraint(Boolean heightConstraintBoolean) {
    this.heightConstraintBoolean = heightConstraintBoolean;
  }

  public HeightConstraint getHeightConstraintObject() {
    return heightConstraintObject;
  }

  public Integer getHeightConstraintInteger() {
    return heightConstraintInteger;
  }

  public Boolean getHeightConstraintBoolean() {
    return heightConstraintBoolean;
  }

  public boolean isHidden() {
    return hidden;
  }

  public void setHidden(final boolean hidden) {
    this.hidden = hidden;
  }

  public Icon getIcon() {
    return icon;
  }

  public void setIcon(final Icon icon) {
    this.icon = icon;
  }

  public String getImage() {
    return image;
  }

  public void setImage(final String image) {
    this.image = image;
  }

  public String getBrokenImage() {
    return brokenImage;
  }

  public void setBrokenImage(final String brokenImage) {
    this.brokenImage = brokenImage;
  }

  public String getGroup() {
    return group;
  }

  public void setGroup(String group) {
    this.group = group;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public boolean isLabelHighlightBold() {
    return labelHighlightBold;
  }

  public void setLabelHighlightBold(final boolean labelHighlightBold) {
    this.labelHighlightBold = labelHighlightBold;
  }

  @JsonGetter
  public Object getMargin() {
    return ObjectUtils.firstNonNull(marginObject, marginInteger);
  }

  public void setMargin(Integer marginInteger) {
    this.marginInteger = marginInteger;
    this.marginObject = null;
  }

  public void setMargin(Margin marginObject) {
    this.marginObject = marginObject;
    this.marginInteger = null;
  }

  public Integer getMarginInteger() {
    return marginInteger;
  }

  public Margin getMarginObject() {
    return marginObject;
  }

  public int getMass() {
    return mass;
  }

  public void setMass(final int mass) {
    this.mass = mass;
  }

  public boolean isPhysics() {
    return physics;
  }

  public void setPhysics(final boolean physics) {
    this.physics = physics;
  }

  public Scaling getScaling() {
    return scaling;
  }

  public void setScaling(final Scaling scaling) {
    this.scaling = scaling;
  }

  @JsonGetter
  public Object getShadow() {
    return ObjectUtils.firstNonNull(shadowObject, shadowBoolean);
  }

  public Boolean getShadowBoolean() {
    return shadowBoolean;
  }

  public Shadow getShadowObject() {
    return shadowObject;
  }

  public void setShadow(final Shadow shadow) {
    this.shadowObject = shadow;
    this.shadowBoolean = null;
  }

  public void setShadow(final Boolean shadow) {
    this.shadowBoolean = shadow;
    this.shadowObject = null;
  }

  public Shape getShape() {
    return shape;
  }

  public void setShape(final Shape shape) {
    this.shape = shape;
  }

  public ShapeProperties getShapeProperties() {
    return shapeProperties;
  }

  public void setShapeProperties(final ShapeProperties shapeProperties) {
    this.shapeProperties = shapeProperties;
  }

  public int getSize() {
    return size;
  }

  public void setSize(final int size) {
    this.size = size;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(final String title) {
    this.title = title;
  }

  public String getValue() {
    return value;
  }

  public void setValue(final String value) {
    this.value = value;
  }

  @JsonGetter
  public Object getWidthConstraint() {
    return ObjectUtils.firstNonNull(widthConstraintObject, widthConstraintInteger,
        widthConstraintBoolean);
  }

  public void setWidthConstraint(WidthConstraint widthConstraintObject) {
    this.widthConstraintObject = widthConstraintObject;
  }

  public void setWidthConstraint(Integer widthConstraintInteger) {
    this.widthConstraintInteger = widthConstraintInteger;
  }

  public void setWidthConstraint(Boolean widthConstraintBoolean) {
    this.widthConstraintBoolean = widthConstraintBoolean;
  }

  public WidthConstraint getWidthConstraintObject() {
    return widthConstraintObject;
  }

  public Integer getWidthConstraintInteger() {
    return widthConstraintInteger;
  }

  public Boolean getWidthConstraintBoolean() {
    return widthConstraintBoolean;
  }

  public Integer getX() {
    return x;
  }

  public void setX(final Integer x) {
    this.x = x;
  }

  public Integer getY() {
    return y;
  }

  public void setY(final Integer y) {
    this.y = y;
  }

  /**
   * Creates builder to build {@link Nodes}.
   *
   * @return created builder
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Builder to build {@link Nodes}.
   */
  public static class Builder {
    private Integer borderWidth;
    private Integer borderWidthSelected;
    private Boolean chosen;
    private NodeColor color;
    private String colorStr;
    private Fixed fixedObject;
    private Boolean fixedBoolean;
    private Font fontObject;
    private String fontStr;
    private HeightConstraint heightConstraintObject;
    private Integer heightConstraintInteger;
    private Boolean heightConstraintBoolean;
    private Boolean hidden;
    private Icon icon;
    private String image;
    private String brokenImage;
    private String group;
    private String label;
    private Boolean labelHighlightBold;
    private Integer level;
    private Margin marginObject;
    private Integer marginInteger;
    private Integer mass;
    private Boolean physics;
    private Scaling scaling;
    private Shadow shadowObject;
    private Boolean shadowBoolean;
    private Shape shape;
    private ShapeProperties shapeProperties;
    private Integer size;
    private String title;
    private String value;
    private WidthConstraint widthConstraintObject;
    private Integer widthConstraintInteger;
    private Boolean widthConstraintBoolean;
    private Integer x;
    private Integer y;

    protected Builder() {}

    @Nonnull
    public Builder withBorderWidth(Integer borderWidth) {
      this.borderWidth = borderWidth;
      return this;
    }

    @Nonnull
    public Builder withBorderWidthSelected(Integer borderWidthSelected) {
      this.borderWidthSelected = borderWidthSelected;
      return this;
    }

    @Nonnull
    public Builder withChosen(Boolean chosen) {
      this.chosen = chosen;
      return this;
    }

    @Nonnull
    public Builder withColor(NodeColor color) {
      this.color = color;
      return this;
    }

    @Nonnull
    public Builder withColor(String colorStr) {
      this.colorStr = colorStr;
      return this;
    }

    @Nonnull
    public Builder withFixed(Fixed fixed) {
      this.fixedObject = fixed;
      this.fixedBoolean = null;
      return this;
    }

    @Nonnull
    public Builder withFixed(Boolean fixed) {
      this.fixedBoolean = fixed;
      this.fixedObject = null;
      return this;
    }

    @Nonnull
    public Builder withFont(Font fontObject) {
      this.fontObject = fontObject;
      return this;
    }

    @Nonnull
    public Builder withFont(String fontStr) {
      this.fontStr = fontStr;
      return this;
    }

    @Nonnull
    public Builder withGroup(String group) {
      this.group = group;
      return this;
    }

    @Nonnull
    public Builder withLabel(String label) {
      this.label = label;
      return this;
    }

    @Nonnull
    public Builder withHeightConstraint(HeightConstraint heightConstraint) {
      this.heightConstraintObject = heightConstraint;
      this.heightConstraintInteger = null;
      this.heightConstraintBoolean = null;
      return this;
    }

    @Nonnull
    public Builder withHeightConstraint(Integer heightConstraint) {
      this.heightConstraintObject = null;
      this.heightConstraintInteger = heightConstraint;
      this.heightConstraintBoolean = null;
      return this;
    }

    @Nonnull
    public Builder withHeightConstraint(Boolean heightConstraint) {
      this.heightConstraintObject = null;
      this.heightConstraintInteger = null;
      this.heightConstraintBoolean = heightConstraint;
      return this;
    }

    @Nonnull
    public Builder withHidden(Boolean hidden) {
      this.hidden = hidden;
      return this;
    }

    @Nonnull
    public Builder withIcon(Icon icon) {
      this.icon = icon;
      return this;
    }

    @Nonnull
    public Builder withImage(String image) {
      this.image = image;
      return this;
    }

    @Nonnull
    public Builder withBrokenImage(String brokenImage) {
      this.brokenImage = brokenImage;
      return this;
    }

    @Nonnull
    public Builder withLabelHighlightBold(Boolean labelHighlightBold) {
      this.labelHighlightBold = labelHighlightBold;
      return this;
    }

    @Nonnull
    public Builder withLevel(Integer level) {
      this.level = level;
      return this;
    }

    @Nonnull
    public Builder withMargin(Margin margin) {
      this.marginObject = margin;
      this.marginInteger = null;
      return this;
    }

    @Nonnull
    public Builder withMargin(Integer margin) {
      this.marginObject = null;
      this.marginInteger = margin;
      return this;
    }

    @Nonnull
    public Builder withMass(Integer mass) {
      this.mass = mass;
      return this;
    }

    @Nonnull
    public Builder withPhysics(Boolean physics) {
      this.physics = physics;
      return this;
    }

    @Nonnull
    public Builder withScaling(Scaling scaling) {
      this.scaling = scaling;
      return this;
    }

    @Nonnull
    public Builder withShadow(Shadow shadow) {
      this.shadowObject = shadow;
      this.shadowBoolean = null;
      return this;
    }

    @Nonnull
    public Builder withShadow(Boolean shadow) {
      this.shadowObject = null;
      this.shadowBoolean = shadow;
      return this;
    }

    @Nonnull
    public Builder withShape(Shape shape) {
      this.shape = shape;
      return this;
    }

    @Nonnull
    public Builder withShapeProperties(ShapeProperties shapeProperties) {
      this.shapeProperties = shapeProperties;
      return this;
    }

    @Nonnull
    public Builder withSize(Integer size) {
      this.size = size;
      return this;
    }

    @Nonnull
    public Builder withTitle(String title) {
      this.title = title;
      return this;
    }

    @Nonnull
    public Builder withValue(String value) {
      this.value = value;
      return this;
    }

    @Nonnull
    public Builder withWidthConstraint(WidthConstraint widthConstraint) {
      this.widthConstraintObject = widthConstraint;
      this.widthConstraintInteger = null;
      this.widthConstraintBoolean = null;
      return this;
    }

    @Nonnull
    public Builder withWidthConstraint(Integer widthConstraint) {
      this.widthConstraintObject = null;
      this.widthConstraintInteger = widthConstraint;
      this.widthConstraintBoolean = null;
      return this;
    }

    @Nonnull
    public Builder withWidthConstraint(Boolean widthConstraint) {
      this.widthConstraintObject = null;
      this.widthConstraintInteger = null;
      this.widthConstraintBoolean = widthConstraint;
      return this;
    }

    @Nonnull
    public Builder withx(Integer x) {
      this.x = x;
      return this;
    }

    @Nonnull
    public Builder withy(Integer y) {
      this.y = y;
      return this;
    }

    @Nonnull
    public Nodes build() {
      return new Nodes(this);
    }
  }
}
