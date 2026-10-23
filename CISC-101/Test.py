

s = ['IILVLA', 'jesus', 'never']



s[0][0]
newList = []
prefixList = []


for m in range(4):
    for i in s:
        if i[m] in newList:
            prefixList.append(i[0])
        else:
            newList.append(i[0])


print(prefixList)