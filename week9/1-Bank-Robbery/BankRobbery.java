
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 *
 * @author qvka
 */
public class BankRobbery {
    private boolean[][] graph;
    private int[] robberVisited;
    private int[] policeVisited;
    private int[] path;
    private int bank;
    private int police;
    private int helicopter;
    public void go(){
        getData();
        int robberPath = getShortestPath(bank, helicopter, robberVisited) ;
        int policePath = getShortestPath(police, helicopter, policeVisited);
        System.out.println(policePath - robberPath - 1);
    }
    private void getData(){
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        int m = sc.nextInt();
        n++; // not zero based
        graph = new boolean[n][n];
        robberVisited = new int[n];
        Arrays.fill(robberVisited, -1);
        policeVisited = new int[n];
        Arrays.fill(policeVisited, -1);
        path = new int[n];
        int v1,v2;
        for(int i = 0 ; i < m ; ++i){
            v1 = sc.nextInt();
            v2 = sc.nextInt();
            graph[v1][v2] = true;
            graph[v2][v1] = true;
        }
        bank = sc.nextInt();
        police = sc.nextInt();
        helicopter = sc.nextInt();
    }
    private int getShortestPath(int start,int end, int[] visited){
        Queue<Integer> q = new LinkedList();
        q.add(start);
        int current;
        visited[start] = 0;
        while( !q.isEmpty()){
            current = q.poll();
            if(end == current){
                break;
            }
            addNeighboursToQ(q,current,visited);
        }
        return visited[end];
    }
    private void addNeighboursToQ(Queue<Integer> q, int vertex , int[] visited){
        for(int i = 0 ; i < graph[vertex].length ; ++i){
            if( graph[vertex][i] == true && visited[i] == -1){
                visited[i] = visited[vertex]+1;
                q.add(i);
            }
        }
    }
    public static void main(String[] args) {
        BankRobbery br = new BankRobbery();
        br.go();
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
    
}