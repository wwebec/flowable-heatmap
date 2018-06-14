package com.mimacom.hackathon.flowable.heatmap.dom;

import org.w3c.dom.NodeList;

public class NodeListUtils {

	public static Double doubleValueOfFirstNodeAttribute(NodeList nodes, String name) {
		return doubleValueOfNodeAttribute(nodes, 0, name);
	}

	public static Double doubleValueOfLastNodeAttribute(NodeList nodes, String name) {
		return doubleValueOfNodeAttribute(nodes, nodes.getLength() - 1, name);
	}

	public static Double doubleValueOfNodeAttribute(NodeList nodes, int index, String name) {
		return Double.parseDouble(nodes.item(index).getAttributes().getNamedItem(name).getNodeValue());
	}

}
