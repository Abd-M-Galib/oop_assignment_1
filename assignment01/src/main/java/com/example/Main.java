package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String[] productName = new String[100];
        int[] productId = new int[100];
        int[] productQuantity = new int[100];
        double[] productPrice = new double[100];
        int productCount = 0;

        askForOperation(productCount, productName, productId, productQuantity, productPrice, userInput);
    }

    public static void insertProduct(int pCount, String[] pName, int[] pId, int[] pQuantity, double[] pPrice, Scanner input) {
        if (pCount < 100) {
            System.out.println("Enter Product Name = ");
            pName[pCount] = input.nextLine();

            System.out.println("Enter Product Id = ");
            pId[pCount] = input.nextInt();
            input.nextLine(); 

            System.out.println("Enter Product Price = ");
            pPrice[pCount] = input.nextDouble();
            input.nextLine(); 

            System.out.println("Enter Product Quantity = ");
            pQuantity[pCount] = input.nextInt();
            input.nextLine(); 

            pCount++;
        } else {
            System.out.println("You can only store 100 items. First rent a bigger shop to add more products.");
        }
        askForOperation(pCount, pName, pId, pQuantity, pPrice, input);
    }

    public static void deleteProduct(int pCount, String[] pName, int[] pId, int[] pQuantity, double[] pPrice, Scanner input) {
        System.out.println("Enter the position of the product to delete = ");
        int position = input.nextInt();
        input.nextLine();

        if (position >= pCount || pName[position] == null) {
            System.out.println("Invalid position. Try again.");
        } else {
            for (int i = position; i < pCount - 1; i++) {
                pName[i] = pName[i + 1];
                pId[i] = pId[i + 1];
                pQuantity[i] = pQuantity[i + 1];
                pPrice[i] = pPrice[i + 1];
            }
            pName[pCount - 1] = null;
            pId[pCount - 1] = 0;
            pQuantity[pCount - 1] = 0;
            pPrice[pCount - 1] = 0.0;
            pCount--;
            System.out.println("Product deleted successfully.");
        }

        askForOperation(pCount, pName, pId, pQuantity, pPrice, input);
    }

    public static void updateProduct(int pCount, String[] pName, int[] pId, int[] pQuantity, double[] pPrice, Scanner input) {
        System.out.println("Enter the position of the product to update = ");
        int position = input.nextInt();
        input.nextLine(); 

        if (position >= pCount || pName[position] == null) {
            System.out.println("Invalid position. Try again.");
        } else {
            System.out.println("Enter new value for product name at position " + position + " = ");
            pName[position] = input.nextLine();

            System.out.println("Enter new value for product id at position " + position + " = ");
            pId[position] = input.nextInt();
            input.nextLine(); 

            System.out.println("Enter new value for product quantity at position " + position + " = ");
            pQuantity[position] = input.nextInt();
            input.nextLine(); 

            System.out.println("Enter new value for product price at position " + position + " = ");
            pPrice[position] = input.nextDouble();
            input.nextLine(); 

            System.out.println("Product updated successfully.");
        }

        askForOperation(pCount, pName, pId, pQuantity, pPrice, input);
    }

    public static void showProduct(int pCount, String[] pName, int[] pId, int[] pQuantity, double[] pPrice, Scanner input) {
        if (pCount == 0) {
            System.out.println("No products available to display.");
        } else {
            System.out.println("Showing " + pCount + " products:");
            for (int i = 0; i < pCount; i++) {
                if (pName[i] != null) {
                    System.out.println("Product Position - " + i + " | Product Id - " + pId[i] + " | Product Name - " + pName[i] + " | Product Price - " + pPrice[i] + " | Product Quantity - " + pQuantity[i]);
                }
            }
        }
        askForOperation(pCount, pName, pId, pQuantity, pPrice, input);
    }

    public static void askForOperation(int pCount, String[] pName, int[] pId, int[] pQuantity, double[] pPrice, Scanner input) {
        System.out.println("Which operation do you want to perform?\n1. Show product list\n2. Insert a new product\n3. Update a product\n4. Delete a product");
        int choice = input.nextInt();
        input.nextLine();

        switch (choice) {
            case 1:
                showProduct(pCount, pName, pId, pQuantity, pPrice, input);
                break;
            case 2:
                insertProduct(pCount, pName, pId, pQuantity, pPrice, input);
                break;
            case 3:
                updateProduct(pCount, pName, pId, pQuantity, pPrice, input);
                break;
            case 4:
                deleteProduct(pCount, pName, pId, pQuantity, pPrice, input);
                break;
            default:
                System.out.println("Invalid input. Try again.");
                askForOperation(pCount, pName, pId, pQuantity, pPrice, input);
                break;
        }
    }
}
