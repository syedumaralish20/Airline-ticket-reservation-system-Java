package airline.practice;

import java.util.*;

public class AirlinePractice {

    public static boolean res(boolean[] seats, int start, int end, String type) {
        for (int i = start; i <= end; i++) {
            if (!seats[i]) { // Using !seats[i] is cleaner than == false
                seats[i] = true;
                System.out.printf("Success! Seat %d reserved in %s class.%n", i + 1, type);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean[] seats = new boolean[10];
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Welcome to Umar's Airlines ---");
            System.out.println("1. Economy (1-5)\n2. Business (6-10)\n0. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();

            if (choice == 0) break;

            switch (choice) {
                case 1:
                    if (!res(seats, 0, 4, "Economy")) {
                        System.out.print("Economy full. Switch to Business? (1 for Yes / 2 for No): ");
                        if (sc.nextInt() == 1) {
                            if (!res(seats, 5, 9, "Business")) {
                                System.out.println("Sorry, the entire flight is full. Next flight in 3 hrs.");
                            }
                        } else {
                            System.out.println("Next flight in 3 hrs.");
                        }
                    }
                    break;

                case 2:
                    if (!res(seats, 5, 9, "Business")) {
                        System.out.print("Business full. Switch to Economy? (1 for Yes / 2 for No): ");
                        if (sc.nextInt() == 1) {
                            if (!res(seats, 0, 4, "Economy")) {
                                System.out.println("Sorry, the entire flight is full. Next flight in 3 hrs.");
                            }
                        } else {
                            System.out.println("Next flight in 3 hrs.");
                        }
                    }
                    break;
                
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
        System.out.println("Thank you for using Umar's Airlines!");
    }
}