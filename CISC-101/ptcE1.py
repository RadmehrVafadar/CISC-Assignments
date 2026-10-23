

guestdict = {"Raisa": ["pizza", "cookies", 3], "Susan": ["salad", 2], "Jia": ["ice cream", 0], "Val": ["cake", 2], "Brian": ["pasta", "cheese", "crackers", 2], "Chandra": ["burgers", "buns", 3]}
powleyGuests = ["Isla", "Susan", "Ellen", "Jia", "Raisa", "Chandra", "Wendy"]

def guestAndFood(guestdict):
    for name in guestdict:
        foodsList = guestdict[name][0:-1]

        print(name, "is bringing", ' and '.join(foodsList) + ".")



def numberOfGuests(guestdict):
    count = 0
    for word in guestdict:
        count += guestdict[word][-1] + 1
    return count



def forgotenGuests(guestdict, powelyGuests):
    thoseNotinList = list()
    for word in powelyGuests:
        if word in guestdict:
            continue
        else:
            thoseNotinList.append(word)
    return thoseNotinList


def addingForgotenGuests(thoseNotinList, guestdict):
    for word in thoseNotinList:
        guestdict[word] = ["tbd", 0]
    return guestdict


def checkItems(guestdict):
    for name in guestdict:
        if guestdict[name][-1] > 0 and (len(guestdict[name][0]) > 3 or list(guestdict[name][0]) == "p"):
            return True
        
        elif guestdict[name][-1] == 0 and any(char == "p" or char == "s" for char in guestdict[name][0:-1]):
            return True
        
        else:
            return False
    

def addNames(powelyGuests):
    numberGuests = int(input("How many names would you like to enter: "))
    i = 0
    while i < numberGuests:
        name = input("Name you would like to enter: ").capitalize()
        if name not in powelyGuests:
            powelyGuests.append(name)
            i += 1
    return powelyGuests



def main():
    guestAndFood(guestdict)
    numberOfGuests(guestdict)
    forgoten = forgotenGuests(guestdict, powleyGuests)
    print(forgoten)

    print(checkItems(addingForgotenGuests(forgoten, guestdict)))

    addNames(powleyGuests)

main()






    
