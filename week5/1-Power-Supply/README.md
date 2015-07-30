# Power Supply

The mayor of a big city has contacted you. They are about to adopt electricity and
are planning major reconstructions of the streets. His request is given information
about the streets and junctions that you calculate the least amount of cable (in)
meters that is sufficient to provide electricity on every street.

## Input

The first line of the input will contain N - the number of junction connections.
The following N lines will contain three numbers in the form `<first> <second> <length>`
where `<first>` and `<second>` are indices of junctions and `<length>` is the
length of the street that connects them in meters.

## Output

On the single line of the output print the total length in meters of the least amount
of cable that is sufficient to provide electricity on every street.

## Limits

```
1 <= N <= 1000
The graph could have at most 1000 vertices.
```

## Example

Input:

```
12
1 2 1100
1 3 1400
1 4 2000
2 4 2000
2 5 1300
1 6 2600
3 5 780
5 4 1000
3 4 900
3 6 1300
6 7 200
4 7 800
```

Output:

```
5080
```
