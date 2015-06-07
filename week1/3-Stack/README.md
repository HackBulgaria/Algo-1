# Stack

You have the `Queue` data structure from the previous task at your disposal.
Using only it implement the `Stack` data structure in Java, Python or C++.

The type of the data in the `Stack` is of your choice.
It should be either primitive (ints, strings or floats) or generic.
The `Stack` should not be limited in capacity.
It should expand if there is not enough space to accomodate insertions.
The required interface is:

```
Stack {

  // Adds value to the end of the Stack.
  // Complexity: O(1)
  push(value)

  // Returns value from the end of the Stack and removes it.
  // Complexity: O(n)
  pop()

  // Returns value from the end of the Stack without removing it.
  // Complexity: O(n)
  peek()

  // Returns the number of elements in the Stack.
  // Complexity: O(1)
  size()
}
```
