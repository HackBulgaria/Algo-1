package com.company;

import java.util.ArrayList;

/**
 * Created by NewUser on 11.6.2015 ã..
 */
public class SelectionSort
{
    public void Sort(int[] list)
    {
        //int smallest

        for(int i = 0; i < list.length - 1; i++)
        {
            int min = i;
            for(int j = i+1; j < list.length; j++)
            {
                if(list[j] < list[min])
                {
                    min = j;
                }
            }

            if(min != i)
            {
                int right = list[i];
                int left = list[min];
                list[i] = left;
                list[min] = right;
            }
        }
    }

}
