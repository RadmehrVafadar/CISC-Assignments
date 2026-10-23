package Assignment_2;

import java.util.Objects;

/*
 * Student Name: Radmehr Vafadar
 * SID: 20421691
 * Date: 25/07/24
 * Description: This program outlines the submarine object. It houses the objects properties and methods.
 */

public class Submarine implements Comparable<Submarine>, Cloneable {


    
    private String size;
    private int cheese;
    private int mushrooms;
    private int pepperoni;
    private double subCost;
    private int subCalories;

    private String cheeseString;
    private String mushroomString;
    private String pepperoniString;

    public Submarine(String size, int cheese, int mushrooms, int pepperoni) {
        setSize(size);
        setCheese(cheese);
        setMushrooms(mushrooms);
        setPepperoni(pepperoni);
    }

    public double calculateCost() {

        switch(size) {
            case "small":
                subCost += 7;
                break;

            case "medium":
                subCost += 9;
                break;

            case "large":
                subCost += 11;
                break;

        }

        switch(cheese) {
            case 2:
                subCost += 1.5;
                break;
            
            case 3:
                subCost += 3;
                break;
            
            default:
            //pass
            break;
        }

        switch(mushrooms) {
            case 2:
                subCost += 1.5;
                break;
            
            case 3:
                subCost += 3;
                break;
            
            default:
            //pass
            break;
        }

        switch(pepperoni) {
            case 2:
                subCost += 1.5;
                break;
            
            case 3:
                subCost += 3;
                break;
            
            default:
            //pass
            break;
        }

        return subCost; 
    }

    public int calculateNutrition() {

        switch (cheese) {
            case 1:
                subCalories += 50;
                break;

            case 2:
                subCalories += 100;
                break;

            case 3:
                subCalories += 150;
                break;

            default:
                break;
        }

        switch (mushrooms) {
            case 1:
                subCalories += 15;
                break;

            case 2:
                subCalories += 30;
                break;
        
            case 3:
                subCalories += 45;
                break;

            default:
                break;
        }

        switch (pepperoni) {
            case 1:
                subCalories += 80;
                break;

            case 2:
                subCalories += 160;
                break;
        
            case 3:
                subCalories += 240;
                break;

            default:
                break;
        }
    
        return subCalories; 
    }

    @Override 
    public String toString() {

        switch (cheese) {
            case 1:
                cheeseString = "single";
                break;

            case 2:
                cheeseString = "double";
                break;

            case 3:
                cheeseString = "triple";
                break;
        
            default:
                cheeseString = "none";
                break;
        }

        switch (mushrooms) {
            case 1:
                mushroomString = "single";
                break;

            case 2:
                mushroomString = "double";
                break;

            case 3:
                mushroomString = "triple";
                break;
        
            default:
                mushroomString = "none";
                break;
        }

        switch (pepperoni) {
            case 1:
                pepperoniString = "single";
                break;

            case 2:
                pepperoniString = "double";
                break;

            case 3:
                pepperoniString = "triple";
                break;
        
            default:
                pepperoniString = "none";
                break;
        }

        return size.substring(0, 1).toUpperCase() + size.substring(1) + " submarine sandwich with a " + cheeseString + " portion of cheese, a " + mushroomString + " portion of mushrooms, and a " + pepperoniString + " portion of pepperoni." ;

    }

    @Override
    public int compareTo(Submarine other) {
        return Double.compare(this.calculateCost(), other.calculateCost());
    }

        @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Submarine submarine = (Submarine) o;
        return cheese == submarine.cheese &&
               mushrooms == submarine.mushrooms &&
               pepperoni == submarine.pepperoni &&
               size.equals(submarine.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, cheese, mushrooms, pepperoni);
    }

    @Override
    public Submarine clone() {
        try {
            return (Submarine) super.clone();
        } catch (CloneNotSupportedException e) {
            return new Submarine(this.size, this.cheese, this.mushrooms, this.pepperoni);
        }
    }

    
    // Mutator Methods
    public void setSize(String s) throws IllegalSubmarine {
        if (s.equals("small") || s.equals("medium") || s.equals("large")) {
            size = s;
        }
        else {
            throw new IllegalSubmarine("Illegal size: " + s + ". Must be small, medium or large.");
        }
    }

    public void setCheese(int c) {
        if (c > 3 || c < 0) {
            throw new IllegalSubmarine("Illegal cheese ammount: " + c + ". Has to be 0, 1, 2 or 3.");
        }
        cheese = c;
    }

    public void setMushrooms(int m) {
        if (m > 3 || m < 0) {
            throw new IllegalSubmarine("Illegal mushroom ammount: " + m + ". Has to be 0, 1, 2 or 3.");
        }
        mushrooms = m;
    }

    public void setPepperoni(int p) {
        if (p > 3 || p < 0) {
            throw new IllegalSubmarine("Illegal pepperoni ammount: " + p + ". Has to be 0, 1, 2 or 3.");
        }
        pepperoni = p;
    }


    // Accessor Methonds
    public String getSize() {
        return size;
    }

    public int getCheese() {
        return cheese;
    }
    
    public int getMushrooms() {
        return mushrooms;
    }

    public int getPepperoni() {
        return pepperoni;
    }


}
