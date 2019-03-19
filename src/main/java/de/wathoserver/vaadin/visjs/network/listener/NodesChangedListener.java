package de.wathoserver.vaadin.visjs.network.listener;

import com.vaadin.flow.component.ComponentEventListener;

import de.wathoserver.vaadin.visjs.network.event.NodesChangedEvent;

/**
 * Fired when nodes are added, updated or deleted.
 *
 * @author watho
 *
 */
public interface NodesChangedListener extends ComponentEventListener<NodesChangedEvent> {
}
