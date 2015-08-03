# Light switches

You have 16 light bulbs in a row. Some of them are switched on and some
of them are switched off. You also have 16 switches. However, these switches
are a bit more complex - each of them is connected to a set of bulbs.
Switching a switch will turn the state of all the bulbs connected to it -
all the bulbs which are on will be turned off and all the bulbs which are off
will be turned on.

It is a bit late so you want to turn off all of them and go to bed.

Find a way to switch off all of them.

## Input

The first line will contain 16 strings `on` or `off`, space-separated.
The next 16 lines will contain 16 integers each. If the number at line i,
column j is 1, this means that switching switch i toggles the state of bulb j.

## Output

On a single line, print the sequence of switches we need to switch in order to
turn off all of the bulbs.

## Example

Input:

```
on on on off on on on off on on on off on on on off
1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 1 0 0 0 1 0 0
0 0 0 0 0 0 0 0 0 0 0 1 1 1 0 0
0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 1
0 1 0 0 0 1 0 0 0 0 1 0 0 0 1 0
0 0 0 0 0 0 0 0 0 1 1 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 1 1 0 1 1
0 1 0 0 0 0 1 0 0 1 0 0 0 0 0 1
0 0 1 1 0 0 0 0 0 0 0 0 0 0 0 0
0 0 1 0 0 0 0 0 0 0 0 1 0 0 1 0
0 0 0 0 1 1 1 0 0 0 0 0 0 0 0 0
0 0 0 1 0 0 0 1 0 0 0 0 0 0 0 1
0 0 0 0 0 0 0 0 1 1 0 0 0 0 0 0
0 0 0 0 0 1 0 1 0 1 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0
0 0 0 1 0 1 0 1 0 0 0 0 0 0 0 0
```

Output:

```
1 3 4 6 7 9 11 13 14 16
```
