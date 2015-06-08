class Vector:

    def __init__(self):
        self.myArray = [None] * 2

    def double(self):
        newList = [None] * Vector.capacity(self)
        self.myArray.extend(newList)

    def garbage_collector(self):
        print(len(self.myArray))

        for x in range(Vector.capacity(self) - 1, 2, -1):
            if self.myArray[x] == None:
                self.myArray.pop()
            else:
                break

    def insert(self, index, value):

        Vector.double(self)
        firstVector = self.myArray[:index]
        secondVector = self.myArray[index:]

        self.myArray = []

        self.myArray.extend(firstVector)
        self.myArray.append(value)
        self.myArray.extend(secondVector)

        Vector.garbage_collector(self)

    def add(self, value):
        insertAtPositon = (Vector.capacity(self) + 1)
        Vector.double(self)
        Vector.insert(self, insertAtPositon, value)
        print("Garbage:")
        Vector.garbage_collector(self)

    def get(self, index):
        return self.myArray[index]

    def capacity(self):
        return len(self.myArray)

b = Vector()
b.insert(0, "Ivan")
print(b.myArray)
b.insert(0, "Vitya1")
b.insert(2, "Vitya")
print(b.myArray)
