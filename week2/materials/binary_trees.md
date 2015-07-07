# Binary trees

## Binary tree

[Binary tree](http://www.cs.cmu.edu/~adamchik/15-121/lectures/Trees/trees.html)
is a data structure that allows nodes to have up to two descendants. In that
sense it could be considered a generalization of a
[List](../week1/materials/linear_data_structures.md#list).

## Binary search tree

[Binary search tree](http://www.stoimen.com/blog/2012/06/22/computer-algorithms-binary-search-tree-data-structure/)
enforces order for the values of a binary tree. For every node of the
binary search tree it is true that all values in the left subtree (the one
that has the left descendant as a root) are smaller than the value of the
node and all values in the right subtree (the one that has the right descendant
as a root) are bigger than the value of the node.

## Binary heap

[Binary heap](https://en.wikipedia.org/wiki/Heap_(data_structure)) is quite similar
to binary search tree except that its invariant is different. For every node of the
heap it is true that all values in its descendant subtrees are smaller (for max heap)
or bigger (for min heap) than the value of the node. This way we have a fast
way of retrieving the biggest/smallest element in the heap.

## Heap sort

Did you know that heaps could be used for efficient
[sorting](https://en.wikipedia.org/wiki/Heapsort)?
[Here](https://www.cs.usfca.edu/~galles/visualization/HeapSort.html) you can
see the algorithm in action.

## Priority queue

[Priority queue](https://en.wikipedia.org/wiki/Priority_queue) assigns priorities
to elements of the queue. Elemenets with higher priority are poped out of the
queue sooner than elements with lower priority. It could be considered as a
generalization of a standard queue where all elements have the same priority.
