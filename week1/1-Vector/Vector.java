
/**
 *
 * @author qvka
 */
public class Vector<T> {
    private T[] array;
    private int size;
    public Vector(){
        this.size = 0;
        this.array = (T[]) new Object[8];
    }
    public Vector(int capacity){
        this.size = 0;
        this.array = (T[]) new Object[capacity];
    }
    // Adds value at a specific index in the Vector.
    // Complexity: O(n)
    public void insert(int index, T value) {
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        if(size == array.length){
            expand();
        }
        int i = size;
       
        while( i > index ){
            array[i] = array[i-1];
            i--;
        }
        array[index] = value;
        size++;
    }

    // Adds value to the end of the Vector.
    // Complexity: O(1)
    public void add(T value) {
        if(size == array.length){
            expand();
        }
        array[size] = value;
        size++;
    }
    private void expand(){
        T[] temp  = (T[]) new Object[array.length*2];
        System.arraycopy(array, 0, temp, 0, size);
        array = temp;
    }
    // Returns value at a specific index in the Vector
    // Complexity: O(1)
    public T get(int index) {
        if( index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        return (T)array[index];
    }

    // Removes element at the specific index
    // Complexity: O(n)
    public void remove(int index) {
        if(size == 0){
            return;
        }
        if( index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        int i = index+1;
        while( i < size){
            array[i-1] = array[i];
            i++;
        }
        size--;
    }

    // Removes element at the last index
    // Complexity: O(1)
    public T pop() {
        if(size == 0){
            return null;
        }
        size--;
        return (T)array[size+1];
    }

    // Returns the number of elements in the Vector.
    // Complexity: O(1)
    public int size() {
        return size;
    }

    // Returns the total capacity of the Vector.
    // Complexity: O(1)
    public int capacity() {
        return array.length;
    }

    public static void main(String[] args) {
        Vector<Integer> a = new Vector(5);
        System.out.println(a.capacity() + " " +a.size());
        a.add(2);
        System.out.println(a.get(0));
        a.insert(0, 1);
        System.out.println(a.get(0));
        a.remove(0);
        a.add(6);
        a.add(6);
        a.add(6);
        a.add(6);
        a.add(6);
        a.add(6);
        System.out.println(a.capacity());
       
    } 
}
