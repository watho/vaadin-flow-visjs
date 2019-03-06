package de.wathoserver.vaadin.visjs.network.options.nodes;

import de.wathoserver.vaadin.visjs.network.util.Color;
import de.wathoserver.vaadin.visjs.network.util.Fixed;
import de.wathoserver.vaadin.visjs.network.util.Font;
import de.wathoserver.vaadin.visjs.network.util.Scaling;
import de.wathoserver.vaadin.visjs.network.util.Shadow;
import de.wathoserver.vaadin.visjs.network.util.Shape;
import de.wathoserver.vaadin.visjs.network.util.ShapeProperties;

/**
 * Created by roshans on 10/29/14. Updated to latest elements by Martin Prause 4.8.2017
 */
public class Nodes {

  private int borderWidth = 1;
  private int borderWidthSelected;
  private boolean chosen = true;
  private Color color;
  private Fixed fixed = new Fixed();
  private Font font;
  // group
  private boolean heightConstraint = false;
  private boolean hidden = false;
  private Icon icon;
  private String image;
  private String brokenImage;

  private boolean labelHighlightBold = true;
  private Integer level;
  private int mass = 1;
  private boolean physics = true;
  private Scaling scaling;
  private Shadow shadow;
  private Shape shape = Shape.ellipse;
  private ShapeProperties shapeProperties;

  private int size = 25;
  private String title = null;
  private String value = null;
  private WidthConstraint widthConstraint;
  private Integer x = null;
  private Integer y = null;

  public boolean isChosen() {
    return chosen;
  }

  public void setChosen(final boolean chosen) {
    this.chosen = chosen;
  }

  public WidthConstraint getWidthConstraint() {
    return widthConstraint;
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

  public Color getColor() {
    return color;
  }

  public void setColor(final Color color) {
    this.color = color;
  }

  public Font getFont() {
    return font;
  }

  public void setFont(final Font font) {
    this.font = font;
  }

  public boolean isHeightConstraint() {
    return heightConstraint;
  }

  public void setHeightConstraint(final boolean heightConstraint) {
    this.heightConstraint = heightConstraint;
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

  public boolean isLabelHighlightBold() {
    return labelHighlightBold;
  }

  public void setLabelHighlightBold(final boolean labelHighlightBold) {
    this.labelHighlightBold = labelHighlightBold;
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

  public Shadow getShadow() {
    return shadow;
  }

  public void setShadow(final Shadow shadow) {
    this.shadow = shadow;
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

  public WidthConstraint isWidthConstraint() {
    return widthConstraint;
  }

  public void setWidthConstraint(final WidthConstraint widthConstraint) {
    this.widthConstraint = widthConstraint;
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

  public Fixed getFixed() {
    if (fixed == null) {
      fixed = new Fixed();
    }
    return fixed;
  }

  public void setFixed(final boolean fixed) {
    getFixed().setX(fixed);
    getFixed().setY(fixed);
  }

  public void setFixed(final Fixed fixed) {
    this.fixed = fixed;
  }

  public boolean isFixedX() {
    return getFixed().isX();
  }

  public void setFixedX(final boolean fixedX) {
    getFixed().setX(fixedX);
  }

  public boolean isFixedY() {
    return getFixed().isY();
  }

  public void setFixedY(final boolean fixedY) {
    getFixed().setY(fixedY);
  }

}
