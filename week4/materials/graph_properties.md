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

![](https://upload.wikimedia.org/wikipedia/commons/thumb/3/3d/Undirected_graph.svg/1280px-Undirected_graph.svg.png =250x)

### Directed graph

A graph which edges have a direction. This means that if a node `a` is
related to another node `b` the reverse might not be true.

![](http://journyx.com/sites/default/files/imgs/images/directed%20graph.png =250x)

## Edge weight

### Unweighted graph

Graphs without edge weights are called unweighted. Edges of unweighted
graphs are considered equals.

![](https://upload.wikimedia.org/wikipedia/commons/thumb/3/3d/Undirected_graph.svg/1280px-Undirected_graph.svg.png =250x)

### Weighted graph

Graphs with edge weights are called weighted. Edges are threated differently
in algorithms with respect to their weights.

![](http://web.cecs.pdx.edu/~sheard/course/Cs163/Graphics/graph6.png =250x)

## Number of edges

### Simple graph

Simple graphs allow single edge connecting two vertices.

![](http://graphs.grevian.org/resources/static/images/example1.png =250x)

### Multigraph

Multigraphs allow more than one edge to connect two vertices.

![](https://mvngu.files.wordpress.com/2011/03/weighted-multigraph.png =250x)

## Cycles

### Acyclic graph

Acyclic graphs are graphs that do not have cycles in paths
between any two vertices.

![](https://upload.wikimedia.org/wikipedia/commons/thumb/3/39/Directed_acyclic_graph_3.svg/2000px-Directed_acyclic_graph_3.svg.png =250x)

### Cyclic graph

Cyclic graphs are graphs that have at least one cycle in paths
between any two vertices.

![](https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/Directed_graph,_cyclic.svg/450px-Directed_graph,_cyclic.svg.png =250x)

## Connected component

A subgraph where every any two vertices are connected with a path.

![](https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Scc.png/220px-Scc.png =250x)
