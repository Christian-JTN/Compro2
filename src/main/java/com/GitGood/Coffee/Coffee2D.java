package com.GitGood.Coffee;

import java.util.Scanner;
public class Coffee2D {
    public static void main(String[] args){
        try (Scanner nera = new Scanner(System.in)) {
            String[] orderMenu = {"Espresso", "Latte", "Cappuccino", "Mocha"};

            double[][] orderDetails = {
                    {50.0, 0}, // Espresso - kinda good
                    {70.0, 0}, // Latte - Mid
                    {65.0, 0}, // Cappuccino - somewhat good
                    {80.0, 0}  // Mocha - Favorito
            };
            while (true) {
                System.out.println("""
                        --- Coffee Menu ---
                        1. Espresso - 50.0 PHP
                        2. Latte - 70.0 PHP
                        3. Cappuccino - 65.0 PHP
                        4. Mocha - 80.0 PHP
                        0. Finish Order
                        Choose your coffee(1-4, or 0 to finish)""");
                if (!nera.hasNextInt()) {
                    System.out.println("Invalid input. Please try a different order");
                    nera.next();
                    continue;
                }
                int choice = nera.nextInt();
                if (choice == 0) break;
                if (choice < 1 || choice > orderMenu.length) {
                    System.out.println("Invalid input. Please try a different order");
                    continue;
                }
                System.out.print("Enter Quantity: ");
                if (!nera.hasNextInt()) {
                    System.out.println("Invalid input. Please try a different order");
                    nera.next();
                    continue;
                }
                int quantity = nera.nextInt();
                if (quantity > 0) {
                    orderDetails[choice - 1][1] += quantity;
                } else {
                    System.out.println("Invalid input. Please try a different order");
                }
            }

            double subtotal = 0;
            boolean orderPlaced = false;

            System.out.println("\n---- Coffee Order Receipt ----");
            for (int i = 0; i < orderMenu.length; i++) {
                int qty = (int) orderDetails[i][1];
                if (qty > 0) {
                    orderPlaced = true;
                    double itemCost = qty * orderDetails[i][0];
                    subtotal += itemCost;
                    System.out.printf("%d x %s @ %.2f PHP = %.2f PHP\n", qty, orderMenu[i], orderDetails[i][0], itemCost);
                }
            }

            if (!orderPlaced) {
                System.out.println("No items were ordered");
            } else {
                double vat = subtotal * 0.12;
                double grandTotal = subtotal + vat;

                System.out.println("-------------------------------");
                System.out.printf("Subtotal: %.2f PHP\n", subtotal);
                System.out.printf("VAT (12%%): %.2f PHP\n", vat);
                System.out.printf("Grand Total: %.2f PHP\n", grandTotal);
                System.out.println("-------------------------------");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}