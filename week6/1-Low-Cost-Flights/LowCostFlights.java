
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;



/**
 *
 * @author qvka
 */
public class LowCostFlights {
    private int[] path;
    private Heap heap;
    private boolean[] visited;
    private int minPath;
    
    public int shortestPath(int from , int to , int[][] graph){
        if( graph[from][to] != 0 ){
            return graph[from][to];
        }
        heap = new Heap(true);
        path = new int[graph.length];
        visited = new boolean[graph.length];
        minPath = 0;
        Edge temp;
        visited[from]= true;
        Arrays.fill(path, Integer.MAX_VALUE);
        path[from] = 0;
        addEdgesToHeap(from, graph);
        while(heap.size > 0){
            temp = heap.deleteTop();
          
            visited[temp.b] = true;
            minPath = path[temp.b];
            if(temp.b == to){
                break;
            }
            addEdgesToHeap(temp.b, graph);
        }
        return path[to];
        
    }
    private void addEdgesToHeap(int k , int[][] graph){
        int temp;
        for (int i = 0 ; i < graph.length ; ++i){
            if( visited[i] == false && graph[k][i] != 0){
                
                heap.insert(new Edge(k,i,graph[k][i]));
                temp = minPath + graph[k][i];
                if( temp < path[i]){
                   path[i] = temp; 
                }
       
            }
        }
    }
    public class Edge {
        public int a;
        public int b;
        public int weigth;
        public Edge(int a , int b ,int weigth){
            this.a = a;
            this.b = b;
            this.weigth = weigth;
        }
    }
    public class Heap {
        private Edge[] heap; // starting from 1
        private static final int CAPACITY = 2;
        private int size;
        protected boolean isMinHeap;

        public Heap(boolean isMin){  //for max heap give argument false
            this.isMinHeap = isMin;
            size=0;
            heap = new Edge[CAPACITY];
        }
        public Heap(boolean isMin,int cap){  //for max heap give argument false
            this.isMinHeap = isMin;
            size=0;
            heap = new Edge[cap];
        }
       
        public int size(){
            return this.size;
        }
        private void expandHeap(){
            Edge[] old = heap;
            heap = new Edge[heap.length*2];
            System.arraycopy(old, 1, heap, 1, size);
        }
        public void insert(Edge value){
            if( size == heap.length-1){
                expandHeap();
            }
            size++;
            int position = size;           
            if(isMinHeap){
                while( position > 1 && value.weigth < heap[position/2].weigth ) {
                    heap[position] = heap[position/2];
                    position = position/2;
                }
            }else{
                 while( position > 1 && value.weigth > heap[position/2].weigth ) {
                    heap[position] = heap[position/2];
                    position = position/2;
                }
            }
            heap[position] = value;
        }
        public Edge deleteTop() throws RuntimeException{
            if(size == 0){
                throw new RuntimeException();
            }
            Edge top=heap[1];
            heap[1]=heap[size];
            size--;
            movingDown(1);
            return top;
        }
        public Edge peek(){
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
        public void movingDown(int k){
            Edge temp = heap[k];
            int child;
            while( 2*k <= size ){
                child=2*k;
                if( child != size ){ // has sibling ?
                    if(isMinHeap){ // min heap
                        if( heap[child].weigth > heap[child+1].weigth ){ // take lesser child
                            child++;
                        }
                    }else{ // max heap
                        if( heap[child].weigth < heap[child+1].weigth ){ // take greater child
                            child++;
                        }
                    }
                }
                if( isMinHeap ){ //min heap
                    if( temp.weigth > heap[child].weigth ){
                            heap[k] = heap[child];  
                    }else{
                        break;
                    }
                }else{ // max heap
                    if( temp.weigth < heap[child].weigth ){
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
          for(int k = 1; k <= size; k++) out += heap[k].weigth+" ";
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
    
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out),true);
        int n = sc.nextInt();
        int[][] graph = new int[n][n];
        for(int i = 0 ; i < n ; ++i){
            for(int y = 0 ; y < n ; ++y){
                graph[i][y] = sc.nextInt();
            }
        }
        int m  = sc.nextInt();
        int start;
        int destination;
        LowCostFlights lc = new LowCostFlights();
        for(int i = 0 ; i < m ; ++i){
            start = sc.nextInt();
            destination = sc.nextInt();
            int temp = lc.shortestPath(start, destination, graph);
            if( temp == Integer.MAX_VALUE){
                out.println("NO WAY");
            }else{
                out.println(temp);
            }
        }
    }
    
}