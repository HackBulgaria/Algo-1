# Phone Numbers

You, as a leacturer of the algorithms class, have to call all the students to
notify them that the class on Monday will not be held. However, calling each
student individually will enormously increase your phone bills.

You have a list of the phone numbers of all of the students. For each of the
students, you also have the list of phone numbers of other students he or she
has. Your genius plan to save on phone bills is to only call some of the
students and tell them to call the others.

What is the minimum number of phone calls you need to make in order to ensure
that each student will be notified.

Implement a function in [Java](PhoneNumbers.java), [Python](phone_numbers.py)
or [C++](phone_numbers.cpp) which finds that number.

## Input

On the first line of the standard input, there will be one integer - N - the
number of students. On the next line there will be N space separated integers
in the range [1; 1 000] - each representing the phone number of the
i-th student. The following N lines will start with a single integer M and
will be followed by M phone numbers - the i-th line will represent the list
of contacts the i-th student has.

It is guaranteed that if student i has the number of student j, student j
also has the number of student i because they are considered to be friends.

## Output

Output a single integer - the minimum number of calls you need to make.

## Limits

```
1 <= N <= 1000
0 <= M <= 1000
```

## Example

Input:

```
6
100 200 300 400 500 600
2 200 300
2 100 300
2 100 200
1 500
1 400
0
```

Output:

```
3
```
