# Linear data structures

The data structures described here are fundamental to many algorithms.
They are used for storing an ordered collection of elements. Each of the
structures has its own benefits and we'll learn how to take advantage of
them in order to speed up our algorithms.

## Array

[Array](http://en.wikipedia.org/wiki/Array_data_structure)

## Vector

[Dynamic array](http://en.wikipedia.org/wiki/Dynamic_array)

## List

List is a data structure that allows us to store unlimited number of
elements without copying them over when expanding. In order to achieve
this it does not store the elements in an Array. Instead, every element
is an object that holds both the value (int, string, float, etc...) and
a pointer to the next element in the list. This way every element of the
list could be accessed starting from the first element (we call this `head`
of the list) and following the links.

List sacrifices the performance of accessing elements at random position
(this operation runs in O(n) time) so that adding, removing and retrieving
elements from the end of the list is fast (runs in O(1) time).

[Linked list](http://en.wikipedia.org/wiki/Linked_list) - List with link in one direction.

[Doubly linked list](http://en.wikipedia.org/wiki/Doubly_linked_list) - List with
links in both directions.

## Queue

[Queue](http://en.wikipedia.org/wiki/Queue_%28abstract_data_type%29) is an
abstract data type. This means that it does not define a specific implementation.
It just provides an interface for the supported operations.

The interface of a Queue data type is:

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

It could be implemented with both Vector and List.

## Stack

[Stack](http://en.wikipedia.org/wiki/Stack_%28abstract_data_type%29) is an
abstract data type. This means that it does not define a specific implementation.
It just provides an interface for the supported operations.

The interface of a Stack data type is:

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

It could be implemented with both Vector and List.
