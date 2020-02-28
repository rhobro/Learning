lessons = ["Why Python Programming", "Data Types and Operators", "Control Flow", "Functions", "Scripting"]


# def my_enumerate(iterable_object, start=0):
#     return zip(range(start, (start + len(iterable_object))), iterable_object)

def my_enumerate(iterable_object, start = 0):
    for i in range(start, (start + len(iterable_object))):
        yield i, iterable_object[i - start]


for i, lesson in my_enumerate(lessons, 1):
    print("Lesson {}: {}".format(i, lesson))
