import random



def dessertIngredients(desserts, nameList):
    onlyIngredients = list()
    for name in nameList:
        onlyIngredients.extend(desserts[name])
        x = ', '.join(onlyIngredients)

    return x


def ingredientChecker(ingredientList, N):
    newList = list()
    vowels = "aeiou"
    

    for ing in ingredientList:

        has_r = any("r" in char for char in ing)
        has_two_consecutive_vowels = any(ing[i] in vowels and ing[i + 1] in vowels for i in range(len(ing)-1))
        atleast_Nth_long = len(ing) >= N
        
        

        if  has_r and has_two_consecutive_vowels and atleast_Nth_long:
            newList.append(ing)
        
        return newList



def updateDessertList(desserts):
    for key in desserts:
        for i in desserts[key]:

            if len(i) == 4:
                desserts[key][desserts[key].index(i)] = i[1:3]
            
            elif 'r' in i[-1]:
                desserts[key][desserts[key].index(i)] = i + 'y'

            elif i == "cocoa":
                desserts[key][desserts[key].index(i)] = "chocolate"

    return desserts


def randomListofDesserts(desserts):
    
    myList = list(desserts.keys())
    chosenList = list()
    for i in range(2):
        choose = random.randint(0, len(myList) - 1)
        x = myList.pop(choose)
        chosenList.append(x)
    return chosenList



def main():

    desserts = {'cookies': ["flour", "sugar", "butter", "chocolate chips", "salt"], 
 'brownies': ["flour", "eggs", "salt", "cocoa", "butter"], 
  'mousse': ["eggs", "cream", "sugar", "caramel"],
  'ice cream': ["heavy cream", "sugar", "salt", "butter"]
}


    x = randomListofDesserts(desserts)
    print(x)
    print(dessertIngredients(desserts, x))
    

    print(ingredientChecker(desserts["brownies"], 3))

    print(desserts)
    print(updateDessertList(desserts))

    
main()