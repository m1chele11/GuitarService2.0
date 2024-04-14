package edu.iu.mbarrant.C322Homework2.enums;



public enum TypeEnum {
    ACOUSTIC, ELECTRIC, ANY;

    public String toString() {
        switch(this) {
            case ACOUSTIC: return "Acoustic";
            case ELECTRIC: return "Electric";
            case ANY: return "Any";
            default: return "Unspecified";
        }
    }
}
