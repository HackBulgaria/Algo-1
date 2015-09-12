
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;



/**
 *
 * @author qvka
 */
public class LongestSubsequence {

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        StringBuilder sb = new StringBuilder();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out),true);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; ++i){
            arr[i] = sc.nextInt();
        }
      
        int[] path = new int[n];
        int[] seqSize = new int[n];
        seqSize[0] = 1;
        path[0] = -1;
        int maxIndex = 1;
        int currentMax = -1;
        int max = 0;
        for(int i = 1 ; i < n ; ++i){
            max = -1;
            currentMax = 0;
            boolean hasSeq = false;
            for(int y = i-1 ; y >= 0 ; y--){
                if( arr[y] < arr[i]){
               
                    if( seqSize[y] > max){
                        currentMax = y; // new current max
                        max = seqSize[y];
                        hasSeq = true;
                    }
                }
            }
            if( !hasSeq){
                path[i] = -1;
                seqSize[i] = 1;
            }else{
                path[i] = currentMax;
                seqSize[i] = 1 + seqSize[currentMax];
                if( seqSize[i] > seqSize[maxIndex]){
                    maxIndex = i;
                }
            }
        }
        int size = seqSize[maxIndex];
        int[] result = new int[size];
        System.out.println(size);
        for(int i = size-1 ; i >= 0 ; --i){
            result[i] = arr[maxIndex];
            maxIndex = path[maxIndex];
        }
        
        for(int a : result){
            sb.append(a).append(" ");
        }
        sb.delete(sb.length()-1, sb.length());
        out.println(sb);
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