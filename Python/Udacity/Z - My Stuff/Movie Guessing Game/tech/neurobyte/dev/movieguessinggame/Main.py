import sys
import os
import platform
import random

# Software essentials
movieList = list()
movie = str()
underscored_movie = str()
guesses = list()


def setup_movie(difficulty="E"):
    if difficulty is "E":
        with open("res/movieLists/easy-movies.txt", "r") as easyList:
            movieList = easyList.readlines()
    elif difficulty is "H":
        with open("res/movieLists/hard-movies.txt", "r") as hardList:
            movieList = hardList.readlines()

    for movie_d in movieList:
        movie_d = movie.strip()
    movie = str(random.choice(movieList))
    underscored_movie = movie
    for char in underscored_movie:
        if char is not " ":
            char = "_"


def check(guess: str):
    guesses.append(guess)
    guesses.sort()
    if len(guess) is 1 and guess in movie:
        underscored_movie = movie
        for char in underscored_movie:
            if char is not " " and char not in guesses:
                char = "_"
        return True
    else:
        return False


# Setting up clear command based on OS
if platform.system() == "Windows":
    clearScreen = lambda: os.system("cls")
else:
    clearScreen = lambda: os.system("clear")

# Setting up ascii art
startingGame = ""
settings = ""
bye = ""
with open("res/asciiArt/startingGame.txt") as startingGameASCII:
    startingGame = startingGameASCII.read()

with open("res/asciiArt/settings.txt") as settingsASCII:
    settings = settingsASCII.read()

with open("res/asciiArt/bye.txt") as byeASCII:
    bye = byeASCII.read()

while True:
    clearScreen()
    print("""
     _______________________________________
    |                                       |
    |     M O V I E  G U E S S  G A M E     |
    |_______________________________________|
    |                                       |
    |              GAME  MENU               |
    |                                       |
    |        1 - START GAME                 |
    |                                       |
    |        2 - CHANGE SETTINGS            |
    |                                       |
    |        3 - QUIT GAME :(               |
    |                                       |
    |_______________________________________|
    """)

    option = input("Choose an option (1/2/3): ")
    while option is not "1" or option is not "2" or option is not "3":
        if option == "1" or option == "2" or option == "3":
            break
        option = input("Your option was invalid.\nPlease enter a valid option (1/2/3): ")

    if option == "1":
        clearScreen()
        print(startingGame)
        difficulty = input("Choose your difficulty - Easy or Hard (E/H): ").upper()
        while difficulty != "E" or "H":
            if difficulty is "E" or "H":
                break
            difficulty = input("Please enter a valid option (E/H): ")
        clearScreen()
        setup_movie(difficulty)
        while len(guesses) < 10:
            if underscored_movie is movie:
                print("You got it!")
                sys.exit(0)
            print(underscored_movie + "\n")
            print(guesses)
            print("Number of Guesses Left: " + str(10 - len(guesses)))
            guess = input("Guess a letter: ").upper()
            if check(guess):
                print("\nWell Done!")
                clearScreen()
            else:
                print("Uhhhhhh. It's wrong.")
                clearScreen()

        print("Oh no! The movie was \"" + movie + "\"")

    elif option == "2":
        clearScreen()
        print(settings)

    else:
        break

clearScreen()
print(bye)
