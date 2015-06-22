# Min/Max Heap

Implement a function in [Java](MinMaxHeap.java), [Python](min_max_heap.py)
or [C++](min_max_heap.cpp) that checks if a given binary tree is a min/max
heap.

Min/max heap is a tree that maintains the following property for every node:
* If node's `level` is odd number the value of node is less than the values
of node's children.
* If node's `level` is even number the value of node is bigger than the values
of node's children.

The `level` of the root of the tree is 1. For the rest of the tree's nodes
it's true that the `level` of a node is node's parent's `level` + 1.
