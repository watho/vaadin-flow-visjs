package de.wathoserver.vaadin.visjs.network.listener;

import com.vaadin.flow.component.ComponentEventListener;

import de.wathoserver.vaadin.visjs.network.event.EdgesChangedEvent;

/**
 * Fired when edges are added, updated or deleted.
 *
 * @author watho
 *
 */
public interface EdgesChangedListener extends ComponentEventListener<EdgesChangedEvent> {
}
