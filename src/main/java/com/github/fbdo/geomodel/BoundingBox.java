/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.fbdo.geomodel;


/**
 * @author <a href="mailto:fabio.braga@gmail.com">Fabio Oliveira</a>
 */
public class BoundingBox {
    private GeoCoordinate southwest;

    private GeoCoordinate northeast;

    public GeoCoordinate getNortheast() {
        return northeast;
    }

    public void setNortheast(GeoCoordinate northeast) {
        this.northeast = northeast;
    }

    public GeoCoordinate getSouthwest() {
        return southwest;
    }

    public void setSouthwest(GeoCoordinate southwest) {
        this.southwest = southwest;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((northeast == null) ? 0 : northeast.hashCode());
        result = prime * result
                + ((southwest == null) ? 0 : southwest.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        BoundingBox other = (BoundingBox) obj;
        if (northeast == null) {
            if (other.northeast != null) {
                return false;
            }
        } else if (!northeast.equals(other.northeast)) {
            return false;
        }
        if (southwest == null) {
            if (other.southwest != null) {
                return false;
            }
        } else if (!southwest.equals(other.southwest)) {
            return false;
        }
        return true;
    }


}
