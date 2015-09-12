import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class HeapSort {
    public static class MyScanner{
        BufferedReader br;
        StringTokenizer st;
        public MyScanner(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
          while (st == null || !st.hasMoreElements()) {
              try {
                  st = new StringTokenizer(br.readLine());
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
          return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
    }
    
    public class Heap{
        private int[] heap; // starting from 1
        private static final int CAPACITY = 2;
        private int size;
        protected boolean isMinHeap;

        public Heap(boolean isMin){  //for max heap give argument false
            this.isMinHeap = isMin;
            size=0;
            heap = new int[CAPACITY];
        }
        public Heap(boolean isMin,int cap){  //for max heap give argument false
            this.isMinHeap = isMin;
            size=0;
            heap = new int[cap];
        }
        public Heap(int[] array,boolean isMin){
            this.isMinHeap=isMin;
            size= array.length;
            heap = new int[size+1];
            System.arraycopy(array, 0, heap, 1, size);
            buildHeap();
        }
        public int size(){
            return this.size;
        }
        private void expandHeap(){
            int[] old = heap;
            heap = new int[heap.length*2];
            System.arraycopy(old, 1, heap, 1, size);
        }
        public void insert(int value){
            if( size == heap.length-1){
                expandHeap();
            }
            size++;
            int position = size;           
            if(isMinHeap){
                while( position > 1 && value < heap[position/2] ) {
                    heap[position] = heap[position/2];
                    position = position/2;
                }
            }else{
                 while( position > 1 && value > heap[position/2] ) {
                    heap[position] = heap[position/2];
                    position = position/2;
                }
            }
            heap[position] = value;
        }
        public int deleteTop() throws RuntimeException{
            if(size == 0){
                throw new RuntimeException();
            }
            int top=heap[1];
            heap[1]=heap[size];
            size--;
            movingDown(1);
            return top;
        }
        public int peek(){
            if(size == 0){
                throw new RuntimeException();
            }
            return heap[1];
        }
        private void buildHeap(){
            for(int k = size/2 ; k > 0 ; k--){
                movingDown(k);
            }
        }
        
        // returns heap top and places k at the top and traverses down
        public int swap(int k){
            int temp = heap[1];
            heap[1]=k;
            movingDown(1);
            return temp;
        }
        public void movingDown(int k){
            int temp = heap[k];
            int child;
            while( 2*k <= size ){
                child=2*k;
                if( child != size ){ // has sibling ?
                    if(isMinHeap){ // min heap
                        if( heap[child] > heap[child+1] ){ // take lesser child
                            child++;
                        }
                    }else{ // max heap
                        if( heap[child] < heap[child+1] ){ // take greater child
                            child++;
                        }
                    }
                }
                if( isMinHeap ){ //min heap
                    if( temp > heap[child] ){
                            heap[k] = heap[child];  
                    }else{
                        break;
                    }
                }else{ // max heap
                    if( temp < heap[child] ){
                           heap[k] = heap[child];  
                    }else{
                        break;
                    }
                }
                k = child;
            }
            heap[k]=temp;
        }
        public void heapSort(){
          int temp = size;
          while(size > 1){
            heap[size]= swap(heap[size]);
            size--;
          }
          size = temp;
        }
        @Override
        public String toString(){
          String out = "";
          for(int k = 1; k <= size; k++) out += heap[k]+" ";
          return out;
        } 
        public String toString(boolean heapSorted){
            StringBuilder sb = new StringBuilder();
            for(int i = size ; i >= 1 ; --i ){
                sb.append(heap[i]).append(" ");
            }
            return sb.toString();
        }

    }
    
    public String go(int[] sequence){
        Heap hp = new Heap(sequence,true);
        hp.heapSort();
        return hp.toString(true);
    }

    
    public static void main(String[] args) {
        MyScanner scanner = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out),true);
        int[] sequence;
        int n;
        n = scanner.nextInt();
        sequence = new int[n];
        for(int i = 0 ; i < n ; ++i){
            sequence[i] = scanner.nextInt();
        }
        
        HeapSort hs = new HeapSort();
        out.println(hs.go(sequence));
        
    }
    
}