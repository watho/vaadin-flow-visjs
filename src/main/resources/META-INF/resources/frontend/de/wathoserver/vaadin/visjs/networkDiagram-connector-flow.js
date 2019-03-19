window.Vaadin.Flow.networkDiagramConnector = {
	initLazy : function(graph, initialNodes, initialEdges, options,
			predefinedNodesName, predefinedEdgesName) {
		// Check whether the connector was already initialized
		if (graph.$connector) {
			return;
		}
		console.log('init networkDiagramConnector', predefinedNodesName,
				predefinedEdgesName);

		graph.$connector = {};
		graph.predefinedNodesName = predefinedNodesName;
		graph.predefinedEdgesName = predefinedEdgesName;

		// add eventlistener for syncing data changes to java
		graph.$connector.addSyncListener = function() {
			graph.nodes.on("*", function(event, properties, senderId) {
				if (event === "remove") {
					graph.$server.nodesChanged(event, properties.items);
				} else {
					// Returns all changed nodes completely. Needs tweaking for
					// more performance.
					graph.$server.nodesChanged(event, graph.nodes
							.get(properties.items));
				}
			});
			graph.edges.on("*", function(event, properties, senderId) {
				if (event === "remove") {
					graph.$server.edgesChanged(event, properties.items);
				} else {
					// Returns all changed edges completely. Needs tweaking for
					// more performance.
					graph.$server.edgesChanged(event, graph.edges
							.get(properties.items));
				}
			});
		}

		graph.nodes = new vis.DataSet(JSON.parse(initialNodes));
		if (typeof predefinedNodesName === 'string'
				&& window.hasOwnProperty(predefinedNodesName)
				&& window[predefinedNodesName].length > 0) {
			// the array is defined and has at least one element
			console.log('found ' + window[predefinedNodesName].length
					+ ' predefined nodes')
			graph.nodes.add(window[predefinedNodesName]);
		}
		graph.edges = new vis.DataSet(JSON.parse(initialEdges));
		if (typeof predefinedEdgesName === 'string'
				&& window.hasOwnProperty(predefinedEdgesName)
				&& window[predefinedEdgesName].length > 0) {
			// the array is defined and has at least one element
			console.log('found ' + window[predefinedEdgesName].length
					+ ' predefined edges')
			graph.edges.add(window[predefinedEdgesName]);
		}
		graph.$connector.addSyncListener();

		// var self = this;
		// var customNodeifAdded = false;
		// var customNodeID;
		// var customNodeLabel;
		// var customEdgeifAdded = false;
		// var customEdgeID;
		// var customEdgeLabel;

		graph.options = JSON.parse(options);
		// ("manipulation" in graph.options) || (graph.options.manipulation =
		// {});
		// graph.options.manipulation.addNode = function(nodeData, callback) {
		// if (customNodeifAdded == true) {
		// nodeData.label = customNodeLabel;
		// nodeData.id = customNodeID;
		// }
		// self.onManipulationNodeAdded(nodeData);
		// console.log("node added", nodeData);
		// callback(nodeData);
		// };
		// graph.options.manipulation.addEdge = function(edgeData, callback) {
		// if (customEdgeifAdded == true) {
		// edgeData.label = customEdgeLabel;
		// edgeData.id = customEdgeID;
		// }
		// self.onManipulationEdgeAdded(edgeData);
		// callback(edgeData);
		// };
		// graph.options.manipulation.deleteNode = function(nodeData, callback)
		// {
		// self.onManipulationNodeDeleted(nodeData);
		// callback(nodeData);
		// };
		// graph.options.manipulation.deleteEdge = function(edgeData, callback)
		// {
		// self.onManipulationEdgeDeleted(edgeData);
		// callback(edgeData);
		// };
		// graph.options.manipulation.editEdge = function(edgeData, callback) {
		// self.onManipulationEdgeEdited(edgeData);
		// callback(edgeData);
		// };

		graph.$connector.init = function() {
			console.log("networkdiagram options: "
					+ JSON.stringify(graph.options));
			// console.log("nodes: " + JSON.stringify(graph.nodes));
			graph.$connector.diagram = new vis.Network(graph, {
				nodes : graph.nodes,
				edges : graph.edges
			}, graph.options);
		}
		graph.$connector.init();

		// Enable event dispatching to vaadin only for registered eventTypes to
		// avoid to much overhead.
		graph.$connector.enableEventDispatching = function(vaadinEventType) {
			const eventType = vaadinEventType.substring(7);
			graph.$connector.diagram
					.on(
							eventType,
							function(params) {
								if (params != null) {
									// removing dom nodes from params cause they
									// can't send back to server.
									if (params.hasOwnProperty('event')) {
										// source of click event
										delete params.event.firstTarget;
										delete params.event.target;
									}
									JSON
											.stringify(
													params,
													function(key, value) {
														if (value instanceof Node) {
															console
																	.log("Message JsonObject contained a dom node reference  "
																			+ key
																			+ "  which "
																			+ "should not be sent to the server and can cause a cyclic dependecy.");
															delete params[key];
														}
														return value;
													});
								}
								graph.dispatchEvent(new CustomEvent(
										vaadinEventType, {
											detail : params
										}));
							});
		}

		// not used yet
		graph.$connector.disableEventDispatching = function(vaadinEventType) {
			const eventType = vaadinEventType.substring(7);
			console.log("disable registered eventType " + eventType);
			graph.diagram.off(eventType, function(params) {
				graph.dispatchEvent(new Event(vaadinEventType));
			});
		}

		graph.$connector.setData = function(nodes, edges) {
			const nodesObject = JSON.parse(nodes);
			const edgesObject = JSON.parse(edges);
			// console.log("set Data:", JSON.stringify(nodesObject),
			// JSON.stringify(edgesObject));
			graph.nodes = new vis.DataSet(nodesObject);
			graph.edges = new vis.DataSet(edgesObject);
			graph.$connector.diagram.setData({
				nodes : graph.nodes,
				edges : graph.edges
			});
			// console.log("set Data after:", JSON.stringify(graph.nodes),
			// JSON.stringify(graph.edges));
		}

		graph.$connector.addNodes = function(nodes) {
			// console.log("addNodes: " + typeof nodes + "=" +
			// JSON.stringify(nodes));
			let nodesObject = JSON.parse(nodes);
			// console.log("addNodesParsed: " + typeof nodesObject + "=" +
			// JSON.stringify(nodesObject));
			graph.nodes.add(nodesObject);
		}

		graph.$connector.updateNodes = function(nodes) {
			let nodesObject = JSON.parse(nodes);
			graph.nodes.update(nodesObject);
		}

		graph.$connector.addEdges = function(edges) {
			let edgesObject = JSON.parse(edges);
			graph.edges.add(edgesObject);
		}

		graph.$connector.updateEdges = function(edges) {
			let edgesObject = JSON.parse(edges);
			graph.edges.update(edgesObject);
		}

		graph.$connector.removeNodes = function(nodes) {
			let nodesObject = JSON.parse(nodes);
			graph.nodes.remove(nodesObject);
		}

		graph.$connector.removeEdges = function(edges) {
			let edgesObject = JSON.parse(edges);
			graph.edges.remove(edgesObject);
		}

		graph.$connector.clearNodes = function() {
			graph.nodes.clear();
		};

		graph.$connector.clearEdges = function() {
			graph.edges.clear();
		};

		graph.$connector.updateNodesSize = function(newSize) {
			const delta = newSize - graph.nodes.length;
			if (delta > 0) {
				graph.nodes.length = newSize;

				// graph.notifySplices("nodes", [{index: newSize - delta,
				// removed: [], addedCount : delta, object: graph.nodes, type:
				// "splice"}]);
			} else if (delta < 0) {
				const removed = graph.nodes.slice(newSize, graph.nodes.length);
				graph.nodes.splice(newSize);
				// graph.notifySplices("nodes", [{index: newSize, removed:
				// removed, addedCount : 0, object: graph.nodes, type:
				// "splice"}]);
			}
		};

		graph.$connector.updateEdgesSize = function(newSize) {
			const delta = newSize - graph.edges.length;
			if (delta > 0) {
				graph.edges.length = newSize;

				// graph.notifySplices("edges", [{index: newSize - delta,
				// removed: [], addedCount : delta, object: graph.edges, type:
				// "splice"}]);
			} else if (delta < 0) {
				const removed = graph.edges.slice(newSize, graph.edges.length);
				graph.edges.splice(newSize);
				// graph.notifySplices("edges", [{index: newSize, removed:
				// removed, addedCount : 0, object: graph.edges, type:
				// "splice"}]);
			}
		};
		graph.$connector.setOptions = function(options) {
			graph.options = JSON.parse(options);
			graph.$connector.diagram.setOptions(graph.options);
		};
		
		// TODO error handling
		graph.$connector.convertGephi = function(url, parserOptions) {
			graph.$connector.loadJSON(url, function(json) {
				var parsed = vis.network.convertGephi(json,
						JSON.parse(parserOptions));
				graph.nodes = parsed.nodes;
				graph.edges = parsed.edges;
				graph.$connector.diagram.setData({
					nodes : graph.nodes,
					edges : graph.edges
				});
			});
		}

		graph.$connector.updatePredefined = function() {
			const predefinedNodesName = graph.predefinedNodesName;
			const predefinedEdgesName = graph.predefinedEdgesName;
			if (typeof predefinedNodesName === 'string'
					&& window.hasOwnProperty(predefinedNodesName)
					&& window[predefinedNodesName].length > 0) {
				// the array is defined and has at least one element
				console.log('found ' + window[predefinedNodesName].length
						+ ' predefined nodes')
				graph.nodes.clear();
				graph.nodes.add(window[predefinedNodesName]);
			}
			if (typeof predefinedEdgesName === 'string'
					&& window.hasOwnProperty(predefinedEdgesName)
					&& window[predefinedEdgesName].length > 0) {
				// the array is defined and has at least one element
				console.log('found ' + window[predefinedEdgesName].length
						+ ' predefined edges')
				graph.edges.clear();
				graph.edges.add(window[predefinedEdgesName]);
			}
		}

		graph.$connector.loadJSON = function(path, success, error) {
			var xhr = new XMLHttpRequest();
			xhr.onreadystatechange = function() {
				if (xhr.readyState === 4) {
					if (xhr.status === 200) {
						success(JSON.parse(xhr.responseText));
					} else {
						error(xhr);
					}
				}
			};
			xhr.open('GET', path, true);
			xhr.send();
		}
	}
}
