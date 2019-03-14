package de.wathoserver.vaadin.visjs.network.options;

import javax.annotation.Nonnull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = HierarchicalLayout.Builder.class)
public class HierarchicalLayout {

  private Boolean enabled;
  private Integer levelSeparation;
  private Integer nodeSpacing;
  private Integer treeSpacing;
  private Boolean blockShifting;
  private Boolean edgeMinimization;
  private Boolean parentCentralization;
  private Direction direction;
  private SortMethod sortMethod;

  private HierarchicalLayout(Builder builder) {
    this.enabled = builder.enabled;
    this.levelSeparation = builder.levelSeparation;
    this.nodeSpacing = builder.nodeSpacing;
    this.direction = builder.direction;
    this.sortMethod = builder.sortMethod;
    this.treeSpacing = builder.treeSpacing;
    this.blockShifting = builder.blockShifting;
    this.edgeMinimization = builder.edgeMinimization;
    this.parentCentralization = builder.parentCentralization;
  }

  public HierarchicalLayout() {}

  public Integer getTreeSpacing() {
    return treeSpacing;
  }

  public void setTreeSpacing(Integer treeSpacing) {
    this.treeSpacing = treeSpacing;
  }

  public Boolean isBlockShifting() {
    return blockShifting;
  }

  public void setBlockShifting(Boolean blockShifting) {
    this.blockShifting = blockShifting;
  }

  public Boolean isEdgeMinimization() {
    return edgeMinimization;
  }

  public void setEdgeMinimization(Boolean edgeMinimization) {
    this.edgeMinimization = edgeMinimization;
  }

  public Boolean isParentCentralization() {
    return parentCentralization;
  }

  public void setParentCentralization(Boolean parentCentralization) {
    this.parentCentralization = parentCentralization;
  }

  public Boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  public Integer getLevelSeparation() {
    return levelSeparation;
  }

  public void setLevelSeparation(Integer levelSeparation) {
    this.levelSeparation = levelSeparation;
  }

  public Integer getNodeSpacing() {
    return nodeSpacing;
  }

  public void setNodeSpacing(Integer nodeSpacing) {
    this.nodeSpacing = nodeSpacing;
  }

  public Direction getDirection() {
    return direction;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }

  public SortMethod getSortMethod() {
    return sortMethod;
  }

  public void setSortMethod(SortMethod sortMethod) {
    this.sortMethod = sortMethod;
  }

  public static enum Direction {
    UD, DU, LR, RL;
  }

  public static enum SortMethod {
    hubsize, directed;
  }

  /**
   * Creates builder to build {@link HierarchicalLayout}.
   *
   * @return created builder
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Builder to build {@link HierarchicalLayout}.
   */
  public static final class Builder {
    private Boolean enabled;
    private Integer levelSeparation;
    private Integer nodeSpacing;
    private Direction direction;
    private SortMethod sortMethod;
    private Integer treeSpacing;
    private Boolean blockShifting;
    private Boolean edgeMinimization;
    private Boolean parentCentralization;

    private Builder() {}

    @Nonnull
    public Builder withEnabled(Boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    @Nonnull
    public Builder withLevelSeparation(Integer levelSeparation) {
      this.levelSeparation = levelSeparation;
      return this;
    }

    @Nonnull
    public Builder withNodeSpacing(Integer nodeSpacing) {
      this.nodeSpacing = nodeSpacing;
      return this;
    }

    @Nonnull
    public Builder withDirection(Direction direction) {
      this.direction = direction;
      return this;
    }

    @Nonnull
    public Builder withSortMethod(SortMethod sortMethod) {
      this.sortMethod = sortMethod;
      return this;
    }

    @Nonnull
    public Builder withTreeSpacing(Integer treeSpacing) {
      this.treeSpacing = treeSpacing;
      return this;
    }

    @Nonnull
    public Builder withBlockShifting(Boolean blockShifting) {
      this.blockShifting = blockShifting;
      return this;
    }

    @Nonnull
    public Builder withEdgeMinimization(Boolean edgeMinimization) {
      this.edgeMinimization = edgeMinimization;
      return this;
    }

    @Nonnull
    public Builder withParentCentralization(Boolean parentCentralization) {
      this.parentCentralization = parentCentralization;
      return this;
    }

    @Nonnull
    public HierarchicalLayout build() {
      return new HierarchicalLayout(this);
    }
  }
}
