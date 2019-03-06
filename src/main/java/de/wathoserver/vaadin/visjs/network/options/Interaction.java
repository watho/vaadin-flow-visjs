package de.wathoserver.vaadin.visjs.network.options;

public class Interaction {

	private boolean dragNodes=true;
	private boolean dragView=true;
	private boolean  hideEdgesOnDrag=false;
	private boolean hideNodesOnDrag=false;
	private boolean hover=false;
	private boolean hoverConnectedEdges=true;
	private boolean multiselect=false;
	private boolean navigationButtons=true;
	private boolean selectable=true;
	private boolean selectConnectedEdges=true;
	private int tooltipDelay=300;
	private boolean zoomView=false;
	public boolean isDragNodes() {
		return dragNodes;
	}
	public void setDragNodes(boolean dragNodes) {
		this.dragNodes = dragNodes;
	}
	public boolean isDragView() {
		return dragView;
	}
	public void setDragView(boolean dragView) {
		this.dragView = dragView;
	}
	public boolean isHideEdgesOnDrag() {
		return hideEdgesOnDrag;
	}
	public void setHideEdgesOnDrag(boolean hideEdgesOnDrag) {
		this.hideEdgesOnDrag = hideEdgesOnDrag;
	}
	public boolean isHideNodesOnDrag() {
		return hideNodesOnDrag;
	}
	public void setHideNodesOnDrag(boolean hideNodesOnDrag) {
		this.hideNodesOnDrag = hideNodesOnDrag;
	}
	public boolean isHover() {
		return hover;
	}
	public void setHover(boolean hover) {
		this.hover = hover;
	}
	public boolean isHoverConnectedEdges() {
		return hoverConnectedEdges;
	}
	public void setHoverConnectedEdges(boolean hoverConnectedEdges) {
		this.hoverConnectedEdges = hoverConnectedEdges;
	}
	public boolean isMultiselect() {
		return multiselect;
	}
	public void setMultiselect(boolean multiselect) {
		this.multiselect = multiselect;
	}
	public boolean isNavigationButtons() {
		return navigationButtons;
	}
	public void setNavigationButtons(boolean navigationButtons) {
		this.navigationButtons = navigationButtons;
	}
	public boolean isSelectable() {
		return selectable;
	}
	public void setSelectable(boolean selectable) {
		this.selectable = selectable;
	}
	public boolean isSelectConnectedEdges() {
		return selectConnectedEdges;
	}
	public void setSelectConnectedEdges(boolean selectConnectedEdges) {
		this.selectConnectedEdges = selectConnectedEdges;
	}
	public int getTooltipDelay() {
		return tooltipDelay;
	}
	public void setTooltipDelay(int tooltipDelay) {
		this.tooltipDelay = tooltipDelay;
	}
	public boolean isZoomView() {
		return zoomView;
	}
	public void setZoomView(boolean zoomView) {
		this.zoomView = zoomView;
	}
	
	
}
