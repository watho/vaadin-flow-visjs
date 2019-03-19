package de.wathoserver.vaadin.visjs.network;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.ClientCallable;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.DetachEvent;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.JavaScript;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.provider.Query;
import com.vaadin.flow.function.SerializableConsumer;
import com.vaadin.flow.internal.JsonUtils;
import com.vaadin.flow.shared.Registration;

import de.wathoserver.vaadin.visjs.network.api.NetworkDiagramEvent;
import de.wathoserver.vaadin.visjs.network.event.AfterDrawingEvent;
import de.wathoserver.vaadin.visjs.network.event.AnimationFinshedEvent;
import de.wathoserver.vaadin.visjs.network.event.BeforeDrawingEvent;
import de.wathoserver.vaadin.visjs.network.event.BlurEdgeEvent;
import de.wathoserver.vaadin.visjs.network.event.BlurNodeEvent;
import de.wathoserver.vaadin.visjs.network.event.ClickEvent;
import de.wathoserver.vaadin.visjs.network.event.ConfigChangeEvent;
import de.wathoserver.vaadin.visjs.network.event.DeselectEdgeEvent;
import de.wathoserver.vaadin.visjs.network.event.DeselectNodeEvent;
import de.wathoserver.vaadin.visjs.network.event.DoubleClickEvent;
import de.wathoserver.vaadin.visjs.network.event.DragEndEvent;
import de.wathoserver.vaadin.visjs.network.event.DragStartEvent;
import de.wathoserver.vaadin.visjs.network.event.DraggingEvent;
import de.wathoserver.vaadin.visjs.network.event.EdgesChangedEvent;
import de.wathoserver.vaadin.visjs.network.event.EdgesChangedEvent.EventType;
import de.wathoserver.vaadin.visjs.network.event.HidePopupEvent;
import de.wathoserver.vaadin.visjs.network.event.HoldEvent;
import de.wathoserver.vaadin.visjs.network.event.HoverEdgeEvent;
import de.wathoserver.vaadin.visjs.network.event.HoverNodeEvent;
import de.wathoserver.vaadin.visjs.network.event.InitRedrawEvent;
import de.wathoserver.vaadin.visjs.network.event.NodesChangedEvent;
import de.wathoserver.vaadin.visjs.network.event.OnContextEvent;
import de.wathoserver.vaadin.visjs.network.event.ReleaseEvent;
import de.wathoserver.vaadin.visjs.network.event.ResizeEvent;
import de.wathoserver.vaadin.visjs.network.event.SelectEdgeEvent;
import de.wathoserver.vaadin.visjs.network.event.SelectEvent;
import de.wathoserver.vaadin.visjs.network.event.SelectNodeEvent;
import de.wathoserver.vaadin.visjs.network.event.ShowPopupEvent;
import de.wathoserver.vaadin.visjs.network.event.StabilizationIterationsDoneEvent;
import de.wathoserver.vaadin.visjs.network.event.StabilizationProgressEvent;
import de.wathoserver.vaadin.visjs.network.event.StabilizedEvent;
import de.wathoserver.vaadin.visjs.network.event.StartStabilizingEvent;
import de.wathoserver.vaadin.visjs.network.event.ZoomEvent;
import de.wathoserver.vaadin.visjs.network.listener.AfterDrawingListener;
import de.wathoserver.vaadin.visjs.network.listener.AnimationFinishedListener;
import de.wathoserver.vaadin.visjs.network.listener.BeforeDrawingListener;
import de.wathoserver.vaadin.visjs.network.listener.BlurEdgeListener;
import de.wathoserver.vaadin.visjs.network.listener.BlurNodeListener;
import de.wathoserver.vaadin.visjs.network.listener.ClickListener;
import de.wathoserver.vaadin.visjs.network.listener.ConfigChangeListener;
import de.wathoserver.vaadin.visjs.network.listener.DeselectEdgeListener;
import de.wathoserver.vaadin.visjs.network.listener.DeselectNodeListener;
import de.wathoserver.vaadin.visjs.network.listener.DoubleClickListener;
import de.wathoserver.vaadin.visjs.network.listener.DragEndListener;
import de.wathoserver.vaadin.visjs.network.listener.DragStartListener;
import de.wathoserver.vaadin.visjs.network.listener.DraggingListener;
import de.wathoserver.vaadin.visjs.network.listener.EdgesChangedListener;
import de.wathoserver.vaadin.visjs.network.listener.HidePopupListener;
import de.wathoserver.vaadin.visjs.network.listener.HoldListener;
import de.wathoserver.vaadin.visjs.network.listener.HoverEdgeListener;
import de.wathoserver.vaadin.visjs.network.listener.HoverNodeListener;
import de.wathoserver.vaadin.visjs.network.listener.InitRedrawListener;
import de.wathoserver.vaadin.visjs.network.listener.NodesChangedListener;
import de.wathoserver.vaadin.visjs.network.listener.OnContextListener;
import de.wathoserver.vaadin.visjs.network.listener.ReleaseListener;
import de.wathoserver.vaadin.visjs.network.listener.ResizeListener;
import de.wathoserver.vaadin.visjs.network.listener.SelectEdgeListener;
import de.wathoserver.vaadin.visjs.network.listener.SelectListener;
import de.wathoserver.vaadin.visjs.network.listener.SelectNodeListener;
import de.wathoserver.vaadin.visjs.network.listener.ShowPopupListener;
import de.wathoserver.vaadin.visjs.network.listener.StabilizationIterationsDoneListener;
import de.wathoserver.vaadin.visjs.network.listener.StabilizedListener;
import de.wathoserver.vaadin.visjs.network.listener.StabilizingProgressListener;
import de.wathoserver.vaadin.visjs.network.listener.StartStabilizingListener;
import de.wathoserver.vaadin.visjs.network.listener.ZoomListener;
import de.wathoserver.vaadin.visjs.network.options.Options;
import elemental.json.JsonArray;
import elemental.json.JsonString;
import elemental.json.JsonType;
import elemental.json.impl.JreJsonString;

/**
 * Wraps a visjs network diagram. See http://visjs.org/network_examples.html
 */
@SuppressWarnings("serial")
@Tag("div")
@JavaScript("frontend://de/wathoserver/vaadin/visjs/vis-patched.min.js")
@JavaScript("frontend://de/wathoserver/vaadin/visjs/networkDiagram-connector-flow.js")
@StyleSheet("frontend://de/wathoserver/vaadin/visjs/vis-network.min.css")
@StyleSheet("frontend://de/wathoserver/vaadin/visjs/networkDiagram.css")
public class NetworkDiagram extends Component implements HasSize, HasStyle {

  Logger log = LoggerFactory.getLogger(NetworkDiagram.class);

  private final Options options;
  private String predefinedNodesVariableName;
  private String predefinedEdgesVariableName;
  private final ObjectMapper mapper = new ObjectMapper();

  // Holds all eventtypes already registered client side.
  private final Set<Class<? extends NetworkDiagramEvent>> enabledEvents = new LinkedHashSet<>();

  private DataProvider<Edge, ?> edgesDataProvider = DataProvider.ofItems();
  private DataProvider<Node, ?> nodesDataProvider = DataProvider.ofItems();

  private Registration edgeDataProviderListenerRegistration;
  private Registration nodeDataProviderListenerRegistration;
  private final Map<String, Node> nodes = new LinkedHashMap<>();
  private final Map<String, Edge> edges = new LinkedHashMap<>();

  public NetworkDiagram() {
    this(new Options());
  }

  public NetworkDiagram(final Options options) {
    super();
    // Dont transfer empty options.
    mapper.setSerializationInclusion(Include.NON_EMPTY);
    // Dont transfer getter and setter
    mapper.setVisibility(mapper.getSerializationConfig().getDefaultVisibilityChecker()
        .withGetterVisibility(Visibility.NONE).withSetterVisibility(Visibility.NONE)
        .withIsGetterVisibility(Visibility.NONE).withFieldVisibility(Visibility.ANY));
    // remains utf8 escaped chars
    mapper.configure(Feature.ESCAPE_NON_ASCII, true);
    // mapper.getFactory().configure(JsonGenerator, true);
    this.options = Objects.requireNonNull(options);
    // if (options.getManipulation() == null) {
    // options.setManipulation(new Manipulation());
    // }
    this.setWidth(options.getWidth());
    this.setHeight(options.getHeight());
  }

  private void initConnector() {
    nodes.clear();
    edges.clear();
    String nodesArray = "[]";
    try {
      nodesArray = mapper.writeValueAsString(
          getNodesDataProvider().fetch(new Query<>()).collect(Collectors.toSet()));
    } catch (final JsonProcessingException e) {
      e.printStackTrace();
    }
    String edgesArray = "[]";
    try {
      edgesArray = mapper.writeValueAsString(
          getEdgesDataProvider().fetch(new Query<>()).collect(Collectors.toSet()));
    } catch (final JsonProcessingException e) {
      e.printStackTrace();
    }
    getUI()
        .orElseThrow(() -> new IllegalStateException(
            "Connector can only be initialized for an attached NetworkDiagram"))
        .getPage().executeJavaScript(
            "window.Vaadin.Flow.networkDiagramConnector.initLazy($0, $1, $2, $3, $4, $5)",
            getElement(), nodesArray, edgesArray, optionsToJson(options),
            predefinedNodesVariableName, predefinedEdgesVariableName);
    // TODO reinitialise listener
    // getEventBus().hasListener(eventType)
  }

  @Override
  protected void onAttach(AttachEvent attachEvent) {
    super.onAttach(attachEvent);
    initConnector();
  }

  @Override
  protected void onDetach(DetachEvent detachEvent) {
    super.onDetach(detachEvent);
    // FIXME does not work this.diagamDestroy();
    enabledEvents.clear();
  }

  private String optionsToJson(final Options options) {
    try {
      log.info("Options: {}", mapper.writeValueAsString(options));
      return mapper.writeValueAsString(options);
    } catch (final JsonProcessingException e) {
      e.printStackTrace();
    }
    return "{}";
  }

  void runBeforeClientResponse(SerializableConsumer<UI> command) {
    getElement().getNode()
        .runWhenAttached(ui -> ui.beforeClientResponse(this, context -> command.accept(ui)));
  }

  /**
   * Creates a ListDataProvider with the given items.
   *
   * @param nodes
   */
  public void setNodes(Collection<Node> nodes) {
    setNodesDataProvider(new ListDataProvider<>(nodes));
  }

  /**
   * Creates a ListDataProvider with the given items.
   *
   * @param nodes
   */
  public void setNodes(Node... nodes) {
    setNodesDataProvider(new ListDataProvider<>(Arrays.asList(nodes)));
  }

  /**
   * Creates a ListDataProvider with the given items.
   *
   * @param edges
   */
  public void setEdges(Collection<Edge> edges) {
    setEdgesDataProvider(new ListDataProvider<>(edges));
  }

  /**
   * Creates Edges in ListDataProvider with given ids. edgesIds are interpreted as pairs of fromId
   * and toId. Therefore count has to be even. <br>
   * e.g. setEdges("1","2","2","3") creates new Edge("1", "2") and new Edge("2", "3");
   *
   * @param edgesIds
   */
  public void setEdges(String... edgesIds) {
    if (!(edgesIds.length % 2 == 0)) {
      throw new IllegalArgumentException("number of arguments has to be even");
    }
    final Set<Edge> edges = Arrays.stream(edgesIds).sequential().flatMap(new PairCollater<>())
        .map(pair -> new Edge(pair.getLeft(), pair.getRight())).collect(Collectors.toSet());
    this.setEdges(edges);
  }

  /**
   * Creates a ListDataProvider with the given items.
   *
   * @param edges
   */
  public void setEdges(Edge... edges) {
    setEdgesDataProvider(new ListDataProvider<>(Arrays.asList(edges)));
  }

  public void setData(Iterable<Node> nodes, Iterable<Edge> edges) {
    // TODO use DataProvider
    try {
      getElement().callFunction("$connector.setData", mapper.writeValueAsString(nodes),
          mapper.writeValueAsString(edges));
    } catch (final JsonProcessingException e) {
      e.printStackTrace();
    }
  }

  public void addNodes(Iterable<Node> nodes) {
    addNodes(StreamSupport.stream(nodes.spliterator(), false).toArray(Node[]::new));
  }

  public void addNodes(final Node... node) {
    runBeforeClientResponse(ui -> {
      try {
        getElement().callFunction("$connector.addNodes", mapper.writeValueAsString(node));
      } catch (final JsonProcessingException e) {
        e.printStackTrace();
      }
    });
  }

  public void updateNodes(Iterable<Node> nodes) {
    updateNodes(StreamSupport.stream(nodes.spliterator(), false).toArray(Node[]::new));
  }

  public void updateNodes(final Node... node) {
    runBeforeClientResponse(ui -> {
      try {
        getElement().callFunction("$connector.updateNodes", mapper.writeValueAsString(node));
      } catch (final JsonProcessingException e) {
        e.printStackTrace();
      }
    });
  }

  public void removeNodes(Iterable<String> nodeIds) {
    removeNodes(StreamSupport.stream(nodeIds.spliterator(), false).toArray(String[]::new));
  }

  public void removeNodes(final String... nodeIds) {
    runBeforeClientResponse(ui -> {
      try {
        getElement().callFunction("$connector.removeNodes", mapper.writeValueAsString(nodeIds));
      } catch (final JsonProcessingException e) {
        e.printStackTrace();
      }
    });
  }

  public void addEdges(Iterable<Edge> edges) {
    addEdges(StreamSupport.stream(edges.spliterator(), false).toArray(Edge[]::new));
  }

  public void addEdges(final Edge... edge) {
    runBeforeClientResponse(ui -> {
      try {
        getElement().callFunction("$connector.addEdges", mapper.writeValueAsString(edge));
      } catch (final JsonProcessingException e) {
        e.printStackTrace();
      }
    });
  }

  public void updateEdges(Iterable<Edge> edges) {
    updateEdges(StreamSupport.stream(edges.spliterator(), false).toArray(Edge[]::new));
  }

  public void updateEdges(final Edge... edge) {
    runBeforeClientResponse(ui -> {
      try {
        getElement().callFunction("$connector.updateEdges", mapper.writeValueAsString(edge));
      } catch (final JsonProcessingException e) {
        e.printStackTrace();
      }
    });
  }

  public void removeEdges(Iterable<String> edgeIds) {
    removeEdges(StreamSupport.stream(edgeIds.spliterator(), false).toArray(String[]::new));
  }

  public void removeEdges(final String... edgeIds) {
    runBeforeClientResponse(ui -> {
      try {
        getElement().callFunction("$connector.removeEdges", mapper.writeValueAsString(edgeIds));
      } catch (final JsonProcessingException e) {
        e.printStackTrace();
      }
    });
  }

  public void clearEdges() {
    runBeforeClientResponse(ui -> {
      getElement().callFunction("$connector.clearEdges");
    });
  }

  public void clearNodes() {
    runBeforeClientResponse(ui -> {
      getElement().callFunction("$connector.clearNodes");
    });
  }

  /**
   * Returns the data provider of this diagram.
   *
   * @return the data provider of this diagram, not {@code null}
   */
  public DataProvider<Edge, ?> getEdgesDataProvider() {
    return edgesDataProvider;
  }

  /**
   * Returns the data provider of this diagram.
   *
   * @return the data provider of this diagram, not {@code null}
   */
  public DataProvider<Node, ?> getNodesDataProvider() {
    return nodesDataProvider;
  }

  public void setEdgesDataProvider(DataProvider<Edge, ?> dataProvider) {
    Objects.requireNonNull(dataProvider, "The dataProvider cannot be null");
    this.edgesDataProvider = dataProvider;
    reset();
    if (edgeDataProviderListenerRegistration != null) {
      edgeDataProviderListenerRegistration.remove();
    }
    edgeDataProviderListenerRegistration = dataProvider.addDataProviderListener(e -> reset());
  }

  public void setNodesDataProvider(DataProvider<Node, ?> dataProvider) {
    Objects.requireNonNull(dataProvider, "The dataProvider cannot be null");
    this.nodesDataProvider = dataProvider;
    reset();
    if (nodeDataProviderListenerRegistration != null) {
      nodeDataProviderListenerRegistration.remove();
    }
    nodeDataProviderListenerRegistration = dataProvider.addDataProviderListener(e -> reset());
  }

  private void reset() {
    final Set<Node> nodes = nodesDataProvider.fetch(new Query<>()).collect(Collectors.toSet());
    final Set<Edge> edges = edgesDataProvider.fetch(new Query<>()).collect(Collectors.toSet());
    clearNodes();
    clearEdges();
    addNodes(nodes);
    addEdges(edges);
  }

  /**
   *
   * @return unmodifiableMap of edges
   */
  public Map<String, Edge> getEdges() {
    return Collections.unmodifiableMap(edges);
  }

  /**
   *
   * @return unmodifiableMap of nodes
   */
  public Map<String, Node> getNodes() {
    return Collections.unmodifiableMap(nodes);
  }

  /**
   * Name of the variable which holds an array with edges. Useful when edges are loaded through
   * external javascript-file.
   *
   * @return
   */
  public String getPredefinedEdgesVariableName() {
    return predefinedEdgesVariableName;
  }

  public void setPredefinedEdgesVariableName(String predefinedEdgesVariableName) {
    this.predefinedEdgesVariableName = predefinedEdgesVariableName;
  }

  /**
   * Name of the variable which holds an array with nodes. Useful when nodes are loaded through
   * external javascript-file.
   *
   * @return
   */
  public String getPredefinedNodesVariableName() {
    return predefinedNodesVariableName;
  }

  public void setPredefinedNodesVariableName(String predefinedNodesVariableName) {
    this.predefinedNodesVariableName = predefinedNodesVariableName;
  }

  /**
   * Clears all edges and nodes sets them to predefinedNodes|EdgesVariable if defined
   */
  public void updatePredefinedNodesAndEdges() {
    runBeforeClientResponse(ui -> getElement().callFunction("$connector.updatePredefined"));
  }

  // ==== Diagram-Methods ====
  public void redrawDiagram() {
    runBeforeClientResponse(ui -> getElement().callFunction("$connector.diagram.redraw"));
  }

  public void setSize(final String width, final String height) {
    this.setWidth(width);
    this.setHeight(height);
    runBeforeClientResponse(
        ui -> getElement().callFunction("$connector.diagram.setSize", width, height));
  }

  public void selectNodes(Iterable<String> nodeIds) {
    final JsonArray nodeIdArray = StreamSupport.stream(nodeIds.spliterator(), false)
        .map(JreJsonString::new).collect(JsonUtils.asArray());
    runBeforeClientResponse(
        ui -> getElement().callFunction("$connector.diagram.selectNodes", nodeIdArray));
  }

  public void selectEdges(Iterable<String> edgeIds) {
    final JsonArray edgeIdArray = StreamSupport.stream(edgeIds.spliterator(), false)
        .map(JreJsonString::new).collect(JsonUtils.asArray());
    runBeforeClientResponse(
        ui -> getElement().callFunction("$connector.diagram.selectEdges", edgeIdArray));
  }

  public void setOptions(final Options options) {
    runBeforeClientResponse(ui -> {
      try {
        getElement().callFunction("$connector.setOptions", mapper.writeValueAsString(options));
      } catch (final JsonProcessingException e) {
        e.printStackTrace();
      }
    });
  }

  public void stabilizeDiagram() {
    runBeforeClientResponse(ui -> getElement().callFunction("$connector.diagram.stabilize"));
  }

  public void unselectAll() {
    runBeforeClientResponse(ui -> getElement().callFunction("$connector.diagram.unselectAll"));
  }

  public void fitDiagram() {
    runBeforeClientResponse(ui -> getElement().callFunction("$connector.diagram.fit"));
  }

  @Override
  public void setSizeFull() {
    HasSize.super.setSizeFull();
    runBeforeClientResponse(
        ui -> getElement().callFunction("$connector.diagram.setSize", getWidth(), getHeight()));
  }

  public void destroyDiagram() {
    runBeforeClientResponse(ui -> getElement().callFunction("$connector.diagram.destroy"));
  }

  public void resetDiagram() {
    destroyDiagram();
    runBeforeClientResponse(ui -> getElement().callFunction("$connector.init"));
  }

  /**
   * The jackson object mapper used to serialize options, nodes and edges.
   *
   * @return
   */
  public ObjectMapper getMapper() {
    return mapper;
  }

  /**
   * Called from javascript, when node changes occur.
   *
   * @param eventTypeJson
   * @param params
   */
  @ClientCallable
  public void nodesChanged(final JsonString eventTypeJson, final JsonArray params) {
    final de.wathoserver.vaadin.visjs.network.event.NodesChangedEvent.EventType eventType =
        de.wathoserver.vaadin.visjs.network.event.NodesChangedEvent.EventType
            .valueOf(eventTypeJson.asString());
    final int size = params.length();
    for (int i = 0; i < size; i++) {
      switch (eventType) {
        case add:
        case update:
          if (params.get(i).getType().equals(JsonType.OBJECT)) {
            log.debug("Node: {}", params.getObject(i));
            try {
              final Node node = mapper.readValue(params.getObject(i).toJson(), Node.class);
              nodes.put(node.getId(), node);
            } catch (final IOException e) {
              e.printStackTrace();
            }
          } else {
            log.warn("Retrieved wrong param for {} type: {}", params.get(i).toJson(),
                params.get(i).getType());
          }
          break;
        case remove:
          if (params.get(i).getType().equals(JsonType.STRING)) {
            log.debug("NodeId to delete: {}", params.getString(i));
            nodes.remove(params.getString(i));
          } else {
            log.warn("Retrieved wrong param for {} type: {}", params.get(i).toJson(),
                params.get(i).getType());
          }
          break;
        default:
          log.warn("Unknown eventType: {}", eventTypeJson.asString());
          break;
      }
    }
    fireEvent(new NodesChangedEvent(this, true, eventType));
  }

  /**
   * Called from javascript, when edge changes occur.
   *
   * @param eventTypeJson add, update or delete
   * @param params array with objects of type edge
   */
  @ClientCallable
  public void edgesChanged(final JsonString eventTypeJson, final JsonArray params) {
    final EventType eventType = EventType.valueOf(eventTypeJson.asString());
    final int size = params.length();
    for (int i = 0; i < size; i++) {
      switch (eventType) {
        case add:
        case update:
          if (params.get(i).getType().equals(JsonType.OBJECT)) {
            log.debug("Edge: {}", params.getObject(i));
            try {
              final Edge edge = mapper.readValue(params.getObject(i).toJson(), Edge.class);
              edges.put(edge.getId(), edge);
            } catch (final IOException e) {
              e.printStackTrace();
            }
          } else {
            log.warn("Retrieved wrong param for {} type: {}", params.get(i).toJson(),
                params.get(i).getType());
          }
          break;
        case remove:
          if (params.get(i).getType().equals(JsonType.STRING)) {
            log.debug("EdgeId to delete: {}", params.getString(i));
            edges.remove(params.getString(i));
          } else {
            log.warn("Retrieved wrong param for {} type: {}", params.get(i).toJson(),
                params.get(i).getType());
          }
          break;
        default:
          log.warn("Unknown eventType: {}", eventTypeJson.asString());
          break;
      }
    }
    fireEvent(new EdgesChangedEvent(this, true, eventType));
  }

  // ==== Events ====
  private void enableEventDispatching(Class<? extends NetworkDiagramEvent> clazz) {
    runBeforeClientResponse(ui -> {
      if (!enabledEvents.contains(clazz)) {
        enabledEvents.add(clazz);
        getElement().callFunction("$connector.enableEventDispatching",
            clazz.getAnnotation(DomEvent.class).value());
      }
    });
  }

  public Registration addNodesChangedListener(final NodesChangedListener listener) {
    return addListener(NodesChangedEvent.class, listener);
  }

  public Registration addEdgesChangedListener(final EdgesChangedListener listener) {
    return addListener(EdgesChangedEvent.class, listener);
  }

  public Registration addClickListener(final ClickListener listener) {
    enableEventDispatching(ClickEvent.class);
    return new NetworkDiagramRegistration(addListener(ClickEvent.class, listener), event -> {
      // Should disable event dispatching here but only if this is last event of this type.
    });
  }

  public Registration addDoubleClickListener(final DoubleClickListener listener) {
    enableEventDispatching(DoubleClickEvent.class);
    return addListener(DoubleClickEvent.class, listener);
  }

  public Registration addOnContextListener(final OnContextListener listener) {
    enableEventDispatching(OnContextEvent.class);
    return addListener(OnContextEvent.class, listener);
  }

  public Registration addHoldListener(final HoldListener listener) {
    enableEventDispatching(HoldEvent.class);
    return addListener(HoldEvent.class, listener);
  }

  public Registration addReleaseListener(final ReleaseListener listener) {
    enableEventDispatching(ReleaseEvent.class);
    return addListener(ReleaseEvent.class, listener);
  }

  public Registration addSelectListener(final SelectListener listener) {
    enableEventDispatching(SelectEvent.class);
    return addListener(SelectEvent.class, listener);
  }

  public Registration addSelectNodeListener(final SelectNodeListener listener) {
    enableEventDispatching(SelectNodeEvent.class);
    return addListener(SelectNodeEvent.class, listener);
  }

  public Registration addSelectEdgeListener(final SelectEdgeListener listener) {
    enableEventDispatching(SelectEdgeEvent.class);
    return addListener(SelectEdgeEvent.class, listener);
  }

  public Registration addDeselectNodeListener(final DeselectNodeListener listener) {
    enableEventDispatching(DeselectNodeEvent.class);
    return addListener(DeselectNodeEvent.class, listener);
  }

  public Registration addDeselectEdgeListener(final DeselectEdgeListener listener) {
    enableEventDispatching(DeselectEdgeEvent.class);
    return addListener(DeselectEdgeEvent.class, listener);
  }

  public Registration addDragStartListener(final DragStartListener listener) {
    enableEventDispatching(DragStartEvent.class);
    return addListener(DragStartEvent.class, listener);
  }

  public Registration addDraggingListener(final DraggingListener listener) {
    enableEventDispatching(DraggingEvent.class);
    return addListener(DraggingEvent.class, listener);
  }

  public Registration addDragEndListener(final DragEndListener listener) {
    enableEventDispatching(DragEndEvent.class);
    return addListener(DragEndEvent.class, listener);
  }

  public Registration addHoverNodeListener(final HoverNodeListener listener) {
    enableEventDispatching(HoverNodeEvent.class);
    return addListener(HoverNodeEvent.class, listener);
  }

  public Registration addBlurNodeListener(final BlurNodeListener listener) {
    enableEventDispatching(BlurNodeEvent.class);
    return addListener(BlurNodeEvent.class, listener);
  }

  public Registration addHoverEdgeListener(final HoverEdgeListener listener) {
    enableEventDispatching(HoverEdgeEvent.class);
    return addListener(HoverEdgeEvent.class, listener);
  }

  public Registration addBlurEdgeListener(final BlurEdgeListener listener) {
    enableEventDispatching(BlurEdgeEvent.class);
    return addListener(BlurEdgeEvent.class, listener);
  }

  public Registration addZoomListener(final ZoomListener listener) {
    enableEventDispatching(ZoomEvent.class);
    return addListener(ZoomEvent.class, listener);
  }

  public Registration addShowPopupListener(final ShowPopupListener listener) {
    enableEventDispatching(ShowPopupEvent.class);
    return addListener(ShowPopupEvent.class, listener);
  }

  public Registration addHidePopupListener(final HidePopupListener listener) {
    enableEventDispatching(HidePopupEvent.class);
    return addListener(HidePopupEvent.class, listener);
  }

  public Registration addStartStabilizingListener(final StartStabilizingListener listener) {
    enableEventDispatching(StartStabilizingEvent.class);
    return addListener(StartStabilizingEvent.class, listener);
  }

  public Registration addStabilizationProgressListener(final StabilizingProgressListener listener) {
    enableEventDispatching(StabilizationProgressEvent.class);
    return addListener(StabilizationProgressEvent.class, listener);
  }

  public Registration addStabilizationIterationsDoneListener(
      final StabilizationIterationsDoneListener listener) {
    enableEventDispatching(StabilizationIterationsDoneEvent.class);
    return addListener(StabilizationIterationsDoneEvent.class, listener);
  }

  public Registration addStabilizedListener(final StabilizedListener listener) {
    enableEventDispatching(StabilizedEvent.class);
    return addListener(StabilizedEvent.class, listener);
  }

  public Registration addResizeListener(final ResizeListener listener) {
    enableEventDispatching(ResizeEvent.class);
    return addListener(ResizeEvent.class, listener);
  }

  public Registration addInitRedrawListener(final InitRedrawListener listener) {
    enableEventDispatching(InitRedrawEvent.class);
    return addListener(InitRedrawEvent.class, listener);
  }

  public Registration addBeforeDrawingListener(final BeforeDrawingListener listener) {
    enableEventDispatching(BeforeDrawingEvent.class);
    return addListener(BeforeDrawingEvent.class, listener);
  }

  public Registration addAfterDrawingListener(final AfterDrawingListener listener) {
    enableEventDispatching(AfterDrawingEvent.class);
    return addListener(AfterDrawingEvent.class, listener);
  }

  public Registration addAnimationFinishedListener(final AnimationFinishedListener listener) {
    enableEventDispatching(AnimationFinshedEvent.class);
    return addListener(AnimationFinshedEvent.class, listener);
  }

  public Registration addConfigChangeListener(final ConfigChangeListener listener) {
    enableEventDispatching(ConfigChangeEvent.class);
    return addListener(ConfigChangeEvent.class, listener);
  }

  private static class NetworkDiagramRegistration implements Registration {
    private boolean isInvoked;

    private final Registration origin;

    private final SerializableConsumer<NetworkDiagramRegistration> callback;

    private NetworkDiagramRegistration(Registration origin,
        SerializableConsumer<NetworkDiagramRegistration> onRemoveCallback) {
      this.origin = origin;
      this.callback = onRemoveCallback;

    }

    @Override
    public void remove() {
      if (isInvoked) {
        return;
      }
      origin.remove();
      callback.accept(this);

      isInvoked = true;
    }

  }

}
