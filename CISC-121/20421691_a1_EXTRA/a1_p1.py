import random

# Creates Random Number from 0-100
def randomNum():
    return random.randint(0,100)



# Ensure the two numbers generated are not the same
def generateDistinctRandomNumbers():
    num1 = randomNum()

    while True:
        num2 = randomNum()

        if num1 != num2:
            break

    sortedList = sorted([num1, num2], reverse=True)
    return sortedList


# Prints the two random numbers with message
def printValues(sortedList):
    print("Two randomly generated integer values are:", sortedList[0], sortedList[1])


# Find out if the diffirence of the two numbers is b/t 10-50 and fixes them
def diffirenceCorrector(sortedList):

    while True:

        printValues(sortedList)

        diff = sortedList[0] - sortedList[1]

        if diff >= 10 and diff <= 50:
            print("This pair of integers is valid")
            break
        else:
            print("This pair of integers is invalid. Trying again…")

            if diff < 10:
                sortedList[0] *= 2
            
            elif diff > 50:
                sortedList[0] //= 3
            
    return sortedList


# prints the numbers relative to requirements
def printingNums(sortedList):

    for num in sortedList:
        followed = str()

        if num%5 == 0:
            followed += " apple"

        if num%7 == 0:
            followed += " pen"
        
        if '3' in str(num):
            followed += " pineapple"
    
        print(num, followed)


if __name__ == "__main__":
    printingNums(diffirenceCorrector(generateDistinctRandomNumbers()))

    






















