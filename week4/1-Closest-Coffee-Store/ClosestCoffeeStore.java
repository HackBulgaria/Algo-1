
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
public class ClosestCoffeeStore {
    private boolean[] visited;
    Queue<Integer> q ;
    public ClosestCoffeeStore(){
        
    }
      // Finds the closest coffee store to a point.
    public int closestCoffeeStore(boolean[][] graph, boolean[] isCoffeStore, int startingPoint) {
      // ...
        q=new LinkedList();
        visited=new boolean[isCoffeStore.length];
      //  closestCoffeeStore(graph, isCoffeStore, startingPoint);
       
        int current=startingPoint;
        if(isCoffeStore[current]==true){
            return current;
        }
        
        q.add(current);
        while(!q.isEmpty()){
            int peek = q.peek();
            if(isCoffeStore[peek] == true){
                return peek; // exit success
            }
            visited[peek]=true;
            traverseChildren(peek, graph,isCoffeStore);
            q.poll();
        }
        
        
        return -1;
    }
    public void traverseChildren(int index , boolean[][] graph , boolean[] isCoffeStore){
        for(int i =0 ;i < graph[index].length;i++){
            
            if( graph[index][i] == true && visited[i] == false){
                q.add(i);
                visited[i]=true;
            }
           
        }
    }
  /*  public static class MyScanner {
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
        ClosestCoffeeStore c = new ClosestCoffeeStore();
        int n;
        int startingPoint;
        n=sc.nextInt();
      
        int[][] graph = new int[n][n];
        boolean[] isCoffeeStore = new boolean[n];
    }
    */
}