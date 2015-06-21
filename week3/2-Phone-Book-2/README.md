# Phone book

Implement a class in [Java](PhoneBook.java), [Python](phone_book.py)
or [C++](phone_book.cpp) which stores pairs of names and phone numbers
and provides the following operations:

`insert [phone_number] [name]` - inserts a record in the phone book
with a phone number and a name. If the name already exists, update
the phone number. Names will not have white spaces in them.
Phone numbers will be digit-only strings, at most 9 characters long.

`lookup [name]` - returns the phone number related to that name.
If no such name is found, return "NOT FOUND!".

`list` - prints the records from the phone book sorted alphabetically
by the name.

`remove [name]` (optional) - removes the record for a given name

## Example

```
insert 1 Stanislav
insert 15 Rado
lookup Rado
\>15
insert 6 Ivan
lookup Ivan
\>6
insert 8 Ivan
lookup Ivan
\>8
lookup Pesho
\>NOT FOUND!
remove Ivan
lookup Ivan
\>NOT FOUND!
insert 23 Ani
insert 44 Pesho
insert 77 Eli
insert 83 Georgi
list
\>Ani 23
\>Eli 77
\>Georgi 83
\>Pesho 44
\>Rado 15
\>Stanislav 1
```
