package com.ps;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Transaction> history = new ArrayList<>();

    public static void main(String[] args) {

        int homeScreenMenu;

        do {
            System.out.println("---Welcome to your account!---");
            System.out.println("1) Deposit money into your account.");
            System.out.println("2) Make a Payment from your account.");
            System.out.println("3) Display your Ledger.");
            System.out.println("What would you like to do today");
            homeScreenMenu = scanner.nextInt();

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

    private static void handleDepositScreen() {

    }

    private static void handlePaymentScreen() {

    }

    private static void handleLedgerScreen() {

    }
}