package org.vaadin.addons.visjs.network;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.shared.Registration;

import org.vaadin.addons.visjs.network.main.Edge;
import org.vaadin.addons.visjs.network.main.NetworkDiagram;
import org.vaadin.addons.visjs.network.main.Node;
import org.vaadin.addons.visjs.network.options.Options;

@SuppressWarnings("serial")
@Route("")
public class DemoView extends VerticalLayout {

  public DemoView() {
    setMargin(true);
    setPadding(true);
    setSpacing(true);
    // setWidth("400px");

    final NetworkDiagram nd =
        new NetworkDiagram(Options.builder().withWidth("600px").withHeight("400px").build());

    final List<Node> nodes = new LinkedList<>();
    AtomicInteger idCounter = new AtomicInteger();
    for (int i=1 ; i <= 5 ; i++)
    {
      int nodeId = idCounter.incrementAndGet();
      nodes.add(new Node(nodeId+"", "Node "+nodeId));
    }
    final ListDataProvider<Node> dataProvider = new ListDataProvider<>(nodes);
    nd.setNodesDataProvider(dataProvider);
    nd.setEdges(new Edge("1", "3"), new Edge("1", "2"), new Edge("2", "4"), new Edge("2", "5"), new Edge("3", "3"));
    final Registration registrationSelect = nd.addSelectNodeListener(
            ls -> Notification.show("NodeId selected " + ls.getParams().getArray("nodes").toJson()));
    final Registration registrationDeselect =  nd.addDeselectNodeListener(
            ls -> Notification.show("NodeId deselected " + ls.getParams().getObject("previousSelection").getArray("nodes").toJson()));
    add(nd);
    add(new HorizontalLayout(new Button("Add Node", e -> {
      final String id = (idCounter.incrementAndGet())+"";
      nodes.add(new Node(id, "Node "+id));
      dataProvider.refreshAll();
    }), new Button("remove all Nodes", e -> {
      nodes.clear();
      dataProvider.refreshAll();
      registrationSelect.remove();
      registrationDeselect.remove();
    }), new Button("fit", e -> {
      nd.diagramFit();
    }), new Button("selectNode", e -> {
      nd.diagramSelectNodes(Arrays.asList(new String[] {"1", "2"}));
    }), new Button("unselectAll", e -> {
      nd.diagramUnselectAll();;
    })));
    setSizeFull();
  }

}
