# Sorting

Sorting a sequence of elements is a well-known problem with many solutions.
We could learn a lot just by looking at the steps that different algorithms
take to produce a solution.

## Selection sort

[Selection sort](http://en.wikipedia.org/wiki/Selection_sort) is probably
the simplest way of sorting a collection - take the minimum element and
put in the first postion, take the next smallest element and put it next
to the previous. Do this for all elements and you have a sorted collection!
[Here](http://courses.cs.vt.edu/~csonline/Algorithms/Lessons/SelectionSort/index.html)
is a description of the steps of the algorithm.
[Here](https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html)
you can find a nice visualization of the steps of the algorithm.

## Insertion sort

[Insertion sort](http://en.wikipedia.org/wiki/Insertion_sort) builds the
sorted array by constantly adding elements to it in the correct position.
[Here](http://courses.cs.vt.edu/csonline/Algorithms/Lessons/InsertionSort/index.html)
is a description of the steps of the algorithm.
[Here](https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html)
you can find a nice visualization of the steps of the algorithm.

## Merge sort

[Merge sort](http://en.wikipedia.org/wiki/Merge_sort) is a nice way of sorting
a sequence of elements. It is a divide and conquer algorithm that divides the
problem in smaller parts, solves them separately and then combines the solutions
to produce a result.
[Here](https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html)
you can find a nice visualization of the steps of the algorithm.

## Bubble sort

[Bubble sort](http://en.wikipedia.org/wiki/Bubble_sort) produces a sorted sequence
by comparing and swapping adjacent elements.
[Here](https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html)
you can find a nice visualization of the steps of the algorithm.

## Shell sort

[Shell sort](http://en.wikipedia.org/wiki/Shellsort) improves Bubble sort by
comparing elements at longer range (not only adjacent). This way the algorithm
is able to fix more out-of-place elements with fewer swaps.
[Here](https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html)
you can find a nice visualization of the steps of the algorithm.

## Quick sort

The name speaks for itself. [Quick sort](http://en.wikipedia.org/wiki/Quicksort)
is one of the fastest ways for sorting a sequence of arbitrary elements known to
mankind.
[Here](https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html)
you can find a nice visualization of the steps of the algorithm.

## Counting sort

[Counting sort](http://en.wikipedia.org/wiki/Counting_sort) is a genious algorithm
that exploits the fact that arrays allow us to make n-way decisions (not just binary
like if/else) to improve the performance for certain sequences.
[Here](https://www.cs.usfca.edu/~galles/visualization/CountingSort.html)
you can find a nice visualization of the steps it executes.
