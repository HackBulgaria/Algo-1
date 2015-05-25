# Palindromes

A palindrome is a string which reads the same backward or forward. 

Examples for palindromes:

* `a`
* `abba`
* `alabala`
* `kamak`

**A rotation of a string** is a string derived from the original one by splitting it at any position and concatenating the two parts in reverse order. Any string is considered a rotation of itself.

Example (all rotations of the string "bird"):

* `bird`
* `irdb`
* `rdbi`
* `dbir`

## Input

* On the standard input you will be given a string consisting of lower-case latin letters only. 
* The length of the string will be between 1 and 1000.

## Output

**On the standard output print all the rotations of the given string which are palindromes.**

Each rotation should be printed on a separate line. You can print them in any order. 

Two rotations are considered different if the index at which the original string was split is different even if they are lexicographically equal. If none of the rotations of the string is a palindrome, print "NONE" (without the quotes).

## Examples

### Example 1

Input:

`labalaa`

Output:

`alabala`

### Example 2

Input:

`akawwaka`

Output:

```
akawwaka
wakaakaw
```

### Example 3

Input:

`shakira`

Output:

`NONE`
