# Word Dictionary

Implement a word dictionary which supports the following operations:

* Insert a word - O(word_len)
* Lookup a word - O(word_len)

## Input

The first line reads `N` - the number of commands that follow. Each of
the other `N` lines contains a command in the form:

* insert <word>
* contains <number>

## Output

Output the result of the `contains` command on separate lines. `contains <word>`
should print either `true` or `false`.

## Limits

```
1 <= N <= 100000
1 <= word_len <= 10
```

## Example

Input:

```
9
insert alabala
insert asdf
contains alabala
insert aladin
contains asdf
contains aladin
insert circle
contains square
contains rectangle
```

Output:

```
true
true
true
false
false
```
