# Brackets

You are given a string containing digits only `(0-9)` and brackets of the following types: `()`, `[]`, `{}`. 

We will call the given string a valid bracket expression if it starts with an opening bracket and ends with a closing bracket of the same type. 

All brackets inside that string must be correctly closed and the string must meet the following rules.

## Validity rules:

* `()` can either be outermost or appear between `[]`. `()` cannot be directly contained within `{}`. 
* Neither `[]` nor `{}` can be contained within ().
* `[]` can either be outermost or contained within `{}`. `{}` cannot be contained within `[]`.
* `{}` **are always outermost** and both `()` and `[]` can be contained between them.
* **None of the bracket types can be contained between the same bracket type** - `(())`, `[[]]`, `{{}}` are not valid.
* Digits can appear anywhere between any type of bracket - both opening and closing. Digits cannot be leading or trailing the expression.

In other words, the expression must meet the rules we were taught in elementary school, except the fact that numbers can appear anywhere between the outermost brackets.

### Examples of valid expressions:

* `(123)`
* `[(123)(123)]`
* `[23(123)12(123)]`
* `{123[123(123)123(123)]23[123]2}`
* `[123]`
* `{123}`

### Examples of invalid expressions:

* `123(123)`
* `(123[123])`
* `[123(123])`
* `[123{123}]`
* `(123)(123)`

## The problem - evaluate an expression of brackets and digits

Your task is to write a program which:

1. Checks if the given string is a valid bracket expression.
2. If it is valid, then calculate the value of the expression, following the rules below:

## Expression evaluation rules

Any bracket expression can be evaluated to a value in the following way:

* Consecutive digits are evaluated as decimal numbers: `xyz = 100x + 10y + z`
* The value of an expression contained within `()` is the value of the decimal number in the brackets or 0 if there are no digits:

```
(xyz) = 100x + 10y + z
() = 0
```

* The value of an expression contained within `[]` is the sum of the values of the separate decimal numbers within the brackets **plus the sum of the `()` expressions inside multiplied by `2`**

```
[xyz(ab)ed(c)gh] = 100x + 10y + z + 2(10a + b) + 10e + d + 2c + 10g + h
```

* The value of an expression contained within `{}` is the sum of the values of the separate decimal numbers within the brackets **plus the sum of the `[]` expressions inside multiplied by 2**

```
{xy[ab(cd)ef]z} = 10x + y + 2(10a + b + 2(10c + d) + 10e + f) + z
```

## Input

* On the standard input you will be given a single line containing the described string. 
* There will be no empty spaces in between. The string will be at least 2 and at most 1000 characters long. 
* There will always be at most 3 consecutive digits (i.e. no number in the expression will be greater than 999).

## Output

* On a single line on the standard output print the result of the evaluation. 
* If the string is not a valid bracket expression, print `NO`. 
* It is guaranteed that the result of the evaluation will not exceed `1 000 000 000`.

## Examples

### Example 1

Input:

`[123(145)67(37)912]`

Output:

`1337`

### Example 2

Input:

`{125[2][(1)][3]125}`

Output:

`264`

### Example 3

Input:

```
[125()125()125()125]
```

Output:

```
500
```

### Example 4

Input:

```
{125()125}
```

Output:

```
NO
```

### Example 5

Input:

```
{125[12]{125}[12]125}
```

Output:

```
NO
```

### Example 6

Input:

```
{125[12(123]125}
```

Output:

```
NO
```
