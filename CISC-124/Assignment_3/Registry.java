package Assignment_3;

import java.util.ArrayList;

/*
 * Student Name: Radmehr Vafadar
 * SID: 20421691
 * Date: 2024/08/07
 * Description: This class test all of the different object instances with example and prints the results. 
 * It also includes exception handling.
 */

public class Registry {
    public static void main(String[] args) {
        ArrayList<Person> personDB = new ArrayList<>();

        try {
            Undergraduate person1 = new Undergraduate("Emma", "Wilson", 22, 20456, 2, 5, 75000, true, Undergraduate.MajorType.ENGINEERING, true);
            personDB.add(person1);

            Graduate person2 = new Graduate("Liam", "Chen", 28, 30789, 3, 2, 80000, false, Graduate.Program.PHD, 1500);
            personDB.add(person2);

            SupportStaff person3 = new SupportStaff("Sophia", "Garcia", 42, 90123, Staff.DepartmentType.HEALTH_SCI, 12, 40, 18.50);
            personDB.add(person3);

            FacultyMember person4 = new FacultyMember("Noah", "Patel", 38, 95678, Staff.DepartmentType.ENGINEER, 7, FacultyMember.Training.GRADUATE);
            personDB.add(person4);

            // Test compareTo
            System.out.println(person1.compareTo(person3));
            System.out.println("Sophia is " + (person3.getAge() - person1.getAge()) + " years older than Emma");

            // Print all persons
            for (Person person : personDB) {
                System.out.println(person);
                if (person instanceof Student) {
                    System.out.println("Tuition: $" + ((Student) person).calculateTuition());
                } else if (person instanceof Staff) {
                    System.out.println("Salary: $" + ((Staff) person).calculatePay());
                }
                System.out.println();
            }

            // Test exception handling
            try {
                Undergraduate invalidPerson = new Undergraduate("Invalid", "Student", 16, 20457, 0, 7, 130000, false, Undergraduate.MajorType.MATHEMATICS, false);
            } catch (HRException e) {
                System.out.println("Caught exception: " + e.getMessage());
            }

        } catch (HRException e) {
            System.out.println("Error creating person: " + e.getMessage());
        }
    }
}