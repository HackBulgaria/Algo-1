
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 *
 * @author qvka
 */
public class WordDictionary {
    private PrefixTree trie;
    public void go(){
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        String command;
        String word;
        trie = new PrefixTree();
        for(int i = 0 ; i < n ; ++i){
            command = sc.next();
            word = sc.next();
            switch(command){
                case "insert" : {
                    trie.insert(word);
                }break;
                case "contains" : {
                    System.out.println(trie.contains(word));
                }break;
            }
        }
        
    }
    public class PrefixTree{
        private Node root;
        public PrefixTree(){
            root = new Node();
        }
        public void insert(String a){
            Node current = root;
            int temp;
            for(int i = 0; i < a.length() ; ++i){
                temp = (int)a.charAt(i) - 97;
                if(current.children[temp] == null){
                    current.children[temp] = new Node();
                }
                current = current.children[temp];
            }
        }
        public boolean contains(String a){
            Node current = root;
            int temp;
            for(int i = 0 ; i < a.length() ; ++i){
                temp = (int)a.charAt(i) - 97;
                if( current.children[temp] == null){
                    return false;
                }
                current = current.children[temp];
            }
            return true;
        }
        class Node{
            Node[] children;
            public Node(){
               children = new Node[26];
            }
        }
        
    }
    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.go();
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