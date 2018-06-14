package com.mimacom.hackathon.flowable.heatmap.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class HeatmapData implements Serializable {
	private final String processDefinitionid;
	private final List<Node> nodes;
	private final List<Edge> edges;

	public HeatmapData(String processDefinitionid, List<Node> nodes, List<Edge> edges) {
		this.processDefinitionid = processDefinitionid;
		this.nodes = nodes;
		this.edges = edges;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) { return true; }
		if (o == null || getClass() != o.getClass()) { return false; }
		HeatmapData that = (HeatmapData) o;
		return Objects.equals(processDefinitionid, that.processDefinitionid) &&
				Objects.equals(nodes, that.nodes) &&
				Objects.equals(edges, that.edges);
	}

	@Override
	public int hashCode() {
		return Objects.hash(processDefinitionid, nodes, edges);
	}
}
