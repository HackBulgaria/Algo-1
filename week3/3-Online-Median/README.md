# Online median

Implement a function in [Java](Median.java), [Python](median.py)
or [C++](median.cpp) which inserts a number to a collection and
returns the `median` of the collection on each insert.

A `median` of the collection is the element which stays on position
`ceiling((Length-1)/2)` in the zero-based sorted list of the items.

## Input

The first line of the input contains a number `N` - the count of
integers that are present in the second line of the input.

## Output

Each line of the output contains a number which is the median of the
collection after corresponding number of iterations over the input.

## Limits

```
N <= 500000

Time <= 1s
Memory <= 10mb
```

## Example

Input:

```
10
5 6 7 4 3 10 20 30 40 50
```

Output:

```
5
6
6
6
5
6
6
7
7
10
```
