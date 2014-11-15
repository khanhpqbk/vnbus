package com.khanhpq.algorithm;

import com.khanhpq.datastructure.BusRoute;

public class Edge {
	private double cost; // khoang cach giua current node (chua Edge) va child node
	private Node node; // child node
	private BusRoute currentRoute; // xe bus (bus+direction) dang di la gi
	
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public Node getNode() {
		return node;
	}
	public void setNode(Node node) {
		this.node = node;
	}
	public BusRoute getCurrentRoute() {
		return currentRoute;
	}
	public void setCurrentRoute(BusRoute currentRoute) {
		this.currentRoute = currentRoute;
	}
	
	
}
