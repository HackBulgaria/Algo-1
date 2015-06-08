# Vector

Implement the `Vector` data structure in Java, Python or C++.

The type of the data in the `Vector` is of your choice.
It should be either primitive (ints, strings or floats) or generic.
The `Vector` should not be limited in capacity.
It should expand if there is not enough space to accomodate insertions.
The required interface is:

```
Vector {

  // Adds value at a specific index in the Vector.
  // Complexity: O(n)
  insert(index, value)

  // Adds value to the end of the Vector.
  // Complexity: O(1)
  add(value)

  // Returns value at a specific index in the Vector
  // Complexity: O(1)
  get(index)

  // Removes element at the specific index
  // Complexity: O(n)
  remove(index)

  // Removes element at the last index
  // Complexity: O(1)
  pop()

  // Returns the number of elements in the Vector.
  // Complexity: O(1)
  size()

  // Returns the total capacity of the Vector.
  // Complexity: O(1)
  capacity()
}
```
