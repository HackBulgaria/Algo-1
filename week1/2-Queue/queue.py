class Queue:

    def __init__(self):
        self.myArray = []

    def size(self):
        return len(self.myArray)

    def push(self, value):
        self.myArray.append(value)

    def pop(self):
        first = self.myArray[0]
        self.myArray = self.myArray[1:]
        return first

    def peek(self):
        return self.myArray[0]

q = Queue()

print(q.size())
q.push(1)
q.push(2)
q.push(100)
print(q.pop())
print(q.pop())
