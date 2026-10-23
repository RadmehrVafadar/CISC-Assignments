package Assignment_3;

/*
 * Student Name: Radmehr Vafadar
 * SID: 20421691
 * Date: 2024/08/07
 * Description: The SupportStaff class extends the abstract Staff class.
 * It creates properties such as pay and hours worked. It has its own Setter and Mutator methods for these new properties.
 * In addition it houses its own toString method and has a method calculating the ammount of pay for the object/SupportingStaff.
 */

public class SupportStaff extends Staff {
    private int numberOfHours;
    private double basePayRate;

    public SupportStaff(String firstName, String lastName, int age, int staffIdNumber, DepartmentType departmentName, 
                        int numberOfYears, int numberOfHours, double basePayRate) throws HRException {
        super(firstName, lastName, age, staffIdNumber, departmentName, numberOfYears);
        setNumberOfHours(numberOfHours);
        setBasePayRate(basePayRate);
    }

    // Getter Methods
    public int getNumberOfHours() {
        return numberOfHours;
    }

    public double getBasePayRate() {
        return basePayRate;
    }

    // Mutator Methods
    public void setNumberOfHours(int numberOfHours) throws HRException {
        if (numberOfHours <= 0) {
            throw new HRException("Number of hours must be positive");
        }
        this.numberOfHours = numberOfHours;
    }

    public void setBasePayRate(double basePayRate) throws HRException {
        if (basePayRate <= 15) {
            throw new HRException("Base pay rate must be greater than $15");
        }
        this.basePayRate = basePayRate;
    }

    @Override
    public String toString() {
        return super.toString() + " SupportStaff{" +
                "numberOfHours=" + numberOfHours +
                ", basePayRate=" + basePayRate +
                '}';
    }

    @Override
    public double calculatePay() {
        return (basePayRate * numberOfHours) * 52;
    }
}
