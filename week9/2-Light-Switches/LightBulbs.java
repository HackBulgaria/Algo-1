
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



/**
 *
 * @author qvka
 */
public class LightBulbs {
    public void go(){
        Scanner sc = new Scanner(System.in);
        int state = 0;
        String temp;
        int[] switches = new int[17];
        int bit;
        for(int i = 15 ; i >= 0 ; --i){
            temp = sc.next();
            if( temp.equals("on") ){
                    state = state | ( 1 << i);
            }  
        }
        int tempState;
        int num;
        for(int y = 1 ; y < 17 ; ++y){
            tempState = 0;
            for(int i = 15 ; i >= 0 ; --i){
                num = sc.nextInt();
                if( num == 1){
                    switches[ y ] = switches[y] | ( num << i); 
                }
            }
        }
       
        bfs(state , switches);
        
        int a = 1;
    }
    private void bfs(int state, int[] switches){
        boolean[] visited = new boolean[ (int)Math.pow(2, 16)];
        Tree tree = new Tree(state);
        Tree.Node current = null;
        Queue<Tree.Node> q = new LinkedList();
        q.add(tree.root);
        boolean isPossible = false;
        while( !q.isEmpty()){
            current = q.poll();
            if(current.state == 0){
                isPossible = true;
                break;
            }
            if( visited[current.state] == false){
                visited [current.state] = true;
                for(int i = 1 ; i < 17 ; ++i){
                    tree.addChild(current, i , switches);
                    q.add(current.children.getLast());
                    visited[current.state] = true;
                }
            }
        }
        if(!isPossible){
            System.out.println("Can't be done");
        }else{
            LinkedList result = new LinkedList();
            while( current.parent != null){
                result.add(current.switchIndex);
                current = current.parent;
            }
            StringBuilder sb = new StringBuilder();
            while(!result.isEmpty()){
                sb.append(result.pollLast()).append(" ");
            }
            sb.delete(sb.length()-1, sb.length());
            System.out.println(sb.toString());
        }
        
    }
    private int getState(int state , int index , int[] switches){
      // y = x ^ (1<<n)  toggle n-th bit
        state = state ^ switches[index];
        return state;
    }
    public static void main(String[] args) {
        LightBulbs lb = new LightBulbs();
        lb.go();
    }
    public class Tree{
        public Node root;
        public Tree(int state){
            this.root = new Node(state);
        }
        public class Node{
            private int state;
            private int switchIndex;
            private Node parent;
            private LinkedList<Node> children;
            public Node(int state){
                this.state = state;
                this.switchIndex = -1;
                this.children = new LinkedList();
            }
            public Node(int state , int switchIndex , int[] switches){
                this.switchIndex = switchIndex;
                this.state = getState ( state , switchIndex , switches);
                this.children = new LinkedList();
            }
        }
        public void addChild(Node current , int index , int[] switches){
            current.children.add( new Node( current.state , index , switches));
            current.children.getLast().parent = current;
        }
    }
    
}