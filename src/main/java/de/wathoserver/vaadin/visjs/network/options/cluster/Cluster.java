package de.wathoserver.vaadin.visjs.network.options.cluster;

import javax.annotation.Generated;
import javax.annotation.Nonnull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = Cluster.Builder.class)
public class Cluster {

  private Integer initialMaxNodes;
  private Integer clusterThreshold;
  private Integer reduceToNodes;
  private Integer clusterEdgeThreshold;
  private Integer sectorThreshold;
  private Integer maxFontSize;
  private Integer edgeGrowth;
  private Integer maxNodeSizeIncrements;
  private Integer activeAreaBoxSize;
  private Integer clusterLevelDifference;

  private Double chainThreshold;
  private Double screenSizeThreshold;
  private Double fontSizeMultiplier;
  private Double forceAmplification;
  private Double distanceAmplification;

  private NodeScale nodeScaling = new NodeScale();

  private Cluster(Builder builder) {
    this.initialMaxNodes = builder.initialMaxNodes;
    this.clusterThreshold = builder.clusterThreshold;
    this.reduceToNodes = builder.reduceToNodes;
    this.clusterEdgeThreshold = builder.clusterEdgeThreshold;
    this.sectorThreshold = builder.sectorThreshold;
    this.maxFontSize = builder.maxFontSize;
    this.edgeGrowth = builder.edgeGrowth;
    this.maxNodeSizeIncrements = builder.maxNodeSizeIncrements;
    this.activeAreaBoxSize = builder.activeAreaBoxSize;
    this.clusterLevelDifference = builder.clusterLevelDifference;
    this.chainThreshold = builder.chainThreshold;
    this.screenSizeThreshold = builder.screenSizeThreshold;
    this.fontSizeMultiplier = builder.fontSizeMultiplier;
    this.forceAmplification = builder.forceAmplification;
    this.distanceAmplification = builder.distanceAmplification;
    this.nodeScaling = builder.nodeScaling;
  }

  @Generated("SparkTools")
  public Cluster() {}

  public Integer getInitialMaxNodes() {
    return initialMaxNodes;
  }

  public void setInitialMaxNodes(Integer initialMaxNodes) {
    this.initialMaxNodes = initialMaxNodes;
  }

  public Integer getClusterThreshold() {
    return clusterThreshold;
  }

  public void setClusterThreshold(Integer clusterThreshold) {
    this.clusterThreshold = clusterThreshold;
  }

  public Integer getReduceToNodes() {
    return reduceToNodes;
  }

  public void setReduceToNodes(Integer reduceToNodes) {
    this.reduceToNodes = reduceToNodes;
  }

  public Integer getClusterEdgeThreshold() {
    return clusterEdgeThreshold;
  }

  public void setClusterEdgeThreshold(Integer clusterEdgeThreshold) {
    this.clusterEdgeThreshold = clusterEdgeThreshold;
  }

  public Integer getSectorThreshold() {
    return sectorThreshold;
  }

  public void setSectorThreshold(Integer sectorThreshold) {
    this.sectorThreshold = sectorThreshold;
  }

  public Integer getMaxFontSize() {
    return maxFontSize;
  }

  public void setMaxFontSize(Integer maxFontSize) {
    this.maxFontSize = maxFontSize;
  }

  public Integer getEdgeGrowth() {
    return edgeGrowth;
  }

  public void setEdgeGrowth(Integer edgeGrowth) {
    this.edgeGrowth = edgeGrowth;
  }

  public Integer getMaxNodeSizeIncrements() {
    return maxNodeSizeIncrements;
  }

  public void setMaxNodeSizeIncrements(Integer maxNodeSizeIncrements) {
    this.maxNodeSizeIncrements = maxNodeSizeIncrements;
  }

  public Integer getActiveAreaBoxSize() {
    return activeAreaBoxSize;
  }

  public void setActiveAreaBoxSize(Integer activeAreaBoxSize) {
    this.activeAreaBoxSize = activeAreaBoxSize;
  }

  public Integer getClusterLevelDifference() {
    return clusterLevelDifference;
  }

  public void setClusterLevelDifference(Integer clusterLevelDifference) {
    this.clusterLevelDifference = clusterLevelDifference;
  }

  public Double getChainThreshold() {
    return chainThreshold;
  }

  public void setChainThreshold(Double chainThreshold) {
    this.chainThreshold = chainThreshold;
  }

  public Double getScreenSizeThreshold() {
    return screenSizeThreshold;
  }

  public void setScreenSizeThreshold(Double screenSizeThreshold) {
    this.screenSizeThreshold = screenSizeThreshold;
  }

  public Double getFontSizeMultiplier() {
    return fontSizeMultiplier;
  }

  public void setFontSizeMultiplier(Double fontSizeMultiplier) {
    this.fontSizeMultiplier = fontSizeMultiplier;
  }

  public Double getForceAmplification() {
    return forceAmplification;
  }

  public void setForceAmplification(Double forceAmplification) {
    this.forceAmplification = forceAmplification;
  }

  public Double getDistanceAmplification() {
    return distanceAmplification;
  }

  public void setDistanceAmplification(Double distanceAmplification) {
    this.distanceAmplification = distanceAmplification;
  }

  public NodeScale getNodeScaling() {
    return nodeScaling;
  }

  public void setNodeScaling(NodeScale nodeScaling) {
    this.nodeScaling = nodeScaling;
  }

  /**
   * Creates builder to build {@link Cluster}.
   *
   * @return created builder
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Builder to build {@link Cluster}.
   */
  public static final class Builder {
    private Integer initialMaxNodes;
    private Integer clusterThreshold;
    private Integer reduceToNodes;
    private Integer clusterEdgeThreshold;
    private Integer sectorThreshold;
    private Integer maxFontSize;
    private Integer edgeGrowth;
    private Integer maxNodeSizeIncrements;
    private Integer activeAreaBoxSize;
    private Integer clusterLevelDifference;
    private Double chainThreshold;
    private Double screenSizeThreshold;
    private Double fontSizeMultiplier;
    private Double forceAmplification;
    private Double distanceAmplification;
    private NodeScale nodeScaling;

    private Builder() {}

    @Nonnull
    public Builder withInitialMaxNodes(Integer initialMaxNodes) {
      this.initialMaxNodes = initialMaxNodes;
      return this;
    }

    @Nonnull
    public Builder withClusterThreshold(Integer clusterThreshold) {
      this.clusterThreshold = clusterThreshold;
      return this;
    }

    @Nonnull
    public Builder withReduceToNodes(Integer reduceToNodes) {
      this.reduceToNodes = reduceToNodes;
      return this;
    }

    @Nonnull
    public Builder withClusterEdgeThreshold(Integer clusterEdgeThreshold) {
      this.clusterEdgeThreshold = clusterEdgeThreshold;
      return this;
    }

    @Nonnull
    public Builder withSectorThreshold(Integer sectorThreshold) {
      this.sectorThreshold = sectorThreshold;
      return this;
    }

    @Nonnull
    public Builder withMaxFontSize(Integer maxFontSize) {
      this.maxFontSize = maxFontSize;
      return this;
    }

    @Nonnull
    public Builder withEdgeGrowth(Integer edgeGrowth) {
      this.edgeGrowth = edgeGrowth;
      return this;
    }

    @Nonnull
    public Builder withMaxNodeSizeIncrements(Integer maxNodeSizeIncrements) {
      this.maxNodeSizeIncrements = maxNodeSizeIncrements;
      return this;
    }

    @Nonnull
    public Builder withActiveAreaBoxSize(Integer activeAreaBoxSize) {
      this.activeAreaBoxSize = activeAreaBoxSize;
      return this;
    }

    @Nonnull
    public Builder withClusterLevelDifference(Integer clusterLevelDifference) {
      this.clusterLevelDifference = clusterLevelDifference;
      return this;
    }

    @Nonnull
    public Builder withChainThreshold(Double chainThreshold) {
      this.chainThreshold = chainThreshold;
      return this;
    }

    @Nonnull
    public Builder withScreenSizeThreshold(Double screenSizeThreshold) {
      this.screenSizeThreshold = screenSizeThreshold;
      return this;
    }

    @Nonnull
    public Builder withFontSizeMultiplier(Double fontSizeMultiplier) {
      this.fontSizeMultiplier = fontSizeMultiplier;
      return this;
    }

    @Nonnull
    public Builder withForceAmplification(Double forceAmplification) {
      this.forceAmplification = forceAmplification;
      return this;
    }

    @Nonnull
    public Builder withDistanceAmplification(Double distanceAmplification) {
      this.distanceAmplification = distanceAmplification;
      return this;
    }

    @Nonnull
    public Builder withNodeScaling(NodeScale nodeScaling) {
      this.nodeScaling = nodeScaling;
      return this;
    }

    @Nonnull
    public Cluster build() {
      return new Cluster(this);
    }
  }
}
