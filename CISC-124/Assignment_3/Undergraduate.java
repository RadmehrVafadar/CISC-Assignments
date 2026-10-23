package Assignment_3;

/*
 * Student Name: Radmehr Vafadar
 * SID: 20421691
 * Date: 2024/08/07
 * Description: The Undergraduate class extends the abstract Student class.
 * It creates properties that apply to an undergraduate student such as MajorType and residence. It has its own Setter and Mutator methods for these new properties.
 * In addition it houses its own toString method and has a method calculating the ammount of tuition cost based on if the student is international or domestic.
 */

public class Undergraduate extends Student {
    public enum MajorType { ENGLISH, COMPUTER_SCIENCE, MATHEMATICS, ENGINEERING, EDUCATION, MEDICINE, ARTS_SCI }

    private MajorType major;
    private boolean residence;

    public Undergraduate(String firstName, String lastName, int age, int studentIdNumber, int yearOfStudy,
                         int numberOfCourses, double scholarship, boolean domestic, MajorType major, boolean residence) throws HRException {
        super(firstName, lastName, age, studentIdNumber, yearOfStudy, numberOfCourses, scholarship, domestic);
        setMajor(major);
        setResidence(residence);
    }

    // Getter Method
    public MajorType getMajor() {
        return major;
    }


    // Mutator Methods
    public void setMajor(MajorType major) throws HRException {
        if (major == null) {
            throw new HRException("Major cannot be null");
        }
        this.major = major;
    }

    public boolean isResidence() {
        return residence;
    }

    public void setResidence(boolean residence) {
        this.residence = residence;
    }

    @Override
    public String toString() {
        return super.toString() + " Undergraduate{" +
                "major=" + major +
                ", residence=" + residence +
                '}';
    }

    @Override
    public double calculateTuition() {
        double baseTuition = isDomestic() ? 9934 : 30263;
        
        switch (major) {
            case COMPUTER_SCIENCE:
                baseTuition = isDomestic() ? 9619 : 33875;
                break;
            case MATHEMATICS:
                baseTuition = isDomestic() ? 9567 : 34537;
                break;
            case ENGINEERING:
                baseTuition = isDomestic() ? 12626 : 29873;
                break;
            case EDUCATION:
            case MEDICINE:
            case ARTS_SCI:
                baseTuition = isDomestic() ? 7037 : 32416;
                break;
        }
        
        return baseTuition;
    }
}