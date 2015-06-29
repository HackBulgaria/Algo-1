# Valid Directories

Implement a function in [Java](GraphCycle.java), [Python](graph_cycle.py)
or [C++](graph_cycle.cpp) that checks if a collection of directories and files
is valid.

A valid collection of directories and files is one that does not allow a path
starting from directory and visiting its children to end in the same directory.

The input is an adjacency matrix of the graph of directories and files.
The values in the matrix symbolize different type of relations. For
`graph[a][b]` the possible values are:

* `0` - There is no relation between nodes `a` and `b`
* `1` - Node `b` is a directory child of `a`
* `2` - Node `b` is a file child of `a`

## Example

Input:

```
The directory structure (node indices are present next to each item):

a #0
  b #1
    file1.txt #2
  c #3
    a #0
    file2.txt #4
  file3.txt #5

The adjacency matrix:

    0 1 2 3 4 5
---------------
0 | 0 1 0 1 0 2
1 | 0 0 2 0 0 0
2 | 0 0 0 0 0 0
3 | 1 0 0 0 2 0
4 | 0 0 0 0 0 0
5 | 0 0 0 0 0 0
```

Output:

```
false # Because `c` is parent of `a` and there is a cycle when traversing the directories.
```
