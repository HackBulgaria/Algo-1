import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 *
 * @author qvka
 */
public class ValidDirectories {
    private int visited[];
    private int[][] graph;
    private int n;
    private boolean isValidDir;
    public void go(){
        MyScanner sc = new MyScanner();
        n  = sc.nextInt();
        graph = new int[n][n];
        visited = new int[n];

        for (int i = 0 ; i < n ; ++i){
            for(int y = 0 ; y < n ; ++y){
                graph[i][y] = sc.nextInt();
            }
        }
        isValidDir = true;
        dfs(0);
        System.out.println(isValidDir);
    }
    public void dfs(int v){
        if(!isValidDir){
            return;
        }
        
        int temp;
        visited[v] = 1;
        for(int i = 0 ; i < n ; ++i){
            temp = graph[v][i];
            if(temp ==1 ){
                if(visited[i] == 0){
                    dfs(i);
                }else if( visited[i] == 1){
                    isValidDir = false;
                    return;
                }
                
            }
        }
        visited[v] = 2;
    }
    public static void main(String[] args) {
        ValidDirectories vd = new ValidDirectories();
        vd.go();
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