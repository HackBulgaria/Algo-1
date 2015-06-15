class Vector:

    def __init__(self):
        self.myArray = [None] * 2

    def double(self):
<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 7b123ca15b4397fc90d1d0fa90f8326bbce25e0b
        newList = [None] * int(Vector.capacity(self)*0.5)
        self.myArray.extend(newList)

    def garbage_collector(self):
<<<<<<< HEAD
=======
=======
=======
        newList = [None] * int(Vector.capacity(self) * 0.5)
        self.myArray.extend(newList)

    def garbage_collector(self):
>>>>>>> 1b438e3218a0f4fb5b293cd4023f706cffa5120a
        newList = [None] * Vector.capacity(self)
        self.myArray.extend(newList)

    def garbage_collector(self):
        print(len(self.myArray))
<<<<<<< HEAD
>>>>>>> 9de26a37b4243d1a0a9bf3a7f8fe77ceb1be9141
>>>>>>> 7b123ca15b4397fc90d1d0fa90f8326bbce25e0b
=======
>>>>>>> 1b438e3218a0f4fb5b293cd4023f706cffa5120a

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
<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 7b123ca15b4397fc90d1d0fa90f8326bbce25e0b
=======
>>>>>>> 1b438e3218a0f4fb5b293cd4023f706cffa5120a
        Vector.garbage_collector(self)

    def add(self, value):
        insertAtPositon = (Vector.capacity(self))
        Vector.double(self)
        Vector.insert(self, insertAtPositon, value)
        Vector.garbage_collector(self)

    def pop(self):
        Vector.remove(self, Vector.capacity(self) - 1)

    def remove(self, index):
        firstVector = self.myArray[:index]
        secondVector = self.myArray[index + 1:]
        self.myArray = []
        self.myArray.extend(firstVector)
        self.myArray.extend(secondVector)

<<<<<<< HEAD
<<<<<<< HEAD
=======
=======

=======
>>>>>>> 1b438e3218a0f4fb5b293cd4023f706cffa5120a
        Vector.garbage_collector(self)

    def add(self, value):
        insertAtPositon = (Vector.capacity(self) + 1)
        Vector.double(self)
        Vector.insert(self, insertAtPositon, value)
        print("Garbage:")
        Vector.garbage_collector(self)

<<<<<<< HEAD
>>>>>>> 9de26a37b4243d1a0a9bf3a7f8fe77ceb1be9141
>>>>>>> 7b123ca15b4397fc90d1d0fa90f8326bbce25e0b
=======
>>>>>>> 1b438e3218a0f4fb5b293cd4023f706cffa5120a
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
<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 7b123ca15b4397fc90d1d0fa90f8326bbce25e0b
=======
>>>>>>> 1b438e3218a0f4fb5b293cd4023f706cffa5120a
b.add("Vitya3")
b.add("Vitya5")
print(b.myArray)
b.remove(0)
print(b.myArray)
b.pop()
b.pop()
print(b.myArray)
b.remove(0)
<<<<<<< HEAD
print(b.myArray)
=======
print(b.myArray)
<<<<<<< HEAD
=======
>>>>>>> 9de26a37b4243d1a0a9bf3a7f8fe77ceb1be9141
>>>>>>> 7b123ca15b4397fc90d1d0fa90f8326bbce25e0b
=======
>>>>>>> 1b438e3218a0f4fb5b293cd4023f706cffa5120a
