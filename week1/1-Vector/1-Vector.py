class Vector:
	def __init__(self, capacity):
		self.elements = [None] * capacity
		self.capacity = capacity
		self.size = 0


	def capacity(self):
		return self.capacity


	def size(self):
		return self.size


	def insert(self, index, value):
		#Adds value at a specific index in the Vector.
		if (index == self.size):
			self.add(value)
		else:
			
			if (self.size == self.capacity):
				self.expand()
			r = range(self.size - 1, index - 1, -1)
			for i in r:
				self.elements[i + 1] = self.elements[i]
			self.elements[index] = value
			self.size += 1


	def expand(self):
		i = 0
		elements = [None] * (self.capacity * 2)
		for element in self.elements:
			elements[i] = element
			i += 1
		self.elements = elements
		self.capacity = self.capacity * 2


	def add(self, value):
		#Adds value at the end of the vector.
		if (self.elements[self.capacity - 1]):
			self.expand()
		self.elements[self.size] = value
		self.size += 1


	def get(self, index):
		#Returns value at a specific index in the Vector
		if (index < self.size):
			return self.elements[index]
		else:
			raise IndexError("Index out of range")

