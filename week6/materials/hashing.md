# Hashing

Hashing is the process of transforming objects into other
(most probably simpler (often integers)) objects.

It is useful when we need a fast way of comparing, indexing
or ... complex objects.

## Hash function

A [hash function](https://en.wikipedia.org/wiki/Hash_function) takes an object as an input and produces
another, simpler object that serves as the "hash" of the
original.

Here are some rules for writing good hash functions:

* The hash value is fully determined by the data being hashed.
* The hash function uses all the input data.
* The hash function "uniformly" distributes the data across the entire set of p ossible hash values.
* The hash function can generate different hash values for similar objects.

## Hash table

[Hash table](https://en.wikipedia.org/wiki/Hash_table) is a data structure that combines the fast indexing
properties of an array with a hash function that could transform
any object into a number. This way we end up with collection that
could perform insertion, lookup and removal of elements in `O(1)`
time (almost).

Some problems that arise when implementing a hash table:

* How big array to use for storing objects.
* Should we resize this array (and when).
* What happens if two objects produce the same hash?

## Bloom filter

[Bloom filter](http://billmill.org/bloomfilter-tutorial/) is a space-efficient data structure that serves
as a set and could perform the following operations: insert
an element, remove an element, tell if the element is present
in the set.

It is also probabalistic. We allow false positive results for
the `contains` operation. False negatives however are not premitted.

## Additional materials

Make sure you take a look at the hashing article at [informatika.bg](http://informatika.bg/lectures/hashing) as well as the one at [Interactive Python](http://interactivepython.org/runestone/static/pythonds/SortSearch/Hashing.html).
