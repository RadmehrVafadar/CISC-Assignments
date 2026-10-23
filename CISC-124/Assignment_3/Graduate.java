package Assignment_3;

/*
 * Student Name: Radmehr Vafadar
 * SID: 20421691
 * Date: 2024/08/07
 * Description: This class extends the Student class to represent a graduate student pursuing a certain program type (MASTERS, PROFESSIONAL_STUDIES, or PHD) and research funding. 
 * It covers strategies for obtaining and determining the sort of program and research money, as well as validation to ensure they are within permissible limits.
 * The class also has a method for calculating tuition depending on the student's domestic status and research funding, as well as a method for returning a string representing the graduate student.
 */

public class Graduate extends Student {
    public enum Program { MASTERS, PROFESSIONAL_STUDIES, PHD }
    
    private Program studentType;
    private double researchFunding;

    public Graduate(String firstName, String lastName, int age, int studentIdNumber, int yearOfStudy,
                    int numberOfCourses, double scholarship, boolean domestic, Program studentType, double researchFunding) throws HRException {
        super(firstName, lastName, age, studentIdNumber, yearOfStudy, numberOfCourses, scholarship, domestic);
        setStudentType(studentType);
        setResearchFunding(researchFunding);
    }

    public Program getStudentType() {
        return studentType;
    }

    public void setStudentType(Program studentType) throws HRException {
        if (studentType == null) {
            throw new HRException("Student type cannot be null");
        }
        this.studentType = studentType;
    }

    public double getResearchFunding() {
        return researchFunding;
    }

    public void setResearchFunding(double researchFunding) throws HRException {
        if (researchFunding <= 1000 || researchFunding >= 3000) {
            throw new HRException("Research funding must be between $1000 and $3000");
        }
        this.researchFunding = researchFunding;
    }

    @Override
    public String toString() {
        return super.toString() + " Graduate{" +
                "studentType=" + studentType +
                ", researchFunding=" + researchFunding +
                '}';
    }

    @Override
    public double calculateTuition() {
        double baseTuition = isDomestic() ? 5603.65 : 8426.27;
        return baseTuition - researchFunding;
    }
}   