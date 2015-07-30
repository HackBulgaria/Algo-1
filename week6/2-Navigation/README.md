# Navigation

You are out in a foreign city and you want to get to the central station
but unfortunately, you figure out that Google Maps does not work offline
and data roaming is too expensive to enable.

Fortunately, you have your laptop with you and you downloaded the map
data of the city last night in the hotel. Now all you need to do is
write a program which will find the shortest path to the station for you.

The map data contains information about junctions, in the form of numbers
1 through N, and streets in the form of triples (i, j, w) - indicating
that there is a street between i and j which is w meters long.

You can walk in any direction on the streets.

Write a program which will output the shortest path to the central station,
given your current location.

## Input

The first line of the input will contain `N` - the number junctions and `M` -
the number of streets, `S` - your current location and `C` - the location of
the central station. Each of the following M lines will contain three integers
`i j w` - indicating there is a street between `i` and `j` which is `w`
meters long.

## Output

On the first line of the standard output, print a single integer - the total
length of the route. On the second line, print space separated the indices
of the junctions you have to go through.

## Limits

```
1 <= N <= 10000
1 <= M <= 50000
```

## Example

Input:

```
8 11 1 8
1 2 6
1 3 2
1 4 10
2 3 3
2 4 3
2 7 8
4 6 1
6 7 2
7 5 3
7 8 12
8 5 6
```

Output:

```
20
1 3 2 4 6 7 5 8
```
