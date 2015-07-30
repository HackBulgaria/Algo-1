import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author qvka
 */
public class PouringGlasses2 {
    private Queue<Tree.Node> q;
    private LinkedList<Integer> result;
    private Tree tree;
    private boolean[][] state;
    private final int[] c;
    private int g,w1,w2,w3;
    public PouringGlasses2(int c1, int c2, int c3 , int w1, int w2, int w3, int g){
        tree = new Tree(0,0,w1,w2,w3);
        this.c = new int[4];
        this.c[1] = c1;
        this.c[2] = c2;
        this.c[3] = c3;
        this.q = new LinkedList<>();
        this.g = g;
        this.w1 = w1;
        this.w2 = w2;
        this.w3 = w3;
        this.state = new boolean[c1+1][c2+1];
    }
    public void start(){
        boolean success = false;
        int[] w = new int[4];
        int tempFrom,tempTo;
        addChildrenToQ(tree.root);
        state[tree.root.a][tree.root.b] = true;
        Tree.Node node = null;
        while(!q.isEmpty()){
            node = q.poll();
            w[1] = node.w1;
            w[2] = node.w2;
            w[3] = node.w3;
            tempTo = w[node.a] + w[node.b];
            if(tempTo > c[node.b]){
                tempTo = c[node.b];
            }
            tempFrom = w[node.a] + w[node.b] -  c[node.b];
            if(tempFrom < 0){
                tempFrom = 0;
            }
            w[node.b] = tempTo;
            w[node.a] = tempFrom;
            node.w1 = w[1];
            node.w2 = w[2];
            node.w3 = w[3];
            if( node.w1 == g || node.w2 == g || node.w3 ==g){
                success = true;
                break;
            }
            if(state[node.w1][node.w2] == false){
                state[node.w1][node.w2] = true;
                addChildrenToQ(node);
            }
        }
        if(!success){
            System.out.println("IMPOSSIBLE");
            return;
        }
        StringBuilder sb = new StringBuilder();
        result = new LinkedList<>();
        while( node != tree.root){
            result.add(node.b);
            result.add(node.a);
            node = node.parent;
        }
        System.out.println(result.size()/2);
        while(!result.isEmpty()){
            sb.append(result.pollLast());
            sb.append(" ");
            sb.append(result.pollLast());
            sb.append("\n");
        }
        sb.delete(sb.length()-1, sb.length());
        System.out.println(sb.toString());
    }
    public void addChildrenToQ(Tree.Node node){
        int[] w = new int[4];
        w[1] = node.w1;
        w[2] = node.w2;
        w[3] = node.w3;
        if(w[1] != 0 && w[2] != c[2]){
            tree.addChildren(node, 1, 2,w[1],w[2],w[3]);
            q.add(node.children.getLast());
        }
        if(w[1] != 0 && w[3] != c[3]){
            tree.addChildren(node, 1, 3,w[1],w[2],w[3]);
            q.add(node.children.getLast());
        }
        if(w[2] != 0 && w[1] != c[1]){
            tree.addChildren(node, 2, 1,w[1],w[2],w[3]);
            q.add(node.children.getLast());
        }
        if(w[2] != 0 && w[3] != c[3]){
            tree.addChildren(node, 2, 3,w[1],w[2],w[3]);
            q.add(node.children.getLast());
        }
        if(w[3] != 0 && w[1] != c[1]){
            tree.addChildren(node, 3, 1,w[1],w[2],w[3]);
            q.add(node.children.getLast());
        }
        if(w[3] != 0 && w[2] != c[2]){
            tree.addChildren(node, 3, 2,w[1],w[2],w[3]);
            q.add(node.children.getLast());
        } 
    }
   
   
    class Tree{
        public Node root;
        public Tree(int a,int b,int w1,int w2,int w3){
            root = new Node(a,b,w1,w2,w3);
            root.parent=null;
            root.children = new LinkedList<>();
        }
        public class Node{
            int a;
            int b;
            int w1;
            int w2;
            int w3;
            Node parent;
            LinkedList<Node> children;
            public Node(int a,int b,int w1,int w2,int w3){
                this.a = a;
                this.b = b;
                this.w1 = w1;
                this.w2 = w2;
                this.w3 = w3;
                children = new LinkedList<>();
            }
        }
        public void addChildren(Node node, int a,int b,int w1,int w2,int w3){
            node.children.add(new Node(a,b,w1,w2,w3));
            node.children.getLast().parent = node;
        }
        
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c1,c2,c3,w1,w2,w3,g;
        c1 = sc.nextInt();
        c2 = sc.nextInt();
        c3 = sc.nextInt();
        w1 = sc.nextInt();
        w2 = sc.nextInt();
        w3 = sc.nextInt();
        g = sc.nextInt();
        if( w1 == g || w2 == g || w3 == g){
            System.out.println(0);
        }else{
             PouringGlasses2 pg = new PouringGlasses2(c1, c2, c3, w1, w2, w3, g);
             pg.start();
        }
    }
    
}