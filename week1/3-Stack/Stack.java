package com.company;

public class Stack
{
    Queue queue = new Queue();

    public void Push(int value)
    {
        queue.Push(value);
    }

    public int Pop()
    {
        Queue newQueue = new Queue();
        int queueSize = queue.Size();

        for(int i = 0; i < queueSize - 1; i++)
        {
            newQueue.Push(queue.Pop());
        }

        int popValue = queue.Pop();

        queue = newQueue;

        return popValue;
    }

    public int Peak()
    {
        Queue newQueue = new Queue();
        int peakedValue = 0;
        int queueSize = queue.Size();

        for(int i = 0; i < queueSize; i++)
        {
            if(i == queueSize - 1)
                peakedValue = queue.Peak();

            newQueue.Push(queue.Pop());
        }

        queue = newQueue;

        return peakedValue;
    }

    public int Size()
    {
        return queue.Size();
    }
}
