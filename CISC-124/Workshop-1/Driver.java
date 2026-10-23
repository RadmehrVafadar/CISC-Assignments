public class Driver {
   
    public static void main(String[] args) {
        Car car1 = new Car("Ford", "ABCD235", 2010, "red");
        Car car2 = new Car("BMW", "ACCD235", 2009, "pink");
        Car car3 = new Car("Audi", "ACHG235", 2020);
        System.out.println(car1.make);
        System.out.println(car2);
    }
}
