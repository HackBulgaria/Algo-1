<<<<<<< HEAD
package com.company;

public class Queue
{
    private Vector vector;
    private int firstElementIdex;
    private final int firstElementIndexTreshold = 1000;

    public Queue()
    {
        vector = new Vector();
        firstElementIdex = 0;
    }

    public void Push(int value)
    {
        vector.Add(value);
    }

    public int Pop()
    {
        if(vector.Size() - firstElementIdex <= 0)
        {
            //Exception should be thrown
            return -1;
        }

        if(firstElementIdex == firstElementIndexTreshold)
        {
            ContractQueue();
        }

        int returnValue = vector.Get(firstElementIdex);
        firstElementIdex++;

        return returnValue;
    }

    private void ContractQueue()
    {
        //Here we should remove the first empty elements in the queue after a lot of pops, because we only keep record of the poped elements, but do not actually remove them
    }

    public int Peak()
    {
        if(vector.Size() - firstElementIdex <= 0)
        {
            //Exception should be thrown
            return -1;
        }
        int returnValue = vector.Get(firstElementIdex);

        return returnValue;
    }

    public int Size()
    {
        return vector.Size() - firstElementIdex;
    }
=======
class Queue<T> {

  // Adds value to the end of the Queue.
  // Complexity: O(1)
  public void push(T value) {
    // ...
  }

  // Returns value from the front of the Queue and removes it.
  // Complexity: O(1)
  public T pop() {
    // ...
  }

  // Returns value from the front of the Queue without removing it.
  // Complexity: O(1)
  public T peek() {
    // ...
  }

  // Returns the number of elements in the Queue.
  // Complexity: O(1)
  public int size() {
    // ...
  }
>>>>>>> upstream/master
}
