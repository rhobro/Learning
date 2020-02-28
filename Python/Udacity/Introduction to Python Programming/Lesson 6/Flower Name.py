flower_name = dict()
with open("res/flower_list.txt") as flower_list:
    for line in flower_list:
        letter = line.split(":")[0].upper()
        flower = line.split(":")[1]
        flower_name[letter] = flower


def get_flower(fullname: str):
    return flower_name.get(fullname.strip()[0].upper())


full_name = input("Enter your first name [space] last name only: ").title()
print("Unique flower name with the first letter: " + get_flower(full_name))