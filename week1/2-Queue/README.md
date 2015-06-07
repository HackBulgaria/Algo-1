# Queue

You have the `List` data structure at your disposal.
Using only it implement the `Queue` data structure in Java, Python or C++.

The type of the data in the `Queue` is of your choice.
It should be either primitive (ints, strings or floats) or generic.
The `Queue` should not be limited in capacity.
It should expand if there is not enough space to accomodate insertions.
The required interface is:

```
Queue {

  // Adds value to the end of the Queue.
  // Complexity: O(1)
  push(value)

  // Returns value from the front of the Queue and removes it.
  // Complexity: O(1)
  pop()

  // Returns value from the front of the Queue without removing it.
  // Complexity: O(1)
  peek()

  // Returns the number of elements in the Queue.
  // Complexity: O(1)
  size()
}
```
