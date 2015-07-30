
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 *
 * @author qvka
 */
public class Castaway {
    private char[][] map;
    private ArrayList<Integer>[] graph;
    private Pair[] coordinates;
    private boolean[][] visited;
    private int[] path;
    private int m,n,h;
    private Pair start,finish;
    private Queue<Integer> q;
    public void go(){
        MyScanner sc = new MyScanner();
        n = sc.nextInt();
        m = sc.nextInt();
        path = new int[28]; // 26 start  , 27 finish
        Arrays.fill(path, -1);
        coordinates = new Pair[28];
        q = new LinkedList();
        start = new Pair(sc.nextInt(),sc.nextInt());
        finish = new Pair(sc.nextInt(),sc.nextInt());
        map = new char[n][];
        String temp;
        for(int i = 0; i < n ; ++i){
            temp = sc.nextLine();
            map[i]= temp.toCharArray();
        }
        h = sc.nextInt();
        char ch;
        for(int i = 0 ; i < n ; ++i){
            for(int y = 0 ; y < m ; ++y){
                ch = map[i][y];
                if( Character.isAlphabetic(ch)){
                    coordinates[ (int)ch -97] = new Pair(i,y);
                }
            }
        }
        visited = new boolean[n][m];
        coordinates[26] = new Pair(start.a,start.b);
        coordinates[27] = new Pair(finish.a,finish.b);
        graph = new ArrayList[26];
        for(int i = 0 ; i < 26 ; ++i){
            graph[i] = new ArrayList();
        } 
        int vert,child;
        for(int i = 0 ; i < h ; ++i){
            vert = (int)sc.next().charAt(0) - 97;
            child = (int)sc.next().charAt(0) - 97;
            graph[vert].add(child);
            graph[child].add(vert);
        }
        
        q.add( 26 );
        visited[ start.a][ start.b] = true;
        int current;
        char symbol;
        while(!q.isEmpty() && visited[finish.a][finish.b] == false){
            current = q.poll();
            symbol = map[ coordinates[current].a][ coordinates[current].b];
            if( Character.isAlphabetic(symbol) ){
                addSeaNeighbours(current);
            }
            addLandNeighbours(current);
         
        }
        if(visited[finish.a][finish.b] == false){
            System.out.println("NNnoooo");
        }else{
            int counter = 0;
            int backTrack = 27;
            while (backTrack != 26){
                backTrack = path[backTrack];
                counter++;
            }
            System.out.println(counter);
        }
        int asd = 213;
    }
    public void addSeaNeighbours(int p){
        int index = (int)map[coordinates[p].a][coordinates[p].b] - 97;
        int child,x,y;
        for(int i = 0 ; i < graph[index].size() ; ++i){
            child = graph[index].get(i);
            x = coordinates[child].a;
            y = coordinates[child].b;
            if( visited[x][y] == false){
                visited[x][y] = true;
                q.add(child);
                path[child] = p;
            }
        }
    }
    public void addLandNeighbours(int p){
        int child,x,y;
        x = coordinates[p].a;
        y = coordinates[p].b;
        Queue<Pair> landQ = new LinkedList();
        Pair temp;
        landQ.add(new Pair(x,y));
        char ch;
        while(!landQ.isEmpty()){
            temp = landQ.poll();
            ch = map[temp.a][temp.b];
            if ( finish.a == temp.a && finish.b == temp.b){
                visited[temp.a][temp.b] = true;
                path[27] = p;
                break;
            }
            if ( Character.isAlphabetic(ch)){
                if(ch != map[x][y]){
                    q.add( (int)ch - 97);
                    path[ (int)ch - 97] = p;
                }
            }
            bfs(temp,landQ);
        }
        
        
    }

  
    public void bfs(Pair p , Queue<Pair> que){
        if( p.b > 0 && map[p.a][p.b-1] !='.' ){ //check left
            if( visited[p.a][p.b-1] == false){
                visited[p.a][p.b-1] = true;
                que.add(new Pair(p.a,p.b-1));
            }
            
        }
        if( p.b < m-1 && map[p.a][p.b+1] !='.'){ // check right
            if( visited[p.a][p.b+1] == false){
               visited[p.a][p.b+1] = true;
               que.add(new Pair(p.a,p.b+1));
            }
        }
        if( p.a > 0 && map[p.a-1][p.b] !='.'){ // check right
            if( visited[p.a-1][p.b] == false){
               visited[p.a-1][p.b] = true;
               que.add(new Pair(p.a-1,p.b));
            }
        }
        if( p.a < n-1 && map[p.a+1][p.b] !='.'){ // check right
           if( visited[p.a+1][p.b] == false){
               visited[p.a+1][p.b] = true;
               que.add(new Pair(p.a+1,p.b));
            }
        }
    }

    public static void main(String[] args) {
        Castaway c = new Castaway();
        c.go();
        
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
    public class Pair{
        public int a;
        public int b;
        public Pair(int a ,int b){
            this.a = a;
            this.b = b;
        }
    }
}