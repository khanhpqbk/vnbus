package com.khanhpq.algorithm;

import java.util.ArrayList;

import com.khanhpq.datastructure.BusStop;
import com.khanhpq.util.BusFunction;

public class DiagonalHeuristicFunc implements IHeuristicFunction{

	private ArrayList<BusStop> stopList = new ArrayList<BusStop>();
	
	public DiagonalHeuristicFunc(ArrayList<BusStop> stopList){
		this.stopList = stopList;
	}
	
	@Override
	public double caclHeuristicDistance(int startStop, int endStop) {
		BusStop bs1 = findBusStopGivenId(startStop);
		BusStop bs2 = findBusStopGivenId(endStop);
		
		if(bs1== null || bs2 == null)
			return 0;
		return BusFunction.convertToDistance(bs1.getStopLocation(), bs2.getStopLocation());
	}

	private BusStop findBusStopGivenId(int stop) {
		for(BusStop s: stopList)
			if(s.equals(stop)) return s;
		return null;
	}

}
