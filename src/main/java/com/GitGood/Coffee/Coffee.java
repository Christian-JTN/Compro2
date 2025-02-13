package com.GitGood.Coffee;

import java.util.ArrayList;
import java.util.List;

public class Coffee {
    private String name;
    private String type;
    private String size;
    private double price;
    private String roastLevel;
    private String origin;
    private boolean isDecaf;
    private int stock;
    private List<String> flavorNotes;
    private String brewMethod;

    public Coffee(String name, String type, String size, double price, String roastLevel,
                  String origin, boolean isDecaf, int stock, String brewMethod) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.price = price;
        this.roastLevel = roastLevel;
        this.origin = origin;
        this.isDecaf = isDecaf;
        this.stock = stock;
        this.brewMethod = brewMethod;
        this.flavorNotes = new ArrayList<>();
    }

    public double calculatePrice(String size) {
        switch (size.toLowerCase()) {
            case "small":
                return price;
            case "medium":
                return price * 1.2;
            case "large":
                return price * 1.5;
            default:
                return price;
        }
    }

    public boolean checkStock() {
        return stock > 0;
    }

    public void addFlavor(String note) {
        flavorNotes.add(note);
    }

    public void updateStock(int quantity) {
        this.stock += quantity;
    }

    public String describe() {
        return "A " + roastLevel + " roast coffee with " + String.join(", ", flavorNotes) +
                " notes, brewed using " + brewMethod + ".";
    }

    public void setDecaf(boolean isDecaf) {
        this.isDecaf = isDecaf;
    }

    public void changeRoastLevel(String newRoastLevel) {
        this.roastLevel = newRoastLevel;
    }

    public void discount(double percentage) {
        this.price -= (price * (percentage / 100));
    }
}
