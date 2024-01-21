

def promptUser():
    
    while True:
        try:
            fileName = input("What is the name of your data file? ")
            with open(fileName, "r") as file:
                numbers = file.readlines()
                output = ''
                for i in numbers:
                    output += i[0] + ' '
    
            print(output)
            break

        except:
            print("Invalid file name. Try again.")


if __name__ == "__main__":
    promptUser()