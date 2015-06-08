class Stack:

    def __init__(self):
        self.myArray = []

    def size(self):
        return len(self.myArray)

    def push(self, value):
        self.myArray.append(value)

    def pop(self):
        last = self.myArray[Stack.size(self)-1]
        self.myArray = self.myArray[:-1]
        return last

    def peek(self):
        return self.myArray[0]

q = Stack()

q.push(1)
q.push(2)
q.push(100)
print(q.pop())
print(q.pop())
