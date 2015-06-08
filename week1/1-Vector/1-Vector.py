class Vector:
	def __init__(self, capacity):
		self.elements = [None] * capacity
		self.capacity = capacity


	def capacity(self):
		return self.capacity


	def size(self):
		i = 0
		while (i < self.capacity and self.elements[i]):
			i += 1
		return i


	def insert(self, index, value):
		#Adds value at a specific index in the Vector.
		if (index == self.size()):
			self.add(value)
		else:
			if (self.size() == self.capacity):
				self.expand()
			r = range(self.size() - 1, index - 1, -1)
			for i in r:
				self.elements[i + 1] = self.elements[i]
			self.elements[index] = value


	def expand(self):
		new_vector = Vector(self.capacity * 2)
		i = 0
		for element in self.elements:
			new_vector.elements[i] = element
			i += 1
		self.elements = new_vector.elements
		self.capacity = new_vector.capacity


	def add(self, value):
		#Adds value at the end of the vector.
		if (self.elements[self.capacity - 1]):
			self.expand()
		self.elements[self.size()] = value


	def get(self, index):
		#Returns value at a specific index in the Vector
		if (index < self.capacity and self.elements[index]):
			return self.elements[index]
		else:
			raise IndexError("Index out of range")


v = Vector(3)
v.add(1)
v.add(2)
v.add(3)
v.add(4)
v.insert(0, 5)
v.insert(0, 16)
v.insert(1, 23)

print (v.size())
print (v.capacity)
print (v.get(6))
print (v.elements)



