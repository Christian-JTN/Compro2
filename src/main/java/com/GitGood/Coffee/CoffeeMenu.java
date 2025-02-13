package com.GitGood.Coffee;

import java.util.Scanner;
public class CoffeeMenu {
    public static void main(String[] args){
        Scanner nera = new Scanner(System.in);
        String[] orderMenu = {"espresso", "latte", "cappuccino", "mocha"};
        double[] prices = {50.0, 70.0, 65.0, 80.0};

        int[] quantities = new int[orderMenu.length];

        try{
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
                if (choice < 1 || choice > orderMenu.length){
                    System.out.println("Invalid input. Please try a different order");
                    continue;
                }
                System.out.print("Enter Quantity: ");
                if (!nera.hasNextInt()){
                    System.out.println("Invalid input. Please try a different order");
                    nera.next();
                    continue;
                }
                int quantity = nera.nextInt();
                if (quantity > 0){
                    quantities[choice - 1] += quantity;
                } else {
                    System.out.println("Invalid input. Please try a different order");
                }
            }
            double subtotal = 0;
            boolean orderPlaced = false;

            System.out.println("\n---- Coffee order Receipt ----");
            for (int i = 0; i < orderMenu.length; i++){
                if (quantities[i] > 0){
                    orderPlaced = true;
                    double itemCost = quantities[i] * prices[i];
                    subtotal += itemCost;
                    System.out.printf("%d x %s @ %.2f PHP = %.2f PHP\n", quantities[i], orderMenu[i], prices[i], itemCost);
                }
            }
            if (!orderPlaced){
                System.out.println("No items was ordered");
            } else {
                double vat = subtotal * 0.12;
                double grandtotal = subtotal + vat;

                System.out.println("-------------------------------");
                System.out.printf("Subtotal: %.2f PHP\n", subtotal);
                System.out.printf("VAT (12%%): %.2f PHP\n", vat);
                System.out.printf("Grand Total: %.2f PHP\n", grandtotal);
                System.out.println("-------------------------------");
            }
        } catch (Exception e){
            System.out.println("Error " + e.getMessage());
        } finally {
            nera.close();
        }
    }
}
