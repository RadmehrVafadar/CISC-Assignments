
def read_grades(name):
    myDict = dict()    

    try:
        with open(f'20421691_a1/{name}.txt') as file:
            for student in file.readlines():
                studentList = student.split()
                
                studentNum = studentList.pop(0)
                myDict[studentNum] = studentList
        return myDict
    
    except:
        print("Invalid File Name")
                              

def show_all_grades(myDict):
    for key in myDict:
        print(key, " ".join(myDict[key]))


def add_student(myDict):
    gradeList = list()

    while True:
        studentID = input("New Student ID: ")
        if studentID not in myDict and len(studentID) == 7:
            break
        else:
            print("INVALID Student ID")
    
    for i in range(3):
        while True:
            grade = int(input(f"Enter Quiz-{i + 1} Grade: "))
            if grade >= 0 and grade <= 30:
                gradeList.append(grade)
                break
            else:
                print("INVALID Grade")

    while True:
        grade = int(input("Enter Exam Grade: "))
        if grade >= 0 and grade <= 55:
            gradeList.append(grade)
            break
        else:
            print("INVALID Grade")

    myDict[studentID] = gradeList.copy()

    return myDict


def calculate_final_grade(gradeList):
    gradeExam = gradeList.pop(-1)
    finalGrade = float()
    for i in gradeList:
        finalGrade += int(i)/2

    finalGrade += int(gradeExam)
    return finalGrade


def get_high_achivers(myDict):
    high_achiversList = list()

    for key in myDict:
        if calculate_final_grade(myDict[key]) > 80:
            high_achiversList.append(key)
    return high_achiversList


def grades_modification(gradeList):
    for i in range(3):
        if gradeList[i] != 0 and gradeList[i] != 30:
            gradeList[i] += 1

    if gradeList[3] != 0:
        gradeList[3] += 3
        
        overValue = 55 - gradeList[3]

        if overValue < 0:
            gradeList[3] += overValue
        


def convert_number_grade_to_letter(finalGrade):

    if finalGrade <= 49:
        return 'F'
    
    elif finalGrade <= 52:
        return 'D-'
    
    elif finalGrade <= 56:
        return 'D'
    
    elif finalGrade <= 59:
        return 'D+'
    
    elif finalGrade <= 62:
        return 'C-'
    
    elif finalGrade <= 66:
        return 'C'
    
    elif finalGrade <= 69:
        return 'C+'
    
    elif finalGrade <= 72:
        return 'B-'
    
    elif finalGrade <= 76:
        return 'B'
    
    elif finalGrade <= 79:
        return 'B+'
    
    elif finalGrade <= 84:
        return 'A-'
    
    elif finalGrade <= 89:
        return 'A'
    
    elif finalGrade <= 100:
        return 'A+'


def write_letter_grades_file(fileName, gradesDict):
    for key in gradesDict:
        gradesDict[key] = calculate_final_grade(gradesDict[key])

    with open(f'20421691_a1/{fileName}.txt', 'w') as file:
            for key, value in gradesDict.items():
                file.write(f"{key} {convert_number_grade_to_letter(value)} \n")



def write_grades(fileName, gradesDict):
    try:
        with open(f'20421691_a1/{fileName}.txt', 'w')as file:
            for key in gradesDict:
                file.writelines(f"{key} {' '.join(map(str, gradesDict[key]))}\n")

    except:
        print("Something Went Wrong, Please Try Again..")


def main():
    
    #File names for reading/writing
    grades_file_name = "grades"
    final_grades_file_name = "final_grades"

    #Read the initial grades file
    grades = read_grades(grades_file_name)

    #Menu items to display
    menu = [
        "Show all grades",
        "Add a new student",
        "Modify a student's grades",
        "Make and display high-achievers list",
        "Create final letter grades file",
        "Save grades data to file",
        "Quit"
    ]

    while True:
        #Display the menu items
        print("Main menu\n")
        for i in range(len(menu)):
            print(f"{i + 1}. {menu[i]}")

        #Get the user's choice
        choice = int(input("\nYour choice: "))
        print(f"\n{menu[choice - 1]}\n")

        #Display all data
        if choice == 1:
            print("All grades:")
            show_all_grades(grades)

        #Add a new Student
        elif choice == 2:
            add_student(grades)

        #Modify grades for a student 
        elif choice == 3:
            student_id = int(input("Modify grades for which student ID? "))
            if student_id in grades:
                print("Student marks ", grades[student_id])
                grades_modification(grades[student_id])
                print("Student marks after ", grades[student_id])

                print("Grades modified.")
            else:
                print("That student ID doesn't exist.")

        #Make a list of high achievers        
        elif choice == 4:
            print("High Achievers:")
            high_achievers = get_high_achivers(grades)
            for student_id in high_achievers:
                print(student_id)

        #Write student ID/letter grades to a file
        elif choice == 5:
            write_letter_grades_file(final_grades_file_name, grades)
            print("Done.")

        #Save all grades to a file 
        elif choice == 6:
            write_grades(grades_file_name, grades)
            print("Grades saved.")

        #Quit
        elif choice == 7:
            print("Bye!")
            return
        
        else:
            print("Invalid choice. Try again.")
        print()
    

main()