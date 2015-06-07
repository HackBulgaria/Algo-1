# Complexity analysis

## Model

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

## Amorthized complexity

## Best/average/worst analysis
