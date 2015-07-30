# Rand Set

Create a data structure that will represent a collection supporting the following operations:

* Insert integer - O(1)
* Remove integer - O(1)
* Check if an integer is present in the collection - O(1)
* Get random integer from the collection - O(1)

## Input

The first line reads `N` - the number of command that follow. Each of the other `N` lines
contains a command in the form:

* insert <number>
* remove <number>
* contains <number>
* random

## Output

Output the result of the `contains` and `random` commands on separate lines. `contains <number>`
should print either `true` or `false` and `random` should print the number itself.

## Limits

```
1 <= N <= 1000000
```

## Example

Input:

```
10
insert 5
insert 2
random
insert 5
contains 5
remove 5
contains 5
insert 6
random
contains 42
```

Output:

```
2
true
false
6
false
```
