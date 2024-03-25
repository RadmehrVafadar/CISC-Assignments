
def unsortedListGen():
    myList = []
    for i in range(0, 50):
        myList.append(randint(-20,50))
    return myList
 
# myList = unsortedListGen()
 
def sortedListGen():
    myList = []
    for i in range(51):
        myList.append(i)
    return myList
 
myList = sortedListGen()
 
# print(myList)
 
 
 
 
# Search Algorithms
def linearSearch( haystack, needle ):
    n = len(haystack)
    print( n -1)
    if n > 0:
        for i in range(n):
            if needle == haystack[i]:
                return f"{needle} was found in index {i}."
 
            elif i == n - 1:
                return f"{needle} was not found"
    else:
        return "This list is empty"
 
# Test
    # print(linearSearch(myList, -4))
 
 
 
 
def biniarySearch( haystack, needle ):
    n = len(haystack)    
    left = 0
    right = n - 1 
    if n == 0:
        return "list is empty"
 
    while left <= right:
        mid = left + (right - left) // 2
 
        if haystack[mid] == needle:
            return f"{needle} is at index {mid}"
 
        elif haystack[mid] < needle:
            left = mid + 1
 
        else:
            right = mid - 1
 
# print(biniarySearch(myList, 4))
 
 
 
 
# Sorting Algorithms
 
def insertionSort( list ):
    n = len(list)
    for i in range(1, n):
        x = list[i]
        j = i - 1 
        while j >=0 and x < list[j]:
            list[j+1] = list[j]
            j -= 1
        list[j+1] = x
 
 
def bubbleSort( list ):
    n = len(list)
    swapped = True
    while swapped:
        swapped = False
        for i in range(1, n):
            if list[i] < list[i - 1]:
                list[i], list[i-1] = list[i-1], list[i]
                swapped = True
 
 
def selection_sort(a):
    """Sort list a in ascending order by value."""
    n = len(a)
    for i in range(n-1):
        m = i  # m will become the index of the minimum value
        for j in range(i+1, n):
            if a[j] < a[m]:
                m = j
        if m != i:  # If m has changed, a swap is needed
            a[i], a[m] = a[m], a[i]  # Swap
 
 