package com.mimacom.hackathon.flowable.heatmap.model;

import java.io.Serializable;
import java.util.Objects;

public class Coordinate implements Serializable{
	private final double x, y;

	public static Coordinate of(double x, double y){
		return new Coordinate(x,y);
	}
	public Coordinate(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) { return true; }
		if (o == null || getClass() != o.getClass()) { return false; }
		Coordinate that = (Coordinate) o;
		return x == that.x &&
				y == that.y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
}
