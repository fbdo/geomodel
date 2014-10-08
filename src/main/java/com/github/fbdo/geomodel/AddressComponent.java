/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.fbdo.geomodel;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/**
 * @author <a href="mailto:fabio.braga@gmail.com">Fabio Oliveira</a>
 */
@JsonAutoDetect
public class AddressComponent {

    /**
     *
     */
    private static final long serialVersionUID = 4198297042363723302L;
    @JsonProperty("long_name")
    private String longName;
    @JsonProperty("short_name")
    private String shortName;

    @JsonProperty("types")
    private AddressType[] types;

    protected AddressComponent() {
    }

    public AddressComponent(String longName, String shortName,
                            AddressType[] types) {
        super();
        this.longName = longName;
        this.shortName = shortName;
        this.types = types;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public AddressType[] getTypes() {
        return types;
    }

    public void setTypes(AddressType[] types) {
        this.types = types;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((longName == null) ? 0 : longName.hashCode());
        result = prime * result
                + ((shortName == null) ? 0 : shortName.hashCode());
        result = prime * result + Arrays.hashCode(types);
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
        AddressComponent other = (AddressComponent) obj;
        if (longName == null) {
            if (other.longName != null) {
                return false;
            }
        } else if (!longName.equals(other.longName)) {
            return false;
        }
        if (shortName == null) {
            if (other.shortName != null) {
                return false;
            }
        } else if (!shortName.equals(other.shortName)) {
            return false;
        }
        if (!Arrays.equals(types, other.types)) {
            return false;
        }
        return true;
    }


}
