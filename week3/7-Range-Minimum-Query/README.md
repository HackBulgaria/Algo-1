# RMQ - Range Minimum Query

Implement a program in [Java](RMQ.java), [Python](rmq.py) or
[C++](rmq.cpp) which starts with an initial list of number and
then implements the following two commands.

`set [index] [value]` - replaces the value at `index` in the list
with the specified `value`. `index` <= `length of the list`.

`min [start_index] [end_index]` - returns the minimum value from the
elements between `start_index` and `end_index`. `start_index` <= `end_index`.

Indices in both operations are zero-based.

The first line of the input will contain two integers -
the length of the list and the number of commands.

The second line of the input will contain the elements of the list,
separated by space.

Each of the following lines will contain a single
command in the format specified above.

## Input

The first line of the input contains two numbers `N` - the count of
integers that are present in the array and `K` - the number of queries.

The second line of the input contains `N` integers.

Then follow `K` lines of the form `set [index] [value]` or `min [start_index] [end_index]`.

## Output

`M` lines of integers if `M` is the number of `min` queries.

## Limits

```
N <= 1000000
K <= 100000

Time <= 0.6s
Memory <= 5mb
```

## Example

Input:

```
16 8
19 11 15 4 7 13 11 2 3 5 12 7 23 17 4 6
min 0 4
min 5 10
set 4 3
min 4 8
min 0 6
set 15 8
min 15 15
min 10 13
```

Output:

```
4
2
2
3
8
7
```
