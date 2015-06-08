class Vector:

    def __init__(self):
        self.myArray = [None] * 2

    def double(self):
        newList = [None] * int(Vector.capacity(self)*0.5)
        self.myArray.extend(newList)

    def garbage_collector(self):

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
        insertAtPositon = (Vector.capacity(self))
        Vector.double(self)
        Vector.insert(self, insertAtPositon, value)
        Vector.garbage_collector(self)

    def pop(self):
        Vector.remove(self, Vector.capacity(self)-1)

    def remove(self, index):
        firstVector = self.myArray[:index]
        secondVector = self.myArray[index + 1:]
        self.myArray = []
        self.myArray.extend(firstVector)
        self.myArray.extend(secondVector)

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
b.add("Vitya3")
b.add("Vitya5")
print(b.myArray)
b.remove(0)
print(b.myArray)
b.pop()
b.pop()
print(b.myArray)
b.remove(0)
print(b.myArray)