package com.ps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Transaction> history = new ArrayList<>();

    public static void main(String[] args) {

        loadTransactions();
        int homeScreenMenu;

        do {
            System.out.println("---Welcome to your account!---\n");
            System.out.println("1) Deposit money into your account.");
            System.out.println("2) Make a Payment.");
            System.out.println("3) Display your Ledger.");
            System.out.println("0) Exit\n");
            System.out.println("What would you like to do today?");
            homeScreenMenu = scanner.nextInt();
            scanner.nextLine();

            switch (homeScreenMenu) {
                case 1:
                    handleDepositScreen();
                    break;
                case 2:
                    handlePaymentScreen();
                    break;
                case 3:
                    handleLedgerScreen();
                case 0:
                    System.out.println("Exiting...");
                default:
                    System.out.println("Invalid, Please enter the right input. Try again.");
            }
        } while (homeScreenMenu != 0);

    }

    private static void loadTransactions() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("transactions.csv"));
            String input;

            while((input = bufferedReader.readLine()) != null) {
                String[] fields = input.split("\\|");

                String date = fields[0];
                String time = fields[1];
                String description = fields[2];
                String vendor = fields[3];
                double amount = Double.parseDouble(fields[4]);

                Transaction transaction = new Transaction(date, time, description, vendor, amount);

                history.add(transaction);
            }

            bufferedReader.close();

        } catch (Exception e) {
            System.out.println("No transactions found. Going back...");
        }
    }
    private static void saveTransaction(Transaction transaction) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("transactions.csv", true))) {
            writer.println(transaction.toCSV());
            history.add(transaction);
        } catch (Exception e) {
            System.out.println("Error in saving transaction: " + e.getMessage());
        }
    }

    private static void handleDepositScreen() {
        System.out.println("---Deposit---\n");
        System.out.println("How much would you like to Deposit?\n");
        System.out.println("1) $20");
        System.out.println("2) $50");
        System.out.println("3) $100");
        System.out.println("4) Custom");
        System.out.println("0) Go back to main menu.");

        int handleDepositMenu = scanner.nextInt();
        scanner.nextLine();

        double amount = 0;

        switch (handleDepositMenu) {
            case 1:
                amount = 20;
                break;
            case 2:
                amount = 50;
                break;
            case 3:
                amount = 100;
               break;
            case 4:
                System.out.println("Enter the Custom amount you would like to deposit: ");
                amount = scanner.nextDouble();
                scanner.nextLine();

                if (amount <= 0) {
                    System.out.println("Invalid. Deposit must be $1 or more! Please try again.");
                    return;
                }
                break;
            case 0:
                System.out.println("Going Back...");
                break;
            default:
                System.out.println("Invalid, Please enter the right input. Try again.");
        }
        System.out.print("Enter a description for this deposit: ");
        String description = scanner.nextLine();
        System.out.println("Enter the vendor name: ");
        String vendor = scanner.nextLine();

        String date = LocalDate.now().toString();
        String time = LocalTime.now().withNano(0).toString();

        Transaction transaction= new Transaction(date, time, description, vendor, amount);
        saveTransaction(transaction);
        System.out.println("You have deposited $" + amount);
    }

    private static void handlePaymentScreen() {


    }

    private static void handleLedgerScreen() {

    }


}