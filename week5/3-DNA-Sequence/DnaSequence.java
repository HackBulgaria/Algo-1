
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *
 * @author qvka
 */
public class DnaSequence {
    private String[][] graph;
    private boolean[][] visitedEdges;
    private StringBuilder sb = new StringBuilder();
    private int[] edges;
    private HashMap<String,Integer> map;
    private ArrayList<String> names;
    private int n;
    public void go(){
        
        getData();
        int pos = getStartingPoint();
        int asad=214;
        if(pos == -1){
            System.out.println("IMPOSSIBLE");
            return;
        }
        findEulerPath(pos);
    }
    private void findEulerPath(int start){
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out),true);
        int current = start;
        sb.append( names.get(start));
        int next;
        int counter = 0;
        do{
            next = findLegitPath(current);
            if( next != -1){
                sb.append( graph[current][next]).append( names.get(next));
                counter++;
                current = next;
            }
        }while( next != -1);
        if( counter == n){
            out.println(sb.toString());
        }else{
            out.println("IMPOSSIBLE");
        }
    }
    private int findLegitPath(int vertex){
        boolean isBridge = true;
        for(int i = 0 ; i < graph[vertex].length ; ++i){
            if( graph[vertex][i] != null && visitedEdges[vertex][i] == false){
                if( edges[vertex] == 1){  // if the current vertex has only one path we take it
                    isBridge = false;
                }else if( edges[i] == 1){ // if the current vertex has more paths we dont take the dead end
                    isBridge = true;
                }else{
                    isBridge = isBridge(vertex,i);  // we check to see if this edge is a bridge
                }
            }
            if( !isBridge){
                visitedEdges[vertex][i] = true;
                visitedEdges[i][vertex] = true;
                edges[vertex]--;
                edges[i]--;
                return i; // we return the index of the vertex if its not a bridge 
            }
        }
        return -1;  // return -1 if its a bridge
    }
    private boolean isBridge(int first, int second){
        int size = visitedEdges.length;
        boolean[][] visited = new boolean[size][size];
        for(int i = 0 ; i < size ; ++i){
            System.arraycopy(visitedEdges[i], 0, visited[i] , 0, size);
        }
        visited[first][second] = true;
        visited[second][first] = true;
        int edge;
        Queue<Integer> q = new LinkedList();
        q.add(first);
        while(!q.isEmpty()){ // if we can reach second by other path its not a bridge
            edge = q.poll();
            if( edge == second ){
                return false;
            }
            bfs(edge,q,visited);
        }
        return true;
    }
    private void bfs(int vertex, Queue<Integer> q , boolean[][] visited){
        int edge;
        for(int i = 0 ; i < graph[vertex].length ; ++i){
            if( graph[vertex][i] != null && visited[vertex][i] == false){
                q.add(i);
                visited[vertex][i] = true;
                visited[i][vertex] = true;
            }
        }
    }
    private int getStartingPoint(){
        int count = 0 ;
        int pos = 0 ;
        for(int i = 0 ; i < edges.length ; ++i){
            if( edges[i] % 2 == 1){
                pos = i;
                count++;
            }
        }
        if( count == 2 || count ==0){
            return pos;
        }else{
            return -1;
        }
    }
    private void getData(){
        MyScanner sc = new MyScanner();
        n = sc.nextInt();
        names = new ArrayList();
        map = new HashMap();
        sb = new StringBuilder();
        String[] dnaSamples = new String[n];
        int index = 0;
        int firstIndex;
        int secondIndex;
        String dna,first,mid,second;
        for(int i = 0 ; i < n ; ++i){
            dna = sc.next();
            dnaSamples[i] = dna;
            first = dna.substring(0,3);
            second = dna.substring( dna.length()-3);
            if(!map.containsKey(first)){
                map.put(first, index);
                names.add(first);
                index++;
            }
            if(!map.containsKey(second)){
                map.put(second,index);
                names.add(second);
                index++;
            }
        }
        graph = new String[index][index];
        visitedEdges = new boolean[index][index];
        edges = new int[index];
        for(int i = 0 ; i < n ; ++i){
            dna = dnaSamples[i];
            first = dna.substring(0,3);
            mid = dna.substring(3, dna.length()-3);
            second = dna.substring( dna.length()-3);
            firstIndex = map.get(first);
            secondIndex = map.get(second);
            graph[firstIndex][secondIndex] = mid;
            graph[secondIndex][firstIndex] = mid;
            edges[firstIndex]++;
            edges[secondIndex]++;
        }
    }
    public static void main(String[] args) {
        DnaSequence dna = new DnaSequence();
        dna.go();
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