package com.mimacom.hackathon.flowable.heatmap;

import static com.mimacom.hackathon.flowable.heatmap.dom.ElementToEdgeConverter.convertElementToEdge;
import static com.mimacom.hackathon.flowable.heatmap.dom.ElementToNodeConverter.convertElementToNode;
import static org.joox.JOOX.$;

import java.util.List;
import java.util.function.Function;

import com.mimacom.hackathon.flowable.heatmap.model.Edge;
import com.mimacom.hackathon.flowable.heatmap.model.HeatmapData;
import com.mimacom.hackathon.flowable.heatmap.model.Node;

public class HeatmapDataExtractor {

	public HeatmapData provide(String xml, Function<String, Integer> sidToTotalFn) {
		return new HeatmapData("test", getNodes(xml, sidToTotalFn), getEdges(xml, sidToTotalFn));
	}

	private List<Node> getNodes(String xml, Function<String, Integer> sidToTotalFn) {
		return $(xml).find("BPMNPlane")
				.children("BPMNShape")
				.map(context -> convertElementToNode(context.element(), sidToTotalFn));
	}

	private List<Edge> getEdges(String xml, Function<String, Integer> sidToTotalFn) {
		return $(xml).find("BPMNPlane")
				.children("BPMNEdge")
				.map(context -> convertElementToEdge(context.element(), sidToTotalFn));
	}
}
