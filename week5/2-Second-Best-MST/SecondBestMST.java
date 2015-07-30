
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;



/**
 *
 * @author qvka
 */
public class SecondBestMST {
    private boolean[] visited;
    private int[][] visitedEdges;

    private LinkedList<Edge> path;
    private Heap heap;
    public SecondBestMST(int size){
        visited = new boolean[size];
        heap = new Heap(true); // min heap;
        visitedEdges = new int[size][size];
        path = new LinkedList<>();
    }
    public void getMinSpan(int[][] graph){
        int sum = 0;
        int vertex = 1;
        visited[0] = true;
        visited[1] = true;
        Edge temp;
        addEdgesToHeap(vertex,graph);
        while(heap.size() > 0){
            temp = heap.deleteTop();
            if( visited[temp.b] == false){
                visited[temp.b] = true;
                sum += temp.weigth;
                path.add(temp);
                visitedEdges[temp.a][temp.b]++;
                visitedEdges[temp.b][temp.a]++;
                addEdgesToHeap(temp.b, graph);
            }
        }
        heap = new Heap(true);
        int secondBest = getSecondBestMST(graph);
       
        System.out.println(sum + secondBest );
    }
    public int countEdges(int[][] graph , int k){
        int counter = 0;
        for(int i = 1 ; i < graph[k].length ; ++i){
            if( visitedEdges[k][i] == 1){
                counter++;
            }
        }
        return counter;
    }
    public int getSecondBestMST(int[][] graph){
        Edge temp;
        int a;
        int b;
        int current;
        Edge secondBestEdge;
        int currentMin = Integer.MAX_VALUE;
        int difference;
        int min = Integer.MAX_VALUE;
        int aEdges;
        int bEdges;
        while(!path.isEmpty()){
            temp = path.poll();
            a = temp.a;
            b = temp.b;
            current = temp.weigth;
           
            aEdges = countEdges(graph, a);
            bEdges = countEdges(graph, b);
            if(aEdges > 1){
                addEdgesToHeap2(b, graph);
                //a can be disconnected , add edges of b
                
            }
            if(bEdges > 1){
                // b can be disconnected , add edges of a
                addEdgesToHeap2(a, graph);
            }
            if(heap.size > 0){
                secondBestEdge = heap.deleteTop();
                heap = new Heap(true);
                currentMin = secondBestEdge.weigth - current;

                if( min > currentMin){
                    min = currentMin;
                }
            }
        }
        return min;
    }
    public void addEdgesToHeap2(int vertex,int[][] graph){
        for(int i = 1 ; i < graph[vertex].length ; ++i){
            if( visitedEdges[vertex][i] == 0 && graph[vertex][i] != 0){
                heap.insert(new Edge(vertex,i,graph[vertex][i]));
            }
        }
    }
    public void addEdgesToHeap(int vertex,int[][] graph){
        for(int i = 1 ; i < graph[vertex].length ; ++i){
            if( visited[i] == false && graph[vertex][i] != 0){
                heap.insert(new Edge(vertex,i, graph[vertex][i]));
               // visited[i] = true;
            }
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
  
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        int[][] graph = new int[n][n];
        int first , second , length;
        for(int i = 0 ; i< n; i++){
            first = sc.nextInt();
            second = sc.nextInt();
            length = sc.nextInt();
            graph[first][second] = length;
            graph[second][first] = length;
        }
        SecondBestMST ps = new SecondBestMST(graph.length);
        ps.getMinSpan(graph);
    }
    
}