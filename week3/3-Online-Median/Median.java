import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 *
 * @author qvka
 */
public class Week3OnlineMedian {
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
    class Heap{
 
        private int[] heap; // starting from 1
        private static final int CAPACITY = 600000;
        private int size;
        protected boolean isMinHeap;
        
        public Heap(boolean isMin){  //for max heap give argument false
            this.isMinHeap = isMin;
            size=0;
            heap = new int[CAPACITY];
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

            //move up                            min heap                    max heap
           /* while( position > 1 && (isMinHeap ? value < heap[position/2] : value > heap[position/2] )){
                heap[position]=heap[position/2];
                position=position/2;
            } */
           //variant 2
           
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
        @Override
        public String toString(){
          String out = "";
          for(int k = 1; k <= size; k++) out += heap[k]+" ";
          return out;
        } 
    }
    // 0 1 2 3 4 5 6 7
    public void go(){
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out),true);
      
        int n = sc.nextInt();
       // int n = 10;
       // int[] array = {5 ,6 ,7 ,4 ,3 ,10 ,20 ,30, 40, 50};
        int index=0;
        int num;
        Heap left = new Heap(false);  // max heap
        Heap right = new Heap(true);  // min heap
        left.insert(Integer.MIN_VALUE);
        right.insert(Integer.MAX_VALUE);
        int medi;
        int temp;
        medi=sc.nextInt();
      //  medi=array[index];
       // index++;
        //StringBuilder sb = new StringBuilder();
       // sb.append(medi+"\n");
        out.println(medi);
        for(int i = 1 ; i < n ; i++){
            num=sc.nextInt();
           //  num = (int)(Math.random() *1000);
          //  num=array[index];
          //  index++;
            
            if( left.size == right.size){ 
                // add to left heap 
                if ( num <= medi ){
                    left.insert(num);
                }else{
                    left.insert(medi);
                    medi = num;
                    if( medi > right.peek() ){
                       /* temp = medi;
                        medi = right.deleteTop();
                        right.insert(temp); */
                        medi= right.swap(medi);
                    }
                }
                
            }else{
                // add to right heap
                if ( num >= medi ){
                    right.insert(num);
                }else{
                    right.insert(medi);
                    medi=num;
                    if( medi < left.peek() ){
                       /* temp = medi;
                        medi=left.deleteTop();
                        left.insert(temp);*/
                        medi = left.swap(medi);
                    }
                }
                
            }
    
            out.println(medi);
        }
    }
    public static void main(String[] args) {
  
        Week3OnlineMedian ob= new Week3OnlineMedian();
        ob.go();
    }
    
}