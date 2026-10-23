package Assignment_3;

/*
 * Student Name: Radmehr Vafadar
 * SID: 20421691
 * Date: 2024/08/07
 * Description: This class extends the Staff class to represent a faculty member with a specified degree type (bachelor's or graduate).
 * It offers methods for getting and setting the degree type, as well as validation to ensure that it is not null.
 * The class also includes a method for calculating pay based on degree type and years of experience, as well as a method that returns a string representation of the faculty member.
 */


public class FacultyMember extends Staff {
    public enum Training { BACHELOR, GRADUATE }
    
    private Training degreeType;

    public FacultyMember(String firstName, String lastName, int age, int staffIdNumber, DepartmentType departmentName, 
                         int numberOfYears, Training degreeType) throws HRException {
        super(firstName, lastName, age, staffIdNumber, departmentName, numberOfYears);
        setDegreeType(degreeType);
    }

    // Getter Method
    public Training getDegreeType() {
        return degreeType;
    }

    // Mutator Method
    public void setDegreeType(Training degreeType) throws HRException {
        if (degreeType == null) {
            throw new HRException("Degree type cannot be null");
        }
        this.degreeType = degreeType;
    }

    @Override
    public String toString() {
        return super.toString() + " FacultyMember{" +
                "degreeType=" + degreeType +
                '}';
    }

    @Override
    public double calculatePay() {
        double basePay;
        if (degreeType == Training.BACHELOR) {
            basePay = 53345;
        } else {
            basePay = 58567;
        }
        
        int yearsOfExperience = getNumberOfYears();
        if (yearsOfExperience >= 8) {
            basePay += 26000;
        } else if (yearsOfExperience > 0) {
            basePay += (yearsOfExperience - 1) * 3000 + 3000;
        }
        
        return basePay;
    }
}