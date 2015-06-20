class Vector:

    def __init__(self):
        self.__size = 0
        self.__capacity = 10
        self.elements = self.__capacity * [None]


    def insert(self, index, value):
        """
        Adds value at a specific index in the Vector.
        Complexity: O(n)
        """
        if self.__size == self.__capacity:
            self.expand()

        if index > self.__size:
            index = self.__size

        self.elements[index:index] = [value]
        self.__size += 1


    def add(self, value):
        """
        Adds value to the end of the Vector.
        Complexity: O(1)
        """
        if self.__size == self.__capacity:
            self.expand()

        self.elements[self.__size] = value
        self.__size += 1


    def expand(self):
        """
        Increases the __capacity of elements
        """
        self.elements.extend(self.__capacity * [None])
        self.__capacity *= 2


    def get(self, index):
        """
        Returns value at a specific index in the Vector
        Complexity: O(1)
        """
        return self.elements[index]


    def remove(self, index):
        """
        Removes element at the specific index
        Complexity: O(n)
        """
        if self.__size:
            del self.elements[index]
            self.__size -= 1


    def pop(self):
        """
        Removes element at the last index
        Complexity: O(1)
        """
        if self.__size:
            del self.elements[self.__size - 1]
            self.__size -= 1


    def size(self):
        """
        Returns the number of elements in the Vector.
        Complexity: O(1)
        """
        return self.__size


    def capacity(self):
        """
        Returns the total __capacity of the Vector.
        Complexity: O(1)
        """
        return self.__capacity


    def print(self):
        """
        Prints elements
        """
        print(self.elements[:self.__size])

