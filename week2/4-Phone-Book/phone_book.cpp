#include <string>
#include <vector>

using namespace std;

class Contact {
public:
  string name;
  int number;
};

class PhoneBook {
public:

  // Find the names of people based on their phone numbers.
  vector<string> lookupNames(vector<Contact> phoneBook, vector<int> numbers) {
    // ...
  }
};
