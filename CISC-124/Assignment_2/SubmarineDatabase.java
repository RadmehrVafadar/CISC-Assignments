package Assignment_2;
import java.util.ArrayList;


/*
 * Student Name: Radmehr Vafadar
 * SID: 20421691
 * Date: 25/07/24
 * Description: This program houses the submarine order data into an ArrayList.
 */

 
public class SubmarineDatabase {
    private ArrayList<Submarine> submarines = new ArrayList<>();

    public int searchOrders(Submarine sub) {
        return submarines.indexOf(sub);
    }

    public void addItem(int number, Submarine sub) {
        for (int i = 0; i < number; i++) {
            submarines.add(sub.clone());
        }
    }

    public void remove(Submarine sub) {
        submarines.remove(sub);
    }

    public void showOrders() {
        for (Submarine sub : submarines) {
            System.out.println(sub);
        }
    }
}