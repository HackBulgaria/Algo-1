# K Paths

Implement a program which finds all possible paths with K edges that
connect to vertices in a directed acyclic graph.

## Input

The first line will contain N - the number of edges in the graph.
The next N lines will contain the labels of two vertices that are
connected with an edge (first is connected with second).
The last line will contain two vertex labels (start and end vertex)
and a path length K.

## Output

Output the number of paths from starting to ending vertex that are of
length K.

## Limits

```
1 <= N <= 1000
K <= N
```

## Example

Input:

```
5
0 1
0 2
0 3
1 3
2 3
0 3 2
```

Output:

```
2
```
