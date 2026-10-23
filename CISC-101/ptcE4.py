import random


def pointCount(cardList):
    count = 0

    tenPoints = ["K", "Q", "J", "A", "1"]
    fourPoints = ["2", "3", "4", "5", "6", "7", "8", "9"]
    
    for card in cardList:
        firstChar = card[0]

        if firstChar in tenPoints:
            count += 10

        elif firstChar in fourPoints:
            count += int(firstChar)

    return count
    


def randomCards(allCards):
    dealtCards = list()
    for i in range(5):
        randomNum = random.randint(0, len(allCards) - 1)
        card = allCards.pop(randomNum)
        dealtCards.append(card)
    return dealtCards


def checkFullHouse(dealtCards):
    myDict = dict()

    for i in range(len(dealtCards) - 1):
        if dealtCards[i][0] in myDict:
            myDict[dealtCards[i][0]] = myDict[dealtCards[i][0]] + 1

        else:
            myDict[dealtCards[i][0]] = 1
    

    if len(myDict) == 2:
        return True
    
    else:
        return False


def gameMaster(cards):

    
    playersCards = randomCards(cards)
    

    i = 0
    while i < 3:
        print(playersCards)
        cardToChange = input("Card would you like to change: ").upper()
        if cardToChange in playersCards:
            indexNumber = playersCards.index(cardToChange)

            randomCard = random.randint(0, len(cards) - 1)

            returningCard = playersCards.pop(indexNumber)
            cards.append(returningCard)

            playersCards.insert(indexNumber, cards[randomCard])
            i += 1
        else:
            print("Card not in hand, try again")
    
    print(playersCards)
    if checkFullHouse(playersCards) or (pointCount(playersCards) > 43):
        print("You have WON!")
    else:
        print("You have LOST!")


def main():
    while True:
        cards = ["AH", "AD", "AS", "AC", "KH", "KD", "KS", "KC", 
            "QH", "QD", "QS", "QC", "JH", "JD", "JS", "JC", 
            "10H", "10D", "10S", "10C", "9H", "9D", "9S", "9C", 
            "8H", "8D", "8S", "8C", "7H", "7D", "7S", "7C", 
            "6H", "6D", "6S", "6C", "5H", "5D", "5S", "5C", 
            "4H", "4D", "4S", "4C", "3H", "3D", "3S", "3C", 
            "2H", "2D", "2S", "2C"]
        
        gameMaster(cards)
        if input("Play again? ('no' to stop)    ").lower() == "no":
            break

main()