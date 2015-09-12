import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;


/**
 *
 * @author qvka
 */
public class BuildScripts {
    private boolean hasLoop;
    private StringBuilder sb;
    ArrayList<Integer>[] graph; // i-th project - stores which projects it is dependant on
    String[] projectNames;  // get name by index
    int[] visited;
    TreeMap<String,Integer> map; 
    public void go(){
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out),true);
        sb = new StringBuilder();
        int n = sc.nextInt();
        int temp;
        int index;
        hasLoop = false;  //
        int mainProjIndex;
        visited = new int[n];
        graph= new ArrayList[n];  // i-th project - stores which projects it is dependant on
        projectNames = new String[n];  // get name by index
        map = new TreeMap(); // get index by name
        for(int i = 0 ; i < n ; ++i){
            projectNames[i] = sc.next();
            map.put(projectNames[i], i);
        }
        mainProjIndex = map.get(sc.next()); // root
        for(int i = 0 ; i < n ; ++i){
            temp = sc.nextInt();
            graph[i] = new ArrayList();
            for(int y = 0 ; y < temp; ++y){
                index = map.get(sc.next());
                graph[i].add(index);
            }
        }
        
        visitChildren(mainProjIndex);
        if(hasLoop){
            out.println("BUILD ERROR");
        }else{
            sb.delete(sb.length()-1, sb.length());
            out.println(sb.toString());
        }
    }
    public void visitChildren(int v ){
        if(hasLoop){
            return;
        }
        int proj;
        visited[v] = 1;  
        for(int i = 0 ; i < graph[v].size(); ++i ){
            proj = graph[v].get(i);
           
            if(visited[proj] == 0){ // not visited 
                visitChildren(proj);
            }
            if(visited[proj] == 1){
                hasLoop = true;
                return;
            }
           // visited[proj] = 0;
        }
        visited[v]=2;
        sb.append(projectNames[v]).append(" ");
    }
    public static void main(String[] args) {
        BuildScripts b = new BuildScripts();
        b.go();
        
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