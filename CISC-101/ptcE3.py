from random import randint


def convertDict(string):
    newList = list(string.split())
    mydict = {}

    for i in range(int(len(newList)/4)):
        name = newList.pop(0)
        dataList = list()    

        for j in range(3):
            x = newList.pop(0)
            dataList.append(x)
        
        mydict[name] = dataList

    return mydict


def criteriaChecker(mydict):
    deleteList = list()

    for key in mydict.keys():

        if mydict[key][0] > mydict[key][1]:
            continue

        elif int(mydict[key][2]) >= 500:
            continue

        elif (int(mydict[key][0]) + int(mydict[key][1])*2) > int(mydict[key][2]):
            continue
        
        elif 'e' in key:
            continue
        
        else:
            deleteList.append(key)
        
    for i in deleteList:
        del mydict[i]

    return mydict


def matchStudents(residenceNames, studentNames):
    myList = list()
    for name in studentNames:

        mytuple = (name, residenceNames[randint(0, len(residenceNames) - 1)])
        myList.append(mytuple)

    return myList

def main():

    string = "Adelaide 230 15 250 Brant 100 175 445 Leonard 150 300 669 Gordon 400 200 732"
    print(criteriaChecker(convertDict(string)))

    studentNames = list()
    while True:
        
        name = input("Add Student Name: ").capitalize()
        if name == 'Stop':
            break
        
        elif name in studentNames:
            continue
        
        else:
            studentNames.append(name)
    
    listOfTuples = matchStudents(["Adelaide", "Chown", "Gordon"], studentNames)
    for tup in listOfTuples:
        student, res = tup
        print(student, ":", res)

main()




