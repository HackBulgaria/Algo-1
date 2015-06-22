package com.company;

import java.util.HashMap;

/**
 * Created by NewUser on 15.6.2015 ã..
 */
public class CountingSort
{
    public int[] Sort(int[] list)
    {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i< list.length; i++)
        {
            if(map.containsKey(list[i]))
            {
                map.replace(list[i], map.get(list[i]++);
            }
            else
            {
                map.put(list[i], 1);
            }
        }

        int[] sorted = new int[list.length];

        //map.keySet()

    }
}
