# Graph properties

Here are some important properties you should know about different
types of graphs.

## Vertex

An entity in the graph. Vertices are a set of items with common properties
that have some sort of relation.

## Edge

Edges express relation between two vertices. If the vertices are connected with
an edge this means that there is relation between them. The relation could
be some custom property. E.g: `are_friends(a, b) => true`, `are_connected(Sofia, Plovdiv) => false`.

## Edge direction

### Undirected graph

A graph which edges have no direction. They could be interpreted as
bidirectional connections.

![](images/undirected_graph.png =250x)

### Directed graph

A graph which edges have a direction. This means that if a node `a` is
related to another node `b` the reverse might not be true.

![](images/directed_graph.png =250x)

## Edge weight

### Unweighted graph

Graphs without edge weights are called unweighted. Edges of unweighted
graphs are considered equals.

![](images/unweighted_graph.png =250x)

### Weighted graph

Graphs with edge weights are called weighted. Edges are threated differently
in algorithms with respect to their weights.

![](images/weighted_graph.png =250x)

## Number of edges

### Simple graph

Simple graphs allow single edge connecting two vertices.

![](images/simple_graph.png =250x)

### Multigraph

Multigraphs allow more than one edge to connect two vertices.

![](images/multigraph.png =250x)

## Cycles

### Acyclic graph

Acyclic graphs are graphs that do not have cycles in paths
between any two vertices.

![](images/acyclic_graph.png =250x)

### Cyclic graph

Cyclic graphs are graphs that have at least one cycle in paths
between any two vertices.

![](images/cyclic_graph.png =250x)

## Connected component

A subgraph where every any two vertices are connected with a path.

![](images/connected_component.png =250x)
