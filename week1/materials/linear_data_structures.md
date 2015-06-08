# Linear data structures

The data structures described here are fundamental to many algorithms.
They are used for storing an ordered collection of elements. Each of the
structures has its own benefits and we'll learn how to take advantage of
them in order to speed up our algorithms.

## Array

[Arrays](http://en.wikipedia.org/wiki/Array_data_structure) are essential
to many algorithms. They are very close to the memory representation in a
machine and provide efficiant (O(1) time) operations for working with
elements at a random position.

Arrays are key ingrediants in other more complex data structures.

## Vector

[Vectors](http://en.wikipedia.org/wiki/Dynamic_array) are modification of
arrays that allow unlimited number of elements to be added to the collection
while keeping the performance of random access operations similar to array's
(approximately O(1) time).

* C++: [std::vector](http://www.cplusplus.com/reference/vector/vector/)
* Java: [java.util.ArrayList](https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html)
* Python: [list](https://docs.python.org/3.4/tutorial/datastructures.html#more-on-lists)

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

* C++: [std::list](http://www.cplusplus.com/reference/list/list/)
* Java: [java.util.LinkedList](https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html)
* Python: [collections.deque](https://docs.python.org/3/library/collections.html#collections.deque)

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

* C++: [std::queue](http://www.cplusplus.com/reference/queue/queue/)
* Java: [java.util.Queue](http://docs.oracle.com/javase/7/docs/api/java/util/Queue.html)
* Python: [collections.deque](https://docs.python.org/3/library/collections.html#collections.deque)

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
  // Complexity: O(1)
  pop()

  // Returns value from the end of the Stack without removing it.
  // Complexity: O(1)
  peek()

  // Returns the number of elements in the Stack.
  // Complexity: O(1)
  size()
}
```

It could be implemented with both Vector and List.

* C++: [std::stack](http://www.cplusplus.com/reference/stack/stack/)
* Java: [java.util.Stack](https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html)
* Python: [collections.deque](https://docs.python.org/3/library/collections.html#collections.deque)
