public class Car {

    public String make;
    private String licensePlate;
    private int yearManufactured;
    private String color;

    public Car(String makeVehicle, String licence, int year, String CarColor) {
        this.make = makeVehicle;
        this.licensePlate = licence;
        this.yearManufactured = year;
        this.color = CarColor;
    }

    public Car(String makeVehicle, String licence, int year) {
        this.make = makeVehicle;
        this.licensePlate = licence;
        this.yearManufactured = year;
        this.color = "green";
    }

}