
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 *
 * @author qvka
 */
public class NeedleHaystack {
    public static void countOccuurances(String text,String word){
        
        int i = 0;
        int size = text.length()-1;
        int j = word.length()-1;
        int hashWord = hash(word);
        int hash = hash(text.substring(i,word.length()));
        if(hash == hashWord){
            if( text.substring(i,word.length()).equals(word)){
                System.out.println(i);
            }
        }
        int temp ;
        int iVal;
        int jVal;
        //h(i+1,j+1) = (h(i,j) - value(i)*(BASE^(j-i))) * BASE + value(j+1)
       
        
        while( j < size ){
            iVal = (int)text.charAt(i) - 96;
            jVal = (int)text.charAt(j+1) - 96;
            hash =(hash - (iVal  *(int)Math.pow(200,word.length()-1)))*200 + jVal;
              i++;
              j++;
            if(hash == hashWord){
              
                if( text.substring(i,j+1).equals(word)){
                    System.out.println(i);
                }
            }
            
        }
        
    }
    public static int hash(String a){
        int hash = 0;
        int temp;
        char ch;
        for(int i = 0 ; i < a.length() ; ++i){
            ch = a.charAt(i);
            temp = (int) ch -96;
                                            
            temp = temp * (int)Math.pow(200, a.length()- 1 -i);
            hash += temp;
 
        }
        return hash;
    }
    public static void main(String[] args) {
 
        MyScanner sc = new MyScanner();
        String text = sc.nextLine();
        String word = sc.next();
        
        NeedleHaystack.countOccuurances(text, word);
     
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