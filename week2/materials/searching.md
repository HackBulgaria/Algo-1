# Searching

## Linear search

A trivial way of finding an element in a sequence is looking at
every element of the sequence. If the collection does not imply some
specific ordering this could be the only way of searching. However,
large collection will definitely cause a performance impact.

## Binary search

[Binary search](https://www.topcoder.com/community/data-science/data-science-tutorials/binary-search/)
is an example of an algorithm that with some amount of
preprocessing is able to solve a hard problem. Sorting a collection
of elements allows consecutive searches to be really fast.

The strategy that this algorithm employs is very similar to the one
we saw in merge sort and quick sort.

You can go through each step of the algorithm [here](http://www.cs.armstrong.edu/liang/animation/web/BinarySearch.html).

## Interpolation search

Can we search faster than binary? Yes, if we once again limit the problem
and require knowledge about the range of the values in the searched interval.
If that's the case [Interpolation search](http://www.stoimen.com/blog/2012/01/02/computer-algorithms-interpolation-search/)
does a pretty good job improving the performance of binary search.
