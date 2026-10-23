import string


def readFile():
    try:
        with open("cisc101WordCloudFile.txt") as strings:
            file = strings.read().strip().split()
        return file
    except:
        print("file was not found or opened properly")



def isValid(word):
    wordList = list(word)
    if wordList[0].isdigit() or wordList[-1].isdigit() or len(word) < 4 or any(char in string.punctuation for char in word):
        return False
    else:
        return True
    


def cleanseWords(listOfWords):
    for i in range(len(listOfWords)-1,-1, -1):

        if not isValid(listOfWords[i]):
            listOfWords.remove(listOfWords[i])
    return listOfWords
    

def countFrequencies(listOfWords):
    my_dic = dict()
    
    for word in listOfWords:
        my_dic[word] = listOfWords.count(word)

    return my_dic
    


def writeFile(dictionaryOfFrequencies):
        with open('outputForWordCloud101.txt', 'w') as file:

            for key, value in dictionaryOfFrequencies.items():
                file.write(f"{key} {value}\n")


def main():
    writeFile(countFrequencies(cleanseWords(readFile())))

main()