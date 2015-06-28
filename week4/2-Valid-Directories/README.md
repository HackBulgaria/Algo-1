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
