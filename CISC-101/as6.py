

def printScore(athleteData, athleteName, scoreNumber):
    #remove these comments and add your own when you hand in your assignment
    #you will need to write docstrings for each function.  Remember to include
    #in your docstring a description of the function and the names and types
    #of all parameters as well as indicate what the function returns.  Here is a sample docstring for this function:
    """
    This function prints data about the athlete and a requested score for a given athlete.
    Parameters: athleteData - a list of lists (sublists contain data for single athlete)
                athleteName - string (name of athlete)
                scoreNumber: integer (which score to print)
    """


    #given the list of athletes, an athlete's
    #name, and an integer indicating which score to print.
    #for instance, to print the athlete's first score, scoreNumber =1
    #print the athlete's name, their country, and the score on the event indicated by scoreNumber
     
    #if the athlete is not in the list (ie. the name is invalid)
    #print "No athlete by that name".
    #Note that you will need a loop to find out if the athlete exists in the list
    #using if athleteName not in athleteData does not work.

    #If the athlete's name is valid do this part:
    #Check that scoreNumber is valid for the given athlete.  You will need
    #to check how many scores this athlete has and ensure that the score number
    #is valid.  For instance, if scoreNumber = 5 and the data looks like this:
    #["name", "country", 8.3, 7.2]
    #then the score number is not valid.  In this case print:
    #"Score number out of range".
    
    #There will be no explicit return value for this function.
   
    pass #remove this once you have written code

    
def totalScore(data):
    total = 0
    for i in data[2:6]:
        total += i
        
    return total


    
def highestAverageScore(athleteData):
    #this is the hardest function -- leave it for the end.
    #given the list of athlete data, return the name(s) of the athlete(s) with the
    #highest total average score (ie. the gold winner(s)!).
    
    #You will need to calculate the average score
    #for each athlete.
    #You already have a function that will calculate the total for
    #a given athlete.  You must make use of it here.  (I realize that there
    #are other ways, but the requirement here is to make use of the totalScore() function.
    
    #If there is more than one athlete with the same average, return all their names in a list.
    #If the initial athlete list is empty, you would return an empty list.
    
    #You should not change the original athlete list in any way!

    pass #remove this once you have written code.



def increaseScores(athleteData, countries):
    #given the list of athletes and a list of countries, increase all the (individual)
    #scores for all athletes from the given countries by .3 of a mark -- but only
    #if the new mark will be 10.0 or less.  (Otherwise, leave it unchanged)
    #This function does not return anything.
    #Don't worry about the extra decimal places that you may see when doing the addition.
    
    pass #remove this once you have written code.



def addNewAthlete(athleteData):
    #write a function to add a new athlete and their scores to the list of athletes.
    #this function will prompt the user for the name of the athlete and add
    #as many scores as the user wishes.  Ask them first how many scores they are going 
    #to enter (N) then prompt them for each of N scores.  
    #You can assume that they will enter a name that is unique.

    #You must check to see that each score is between 0 and 10 (inclusive).  If not,
    #repeatedly prompt for another number.  You may assume that they enter numbers only.
    #You may also assume that names and countries are entered correctly -- no need to check
    #for invalid inputs.

    #The new athlete data should be added to the end of the athleteData list.

    #this function will have no explicit return statement.
    
    pass #remove this once you have written code.



def main():
    #Make your program user friendly by adding print statements telling the user what is happening.
    #The athlete structure is a list of lists, each representing an athlete and their 
    #scores on several events.  You must NOT assume that there are ONLY 2 athletes -- there
    #may be 0 or 100000 athletes & your program should still work!
    #You may not assume a consistent number of scores per athlete.  Some may have 1 score,
    #some may have 10 scores.
    #You may  assume that no two athletes have the same name.
    

    #we will start with two athletes in our list.
    athletes = [["Madeline Schizas", "CAN", 8.2, 9.3, 8.8, 9.0],
                ["Yi Zhu", "CHN", 9.0, 8.8, 9.3],
                ["Jin Boyang", "CHN", 9.1, 9,8, 9.5]]
    
    print("Here is the data set", athletes)

    print("This program doesn't do anything yet.  Complete the program as per the comments ")

    #note for the next two calls, no input is required from the user
    #call printScore() with name = "Madeline Schizas" and score number = 2
    #call printScore() with name = "Yi Zhu" and score number = 1
    #call printScore() with your own name and score number = 2


    #allow the user to add a new athlete.
    print(athletes)
    

    #show the total score for Yi Zhu

    #increase all the scores for all athletes from China (CHN) and Canada (CAN)
    print(athletes)

    #find (and display) the names of the highest average scoring athletes

   
    
    
main()   