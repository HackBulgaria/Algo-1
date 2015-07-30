# Low Cost Flights

Having connecting flights might be annoying but sometimes this is the only way
to fit into the budget. You are working on a low-cost flight search engine
and you want allow your clients to search for the cheapest possible way
to get from airport A to airport B.

## Input

The first line of the input will contain N - the number of airports in your
database. The next N line will each contain N integers. The j-th integer
on line i indicates the price of the cheapest direct flight between i and j.
If there is 0 at that place, this means that there is no direct flight between
i and j. All indices are 0-based.

After these N lines, there will be a single integer M - the number of queries
received on your server. Each of the following M lines will contain a single
query - the source and the destination airport in the form of two different
space separated integers, each between 0 and N-1.

## Output

For each of the queries, print the lowest possible price of flying between
the requested airports (using direct flight or not). If there is no way,
print NO WAY for that query.

## Limits

```
1 <= N <= 500
1 <= M <= 5000
```

## Example

Input:

```
8
0 9 0 3 2 0 0 0
0 0 7 2 0 0 9 0
7 0 0 0 0 7 7 0
0 2 0 0 0 0 0 0
0 0 0 0 0 0 5 0
0 3 0 0 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 0 0 0 4 0
9
0 5
3 6
6 4
3 2
5 4
5 3
7 6
4 5
2 6
```

Output:

```
19
11
NO WAY
9
19
5
4
NO WAY
7
```
