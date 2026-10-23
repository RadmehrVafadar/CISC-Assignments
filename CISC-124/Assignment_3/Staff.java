package Assignment_3;

/*
 * Student Name: Radmehr Vafadar
 * SID: 20421691
 * Date: 2024/08/07
 * Description: The abstract Staff class extends the Person class with properties that would apply to staff.
 * Properties such as staffID, departmentName and number of years working. It introduces its own Setter and Mutator methods for these properties.
 * In addition, it houses its own toString and creates and abstract method to calculate pay.
 */

public abstract class Staff extends Person {
    public enum DepartmentType { ARTS_SCI, ENGINEER, EDUCATION, HEALTH_SCI }
    
    private int staffIdNumber;
    private DepartmentType departmentName;
    private int numberOfYears;

    // Constructor Method
    public Staff(String firstName, String lastName, int age, int staffIdNumber, DepartmentType departmentName, int numberOfYears) throws HRException {
        super(firstName, lastName, age);
        setStaffIdNumber(staffIdNumber);
        setDepartmentName(departmentName);
        setNumberOfYears(numberOfYears);
    }

    // Getter Methods
    public int getStaffIdNumber() {
        return staffIdNumber;
    }

    public DepartmentType getDepartmentName() {
        return departmentName;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }


    // Mutator Methods
    public void setStaffIdNumber(int staffIdNumber) throws HRException {
        if (staffIdNumber <= 0) {
            throw new HRException("Staff ID number must be positive");
        }
        this.staffIdNumber = staffIdNumber;
    }

    public void setDepartmentName(DepartmentType departmentName) throws HRException {
        if (departmentName == null) {
            throw new HRException("Department name cannot be null");
        }
        this.departmentName = departmentName;
    }

    public void setNumberOfYears(int numberOfYears) throws HRException {
        if (numberOfYears < 0 || numberOfYears > 40) {
            throw new HRException("Number of years must be between 0 and 40");
        }
        this.numberOfYears = numberOfYears;
    }

    @Override
    public String toString() {
        return super.toString() + " Staff{" +
                "staffIdNumber=" + staffIdNumber +
                ", departmentName=" + departmentName +
                ", numberOfYears=" + numberOfYears +
                '}';
    }

    public abstract double calculatePay();
}
