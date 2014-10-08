/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.fbdo.geomodel;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author <a href="mailto:fabio.braga@gmail.com">Fabio Oliveira</a>
 */
@JsonAutoDetect
public class Geometry {

    public enum Type {

        ROOFTOP, RANGE_INTERPOLATED, GEOMETRIC_CENTER, APPROXIMATE
    }

    @JsonProperty("location")
    private GeoCoordinate location;
    @JsonProperty("location_type")
    private Type locationType;
    @JsonProperty("viewport")
    private BoundingBox viewport;
    @JsonProperty("bounds")
    private BoundingBox bounds;

    public GeoCoordinate getLocation() {
        return location;
    }

    public void setLocation(GeoCoordinate location) {
        this.location = location;
    }

    public Type getLocationType() {
        return locationType;
    }

    public void setLocationType(Type locationType) {
        this.locationType = locationType;
    }

    public BoundingBox getViewport() {
        return viewport;
    }

    public void setViewport(BoundingBox viewport) {
        this.viewport = viewport;
    }

    public BoundingBox getBounds() {
        return bounds;
    }

    public void setBounds(BoundingBox bounds) {
        this.bounds = bounds;
    }
}
