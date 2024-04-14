package edu.iu.mbarrant.C322Homework2.model;



public record GuitarData(String serialNumber, double price, String builder, String model, String type, String backWood, String topWood) {


    public String toLine() {
        return String.format("%1$s,%2$s,%3$s,%4$s,%5$s,%6$s,%7$s", serialNumber , price, builder, model, type, backWood, topWood);
    }
    public static GuitarData fromLine(String line) {
        String[] tokens = line.split(",");
        return new GuitarData(tokens[0], Double.parseDouble(tokens[1]), tokens[2], tokens[3], tokens[4], tokens[5], tokens[6]);
    }




}