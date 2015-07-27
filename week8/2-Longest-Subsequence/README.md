# Longest Subsequence

You are given a sequence of positive integer numbers in an arbitrary
order. Find the longest subsequence which contains only increasing
numbers.

A "Subsequence" of a sequence a1,a2,...,ai,...,an is any sequence
a(j1), a(j2), ... ,a(jk) in which any j(i) < j(i+1).

In other words, the elements of the subsequence may not be consecutive,
but their order from the initial sequence must be kept.

## Input

On the first line of the input there will be a single integer N.
The next line will contain N space separated positive integers.

## Output

On the first line of the output, print the length of the longest
increasing subsequence. On the second line, print the integers from
the subsequence, space-separated. If more than one such sequence
exists, print any of them.

## Limits

```
1 <= N <= 10000
```

## Example

Input:

```
10
6 1 5 3 7 1 2 5 7 4
```

Output:

```
4
1 3 5 7
```
