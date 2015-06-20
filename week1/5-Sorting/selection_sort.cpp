#include <iostream>
#include <cstdlib>

using namespace std;

class SelectionSort
{
    public:
        void sort(int*, size_t);
};

void SelectionSort::sort(int* sequence, size_t size)
{
    for (size_t i = 0; i < size - 1; ++i)
    {
        size_t min_index = i;

        for (size_t j = i + 1; j < size; j++)
        {
            if (sequence[min_index] > sequence[j])
            {
                min_index = j;
            }
        }

        if (sequence[i] != sequence[min_index])
        {
            int temp = sequence[i];
            sequence[i] = sequence[min_index];
            sequence[min_index] = temp;
        }
    }
}

