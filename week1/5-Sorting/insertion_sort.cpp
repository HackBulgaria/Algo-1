#include <iostream>
#include <cstdlib>

using namespace std;

class InsertionSort
{
    public:
        void sort(int*, size_t);
};

void InsertionSort::sort(int* sequence, size_t size)
{
    for (size_t i = 1; i < size; ++i)
    {
        for (size_t j = i; j > 0; --j)
        {
            if (sequence[j] < sequence[j - 1])
            {
                int temp = sequence[j];
                sequence[j] = sequence[j - 1];
                sequence[j - 1] = temp;
            }
        }
    }
}

