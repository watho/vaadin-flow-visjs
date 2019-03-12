package de.wathoserver.vaadin.visjs.network.options;

import javax.annotation.Nonnull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = Locale.Builder.class)
public class Locale {
  private String edit;
  private String del;
  private String back;
  private String addNode;
  private String addEdge;
  private String editNode;
  private String editEdge;
  private String addDescription;
  private String edgeDescription;
  private String editEdgeDescription;
  private String createEdgeError;
  private String deleteClusterError;
  private String editClusterError;

  private Locale(Builder builder) {
    this.edit = builder.edit;
    this.del = builder.del;
    this.back = builder.back;
    this.addNode = builder.addNode;
    this.addEdge = builder.addEdge;
    this.editNode = builder.editNode;
    this.editEdge = builder.editEdge;
    this.addDescription = builder.addDescription;
    this.edgeDescription = builder.edgeDescription;
    this.editEdgeDescription = builder.editEdgeDescription;
    this.createEdgeError = builder.createEdgeError;
    this.deleteClusterError = builder.deleteClusterError;
    this.editClusterError = builder.editClusterError;
  }

  public Locale() {}

  public String getEdit() {
    return edit;
  }

  public void setEdit(String edit) {
    this.edit = edit;
  }

  public String getDel() {
    return del;
  }

  public void setDel(String del) {
    this.del = del;
  }

  public String getBack() {
    return back;
  }

  public void setBack(String back) {
    this.back = back;
  }

  public String getAddNode() {
    return addNode;
  }

  public void setAddNode(String addNode) {
    this.addNode = addNode;
  }

  public String getAddEdge() {
    return addEdge;
  }

  public void setAddEdge(String addEdge) {
    this.addEdge = addEdge;
  }

  public String getEditNode() {
    return editNode;
  }

  public void setEditNode(String editNode) {
    this.editNode = editNode;
  }

  public String getEditEdge() {
    return editEdge;
  }

  public void setEditEdge(String editEdge) {
    this.editEdge = editEdge;
  }

  public String getAddDescription() {
    return addDescription;
  }

  public void setAddDescription(String addDescription) {
    this.addDescription = addDescription;
  }

  public String getEdgeDescription() {
    return edgeDescription;
  }

  public void setEdgeDescription(String edgeDescription) {
    this.edgeDescription = edgeDescription;
  }

  public String getEditEdgeDescription() {
    return editEdgeDescription;
  }

  public void setEditEdgeDescription(String editEdgeDescription) {
    this.editEdgeDescription = editEdgeDescription;
  }

  public String getCreateEdgeError() {
    return createEdgeError;
  }

  public void setCreateEdgeError(String createEdgeError) {
    this.createEdgeError = createEdgeError;
  }

  public String getDeleteClusterError() {
    return deleteClusterError;
  }

  public void setDeleteClusterError(String deleteClusterError) {
    this.deleteClusterError = deleteClusterError;
  }

  public String getEditClusterError() {
    return editClusterError;
  }

  public void setEditClusterError(String editClusterError) {
    this.editClusterError = editClusterError;
  }

  /**
   * Creates builder to build {@link Locale}.
   *
   * @return created builder
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Builder to build {@link Locale}.
   */
  public static final class Builder {
    private String edit;
    private String del;
    private String back;
    private String addNode;
    private String addEdge;
    private String editNode;
    private String editEdge;
    private String addDescription;
    private String edgeDescription;
    private String editEdgeDescription;
    private String createEdgeError;
    private String deleteClusterError;
    private String editClusterError;

    private Builder() {}

    @Nonnull
    public Builder withEdit(String edit) {
      this.edit = edit;
      return this;
    }

    @Nonnull
    public Builder withDel(String del) {
      this.del = del;
      return this;
    }

    @Nonnull
    public Builder withBack(String back) {
      this.back = back;
      return this;
    }

    @Nonnull
    public Builder withAddNode(String addNode) {
      this.addNode = addNode;
      return this;
    }

    @Nonnull
    public Builder withAddEdge(String addEdge) {
      this.addEdge = addEdge;
      return this;
    }

    @Nonnull
    public Builder withEditNode(String editNode) {
      this.editNode = editNode;
      return this;
    }

    @Nonnull
    public Builder withEditEdge(String editEdge) {
      this.editEdge = editEdge;
      return this;
    }

    @Nonnull
    public Builder withAddDescription(String addDescription) {
      this.addDescription = addDescription;
      return this;
    }

    @Nonnull
    public Builder withEdgeDescription(String edgeDescription) {
      this.edgeDescription = edgeDescription;
      return this;
    }

    @Nonnull
    public Builder withEditEdgeDescription(String editEdgeDescription) {
      this.editEdgeDescription = editEdgeDescription;
      return this;
    }

    @Nonnull
    public Builder withCreateEdgeError(String createEdgeError) {
      this.createEdgeError = createEdgeError;
      return this;
    }

    @Nonnull
    public Builder withDeleteClusterError(String deleteClusterError) {
      this.deleteClusterError = deleteClusterError;
      return this;
    }

    @Nonnull
    public Builder withEditClusterError(String editClusterError) {
      this.editClusterError = editClusterError;
      return this;
    }

    @Nonnull
    public Locale build() {
      return new Locale(this);
    }
  }
}
