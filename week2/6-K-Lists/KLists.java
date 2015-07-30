import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;



/**
 *
 * @author qvka
 */
public class KLists {
     public static class MyScanner {
      BufferedReader br;
      StringTokenizer st;
 
      public MyScanner() {
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
 
      long nextLong() {
          return Long.parseLong(next());
      }
 
      double nextDouble() {
          return Double.parseDouble(next());
      }
 
      String nextLine(){
          String str = "";
          try {
             str = br.readLine();
          } catch (IOException e) {
             e.printStackTrace();
          }
          return str;
      }

   }
    class Pair{
        int key;
        int value;
        public Pair(int key , int value){
            this.key=key;
            this.value = value;
        }
    }
    class Heap{
 
        private Pair[] heap; // starting from 1
        private static final int CAPACITY = 150;
        private int size;
        protected boolean isMinHeap;
        
        public Heap(boolean isMin){  //for max heap give argument false
            this.isMinHeap = isMin;
            size=0;
            heap = new Pair[CAPACITY];
        }
        public Heap(boolean isMin,int cap){
             this.isMinHeap = isMin;
            size=0;
            heap = new Pair[cap+1];
        }
        public Heap(int[] array,boolean isMin){
            this.isMinHeap=isMin;
            size= array.length;
            heap = new Pair[size+1];
            System.arraycopy(array, 0, heap, 1, size);
            buildHeap();
        }
        
        public int size(){
            return this.size;
        }
        private void expandHeap(){
            Pair[] old = heap;
            heap = new Pair[heap.length*2];
            System.arraycopy(old, 1, heap, 1, size);
        }
        public void insert(Pair value){
            if( size == heap.length-1){
                expandHeap();
            }
            size++;
            int position = size;

            //move up                            min heap                    max heap
           /* while( position > 1 && (isMinHeap ? value < heap[position/2] : value > heap[position/2] )){
                heap[position]=heap[position/2];
                position=position/2;
            } */
           //variant 2
           
            if(isMinHeap){
                while( position > 1 && value.key < heap[position/2].key ) {
                    heap[position] = heap[position/2];
                    position = position/2;
                }
            }else{
                 while( position > 1 && value.key > heap[position/2].key ) {
                    heap[position] = heap[position/2];
                    position = position/2;
                }
            }
            
            heap[position] = value;
        }
        public Pair deleteTop() throws RuntimeException{
         //   if(size == 0){
         //       throw new RuntimeException();
         //   }
            Pair top=heap[1];
            heap[1]=heap[size];
            size--;
            movingDown(1);
            return top;
        }
        public Pair peek(){
         //   if(size == 0){
          //      throw new RuntimeException();
         //   }
            return heap[1];
        }
        private void buildHeap(){
            for(int k = size/2 ; k > 0 ; k--){
                movingDown(k);
            }
        }
        
        public void movingDown(int k){
            Pair temp = heap[k];
            int child;
            while( 2*k <= size ){
                child=2*k;
                
                if( child != size ){ // has sibling ?
                    if(isMinHeap){ // min heap
                        if( heap[child].key > heap[child+1].key ){ // take lesser child
                            child++;
                        }
                    }else{ // max heap
                        if( heap[child].key < heap[child+1].key ){ // take greater child
                            child++;
                        }
                    }
                }
                
                if( isMinHeap ){ //min heap
                    if( temp.key > heap[child].key ){
                            heap[k] = heap[child];  
                    }else{
                        break;
                    }
                }else{ // max heap
                    if( temp.key < heap[child].key ){
                           heap[k] = heap[child];  
                    }else{
                        break;
                    }
                }
                    
                k = child;
            }
            
            heap[k]=temp;
        }
        @Override
        public String toString(){
          String out = "";
          for(int k = 1; k <= size; k++) out += "k="+heap[k].key +" v="+heap[k].value+" ";
          return out;
        } 
    }
    
    private Heap heap;
    
    public void merge(LinkedList<Integer>[] lists){
        Heap hp = new Heap(true,lists.length);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out),true);
        StringBuilder sb= new StringBuilder();
        int value1;
        // we add the first element on each list ot the heap
        for(int i = 0 ; i < lists.length; i++){
            
            //pair ( key  = integer from the list , value =index of that list in the array
            if(!lists[i].isEmpty()){
                hp.insert(new Pair( lists[i].poll(), i)); 
              // lists[i].removeFirst();
            }
        }
        //pop the heap , and add new value from the same list the popped value came from
        while(hp.size > 0){
            sb.append(hp.peek().key).append(" ");
            value1 = hp.peek().value;  // the index of the list in the array
            hp.deleteTop();
            if(!lists[value1].isEmpty()){  // we take another element of the same list
                hp.insert(new Pair(lists[value1].poll() , value1));
               // lists[value1].removeFirst();
            }
        }
        out.println(sb.toString());
    }
    
    public static void main(String[] args) {
        KLists kl = new KLists();
        
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
       LinkedList<Integer>[] arr = new LinkedList[n];
      
       int temp;
       for(int i = 0 ; i < n ; i++){
           arr[i]=new LinkedList<>();
           while( (temp=sc.nextInt()) != -1){
               arr[i].add(temp);
           }
           
       }
   
        kl.merge(arr);
  
    }
    
}