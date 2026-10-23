package Assignment_2;

import java.io.FileWriter;
import java.io.IOException;

/*
 * Student Name: Radmehr Vafadar
 * SID: 20421691
 * Date: 25/07/24
 * Description: This provides the user with order cost with tax. 
 * In addition, it writes the order data into a text file and ensures valid order quantity.
 */

public class SubmarineOrder {
    private int quantity;
    private Submarine submarine;

    public SubmarineOrder(int quantity, Submarine submarine) {
        if (quantity <= 0 || quantity > 100) {
            throw new IllegalSubmarine("Invalid quantity. Must be between 1 and 100.");
        }
        this.quantity = quantity;
        this.submarine = submarine;
    }

    public SubmarineOrder(Submarine submarine) {
        this(1, submarine);
    }

    public double getCost() {
        double totalCost = quantity * submarine.calculateCost();
        if (quantity >= 20) {
            return totalCost * 0.85; // 15% discount
        } else if (quantity >= 10) {
            return totalCost * 0.90; // 10% discount
        }
        return totalCost;
    }

    public void writeOrder() {
        try (FileWriter writer = new FileWriter("order.txt", true)) {
            writer.write(this.toString() + "\n");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return quantity + " x " + submarine.toString() + " Cost each: $" + String.format("%.2f", submarine.calculateCost());
    }
}