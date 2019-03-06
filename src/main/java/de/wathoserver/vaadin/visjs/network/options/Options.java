package de.wathoserver.vaadin.visjs.network.options;

import java.util.HashMap;

import javax.annotation.Nonnull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.wathoserver.vaadin.visjs.network.options.edges.ArrowHead;
import de.wathoserver.vaadin.visjs.network.options.edges.Arrows;
import de.wathoserver.vaadin.visjs.network.options.edges.Edges;
import de.wathoserver.vaadin.visjs.network.options.edges.Layout;
import de.wathoserver.vaadin.visjs.network.options.nodes.Nodes;
import de.wathoserver.vaadin.visjs.network.options.physics.Physics;

public class Options {

  private boolean clickToUse = true;
  private boolean autoResize = true;
  private String locale = "en";
  private String height = "300px";
  private String width = "300px";
  private HashMap<String, Locale> locales;
  private Configure configure;
  private Manipulation manipulation;
  private Interaction interaction;
  private HashMap<String, Group> groups;

  private Physics physics;
  private Edges edges;
  private Nodes nodes;
  // private Cluster clustering;
  private Layout layout;

  private Options(Builder builder) {
    this.clickToUse = builder.clickToUse;
    this.autoResize = builder.autoResize;
    this.locale = builder.locale;
    this.height = builder.height;
    this.width = builder.width;
    this.locales = builder.locales;
    this.configure = builder.configure;
    this.manipulation = builder.manipulation;
    this.interaction = builder.interaction;
    this.groups = builder.groups;
    this.physics = builder.physics;
    this.edges = builder.edges;
    this.nodes = builder.nodes;
    this.layout = builder.layout;
  }

  public Options() {
    configure = new Configure();
    manipulation = new Manipulation();
    interaction = new Interaction();
    locales = new HashMap<>();
    locales.put("en", new Locale());
    final Arrows ar = new Arrows(new ArrowHead());
    edges = new Edges();
    edges.setArrows(ar);
    nodes = new Nodes();
    groups = new HashMap<>();
    physics = new Physics();
    layout = new Layout();
  }

  public HashMap<String, Group> getGroups() {
    return groups;
  }

  public void setGroups(final HashMap<String, Group> groups) {
    this.groups = groups;
  }

  public void addGroup(final String name, final Group group) {
    groups.put(name, group);
  }

  public void removeGroup(final String name) {
    groups.remove(name);
  }

  public void clearGroups() {
    groups.clear();
  }

  public Interaction getInteraction() {
    return interaction;
  }

  public void setInteraction(final Interaction interaction) {
    this.interaction = interaction;
  }

  public boolean isAutoResize() {
    return autoResize;
  }

  public void setAutoResize(final boolean autoResize) {
    this.autoResize = autoResize;
  }

  public String getLocale() {
    return locale;
  }

  public void setLocale(final String locale) {
    this.locale = locale;
  }

  public Configure getConfigure() {
    return configure;
  }

  public void setConfigure(final Configure configure) {
    this.configure = configure;
  }

  public Manipulation getManipulation() {
    return manipulation;
  }

  public void setManipulation(final Manipulation manipulation) {
    this.manipulation = manipulation;
  }

  /**
   * Toggle the manipulation system on or off. Even when false, the manipulation API through the
   * methods will still work.
   */
  @JsonIgnore
  public void setManipulationEnabled(final boolean enable) {
    if (getManipulation() == null) {
      setManipulation(new Manipulation());
    }
    getManipulation().setEnabled(enable);
  }

  @JsonIgnore
  public boolean isManipulationEnabled() {
    if (getManipulation() != null) {
      return getManipulation().isEnabled();
    }
    // default
    return false;
  }

  public boolean isClickToUse() {
    return clickToUse;
  }

  public void setClickToUse(final boolean clickToUse) {
    this.clickToUse = clickToUse;
  }

  public String getHeight() {
    return height;
  }

  public void setHeight(final String height) {
    this.height = height;
  }

  public String getWidth() {
    return width;
  }

  public void setWidth(final String width) {
    this.width = width;
  }

  public HashMap<String, Locale> getLocales() {
    return locales;
  }

  public void setLocales(final HashMap<String, Locale> locales) {
    this.locales = locales;
  }

  public Physics getPhysics() {
    return physics;
  }

  public void setPhysics(final Physics physics) {
    this.physics = physics;
  }

  public Edges getEdges() {
    return edges;
  }

  public void setEdges(final Edges edges) {
    this.edges = edges;
  }

  public Nodes getNodes() {
    return nodes;
  }

  public void setNodes(final Nodes nodes) {
    this.nodes = nodes;
  }

  public Layout getLayout() {
    return layout;
  }

  public void setLayout(final Layout layout) {
    this.layout = layout;
  }

  /**
   * Creates builder to build {@link Options}.
   *
   * @return created builder
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Builder to build {@link Options}.
   */
  public static final class Builder {
    private boolean clickToUse;
    private boolean autoResize;
    private String locale;
    private String height;
    private String width;
    private HashMap<String, Locale> locales = new HashMap<>();
    private Configure configure = new Configure();
    private Manipulation manipulation = new Manipulation();
    private Interaction interaction = new Interaction();
    private HashMap<String, Group> groups;
    private Physics physics;
    private Edges edges;
    private Nodes nodes;
    private Layout layout;

    private Builder() {
      configure = new Configure();
      manipulation = new Manipulation();
      interaction = new Interaction();
      locales = new HashMap<>();
      locales.put("en", new Locale());
      final Arrows ar = new Arrows(new ArrowHead());
      edges = new Edges();
      edges.setArrows(ar);
      nodes = new Nodes();
      groups = new HashMap<>();
      physics = new Physics();
      layout = new Layout();
    }

    @Nonnull
    public Builder withClickToUse(boolean clickToUse) {
      this.clickToUse = clickToUse;
      return this;
    }

    @Nonnull
    public Builder withAutoResize(boolean autoResize) {
      this.autoResize = autoResize;
      return this;
    }

    @Nonnull
    public Builder withLocale(String locale) {
      this.locale = locale;
      return this;
    }

    @Nonnull
    public Builder withHeight(String height) {
      this.height = height;
      return this;
    }

    @Nonnull
    public Builder withWidth(String width) {
      this.width = width;
      return this;
    }

    @Nonnull
    public Builder withLocales(HashMap<String, Locale> locales) {
      this.locales = locales;
      return this;
    }

    @Nonnull
    public Builder withConfigure(Configure configure) {
      this.configure = configure;
      return this;
    }

    @Nonnull
    public Builder withManipulation(Manipulation manipulation) {
      this.manipulation = manipulation;
      return this;
    }

    @Nonnull
    public Builder withInteraction(Interaction interaction) {
      this.interaction = interaction;
      return this;
    }

    @Nonnull
    public Builder withGroups(HashMap<String, Group> groups) {
      this.groups = groups;
      return this;
    }

    @Nonnull
    public Builder withPhysics(Physics physics) {
      this.physics = physics;
      return this;
    }

    @Nonnull
    public Builder withEdges(Edges edges) {
      this.edges = edges;
      return this;
    }

    @Nonnull
    public Builder withNodes(Nodes nodes) {
      this.nodes = nodes;
      return this;
    }

    @Nonnull
    public Builder withLayout(Layout layout) {
      this.layout = layout;
      return this;
    }

    @Nonnull
    public Options build() {
      return new Options(this);
    }
  }

}
