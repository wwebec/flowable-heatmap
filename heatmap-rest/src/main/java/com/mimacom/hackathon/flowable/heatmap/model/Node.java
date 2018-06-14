package com.mimacom.hackathon.flowable.heatmap.model;

import java.io.Serializable;
import java.util.Objects;

public class Node implements Serializable{
	private String sid;
	private int weight;
	private double height;
	private double width;
	private double x;
	private double y;

	public Node(String sid, int weight, double height, double width, double x, double y) {
		this.sid = sid;
		this.weight = weight;
		this.height = height;
		this.width = width;
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) { return true; }
		if (o == null || getClass() != o.getClass()) { return false; }
		Node node = (Node) o;
		return weight == node.weight &&
				height == node.height &&
				width == node.width &&
				x == node.x &&
				y == node.y &&
				Objects.equals(sid, node.sid);
	}

	@Override
	public int hashCode() {
		return Objects.hash(sid, weight, height, width, x, y);
	}
}
