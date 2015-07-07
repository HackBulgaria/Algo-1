# Graph representations

Representing graphs in memory is not a problem with a single solution.
Different models allow different operations on the graph to be efficient.
It is crucial to select an appropriate graph representation in order to
be able to use the structure effectively.

## Adjacency list

[Adjacency list](https://en.wikipedia.org/wiki/Adjacency_list) is a
collection of lists each containing the neighbors of a specific vertex
in the graph. This model allows quick access of all neighbors of a
vertex. However, it does not present an efficient way of checking
if two vertices are in relation.

## Adjacency matrix

[Adjacency matrix](https://en.wikipedia.org/wiki/Adjacency_matrix)
is a way of representing a graph using matrix. Vertices of the graph
are labeled with indices that correspond to rows and columns in the
matrix. The value at specific row/column of the matrix could be a
boolean signifying if there is a relation between the two vertices, or
a number used as a weight of the relation.

Adjacency matrix allows quick check for vertex relations. However, it
requires additional memory quadratic on the number of vertices in the
graph. This memory is wasted if the graph is sparse (there are few
vertex relations).
