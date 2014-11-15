package com.khanhpq.algorithm;

import java.util.ArrayList;

import com.khanhpq.datastructure.BusRoute;
import com.khanhpq.datastructure.BusStop;

public class Node {
	private BusStop stop;
	private ArrayList<Edge> edgeList = new ArrayList<Edge>(); // link to child or neighbor
	
	// TODO: may be only 1 parent (as below)
	private ArrayList<Node> parentList = new ArrayList<Node>(); // link to parent
	// TODO: may be only 1 parent (as below)
	private Node parent;
	
	private double gScore; // cost from start to node along best known path
	private double fScore; // total cost from start to goal through node
	
	// change route (change bus) cases
	// TODO: may be at Constants class
	public static final double CHANGEBUS_COST_PLUS = 7.5;
	public static final int MAX_CHANGES = 2;
	
	// TODO: mac dinh = 1 (hoi ao)
	private int numOfChange = 0;
	
	// TODO: currentRoute cua thang nay la 1 cai dac biet
	private BusRoute currentRoute; // xe bus(bus+direction) hien tai
	
	public BusStop getStop() {
		return stop;
	}
	public void setStop(BusStop stop) {
		this.stop = stop;
	}
	public ArrayList<Edge> getEdgeList() {
		return edgeList;
	}
	public void setEdgeList(ArrayList<Edge> edgeList) {
		this.edgeList = edgeList;
	}
	public ArrayList<Node> getParentList() {
		return parentList;
	}
	public void setParentList(ArrayList<Node> parentList) {
		this.parentList = parentList;
	}
	public double getgScore() {
		return gScore;
	}
	public void setgScore(double gScore) {
		this.gScore = gScore;
	}
	public double getfScore() {
		return fScore;
	}
	public void setfScore(double fScore) {
		this.fScore = fScore;
	}
	
	public int getNumOfChange() {
		return numOfChange;
	}
	public void setNumOfChange(int numOfChange) {
		this.numOfChange = numOfChange;
	}
	public BusRoute getCurrentRoute() {
		return currentRoute;
	}
	public void setCurrentRoute(BusRoute currentRoute) {
		this.currentRoute = currentRoute;
	}
	////////////////////////////////////////////////////
	// temp value
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	////////////////////////////////////////////////////
	
//////////////////////////////////////////////////////
//	// truong hop change bus
//	public void modifyEdgeList() {
//		for (Edge e: edgeList)
//			if ( !e.getCurrentRoute().equals(currentRoute) ) {
//				if(e.getNode() != null)
//					e.getNode().setNumOfChange(e.getNode().getNumOfChange()+1);
//				e.setCost( e.getCost() + CHANGEBUS_COST_PLUS * numOfChange);
//			}
//				
//	}
////////////////////////////////////////////////////
	
	
	/**
	 * dua. theo id cua stop
	 * */
	public boolean equals(Object obj) {
		Node n = (Node) obj;
		if( n.getStop().getStopId() == this.getStop().getStopId() )
			return true;
		return false;
	}
	
}
