# Stack

Write down the asymptotic complexities of the following functions:

## Checking if a number is prime

```
is_prime(number) {
  i = 2
  while (i < number) {
    if (number % i == 0) {
      return false
    }
  }
  return true
}
```

Complexity: ...

## Checking if a string is palindrome

```
is_palindrome(string) {
  n = length(string)

  i = 0
  j = n - 1
  while (i < j) {
    if (string[i] != string[j]) {
      return false
    }
    i = i + 1
    j = j - 1
  }

  return true
}
```

Complexity: ...

## Finding maximum element in array

```
something(numbers) {
  n = length(numbers)

  i = 0
  while (i < n) {
    j = i + 1
    has_bigger = false
    while (j < n) {
      if (numbers[i] < numbers[j]) {
        has_bigger = true
        break
      }
      j = j + 1
    }
    if (has_bigger == false) {
      return numbers[i]
    }
    i = i + 1
  }
}
```

Complexity: ...

## Greatest common divisor of two numbers

```
gcd(a, b) {
  while (a != b) {
    if (a > b) {
      a = a - b
    } else {
      b = b - a
    }
  }
  return a
}
```

Complexity: ...
