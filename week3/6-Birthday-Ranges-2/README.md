# Birthday ranges

Implement a program in [Java](BirthdayRanges.java),
[Python](birthday_ranges.py) or [C++](birthday_ranges.cpp) which
starts with a vector of people's birthdays (numbers in the range 0-365)
and can execute the following commands:

`add [day] [number_of_people]` - adds `number_of_people` new people
who have birthdays on day `day`.

`remove [day] [number_of_people]` - removes `number_of_people` people
who have birthdays on day `day`. You must ensure that the number of
people for any given day is always positive.

`count [start_day] [end_day]` - returns the number of people who have
birthdays in the range between `start_day` and `end_day` inclusive.

The first line of the input will contain two integers -
the length of the vector and the number of commands.

The second line of the input will contain the elements of the list,
separated by space.

Each of the following lines will contain a single
command in the format specified above.

## Example

```
11 12
5 10 6 7 3 4 5 11 21 300 15
count 2 10
\>7
count 10 365
\>5
add 8 3
count 7 11
\>6
remove 8 2
count 7 11
\>4
add 18 5
count 10 20
\>8
add 5 1
count 5 25
\>15
remove 5 10
count 1 10
\>6
```