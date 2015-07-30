# Strings

## Trie

The [Trie](https://en.wikipedia.org/wiki/Trie) structure represents a
generalized tree structure in which each edge carries the information
of a single letter and each node represents a common prefix of many
words in a dictionary. Leaf nodes represent a single word, composed
of the letters on the edges going through the path from the root.

Trie is usually built over a dictionary of words and allows to
quickly lookup if any given word is in that dictionary.

Trie can be built in linear time, going through each word in the
dictionary only once.

Lookup is also linear on the length of the word being looked up.

Tries can take a lot of memory, depending on how different are the
words in the dictionary. To optimize this, an improved data structure
which stores whole substrings on the edges was invented. The structure
is known as "Patricia trie" or ["Radix tree"](https://en.wikipedia.org/wiki/Radix_tree)

## Rabbin-Karp algorithm

The [Rabbin-Karp](https://en.wikipedia.org/wiki/Rabin%E2%80%93Karp_algorithm)
algorithm uses hash functions to quickly find the position of a substring
(needle) inside a larger string(haystack).

It uses the so called "Rolling hash" to quickly calculate the hash function
for the next position in the haystack. The mathematical property which allows
this is that the modulo operator is [distributive](https://en.wikipedia.org/wiki/Distributive_property)
to the operators +,-,*.

Basically, if we have the hash result for a range [i;j] in the haystack,
we can quickly calculate the hash for [i+1;j+1] as follows:

```
h(i+1,j+1) = (h(i,j) - value(i)*(BASE^(j-i))) * BASE + value(j+1)
```

which makes computing the next hash a constant operation.