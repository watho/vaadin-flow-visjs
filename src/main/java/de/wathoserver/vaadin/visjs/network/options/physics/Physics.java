package de.wathoserver.vaadin.visjs.network.options.physics;

import javax.annotation.Nonnull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = Physics.Builder.class)
public class Physics {

  private Boolean enabled;
  private BarnesHut barnesHut;
  private ForceAtlas2Based forceAtlas2Based;
  private Repulsion repulsion;
  private HierarchicalRepulsion hierarchicalRepulsion;

  Integer maxVelocity;
  Double minVelocity;
  Solver solver;

  Stabilization stabilization;
  Double timestep;
  Boolean adaptiveTimestep;

  private Physics(Builder builder) {
    this.enabled = builder.enabled;
    this.barnesHut = builder.barnesHut;
    this.forceAtlas2Based = builder.forceAtlas2Based;
    this.repulsion = builder.repulsion;
    this.hierarchicalRepulsion = builder.hierarchicalRepulsion;
    this.maxVelocity = builder.maxVelocity;
    this.minVelocity = builder.minVelocity;
    this.solver = builder.solver;
    this.stabilization = builder.stabilization;
    this.timestep = builder.timestep;
    this.adaptiveTimestep = builder.adaptiveTimestep;
  }

  public Physics() {}

  public BarnesHut getBarnesHut() {
    return barnesHut;
  }

  public void setBarnesHut(BarnesHut barnesHut) {
    this.barnesHut = barnesHut;
  }

  public Repulsion getRepulsion() {
    return repulsion;
  }

  public void setRepulsion(Repulsion repulsion) {
    this.repulsion = repulsion;
  }

  public HierarchicalRepulsion getHierarchicalRepulsion() {
    return hierarchicalRepulsion;
  }

  public void setHierarchicalRepulsion(HierarchicalRepulsion hierarchicalRepulsion) {
    this.hierarchicalRepulsion = hierarchicalRepulsion;
  }

  public Boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  public ForceAtlas2Based getForceAtlas2Based() {
    return forceAtlas2Based;
  }

  public void setForceAtlas2Based(ForceAtlas2Based forceAtlas2Based) {
    this.forceAtlas2Based = forceAtlas2Based;
  }

  public Integer getMaxVelocity() {
    return maxVelocity;
  }

  public void setMaxVelocity(Integer maxVelocity) {
    this.maxVelocity = maxVelocity;
  }

  public Double getMinVelocity() {
    return minVelocity;
  }

  public void setMinVelocity(Double minVelocity) {
    this.minVelocity = minVelocity;
  }

  public Solver getSolver() {
    return solver;
  }

  public void setSolver(Solver solver) {
    this.solver = solver;
  }

  public Double getTimestep() {
    return timestep;
  }

  public void setTimestep(Double timestep) {
    this.timestep = timestep;
  }

  public Boolean isAdaptiveTimestep() {
    return adaptiveTimestep;
  }

  public void setAdaptiveTimestep(Boolean adaptiveTimestep) {
    this.adaptiveTimestep = adaptiveTimestep;
  }

  public Stabilization getStabilization() {
    return stabilization;
  }

  public void setStabilization(Stabilization stabilization) {
    this.stabilization = stabilization;
  }

  public static enum Solver {
    barnesHut, repulsion, hierarchicalRepulsion, forceAtlas2Based;
  }

  /**
   * Creates builder to build {@link Physics}.
   *
   * @return created builder
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Builder to build {@link Physics}.
   */
  public static final class Builder {
    private Boolean enabled;
    private BarnesHut barnesHut;
    private ForceAtlas2Based forceAtlas2Based;
    private Repulsion repulsion;
    private HierarchicalRepulsion hierarchicalRepulsion;
    private Integer maxVelocity;
    private Double minVelocity;
    private Solver solver;
    private Stabilization stabilization;
    private Double timestep;
    private Boolean adaptiveTimestep;

    private Builder() {}

    @Nonnull
    public Builder withEnabled(Boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    @Nonnull
    public Builder withBarnesHut(BarnesHut barnesHut) {
      this.barnesHut = barnesHut;
      return this;
    }

    @Nonnull
    public Builder withForceAtlas2Based(ForceAtlas2Based forceAtlas2Based) {
      this.forceAtlas2Based = forceAtlas2Based;
      return this;
    }

    @Nonnull
    public Builder withRepulsion(Repulsion repulsion) {
      this.repulsion = repulsion;
      return this;
    }

    @Nonnull
    public Builder withHierarchicalRepulsion(HierarchicalRepulsion hierarchicalRepulsion) {
      this.hierarchicalRepulsion = hierarchicalRepulsion;
      return this;
    }

    @Nonnull
    public Builder withMaxVelocity(Integer maxVelocity) {
      this.maxVelocity = maxVelocity;
      return this;
    }

    @Nonnull
    public Builder withMinVelocity(Double minVelocity) {
      this.minVelocity = minVelocity;
      return this;
    }

    @Nonnull
    public Builder withSolver(Solver solver) {
      this.solver = solver;
      return this;
    }

    @Nonnull
    public Builder withStabilization(Stabilization stabilization) {
      this.stabilization = stabilization;
      return this;
    }

    @Nonnull
    public Builder withTimestep(Double timestep) {
      this.timestep = timestep;
      return this;
    }

    @Nonnull
    public Builder withAdaptiveTimestep(Boolean adaptiveTimestep) {
      this.adaptiveTimestep = adaptiveTimestep;
      return this;
    }

    @Nonnull
    public Physics build() {
      return new Physics(this);
    }
  }
}
