import urllib.request


def readWords(link_url):
    myList = list()
    try:
        response = urllib.request.urlopen(link_url)
        data = response.read().decode('utf-8') 
        myList = data.split()
        return myList
    except:
        return myList



def wordCount(wordList):
    
    my_dic = dict()
    new_list = list()

    for word in wordList:
        new_list.append(len(word))
    
    for length in new_list:
        my_dic[length] = new_list.count(length)

    return my_dic



def totalWords(my_dic, n, m):
    if n > m:
        return 0
    else:
        count = 0
        for i in range(n, m+1):
            count += my_dic[i]
        return count



def maxWordLength(my_dic):
    new_list = []
    for key in my_dic:
        new_list.append(key)

    return max(new_list)



def maxFrequency(my_dic):
    return list(my_dic.keys())[list(my_dic.values()).index(max(list(my_dic.values())))]


def writeToFile(my_dic):
    f = open("statWords.txt", "w")
    for key, value in my_dic.items():
            x = "There are ", str(key), " words of length ", str(value), "\n"
            f.writelines(x)
    f.close()


def main():
    my_dic = wordCount(readWords("https://research.cs.queensu.ca/home/cords2/words.txt"))
    print(totalWords(my_dic, 1, 2))
    print(maxWordLength(my_dic))
    print(maxFrequency(my_dic))
    writeToFile(my_dic)

main()