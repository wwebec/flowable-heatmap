package com.mimacom.hackathon.flowable.heatmap.model;

import java.io.Serializable;
import java.util.Objects;

public class Edge implements Serializable {

	private final String sid;
	private final int weight;
	private final Coordinate from;
	private final Coordinate to;

	public Edge(String sid, int weight, Coordinate from, Coordinate to) {
		this.sid = sid;
		this.weight = weight;

		this.from = from;
		this.to = to;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) { return true; }
		if (o == null || getClass() != o.getClass()) { return false; }
		Edge edge = (Edge) o;
		return weight == edge.weight &&
				Objects.equals(sid, edge.sid) &&
				Objects.equals(from, edge.from) &&
				Objects.equals(to, edge.to);
	}

	@Override
	public int hashCode() {
		return Objects.hash(sid, weight, from, to);
	}
}
