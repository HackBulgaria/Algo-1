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

## Example
```
16 8
19 11 15 4 7 13 11 2 3 5 12 7 23 17 4 6
min 0 4
\>4
min 5 10
\>2
set 4 3
min 4 8
\>2
min 0 7
\>3
set 15 8
min 15 15
\>8
min 10 13
\>7
```