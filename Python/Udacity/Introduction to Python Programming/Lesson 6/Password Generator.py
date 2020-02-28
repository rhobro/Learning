import random as rand

word_list = []

# fill up the word_list
with open("res/words.txt", 'r') as words:
    for line in words:
        # remove white space and make everything lowercase
        word = line.strip().lower()
        # don't include words that are too long or too short
        if 3 < len(word) < 8:
            word_list.append(word)


# Add your function generate_password here
# It should return a string consisting of three random words
# concatenated together without spaces
def generate_password(rand_words_num):
    password = ""
    try:
        for i in range(rand_words_num):
            password += word_list[rand.randint(0, len(word_list))]
    except:
        print("Invalid input value for the number of random words to use.")
    finally:
        return password


# test your function
print(generate_password(3))
