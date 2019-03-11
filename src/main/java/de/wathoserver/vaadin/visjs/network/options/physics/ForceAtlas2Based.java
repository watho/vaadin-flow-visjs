package de.wathoserver.vaadin.visjs.network.options.physics;

import javax.annotation.Nonnull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = ForceAtlas2Based.Builder.class)
public class ForceAtlas2Based {

  Integer gravitationalConstant;
  Integer springLength;
  Double centralGravity;
  Double springConstant;
  Double damping;
  Double avoidOverlap;

  private ForceAtlas2Based(Builder builder) {
    this.gravitationalConstant = builder.gravitationalConstant;
    this.springLength = builder.springLength;
    this.centralGravity = builder.centralGravity;
    this.springConstant = builder.springConstant;
    this.damping = builder.damping;
    this.avoidOverlap = builder.avoidOverlap;
  }

  public ForceAtlas2Based() {}

  public Integer getGravitationalConstant() {
    return gravitationalConstant;
  }

  public void setGravitationalConstant(Integer gravitationalConstant) {
    this.gravitationalConstant = gravitationalConstant;
  }

  public Integer getSpringLength() {
    return springLength;
  }

  public void setSpringLength(Integer springLength) {
    this.springLength = springLength;
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

  public Double getAvoidOverlap() {
    return avoidOverlap;
  }

  public void setAvoidOverlap(Double avoidOverlap) {
    this.avoidOverlap = avoidOverlap;
  }

  /**
   * Creates builder to build {@link ForceAtlas2Based}.
   *
   * @return created builder
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Builder to build {@link ForceAtlas2Based}.
   */
  public static final class Builder {
    private Integer gravitationalConstant;
    private Integer springLength;
    private Double centralGravity;
    private Double springConstant;
    private Double damping;
    private Double avoidOverlap;

    private Builder() {}

    @Nonnull
    public Builder withGravitationalConstant(Integer gravitationalConstant) {
      this.gravitationalConstant = gravitationalConstant;
      return this;
    }

    @Nonnull
    public Builder withSpringLength(Integer springLength) {
      this.springLength = springLength;
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
    public Builder withAvoidOverlap(Double avoidOverlap) {
      this.avoidOverlap = avoidOverlap;
      return this;
    }

    @Nonnull
    public ForceAtlas2Based build() {
      return new ForceAtlas2Based(this);
    }
  }

}
