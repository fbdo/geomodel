package com.github.fbdo.geomodel;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonAutoDetect
public final class GeoCoordinate implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -1633611118363854062L;

    private Float latitude;

    private Float longitude;

    private static int EARTH_RADIUS_M = 6378137;

    protected GeoCoordinate() {
    }

    public GeoCoordinate(GeoCoordinate other) {
        this(other.getLatitude(), other.getLongitude());
    }

    public GeoCoordinate(float latitude, float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        if (Math.abs(latitude) > 90 || Math.abs(longitude) > 180) {
            throw new IllegalArgumentException("The supplied coordinates "
                    + this + " are out of range.");
        }

    }

    @JsonProperty("lat")
    public Float getLatitude() {
        return latitude;
    }

    @JsonProperty("lng")
    public Float getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return String.format("(" + latitude + "," + longitude + ")");
    }

    /**
     * Distance between two points, in meters.
     *
     * @param other
     * @return
     */
    public float distanceBetween(GeoCoordinate other) {
        double dLat = deg2rad(getLatitude() - other.getLatitude());
        double dLon = deg2rad(getLongitude() - other.getLongitude());
        double a = Math.sin(dLat / 2.0) * Math.sin(dLat / 2.0)
                + Math.cos(deg2rad(getLatitude()))
                * Math.cos(deg2rad(other.getLatitude())) * Math.sin(dLon / 2.0)
                * Math.sin(dLon / 2.0);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1.0 - a));
        return (float) (EARTH_RADIUS_M * c); // Distance in meters
    }

    private double deg2rad(float deg) {
        return deg * (Math.PI / 180.0);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof GeoCoordinate) {
            GeoCoordinate other = (GeoCoordinate) obj;
            return latitude == other.latitude && longitude == other.longitude;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 42;
        long latBits = Double.doubleToLongBits(latitude);
        long lonBits = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (latBits ^ (latBits >>> 32));
        result = 31 * result + (int) (lonBits ^ (lonBits >>> 32));
        return result;
    }

}
