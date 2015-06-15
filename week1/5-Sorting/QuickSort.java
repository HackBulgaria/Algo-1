package com.company;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;

/**
 * Created by NewUser on 11.6.2015 �..
 */
public class QuickSort
{
    public void Sort(int[] list)
    {
        QuickSort(list, 0, list.length - 1);
    }

    private void QuickSort(int[] list, int low, int high)
    {
        if(low < high)
        {
            int partition = Partition(list, low, high);
            QuickSort(list, low, partition - 1);
            QuickSort(list, partition + 1, high);
        }
    }

    private int Partition(int[] list, int low, int high)
    {
        int pivotIndex = (low + high) / 2;
        int pivotValue = list[pivotIndex];
        Swap(list, pivotIndex, high);
        int lowIndex = low;
        for(int i = low; i <= high; i++)
        {
            if(list[i] < pivotValue)
            {
                Swap(list, i, lowIndex);
                lowIndex++;
            }
        }
        Swap(list, lowIndex, high);

        return lowIndex;
    }

    private void Swap(int[] list, int valueLeft, int valueRight)
    {
        int right = list[valueRight];
        int left = list[valueLeft];
        list[valueRight] = left;
        list[valueLeft] = right;
    }
}
