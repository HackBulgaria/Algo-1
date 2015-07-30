# Second Best MST

Find a second best minimum spanning tree. This is a spanning tree that has a total
length larger than the length of the MST and less than every other spanning tree
of the graph.

## Input

The first line of the input will contain N - the number of edges in the graph.
The following N lines will contain three numbers in the form `<first> <second> <length>`
where `<first>` and `<second>` are indices of nodes and `<length>` is the
length of the edge that connects them.

## Output

On the single line of the output print the total length of the second best MST.

## Limits

```
1 <= N <= 1000
The graph could have at most 1000 vertices.
```

## Example

Input:

```
11
1 2 5
2 3 13
1 4 17
2 4 12
2 7 8
3 7 11
3 5 6
4 6 10
4 7 8
5 7 14
6 7 4
```

Output:

```
46
```
