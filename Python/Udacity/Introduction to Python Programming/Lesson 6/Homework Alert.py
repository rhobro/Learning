names = input("Please enter the list of students (Separate with commas): ")
assignments = input("Please enter the list of their assignments (Separate with commas): ")
grades = input("Please enter the students' grades (Separate with commas): ")

# message string to be used for each student
# HINT: use .format() with this string in your for loop
message = "Hi {},\n\nThis is a reminder that you have {} assignments left to \
submit before you can graduate. You're current grade is {} and can increase \
to {} if you submit all assignments before the due date.\n\n"

# write a for loop that iterates through each set of names, assignments, and grades to print each student's message
for name, assignment, grade in zip(names.split(","), assignments.split(","), grades.split(",")):
    print(message.format(name.title().strip(), assignment.title().strip(), grade.upper().strip(), int(grade) + int(assignment)*2))
