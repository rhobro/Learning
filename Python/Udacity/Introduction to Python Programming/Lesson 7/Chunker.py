def chunker(iterable_object, size):
    for i in range(0, len(iterable_object), size):
        yield iterable_object[i:i + size]


for chunk in chunker(range(25), 4):
    print(list(chunk))
