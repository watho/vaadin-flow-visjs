package de.wathoserver.vaadin.visjs.network;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.HasSize;
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

import de.wathoserver.vaadin.visjs.network.api.Event;
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
import de.wathoserver.vaadin.visjs.network.event.HidePopupEvent;
import de.wathoserver.vaadin.visjs.network.event.HoldEvent;
import de.wathoserver.vaadin.visjs.network.event.HoverEdgeEvent;
import de.wathoserver.vaadin.visjs.network.event.HoverNodeEvent;
import de.wathoserver.vaadin.visjs.network.event.InitRedrawEvent;
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
import de.wathoserver.vaadin.visjs.network.listener.HidePopupListener;
import de.wathoserver.vaadin.visjs.network.listener.HoldListener;
import de.wathoserver.vaadin.visjs.network.listener.HoverEdgeListener;
import de.wathoserver.vaadin.visjs.network.listener.HoverNodeListener;
import de.wathoserver.vaadin.visjs.network.listener.InitRedrawListener;
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
import de.wathoserver.vaadin.visjs.network.options.Manipulation;
import de.wathoserver.vaadin.visjs.network.options.Options;
import elemental.json.JsonArray;
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
public class NetworkDiagram extends Component implements HasSize {

  Logger log = LoggerFactory.getLogger(NetworkDiagram.class);

  private final Options options;
  private final ObjectMapper mapper = new ObjectMapper();

  // Holds all eventtypes already registered client side.
  private final Set<Class<? extends Event>> enabledEvents = new LinkedHashSet<>();

  private DataProvider<Edge, ?> edgesDataProvider = DataProvider.ofItems();
  private DataProvider<Node, ?> nodesDataProvider = DataProvider.ofItems();

  private Registration edgeDataProviderListenerRegistration;
  private Registration nodeDataProviderListenerRegistration;

  public NetworkDiagram(final Options options) {
    super();
    // Dont transfer empty options.
    mapper.setSerializationInclusion(Include.NON_EMPTY);
    // Dont transfer getter and setter
    mapper.setVisibility(mapper.getSerializationConfig().getDefaultVisibilityChecker()
        .withGetterVisibility(Visibility.NONE).withSetterVisibility(Visibility.NONE)
        .withIsGetterVisibility(Visibility.NONE).withFieldVisibility(Visibility.ANY));
    this.options = Objects.requireNonNull(options);
    if (options.getManipulation() == null) {
      options.setManipulation(new Manipulation());
    }
    this.setWidth(options.getWidth());
    this.setHeight(options.getHeight());
  }

  private void initConnector() {
    getUI()
        .orElseThrow(() -> new IllegalStateException(
            "Connector can only be initialized for an attached NetworkDiagram"))
        .getPage().executeJavaScript("window.Vaadin.Flow.networkDiagramConnector.initLazy($0, $1)",
            getElement(), optionsToJson(options));
  }

  @Override
  protected void onAttach(AttachEvent attachEvent) {
    super.onAttach(attachEvent);
    if (attachEvent.isInitialAttach()) {
      initConnector();
    }
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

  // public void setCustomNodeIfAdded(final boolean activate, final String id, final String label) {
  // callFunction("setCustomNodeIfAdded", activate, id, label);
  // }
  //
  // public void setCustomEdgeIfAdded(final boolean activate, final String id, final String label) {
  // callFunction("setCustomEdgeIfAdded", activate, id, label);
  // }

  // public void updateOptions(final Options options) {
  // getState().updates++;
  // callFunction("updateOptions", gson.toJson(options));
  // }
  //

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
   * Creates a ListDataProvider with the given items.
   *
   * @param edges
   */
  public void setEdges(Edge... edges) {
    setEdgesDataProvider(new ListDataProvider<>(Arrays.asList(edges)));
  }

  private void addNodes(Iterable<Node> nodes) {
    addNodes(StreamSupport.stream(nodes.spliterator(), false).toArray(Node[]::new));
  }

  private void addNodes(final Node... node) {
    runBeforeClientResponse(ui -> {
      try {
        getElement().callFunction("$connector.addNodes", mapper.writeValueAsString(node));
      } catch (final JsonProcessingException e) {
        e.printStackTrace();
      }
    });
  }

  private void addEdges(Iterable<Edge> edges) {
    addEdges(StreamSupport.stream(edges.spliterator(), false).toArray(Edge[]::new));
  }

  private void addEdges(final Edge... edge) {
    runBeforeClientResponse(ui -> {
      try {
        getElement().callFunction("$connector.addEdges", mapper.writeValueAsString(edge));
      } catch (final JsonProcessingException e) {
        e.printStackTrace();
      }
    });
  }

  private void removeAllEdges() {
    runBeforeClientResponse(ui -> {
      getElement().callFunction("$connector.clearEdges");
    });
  }

  private void removeAllNodes() {
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
    removeAllNodes();
    removeAllEdges();
    addNodes(nodes);
    addEdges(edges);
  }

  // ==== Diagram-Methods ====
  public void diagamRedraw() {
    runBeforeClientResponse(ui -> getElement().callFunction("$connector.diagram.redraw"));
  }

  public void diagramSetSize(final String width, final String height) {
    this.setWidth(width);
    this.setHeight(height);
    runBeforeClientResponse(
        ui -> getElement().callFunction("$connector.diagram.setSize", width, height));
  }

  public void diagramSelectNodes(Iterable<String> nodeIds) {
    final JsonArray nodeIdArray = StreamSupport.stream(nodeIds.spliterator(), false)
        .map(JreJsonString::new).collect(JsonUtils.asArray());
    runBeforeClientResponse(
        ui -> getElement().callFunction("$connector.diagram.selectNodes", nodeIdArray));
  }

  public void diagramSelectEdges(Iterable<String> edgeIds) {
    final JsonArray edgeIdArray = StreamSupport.stream(edgeIds.spliterator(), false)
        .map(JreJsonString::new).collect(JsonUtils.asArray());
    runBeforeClientResponse(
        ui -> getElement().callFunction("$connector.diagram.selectEdges", edgeIdArray));
  }

  public void diagramUnselectAll() {
    runBeforeClientResponse(ui -> getElement().callFunction("$connector.diagram.unselectAll"));
  }

  public void diagramFit() {
    runBeforeClientResponse(ui -> getElement().callFunction("$connector.diagram.fit"));
  }

  @Override
  public void setSizeFull() {
    HasSize.super.setSizeFull();
    runBeforeClientResponse(
        ui -> getElement().callFunction("$connector.diagram.setSize", getWidth(), getHeight()));
  }

  // ==== Events ====
  private void enableEventDispatching(Class<? extends Event> clazz) {
    runBeforeClientResponse(ui -> {
      if (!enabledEvents.contains(clazz)) {
        enabledEvents.add(clazz);
        getElement().callFunction("$connector.enableEventDispatching",
            clazz.getAnnotation(DomEvent.class).value());
      }
    });
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
