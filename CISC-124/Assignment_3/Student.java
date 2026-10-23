package Assignment_3;

/*
 * Student Name: Radmehr Vafadar
 * SID: 20421691
 * Date: 2024/08/07
 * Description: The abstract Student class extends the Person class with properties that would apply to students.
 * Properties such as StudentID, year of Study and etc.. It introduces its own Setter and Mutator methods for these properties.
 * In addition, it houses its own toString and creates and abstract method to calculate tuition.
 */

public abstract class Student extends Person {
    private int studentIdNumber;
    private int yearOfStudy;
    private int numberOfCourses;
    private double scholarship;
    private boolean domestic;


    // Constructor Method
    public Student(String firstName, String lastName, int age, int studentIdNumber, int yearOfStudy, 
                   int numberOfCourses, double scholarship, boolean domestic) throws HRException {
        super(firstName, lastName, age);
        setStudentIdNumber(studentIdNumber);
        setYearOfStudy(yearOfStudy);
        setNumberOfCourses(numberOfCourses);
        setScholarship(scholarship);
        setDomestic(domestic);
    }

    // Getter Methods
    public int getStudentIdNumber() {
        return studentIdNumber;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public int getNumberOfCourses() {
        return numberOfCourses;
    }

    public double getScholarship() {
        return scholarship;
    }

    public boolean isDomestic() {
        return domestic;
    }

    // Mutator Methods
    public void setStudentIdNumber(int studentIdNumber) throws HRException {
        if (studentIdNumber <= 0) {
            throw new HRException("Student ID number must be positive");
        }
        this.studentIdNumber = studentIdNumber;
    }

    public void setYearOfStudy(int yearOfStudy) throws HRException {
        if (yearOfStudy <= 0 || yearOfStudy > 10) {
            throw new HRException("Year of study must be between 1 and 10");
        }
        this.yearOfStudy = yearOfStudy;
    }

    public void setNumberOfCourses(int numberOfCourses) throws HRException {
        if (numberOfCourses <= 0 || numberOfCourses > 5) {
            throw new HRException("Number of courses must be between 1 and 5");
        }
        this.numberOfCourses = numberOfCourses;
    }

    public void setScholarship(double scholarship) throws HRException {
        if (scholarship <= 60000 || scholarship > 120000) {
            throw new HRException("Scholarship must be between $60,000 and $120,000");
        }
        this.scholarship = scholarship;
    }

    public void setDomestic(boolean domestic) {
        this.domestic = domestic;
    }

    @Override
    public String toString() {
        return super.toString() + " Student{" +
                "studentIdNumber=" + studentIdNumber +
                ", yearOfStudy=" + yearOfStudy +
                ", numberOfCourses=" + numberOfCourses +
                ", scholarship=" + scholarship +
                ", domestic=" + domestic +
                '}';
    }

    public abstract double calculateTuition();
}
