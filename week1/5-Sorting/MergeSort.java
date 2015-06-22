package com.company;

import java.lang.reflect.Array;

public class MergeSort
{
    public int[] Sort(int[] list)
    {
        if (list.length <= 1)
        {
            return list;
        }

        int middle = list.length / 2;

        int[] leftArray = new int[middle];
        int[] rightArray = new int[list.length - middle];
        for (int i = 0; i < middle; i++)
        {
            leftArray[i] = list[i];
        }
        for (int i = middle; i < list.length; i++)
        {
            rightArray[i - middle] = list[i];
        }

        leftArray = Sort(leftArray);
        rightArray = Sort(rightArray);

        return Merge(leftArray, rightArray);
    }

    private int[] Merge(int[] left, int[] right)
    {
        int indexLeft = 0;
        int indexRight = 0;

        int[] merged = new int[left.length + right.length];

        for (int i = 0; i < merged.length; i++)
        {
            if (indexLeft >= left.length && indexRight >= right.length)
                break;

            if (indexLeft >= left.length && indexRight < right.length)
            {
                while (indexRight < right.length)
                {
                    merged[i] = right[indexRight];
                    i++;
                    indexRight++;
                }

                break;
            }

            if (indexRight >= right.length && indexLeft < left.length)
            {
                while (indexLeft < left.length)
                {
                    merged[i] = left[indexLeft];
                    i++;
                    indexLeft++;
                }

                break;
            }

            if (left[indexLeft] < right[indexRight])
            {
                merged[i] = left[indexLeft];
                indexLeft++;
            } else
            {
                merged[i] = right[indexRight];
                indexRight++;
            }
        }

        return merged;
    }

}
