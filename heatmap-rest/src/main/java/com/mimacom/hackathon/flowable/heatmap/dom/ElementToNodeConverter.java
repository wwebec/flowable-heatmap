package com.mimacom.hackathon.flowable.heatmap.dom;

import static com.mimacom.hackathon.flowable.heatmap.dom.NodeListUtils.doubleValueOfFirstNodeAttribute;

import java.util.function.Function;

import com.mimacom.hackathon.flowable.heatmap.model.Node;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ElementToNodeConverter {

	public static Node convertElementToNode(Element element, Function<String, Integer> sidToTotalFn) {
		String sid = element.getAttribute("id");

		NodeList bounds = element.getElementsByTagName("omgdc:Bounds");

		Integer weight = sidToTotalFn.apply(sid);
		Double height = doubleValueOfFirstNodeAttribute(bounds, "height");
		Double width = doubleValueOfFirstNodeAttribute(bounds,  "width");
		Double x = doubleValueOfFirstNodeAttribute(bounds,  "x");
		Double y = doubleValueOfFirstNodeAttribute(bounds,  "y");

		return new Node(sid, weight, height, width, x, y);
	}
}


