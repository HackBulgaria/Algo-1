# Shortest path

In graph theory, the [shortest path problem](https://en.wikipedia.org/wiki/Shortest_path_problem)
is the problem of finding a path between two vertices in a graph such
that the sum of the weights of the edges in the path is minimized.

The problem has different variations depending on the context.

Depending on the graph type, the problem can be:

* Shortest path in undirected graphs
* Shortest path in directed graphs
* Shortest path in directed acyclic graphs (DAGs)

Depending on the weights of the edges:

* Shortest path in a graph with non-negative weights
* Shortest path in a graph with arbitrary weights

Depending on problem context:

* Single source shortest paths
* Single destination shortest paths
* All-pairs shortest paths

## [Floyd-Warshall algorithm](https://en.wikipedia.org/wiki/Floyd%E2%80%93Warshall_algorithm)

The Floyd-Warshall algorithm finds the shortest paths between all pairs
of vertices in a graph (solves the *All-pairs shortest path* problem).
It has a complexity of O(|V|^3) which is remarkable considering
that there can be up to O(|V|^3) edges in a graph.

The algorithm goes as follows:

1. Build a matrix dist[][] initially filled with +INFINITY (INT_MAX).
1. Set dist[v][v] = 0 for each v in V
1. Set dist[u][v] = weight(u,v) for each edge (u,v)
1. For each vertex k in V
  1.1 For each pair of vertices u,v in V
    1.1.1 dist[u][v] = min(dist[u][v], dist[u][k] + dist[k][v])

At the end of the algorithm, dist[u][v] will contain the shortest path
between u and v for any u,v in V. The step in the body of the inner-most
loop is called `relaxation`.

The Floyd-Warshall algorithm only works on both directed and undirected graphs
with arbitrary edges. The algorithm will not produce correct results if there
is a negative cycle in the graph. In the case, a shortest path between the
vertices in the cycle does not exist.

## [Dijkstra's algorithm](https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm)

The Dijkstra's algorithm is an algorithm that computes shortest paths from a
single source vertex to all of the other vertices (Single source shortest
path). This is basically the fastest shortest path algorithm which works
on arbitrary directed(or undirected) graphs with non-negative edges.

The algorithm keeps the current-best shortest path from the source vertex to
all others, and updates this current-best on each step.

The algorithm goes as follows:

1. Initialize dist[v] = INFINITY for all vertices, except dist[source] = 0
1. Get an unvisited node v for which dist[v] is minimal. Mark v as visited.
1. For each edge (v,u), update d[u] = min(d[u], d[v] + w(v,y)) (relaxation).
1. Repeat 2. until there are no more edges.

The algorithm works very similarly to the Prim's algorithm - it basically
splits all nodes into two sets: visited and unvisited and on each step
adds to the visited set the node which is closest to the source, then
updates the distances of its neighbours.

## [Bellman-Ford's algorithm](https://en.wikipedia.org/wiki/Bellman%E2%80%93Ford_algorithm)

The Bellman–Ford algorithm is an algorithm which computes the shortest paths
from a single source vertex to all of the other vertices in a weighted directed
graph. It is slower than Dijkstra's algorithm for the same problem, but it is
capable of handling graphs with negative edges.

Similar to Dijkstra and Floyd-Warshall, it uses relaxation to update the
current-best distance. However, in contrast to Dijkstra, it does not relax
the edges going out of the current-best vertex but instead repeatedly
(V-1 times) relaxes all the edges.

The algorithm goes as follows:

1. Initialize dist[v] with infinity values, and dist[source] with 0.
1. For i from 1 to |V|-1
  1.1  For each edge (u,v) in Graph
    1.1.1 dist[v] = min(dist[v], dist[u] + w(u,v))
1. Detect negative cycles
  1.1 For each edge (u,v) in graph
    1.1.1 If dist[u] + w(u,v) < dist[v], then this is a negative cycle

