# Castaway

After your ship has wrecked, you wake up on an island with a map in your hand.
Fortunately, it seems that the island you are on is not that lonely and
actually has quite a few harbours. The map you have represent the surrounding
area of the island - it turns out there are several islands around.

The map you have consists of dots, sharps and lower-case Latin letters. The
dots ('.') represent the see, the sharps represent solid ground and the letters
represent harbours.

You also managed to find out (judging by the position of
the moon and the cosmic radiation) that your location on the map is (Sx,Sy)
in zero-based (row,column) coordinates.

On the back of the map there is a list with harbours which are connected via
ships or boats.

Your goal is to reach (Fx,Fy) on the map where a rescue team awaits. You want
to get there as quickly as possible because you don't want the rescue team to
abandon you. But because you are tired and hungry and you don't have any ground
transportation, ground traveling always takes one day. Taking a ship from one
harbour to another also takes a day.

Find the fastest possible way to get to the rescue team, and the number of days
it will you to get there.

## Input

On the first line of the input there will be two numbers: N and M. N is the
number of rows the map has and M is the number of columns. On the second
line there will be four numbers: Sx Sy Fx Fy - the coordinates of the
starting point and the destination point. The following N lines will contain
M-character strings representing a row from the map.

The next line will contain H - the number of harbour connections. The following
H lines will contain two lower-case Latin letters indicating that there is a
two-way connection between these two harbours.

## Output

On a single line on the standard output, print the minimum number of days it
will take you to get to the rescue squad. If there is no way to reach the
squad, print 'NNnoooo' (without the quotes).

## Limits

```
1 <= N,M,H <= 1000
```

## Example

Input:

```
14 25
1 9 13 24
...................###...
...f######.........#b#...
.....##a.................
....######...............
......................##.
....................####c
...###......m##....e##...
...#g.......##n....###...
...###..............###..
....................###..
....................#d#..
....###h###..............
....................j####
......####l####k....#####
9
a e
b f
c b
e n
m g
n h
d h
h l
k j
```

Output:

```
8
```
