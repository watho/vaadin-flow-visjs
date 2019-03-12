package de.wathoserver.vaadin.visjs.network.options.edges;

import javax.annotation.Nonnull;

import org.apache.commons.lang3.ObjectUtils;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.wathoserver.vaadin.visjs.network.options.HierarchicalLayout;

@JsonDeserialize(builder = Layout.Builder.class)
public class Layout {

  private Integer randomSeed;
  private Boolean improvedLayout;
  @JsonIgnore
  HierarchicalLayout hierarchicalObject;
  @JsonIgnore
  Boolean hierarchicalBoolean;

  private Layout(Builder builder) {
    this.randomSeed = builder.randomSeed;
    this.improvedLayout = builder.improvedLayout;
    this.hierarchicalObject = builder.hierarchicalObject;
    this.hierarchicalBoolean = builder.hierarchicalBoolean;
  }

  public Layout() {}

  public Integer getRandomSeed() {
    return randomSeed;
  }

  public void setRandomSeed(Integer randomSeed) {
    this.randomSeed = randomSeed;
  }

  public Boolean isImprovedLayout() {
    return improvedLayout;
  }

  public void setImprovedLayout(Boolean improvedLayout) {
    this.improvedLayout = improvedLayout;
  }

  @JsonGetter
  public Object getHierarchical() {
    return ObjectUtils.firstNonNull(hierarchicalObject, hierarchicalBoolean);
  }

  public void setHierarchical(Boolean hierarchical) {
    this.hierarchicalBoolean = hierarchical;
    this.hierarchicalObject = null;
  }

  public void setHierarchicalObject(HierarchicalLayout hierarchical) {
    this.hierarchicalObject = hierarchical;
    this.hierarchicalBoolean = null;
  }

  public HierarchicalLayout getHierarchicalObject() {
    return hierarchicalObject;
  }

  public Boolean getHierarchicalBoolean() {
    return hierarchicalBoolean;
  }

  /**
   * Creates builder to build {@link Layout}.
   *
   * @return created builder
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Builder to build {@link Layout}.
   */
  public static final class Builder {
    private Integer randomSeed;
    private Boolean improvedLayout;
    private HierarchicalLayout hierarchicalObject;
    private Boolean hierarchicalBoolean;

    private Builder() {}

    @Nonnull
    public Builder withRandomSeed(Integer randomSeed) {
      this.randomSeed = randomSeed;
      return this;
    }

    @Nonnull
    public Builder withImprovedLayout(Boolean improvedLayout) {
      this.improvedLayout = improvedLayout;
      return this;
    }

    @Nonnull
    public Builder withHierarchical(HierarchicalLayout hierarchical) {
      this.hierarchicalObject = hierarchical;
      this.hierarchicalBoolean = null;
      return this;
    }

    @Nonnull
    public Builder withHierarchical(Boolean hierarchical) {
      this.hierarchicalObject = null;
      this.hierarchicalBoolean = hierarchical;
      return this;
    }

    @Nonnull
    public Layout build() {
      return new Layout(this);
    }
  }
}
