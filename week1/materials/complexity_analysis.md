# Complexity analysis

Complexity analysis is a way of looking at the performance of an
algorithm with respect to its input. This allows us to compare
functions that given an input produce the same results and tell
which one performs better.

## Computation model

In order to discuss algorithms and their complexity we should first choose a
computation model that will be executing our programs. What we need essentially
is a computer that has [memory](http://en.wikipedia.org/wiki/Computer_memory)
and a [processor](http://en.wikipedia.org/wiki/Central_processing_unit). The
memory is a linear sequence of bits and the processor could perform some basic
operations (instructions) on these bits. Here are the instructions that our
processor could execute:

* Assigning a value to a variable
* Looking up the value of a particular element in an array
* Comparing two values
* Incrementing a value
* Basic arithmetic operations such as addition and multiplication

## Counting instructions

One way of looking at the performance of a piece of code is counting
the number of instructions that are performed by the processor.

The following snippet is a [Pseudocode](http://en.wikipedia.org/wiki/Pseudocode)
example of how we could obtain the average of the elements in an array.

```
average(numbers) {
  n = length(numbers)
  sum = 0

  i = 0
  while (i < n) {
    sum = sum + numbers[i]
    i = i + 1
  }

  average = sum / n

  return average
}
```

Lets count the number of instructions in the snippet:

* `length(n)` requires one instruction - looking up the size of the array.
* `n = ...` requires one instruction - assigning the size of the array to `n`.
* So `n = length(numbers)` requires two instructions.
* `sum = 0` requires one instruction - assigning 0 to `sum`.
* `i = 0` requires one instruction - assigning 0 to `i`.
* `i < n` requires one instruction - comparing `i` to `n`.
* `numbers[i]` requires one instruction - looking up the `i`th value in `numbers`.
* `sum + ...` requires one instruction - adding up the two elements
* `sum = ...` requires one instruction - assigning the new value to `sum`.
* So `sum = sum + numbers[i]` requires three instructions.
* `i = i + 1` requires one instruction - incrementing `i`.
* `sum / n` requires one instruction - dividing `sum` by `n`.
* `average = ...` requires one instruction - assigning value to `average`.
* So `average = sum / n` requires two instructions.

However, `i < n`, `sum = sum + numbers[i]` and `i = i + 1` are not executed
just once. They are in a loop that iterates from 0 to the length of numbers
which happens to be `n`.

So having this in mind the total number of instructions performed by the
`average` function is: 2 + 1 + 1 + n * (1 + 3 + 1) + 2 = `6 + 5n`.

However, this holds true for our computational model where basic arithmetic
operations are a single instruction. If for example we are running this code
on a machine where such operations require two instructions the total number
of instructions will be `7 + 6n`.

So we see that this formula depends on the machine that we run the program on.
Isn't there a way to generalize the formula so that it holds true regardless of
the computational model used for executing the program?

## Asymptotic complexity

Processors, memory access time, language interpretors, virtual machines could
differ. The total running time of our algorithms depends on all those factors.
It is hard to predict the total running time of a function before executing it.

However, what we could do easily is tell how a function behaves when its input
changes. What is the behaviour of `average` when we run it with list of ten numbers?
`6 + 5 * 10 = 56`. 56 instructions. What about a list of hundred elements?
`6 + 5 * 100 = 506`. Finally, lets look at a thousand. `6 + 5 * 1000 = 5006`.

What we observe is that the constant `6` is quickly swallowed by the other terms.
`5n` is the dominating term. The whole function changes in a similar manner to the
way `5n` changes.

This is the big idea of asymptotic analysis. We are allowed to remove terms that
are not contributing much to the value of a function as its input grows. Similarly
to the way we dropped `6` we could also remove the constant in front of `n`. This
way we could say that as the input to the function changes, `average` is similar
to `n` (it is linear). Thus, we say `average` is `O(n)`.

[Asymptotic computational complexity](http://en.wikipedia.org/wiki/Asymptotic_computational_complexity)

[Big O notation](http://en.wikipedia.org/wiki/Big_O_notation)

## Amortized complexity

[Amortized complexity](http://en.wikipedia.org/wiki/Amortized_analysis) looks at
the complexity of a batch of operations (not a single operation). For example,
Vector's worst case complexity for adding an element is O(n). However, the
amortized complexity for adding `n` elements to a Vector is O(1).

## Best/average/worst analysis

Lets look at another example - a function that checks if there is an even number
in a sequence.

```
has_even(numbers) {
  n = length(numbers)

  i = 0
  while (i < n) {
    if (numbers[i] % 2 == 0) {
      return true
    }
    i = i + 1
  }

  return false
}
```

What is the running time of `has_even`? If first number is even it breaks immediately
so it is O(1). However, if there aren't any even numbers it will go through all elements
increasing the running time to O(n).

We say that the best case performance of `has_even` is O(1). This means that given
the best possible input (even element in the beginning of the sequence) the function
runs in O(1) time.

We say that the worst case performance of `has_even` is O(n). This means that given
the worst possible input (even element is not present in the sequence) the function
runs in O(n) time.

On average the function is O(n) because we have to scan every element until we find
one that is even.

[A Gentle Introduction to Algorithm Complexity Analysis](http://discrete.gr/complexity/)
