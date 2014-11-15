package com.khanhpq.datastructure;

import java.util.ArrayList;

/**
 * lo. trinh 1 tuyen bus<br>
 * phan tach tu BusInfo for performance reason
 * 
 * @author KHANH
 * */
public class BusRoute {
	private int busId;
	private int direction;
	
	private ArrayList<Integer> stopList = new ArrayList<Integer>();

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + busId;
//		result = prime * result + direction;
//		return result;
//	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BusRoute other = (BusRoute) obj;
		if (busId != other.busId)
			return false;
		if (direction != other.direction)
			return false;
		return true;
	}
	
	
}
