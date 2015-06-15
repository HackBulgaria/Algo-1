package com.company;

/**
 * Created by NewUser on 11.6.2015 ã..
 */
public class InsertionSort
{
    public void Sort(int[] list)
    {
        for(int i = 1; i < list.length; i++)
        {
            int j = i;

            while(j > 0 && list[j-1] > list[j])
            {
                int smaller = list[j];
                int bigger = list[j-1];
                list[j] = bigger;
                list[j-1] = smaller;

                j--;
            }
        }

    }
}
