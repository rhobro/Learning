def create_cast_list(filename):
    cast_list = []
    with open(filename) as cast_list_file:
        for line in cast_list_file:
            cast_list.append(line.split(",")[0])

    return cast_list

cast_list = create_cast_list("res/Monty Python's Flying Circus Cast.txt")
for actor in cast_list:
    print(actor)