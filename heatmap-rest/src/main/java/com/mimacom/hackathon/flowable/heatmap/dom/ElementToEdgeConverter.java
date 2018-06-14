package com.mimacom.hackathon.flowable.heatmap.dom;

import static com.mimacom.hackathon.flowable.heatmap.dom.NodeListUtils.doubleValueOfFirstNodeAttribute;
import static com.mimacom.hackathon.flowable.heatmap.dom.NodeListUtils.doubleValueOfLastNodeAttribute;

import java.util.function.Function;

import com.mimacom.hackathon.flowable.heatmap.model.Coordinate;
import com.mimacom.hackathon.flowable.heatmap.model.Edge;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ElementToEdgeConverter {

	public static Edge convertElementToEdge(Element element, Function<String, Integer> sidToTotalFn) {
		String sid = element.getAttribute("id");

		Integer weight = sidToTotalFn.apply(sid);

		NodeList waypoints = element.getElementsByTagName("omgdi:waypoint");
		Double x0 = doubleValueOfFirstNodeAttribute(waypoints, "x");
		Double y0 = doubleValueOfFirstNodeAttribute(waypoints, "y");

		Double xN = doubleValueOfLastNodeAttribute(waypoints, "x");
		Double yN = doubleValueOfLastNodeAttribute(waypoints, "y");

		Coordinate from = new Coordinate(x0, y0);
		Coordinate to = new Coordinate(xN, yN);

		return new Edge(sid, weight, from, to);
	}
}
