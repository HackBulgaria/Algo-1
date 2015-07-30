import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


/**
 * Range Minimum Query
 * @author qvka
 */
public class RMQ {
    private Query qr;
    
    //  O (m+ n + log2n) n=size m=realSize
    public RMQ(int[] sequence){
        qr=new Query(sequence);
    }
    /**
     * Complexity O(log2 n)
     * sets the value at index
     * @param index
     * @param value 
     */
  public void set(int index, int value) {
        qr.setAtIndex(index, value);
  }

  
  /**
   * Complexity O(log2 n)
   * @param startIndex inclusive
   * @param endIndex inclusive
   * @return the minimum value in a range
   */
  public int min(int startIndex, int endIndex) {
 
      return qr.minAtRange(startIndex, endIndex);
  }
  public void print(){
      qr.printTree();
  }
   
   private class Query{
            private int size;
       private int[] tree;
       private int realSize; //closest power of 2 greater or equal to size
       // O (m+ n + log2n) n=size m=realSize
       public Query(int[] sequence){
           
           size=sequence.length;
           setRealSize();
           this.tree = new int[realSize*2];
           buildTree(sequence);

       }
       /**
        * O(log2 n)
        */
       private void setRealSize(){
           int temp= 1;
           while(temp < size){
               temp*=2;
           }
           this.realSize=temp;
       }
        // O(m+n)  m=realSize n=size
       private void buildTree(int[] arr){
           // complexity of arraycopy is platform dependant but lets assume its O(size)
           System.arraycopy(arr, 0, tree, realSize, size);
           for(int i = realSize+size; i< tree.length ; i++){
               tree[i]=Integer.MAX_VALUE;
           }
           // starting from the parent of the first element
           int nodeIndex=tree.length/4;
           // O (n)  n=size
           while(nodeIndex >=1){
                //the number of elements on each depth are equal to the first index 
               // on that depth
               int size = nodeIndex;
               int temp = nodeIndex;
               for(int i = 0 ; i< size ; i++){
                  tree[temp]=(tree[temp*2]<tree[temp*2+1]) ?  tree[temp*2]:tree[temp*2+1];
                   temp++;
               }
               nodeIndex/=2;
           }

       }
       // O(log2 n)
       public void setAtIndex(int index ,int value){
           int position=realSize+index;
           tree[position]=value;
          
           position/=2; // going up to the parent till root
           while(position >= 1 ){
               tree[position] = (tree[position*2] < tree[position*2+1])? tree[position*2] : tree[position*2+1];
               position/=2;
           }
       }
       // start inclusive , end exclusive
       // O(log2 n)
       public int minAtRange(int start,int end){
           
          int left=realSize+start;
          int right=realSize+end;
          if(left==right){
              return tree[left];
          }
          int min=tree[left];
            while( left <= right ){
                 if(tree[left]< min){
                     min=tree[left];
                 }
                 if(tree[right]<min){
                     min=tree[right];
                 }
                //move left pointer
                if(left % 2 != 0) { 
                    left++;
                    left/=2;
                }else{
                    left/=2;
                }
                // move right pointer
                if(right % 2 ==0){
                    right--;
                    right/=2;
                }else{ 
                    right/=2;
                }
            }
          return min;
       }
      
       // O(n)
       public void printTree(){
           for(int i = 1 ; i < tree.length ; i++){
               System.out.print(tree[i]+ " ");
           }
           System.out.println("");
       }
    }
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
       MyScanner sc = new MyScanner();
       PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out),true);
       StringBuilder sb = new StringBuilder();
       RMQ rmq;
       int sizeOfArray;
       int numOfCommands;
       sizeOfArray=sc.nextInt();
       numOfCommands=sc.nextInt();
       int[] array=new int[sizeOfArray];
       
       for(int i = 0 ; i< sizeOfArray ; i++){
           array[i]=sc.nextInt();
       }
       rmq=new RMQ(array);
       int arg1,arg2;
       String command;
       for(int i = 0; i<numOfCommands ; i++){
           command=sc.next();
           arg1=sc.nextInt();
           arg2=sc.nextInt();
           switch(command){
               case "min": {
                   sb.append(rmq.min(arg1, arg2)).append("\n");
               }break;
                   
               case "set" : {
                   rmq.set(arg1, arg2);
               }break;
                   
               default :{
                   System.err.println("Invalid command");
               }break;
           }
       }
       int temp = sb.length();
       sb.delete(temp-1, temp);
       out.println(sb.toString());
   }
}