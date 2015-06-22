<<<<<<< HEAD
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
=======
class Stack<T> {

  // Adds value to the end of the Stack.
  // Complexity: O(1)
  public void push(T value) {
    // ...
  }

  // Returns value from the end of the Stack and removes it.
  // Complexity: O(n)
  public T pop() {
    // ...
  }

  // Returns value from the end of the Stack without removing it.
  // Complexity: O(n)
  public T peek() {
    // ...
  }

  // Returns the number of elements in the Stack.
  // Complexity: O(1)
  public int size() {
    // ...
  }
>>>>>>> upstream/master
}
