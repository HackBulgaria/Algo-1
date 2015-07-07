# Pouring Glasses

You are given three glasses each containing some amount of water. Each glass
has a certain capacity C and is filled with some amount of water W. W can be
less than or equal to C.

You can pour the water from one glass to another either until the glass you
are pouring is empty, or until the glass you are pouring to is filled (you
don't want to spill water).

You start with three glasses with capacities C1, C2, C3 and initial amount of
water in each of the glasses: W1, W2, W3. Your goal is to achieve an exact
amount of water G in some of the glasses. In addition, to reduce the risk
of spilling water, you want to achieve G with a minimum number of pouring
operations.

## Input

On the first line of the standard input, there will be three space separated
integers: C1 C2 C3. On the second line there will be another three integers:
W1 W2 W3. On the third line of the input, there will be a single integer:
the goal amount G.

## Output

On the first line of the standard output, print the minimum number of pours
you need to make in order to achieve G water in some of the glasses. On each
of the following lines, print the number of the glass you are pouring from,
followed by the number of the glass you are pouring to.

## Limits

```
1 <= C,W,G <= 30
```

## Example

Input:

```
4 7 6
2 5 4
1
```

Output:

```
2
2 1
2 3
```
