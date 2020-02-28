filesLoop = []
for i in range(10000):
    filesLoop.append(open("res/Concurrent Files Test.txt", "r"))
    print(i)