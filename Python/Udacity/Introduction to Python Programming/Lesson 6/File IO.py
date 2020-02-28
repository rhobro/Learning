# Read Files
read_file = open("res/File Read.txt")
read_file_content = read_file.read()
read_file.close()
print(read_file_content)

# Write to files
write_file = open("res/File Write.txt", "w")
write_file.write("Qu'est-ce que to portes quand il pleut?")
write_file.close()