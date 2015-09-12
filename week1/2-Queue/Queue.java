
import java.util.LinkedList;


class Queue<T> {
    private LinkedList<T> q;
    public Queue(){
        q = new LinkedList();
    }
    // Adds value to the end of the Queue.
    // Complexity: O(1)
    public void push(T value) {
      q.add(value);
    }

    // Returns value from the front of the Queue and removes it.
    // Complexity: O(1)
    public T pop() {
        if(q.size() < 1){
            return null;
        }
        T temp = q.getFirst();
        q.removeFirst();
        return temp;
    }

    // Returns value from the front of the Queue without removing it.
    // Complexity: O(1)
    public T peek() {
        if(q.size() < 1){
            return null;
        }
        return q.getFirst();
    }

    // Returns the number of elements in the Queue.
    // Complexity: O(1)
    public int size() {
        return q.size();
    }
}
