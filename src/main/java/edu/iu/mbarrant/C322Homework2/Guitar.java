package edu.iu.mbarrant.C322Homework2;

public class Guitar {
    private String serialNumber;
    private double price;
    String builder;
    String model;
    String type;
    String backWood;
    String topWood;
    Integer numStrings;

    public void setBuilder(String builder) {
        this.builder = builder;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBackWood(String backWood) {
        this.backWood = backWood;
    }

    public void setTopWood(String topWood) {
        this.topWood = topWood;
    }

    public Guitar(String serialNumber, double price, String builder, String model, String type, String backWood, String topWood) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.builder = builder;
        this.model = model;
        this.type = type;
        this.backWood = backWood;
        this.topWood = topWood;
        this.numStrings = numStrings;

    }

    public Integer getNumStrings() {
        return numStrings;
    }

    public void setNumStrings(Integer numStrings) {
        this.numStrings = numStrings;
    }

    public String getSerialNumber() {
        return serialNumber;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(float newPrice) {
        this.price = newPrice;
    }
    public String getBuilder() {
        return builder;
    }
    public String getModel() {
        return model;
    }
    public String getType() {
        return type;
    }
    public String getBackWood() {
        return backWood;
    }
    public String getTopWood() {
        return topWood;
    }

}
