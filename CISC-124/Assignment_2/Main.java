package Assignment_2;
import java.util.ArrayList;

/*
 * Student Name: Radmehr Vafadar
 * SID: 20421691
 * Date: 25/07/24
 * Description: This program tests the functionallity of the package classes and their methods.
 */

public class Main {
    public static void main(String[] args) {
        try {
            // Create two instances of a 'Submarine'
            Submarine submarine1 = new Submarine("medium", 1, 2, 1);
            Submarine submarine2 = new Submarine("large", 1, 1, 3);

            // Create an ArrayList for Submarine objects and another ArrayList for SubmarineOrder objects
            ArrayList<Submarine> submarines = new ArrayList<>();
            ArrayList<SubmarineOrder> submarine_orders = new ArrayList<>();

            // Adds 1 instance of submarine1 to the 'submarines' ArrayList
            submarines.add(submarine1);

            // Creates a new submarine order.
            SubmarineOrder submarineOrder = new SubmarineOrder(20, submarine2);

            // Adds the submarine order to the ArrayList of SubmarineOrders
            submarine_orders.add(submarineOrder);

            // Iterate over the ArrayList of Submarine objects and print out a string representation of the object using your toString().
            for (Submarine submarine : submarines) {
                System.out.println(submarine);
            }

            // Modify the attributes for submarine1's size and cheese attributes using the mutator ('setter') method.
            submarine1.setSize("small");
            submarine1.setCheese(2);

            // Iterate over the ArrayList of Submarine objects and print out the size for each -- demonstrates functionality of the 
            // 'getter' (accessor) methods.
            for (Submarine submarine : submarines) {
                System.out.println("the size of this submarine is: " + submarine.getSize());
            }

            for (SubmarineOrder order : submarine_orders) {
                System.out.println(order.getCost());
            }

            // Test IOHelper
            Submarine userSub = IOHelper.configureSubmarine();

            // Test SubmarineDatabase
            SubmarineDatabase database = new SubmarineDatabase();
            database.addItem(3, userSub);
            database.showOrders();

        } catch (IllegalSubmarine e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}