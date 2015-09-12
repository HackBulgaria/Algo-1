import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author qvka
 */
public class BinarySearchTree {
    private boolean isBST = true;
    private int[] array; // root at 1 ; current Min at 0
    private int size;
    public BinarySearchTree(int[] array){
        this.size = array.length;
        this.array = new int[size+1];
        System.arraycopy(array, 0, this.array, 1, size);
        this.array[0] = Integer.MIN_VALUE; // current min;
    }
    public boolean isBinarySearchTree(){
        inOrder(1);    
        return isBST;
    }
    public void inOrder(int k){
        //botoom
        if( (!isBST) || (k > size) || (array[k] == 0) ){
            return; 
        }
        //visit left child
        inOrder(k*2);
        //check if valid bst
        if( array[0] > array[k]){
            isBST = false;
        }else{
            array[0] = array[k];
        }
        //visit right child
        inOrder((k*2)+1);
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
    
    public static void main(String[] args){
        MyScanner scanner = new MyScanner();
        int n = scanner.nextInt();
        int[] array = new int[n];
        for(int i = 0 ; i < n ; ++i){
            array[i] = scanner.nextInt();
        }
        BinarySearchTree bst = new BinarySearchTree(array);
        if(bst.isBinarySearchTree()){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}