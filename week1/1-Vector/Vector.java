<<<<<<< HEAD
package com.company;

public class Vector
{
    private int[] vector;
    private int currentLastEmptyIndexPointer;

    public Vector()
    {
        this.vector = new int[2];
        currentLastEmptyIndexPointer = 0;
    }

    public void Insert(int index, int value)
    {
        if(index > vector.length)
        {
            ExtendVector(vector);
        }

        if(index >= currentLastEmptyIndexPointer)
        {
            Add(value);
        }


        int numberAtNext;
        int numberAtIndex = vector[index];
        for(int i = index + 1; i <= currentLastEmptyIndexPointer; i++)
        {
            numberAtNext = vector[i];
            vector[i] = numberAtIndex;
            numberAtIndex = numberAtNext;
        }

        vector[index] = value;
        currentLastEmptyIndexPointer++;
    }

    public void Add(int value)
    {
        if(currentLastEmptyIndexPointer == vector.length)
        {
            ExtendVector(vector);
        }

        vector[currentLastEmptyIndexPointer] = value;

        currentLastEmptyIndexPointer++;
    }

    public int Get(int index)
    {
        return vector[index];
    }

    public void Remove(int index)
    {
        if(index > currentLastEmptyIndexPointer)
        {
            return;
        }

        if(currentLastEmptyIndexPointer == vector.length)
        {
            ExtendVector(vector);
        }

        for(int i = index; i < currentLastEmptyIndexPointer; i++)
        {
            vector[i] = vector[i+1];
        }

        currentLastEmptyIndexPointer--;
    }

    public void Pop()
    {
        currentLastEmptyIndexPointer--;
    }

    public int Size()
    {
        return currentLastEmptyIndexPointer;
    }

    public int Capacity()
    {
        return vector.length;
    }

    private void ExtendVector(int[] vectorToExtend)
    {
        int[] newVector = new int[vectorToExtend.length * 2];

        for(int i = 0; i < vectorToExtend.length; i++)
        {
            newVector[i] = vectorToExtend[i];
        }

        vector = newVector;
    }

=======
public class Vector<T> {

  // Adds value at a specific index in the Vector.
  // Complexity: O(n)
  public void insert(int index, T value) {
    // ...
  }

  // Adds value to the end of the Vector.
  // Complexity: O(1)
  public void add(T value) {
    // ...
  }

  // Returns value at a specific index in the Vector
  // Complexity: O(1)
  public T get(int index) {
    // ...
  }

  // Removes element at the specific index
  // Complexity: O(n)
  public void remove(int index) {
    // ...
  }

  // Removes element at the last index
  // Complexity: O(1)
  public T pop() {
    // ...
  }

  // Returns the number of elements in the Vector.
  // Complexity: O(1)
  public int size() {
    // ...
  }

  // Returns the total capacity of the Vector.
  // Complexity: O(1)
  public int capacity() {
    // ...
  }
>>>>>>> upstream/master
}
