# Closest Coffee Store

Implement a function in [Java](ClosestCoffeeStore.java), [Python](closest_coffee_store.py)
or [C++](closest_coffee_store.cpp) that given a graph of connected points
of interests and a starting point returns the closest coffee store to that
point. Return `-1` in case there is no reachable coffee store from this location.

## Example

Input:

```
The graph matrix:

    0 1 2 3 4 5
---------------
0 | 0 1 0 1 0 0
1 | 1 0 1 0 0 0
2 | 0 1 0 0 1 0
3 | 1 0 0 0 0 0
4 | 0 0 1 0 0 1
5 | 0 0 0 0 1 0

The coffee store property array:
[0, 0, 1, 0, 0, 1]

Starting point: 0
```

Output:

```
2 # Because the nearest coffee store to `0` is `2` and the path to
it is `0 -> 1 -> 2`.
```
