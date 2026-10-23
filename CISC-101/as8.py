from random import randint


def  generateBachCard():
    batchCard = list()
    mydict = {100: 125, 126: 150, 151: 175, 176: 200}
    

    for key, value in mydict.items():
        i = 0
        myList = []

        while i < 4:
            randomNum = randint(key, value)

            if randomNum in myList:
                 continue
    
            else:  
                myList.append(randomNum)

                i += 1

        batchCard.append(myList)
        
    return batchCard



def printBatch(myList):
    print(" B\t A\t C\t H\t")
    for i in range(4):
        for j in range(4):
            print(myList[j][i], "\t", end="")
        print()
        


def bachChecker(myList):
    mydict = {100: 125, 126: 150, 151: 175, 176: 200}
    i = 0 
    for key, value in mydict.items():
        
        for j in range(4):
            x = myList[list(mydict.keys()).index(key)][j]
            if x >= key and x <= value:
                i += 1

            else:
                return False
    if i == 16:
        return True

                
def calledNumbers():
    myList = list()
    i = 0
    while i < 40:
        x = randint(100, 200)
        if x in myList:
            continue
        else:
            myList.append(x)
            i += 1

    return myList



def columnBoy(myList, N):
    c = 0
    for i in myList[N]:
        
        if (i % 6) == 0:
            myList[N][c] = i - 2

        else:
            myList[N][c] = i + 1
        c += 1
    

    return myList


def foundInCalled(myList, calledNums):
    count = 0
    for i in myList:
        for j in i:
            if j in calledNums:
                count += 1
    return count



def main():
    x = generateBachCard()
    print(x)

    print(bachChecker(x))


    y = columnBoy(x, randint(0, 3))
    print(y)


    z = bachChecker(y)
    print(z)

    if z == False:
        x = generateBachCard()
    
    print(foundInCalled(x, calledNumbers()))
    


main()
    