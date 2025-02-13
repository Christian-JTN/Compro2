package com.GitGood.Coffee;

public class MainCof {
    public static void main(String[] args) {
        Coffee coffee1 = new Coffee("Espresso", "Arabica", "Small", 3.50,
                "Dark", "Colombia", false, 10, "Espresso Machine");

        Coffee coffee2 = new Coffee("Latte", "Robusta", "Medium", 4.00,
                "Medium", "Brazil", false, 15, "Drip");

        coffee1.addFlavor("Chocolate");
        coffee1.addFlavor("Nutty");
        coffee2.addFlavor("Vanilla");
        coffee2.addFlavor("Caramel");

        System.out.println(coffee1.describe());
        System.out.println("Price of medium " + coffee1.calculatePrice("medium"));
        coffee1.updateStock(-2);
        System.out.println("Stock available: " + coffee1.checkStock());

        System.out.println(coffee2.describe());
        coffee2.discount(10);
        System.out.println("Price after discount: $" + coffee2.calculatePrice("medium"));
    }
}
