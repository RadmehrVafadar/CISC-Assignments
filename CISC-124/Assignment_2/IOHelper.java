package Assignment_2;

import java.util.Scanner;

/*
 * Student Name: Radmehr Vafadar
 * SID: 20421691
 * Date: 25/07/24
 * Description: This class takes user input in an interactive manner, and creates a submarine object.
 * Furthermore, it provides description of order and costs.
 */


public class IOHelper {
    private static Scanner scanner = new Scanner(System.in);

    public static Submarine configureSubmarine() throws IllegalSubmarine {
        System.out.println("Configure your submarine:");
        
        System.out.print("Size (small/medium/large): ");
        String size = scanner.nextLine().toLowerCase();

        System.out.print("Cheese portion (0-3): ");
        int cheese = Integer.parseInt(scanner.nextLine());

        System.out.print("Mushroom portion (0-3): ");
        int mushrooms = Integer.parseInt(scanner.nextLine());

        System.out.print("Pepperoni portion (0-3): ");
        int pepperoni = Integer.parseInt(scanner.nextLine());

        Submarine sub = new Submarine(size, cheese, mushrooms, pepperoni);
        System.out.println("Submarine configured: " + sub);
        System.out.println("Cost: $" + String.format("%.2f", sub.calculateCost()));
        System.out.println("Cost with tax: $" + String.format("%.2f", sub.calculateCost() * 1.15));

        return sub;
    }
}
