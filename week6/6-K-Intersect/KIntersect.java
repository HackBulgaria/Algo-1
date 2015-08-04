
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;


/**
 *
 * @author qvka
 */
public class KIntersecti {

    
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out),true);
        int n  = sc.nextInt();
        int value,key;
        String line;
        HashMap<Integer,Integer> map = new HashMap();
        Set<Integer> s = new HashSet();
        StringTokenizer tokenizer;
        for(int i = 0 ; i < n ; ++i){
            tokenizer = new StringTokenizer(sc.nextLine()," ");
            s.clear();
            while(tokenizer.hasMoreTokens()){
                s.add( Integer.parseInt(tokenizer.nextToken()));
            }
            for(int setEntry : s){
                if(!map.containsKey(setEntry)){
                    map.put(setEntry, 1);
                }else{
                    map.put(setEntry, map.get(setEntry)+1);
                }
            }
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            key = entry.getKey();
            value = entry.getValue();
            if(value == n){
                out.println(key);
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
    
}