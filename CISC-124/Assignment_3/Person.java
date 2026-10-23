package Assignment_3;

/*
 * Student Name: Radmehr Vafadar
 * SID: 20421691
 * Date: 2024/08/07
 * Description: This class creates and object called Person and gives it properties such as first name, last name and age.
 * It also provides Mutator and Getter methods for each of those properties. In addition, it houses a toString and compare method.
 */

public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private int age;

    // Constructor Method
    public Person(String firstName, String lastName, int age) throws HRException {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
    }

    // Getter Methods
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    // Mutator Methods
    public void setFirstName(String firstName) throws HRException {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new HRException("First name cannot be empty");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) throws HRException {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new HRException("Last name cannot be empty");
        }
        this.lastName = lastName;
    }

    public void setAge(int age) throws HRException {
        if (age < 15) {
            throw new HRException("Age must be 15 or older");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.age, other.age);
    }
}