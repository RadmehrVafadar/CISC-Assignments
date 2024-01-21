

def prime_sieve(max_num):
    """Return a list of prime numbers less than or equal to max_num.
    From https://www.geeksforgeeks.org/python-program-for-sieve-of-eratosthenes/
    """
    prime_indices = []  # This will become a list of Booleans.
    # Assume all of its indices are prime.
    for i in range(max_num + 1):
        prime_indices.append(True)
    p = 2
    while (p * p <= max_num): 
        if (prime_indices[p]): 
            # Updating all multiples of p
            for i in range(p * p, max_num + 1, p):
                prime_indices[i] = False
        p += 1
    primes = []  # This will become the list of primes.
    for i in range(2, len(prime_indices)):
        if prime_indices[i]:
            primes.append(i)
    return primes


def promptUser():
    integer = None
    while True:
        try:
            integer = int(input("Generate primes up to what integer? "))
            break

        except:
            print("Invalid value. Try again.")
        

    return integer

def fileNameUser():
    while True:
        try:
            fileName = input("What would you like to call your file of primes? ")
            primes = prime_sieve(promptUser())

            with open(fileName, 'w') as file:    
                            for prime in primes:
                                file.write(str(prime) + '\n')
            break
            
        except:
            print("Invalid file name. Try again.")

        

if __name__ == "__main__":
     fileNameUser()