package com.khanhpq.datastructure;

import java.util.ArrayList;

import com.google.android.gms.maps.model.LatLng;

/**
 * diem? dung` xe bus
 * @author KHANH
 * */
public class BusStop {
	
	private int stopId; // id
	/**
	 * ten diem dung`
	 * */
	private String stopName;     
	/**
	 * cac xe di qua diem? dung` nay
	 * */
	private ArrayList<Integer> busList = new ArrayList<Integer>();
	
	private LatLng stopLocation;

	

	public int getStopId() {
		return stopId;
	}

	public void setStopId(int stopId) {
		this.stopId = stopId;
	}

	public String getStopName() {
		return stopName;
	}

	public void setStopName(String stopName) {
		this.stopName = stopName;
	}

	public ArrayList<Integer> getBusList() {
		return busList;
	}

	public void setBusList(ArrayList<Integer> busList) {
		this.busList = busList;
	}

	public LatLng getStopLocation() {
		return stopLocation;
	}

	public void setStopLocation(LatLng stopLocation) {
		this.stopLocation = stopLocation;
	}
	
	public boolean equals(Object obj) {
		if(((BusStop)obj ).getStopId() == stopId  )
			return true;
		return false;
	}
	
}