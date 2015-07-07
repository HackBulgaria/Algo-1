
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;


/**
 *
 * @author qvka
 */
public class PhoneNumbers {
 
 //   private TreeMap<Integer , Integer> map;
    class Graph{
        private Queue<Integer> q;
        private boolean[] visited;
        public Graph(int size){
            q=new LinkedList<>();
            visited= new boolean[size]; 
        }
        
        public int go(int[][] graph , int pos){
            q.add(pos);
            int counter=0;
            int temp;
            for(int index = 0 ; index < graph.length ; index++){
                if(visited[index] == true){
                    continue;
                }
                while(!q.isEmpty()){
                    temp = q.poll();
                    visited[temp]= true;
                    visitChildren(graph, temp);
                    counter++;
                }
            }
            return counter;
        }
        
        public void visitChildren(int[][] graph, int pos){
            for(int col = 0; col < graph[pos].length ; col++){
                if( visited[col] == false  && graph[pos][col] == 1){
                    q.add(col);
                    visited[col]=true;
                }
                
                
            }
        }
    }
   
    
 
    public void getNumbers(){
        Scanner sc = new Scanner(System.in);
        TreeMap<Integer,Integer> tree = new TreeMap();
        int numberOfPpl;
        int phoneNum;
        numberOfPpl = sc.nextInt();
        // map of phone numbers and corespondng indexes
        for(int i = 0 ; i < numberOfPpl ; i++){
            phoneNum = sc.nextInt();
            tree.put(phoneNum, i);
        }
        int temp;
        // adding graph values
        int[][] graph = new int[numberOfPpl][numberOfPpl];
        for(int i = 0 ; i < numberOfPpl ; i++){
            temp = sc.nextInt();
            for(int y = 0 ; y < temp; y++){
                int index = tree.get(sc.nextInt());
                graph[i][index]=1;
                graph[index][i]=1;
            }
        }
        
        //print graph
        for(int row = 0 ; row < numberOfPpl ; row++){
            for(int col = 0 ; col < numberOfPpl ; col++){
                System.out.print(graph[row][col]+" ");
            }
            System.out.println("");
        }
        Graph gr = new Graph(numberOfPpl);
        int result= gr.go(graph, 0);
        System.out.println(result);
     //   for(int i = 0 ; i < n-1 ; i++){
            
      //  }
    
        // System.out.println(tree.root.left.element.value);
    }
    public static void main(String[] args) {
        PhoneNumbers p = new PhoneNumbers();
        p.getNumbers();
       
        
                 
              
                 
    }
    
}
