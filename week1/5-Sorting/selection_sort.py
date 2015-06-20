class SelectionSort:

    def selection_sort(sequence):
        """Sorts a sequence of integers"""

        for i in range(len(sequence)):
            subseq = sequence[i:]
            min_element = min(subseq)
            min_index = subseq.index(min_element) + i

            sequence[i], sequence[min_index] = sequence[min_index], sequence[i]

        return sequence


