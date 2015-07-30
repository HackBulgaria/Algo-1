import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *
 * @author qvka
 */
public class BandwidthManager {
    
    class Manager{
        private Heap heap;
        private Queue<String>[] q;
        public Manager(int numOfPriorities){
            heap = new Heap(true);
            q = new LinkedList[numOfPriorities];
            for(int i = 0 ; i < numOfPriorities ; i++){
                q[i]=new LinkedList();
            }
        }
        //receives a packet with specified protocol and payload
        public void rcv(String protocol, String payload){
            int priority;
            
            switch(protocol){
                case "ICMP" : priority = 0; break;
                case "UDP"  : priority = 1; break;                
                case "RTM"  : priority = 2; break;
                case "IGMP" : priority = 3; break;
                case "DNS"  : priority = 4; break; 
                case "TCP"  : priority = 5; break;
                default : throw new RuntimeException("Invalid protocol");
            }
            heap.insert(priority);
            q[priority].add(payload);
        }

        //returns the payload of the packet which should be sent
        public String send(){
            
            if( heap.size == 0){
                return "Nothing to send!";
            }
            int priority = heap.deleteTop();
          return q[priority].poll();
           
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
    
    public void go(){
        // 0 is the highest priority;
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out),true);
        Manager m = new Manager(6);
        String word,protocol,payload;
        int n = sc.nextInt();
        int i=0;
        while(i < n){
            word = sc.next();
            switch (word) {
                case "rcv":
                    protocol = sc.next();
                    payload = sc.next();
                    m.rcv(protocol, payload);
                    break;
                case "send":
                    out.println( m.send() );
                    break;
            }
            ++i;    
        }
        
    }
    public static void main(String[] args) {
       BandwidthManager bw=new BandwidthManager();
       bw.go();
    }
    
}