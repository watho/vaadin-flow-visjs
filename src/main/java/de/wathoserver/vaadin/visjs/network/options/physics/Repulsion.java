package de.wathoserver.vaadin.visjs.network.options.physics;

import javax.annotation.Nonnull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = Repulsion.Builder.class)
public class Repulsion {

  Integer springLength;
  Integer nodeDistance;

  Double centralGravity;
  Double springConstant;
  Double damping;

  private Repulsion(Builder builder) {
    this.springLength = builder.springLength;
    this.nodeDistance = builder.nodeDistance;
    this.centralGravity = builder.centralGravity;
    this.springConstant = builder.springConstant;
    this.damping = builder.damping;
  }

  public Repulsion() {}

  public Integer getSpringLength() {
    return springLength;
  }

  public void setSpringLength(Integer springLength) {
    this.springLength = springLength;
  }

  public Integer getNodeDistance() {
    return nodeDistance;
  }

  public void setNodeDistance(Integer nodeDistance) {
    this.nodeDistance = nodeDistance;
  }

  public Double getCentralGravity() {
    return centralGravity;
  }

  public void setCentralGravity(Double centralGravity) {
    this.centralGravity = centralGravity;
  }

  public Double getSpringConstant() {
    return springConstant;
  }

  public void setSpringConstant(Double springConstant) {
    this.springConstant = springConstant;
  }

  public Double getDamping() {
    return damping;
  }

  public void setDamping(Double damping) {
    this.damping = damping;
  }

  /**
   * Creates builder to build {@link Repulsion}.
   * 
   * @return created builder
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Builder to build {@link Repulsion}.
   */
  public static final class Builder {
    private Integer springLength;
    private Integer nodeDistance;
    private Double centralGravity;
    private Double springConstant;
    private Double damping;

    private Builder() {}

    @Nonnull
    public Builder withSpringLength(Integer springLength) {
      this.springLength = springLength;
      return this;
    }

    @Nonnull
    public Builder withNodeDistance(Integer nodeDistance) {
      this.nodeDistance = nodeDistance;
      return this;
    }

    @Nonnull
    public Builder withCentralGravity(Double centralGravity) {
      this.centralGravity = centralGravity;
      return this;
    }

    @Nonnull
    public Builder withSpringConstant(Double springConstant) {
      this.springConstant = springConstant;
      return this;
    }

    @Nonnull
    public Builder withDamping(Double damping) {
      this.damping = damping;
      return this;
    }

    @Nonnull
    public Repulsion build() {
      return new Repulsion(this);
    }
  }
}
