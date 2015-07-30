import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;
/**
 *
 * @author qvka
 */
public class PhoneBook {
    
    // only testing time difference
    // not original solution
    public static class MyScanner{
        BufferedReader br;
        StringTokenizer st;
        public MyScanner(){
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
    }
    
    public static void main(String[] args) {
      PhoneBook p = new PhoneBook();
      TreeMap<Integer,String> map = new TreeMap();
      int n,m;
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out),true);
        n= sc.nextInt();
        m= sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; ++i){
            map.put(sc.nextInt(),sc.next());
        }
        
        for(int i = 0 ; i < m ; ++i){
            sb.append(map.get(sc.nextInt())).append("\n");
        }
        int last= sb.length();
        sb.delete(last-1 , last);
        out.println(sb.toString());
    }
    
}