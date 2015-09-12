import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;


/**
 *
 * @author qvka
 */
public class PhoneBook {

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
    
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out),true);
        MyScanner sc = new MyScanner();
        TreeMap<String,Integer> phoneBook = new TreeMap<>();
        int phoneNum;
        String name;
        String command;
        int n = sc.nextInt();
        for(int i = 0 ; i < n ; ++i){
            command = sc.next();
            switch(command){
                case "insert" :{
                    phoneNum = sc.nextInt();
                    name = sc.next();
                    phoneBook.put(name, phoneNum);
                }break;
                case "lookup" :{
                    name = sc.next();
                    if(phoneBook.containsKey(name)){
                        out.println(phoneBook.get(name));
                    }else{
                        out.println("NOT FOUND!");
                    }
                  
                }break;
                case "remove" :{
                    name = sc.next();
                    phoneBook.remove(name);
                }break;
                case "list"   :{
                    StringBuilder sb = new StringBuilder();
                    for(Map.Entry<String,Integer> entry : phoneBook.entrySet()) {
                        sb.append(entry.getKey());
                        sb.append(" ");
                        sb.append(entry.getValue());
                        sb.append("\n");
                    }
                    int temp = sb.length();
                    sb.delete(temp-1, temp);
                    out.println(sb.toString());
                }break;
            }
        }

    }
    
}