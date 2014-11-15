package com.khanhpq.util;

import com.google.android.gms.maps.model.LatLng;

public class BusFunction {
	
	// prevent instantiate instances of this class
	private BusFunction() {}

	public static double convertToDistance(LatLng geo1, LatLng geo2) {
		double R = 6371;
		double dLat = (geo2.latitude - geo1.latitude) * Math.PI / 180;
		double dLon = (geo2.longitude - geo2.longitude) * Math.PI / 180;
		double lat1 = geo1.latitude * Math.PI / 180;
		double lat2 = geo2.latitude * Math.PI / 180;
		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.sin(dLon / 2) * Math.sin(dLon / 2) * Math.cos(lat1) * Math.cos(lat2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double d = R * c;
		return d;
	}

	public static boolean isEqualGeo(LatLng geo1, LatLng geo2) {
		if (geo1.latitude == geo2.latitude && geo2.longitude == geo1.longitude)
			return true;
		return false;
	}

}
