package com.khanhpq.algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import com.google.android.gms.maps.model.LatLng;
import com.khanhpq.datastructure.BusRoute;
import com.khanhpq.datastructure.BusStop;
import com.khanhpq.util.BusFunction;

public class AstarAlgo {

	private static final int MAX_NODES = 2000;

	private ArrayList<BusStop> stopList = new ArrayList<BusStop>();

	private Node startNode;

	public ArrayList<Node> calcShortestPath(Node start, Node goal) {

		double tentgScore = 0;
		startNode = start;

		Set<Node> closedSet = new HashSet<Node>();

		PriorityQueue<Node> openSet = new PriorityQueue<Node>(MAX_NODES,
				new Comparator<Node>() {

					@Override
					public int compare(Node lhs, Node rhs) {
						if (lhs.getfScore() == rhs.getfScore())
							return 0;
						return lhs.getfScore() < rhs.getfScore() ? -1 : 1;
					}

				});

		openSet.add(start);
		start.setgScore(0);
		// start.setCurrentRoute(currentRoute);

//		start.sethCost(BusFunction.convertToDistance(geo1, geo2));
		start.setfScore(start.getgScore() + getHeuristicCost(start, goal));

		while (!openSet.isEmpty()) {
			// peek and remove
			Node current = openSet.poll();

			// neu id trung` nhau (current == goal)
			if (current.equals(goal)) {
				return reconstructPath(goal);
			}

			closedSet.add(current);

			// current.setEdgeList(createEdgeList(current));
			// current.modifyEdgeList();

			for (Edge e : createEdgeList(current)) {
				Node child = e.getNode();
				if (closedSet.contains(child))
					continue;
				// TODO: tentative distance tentgScore between current and child
				// currently use
				// "temp cost = pure cost + CHANGEBUS_COST_PLUS * numOfChange"
				// LatLng currentLoc = current.getStop().getStopLocation();
				// LatLng childLoc = child.getStop().getStopLocation();

				tentgScore = current.getgScore() + e.getCost();

				if (!openSet.contains(child) || tentgScore < child.getgScore()) {
					child.setParent(current);
					child.setgScore(tentgScore);
					child.setfScore(child.getgScore() + getHeuristicCost(child, goal));
					if (!openSet.contains(child))
						openSet.add(child);
				}
			}

		} // end while

		return null;
	} // end method calcShortestPath

	/**
	 * duplicate edgeList with plus changebus_cost_plus
	 * */
	private ArrayList<Edge> createEdgeList(Node current) {
		ArrayList<Edge> tempEdgeList = new ArrayList<Edge>();
		for (Edge e : current.getEdgeList()) {
			// if ( e.getNode().getParent().equals(startNode) )

			Edge newEdge = new Edge();
			newEdge.setNode(e.getNode());
			BusRoute br = e.getCurrentRoute();
			// neu di theo lo. trinh khac
			if (!br.equals(current.getCurrentRoute())) {
				// neu node hien tai la startNode thi ko bi. "plus changebus"
				if (!current.equals(startNode))
					newEdge.setCost(e.getCost() + Node.CHANGEBUS_COST_PLUS);
				Node n = newEdge.getNode();
				n.setCurrentRoute(br);
				n.setNumOfChange( n.getNumOfChange() + 1 );
			}
			newEdge.setCurrentRoute(br);

			tempEdgeList.add(newEdge);
		}

		return tempEdgeList;
	}

	/**
	 * reconstruct path from start to goal<br>
	 * based on tracing back from goal to start (keeping node.parent)<br>
	 * TODO: chua lam
	 * */
	private ArrayList<Node> reconstructPath(Node goal) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * heuristic cost currently based on "straight-line"
	 * */
	private double getHeuristicCost(Node start, Node goal) {
		LatLng geo1 = start.getStop().getStopLocation();
		LatLng geo2 = goal.getStop().getStopLocation();
		return BusFunction.convertToDistance(geo1, geo2);
	}

	// private BusStop findStopGivenId(int stop) {
	// for (BusStop s: stopList)
	// if (s.getStopId() == stop)
	// return s;
	// return null;
	// }

} // end class
