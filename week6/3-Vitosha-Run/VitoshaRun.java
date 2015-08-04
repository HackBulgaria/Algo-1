
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



/**
 *
 * @author qvka
 */
public class VitoshaRun {

    public int findShorthestPath(int startA, int startB , int finishA , int finishB , int[][] matrix){
        int n = matrix.length;
       
        boolean[][] visited = new boolean[n][n];
        int[][] currentDistance = new int[n][n];
        for(int i = 0 ; i < n ; ++i){
            Arrays.fill(currentDistance[i], Integer.MAX_VALUE);
        }
        Vertex current;
        PriorityQueue<Vertex> heap = new PriorityQueue();
        heap.offer( new Vertex(startA, startB, 0));
        while(!heap.isEmpty()){
            current = heap.poll();
            if( visited[ current.a][current.b] == false){
                visited[current.a][current.b] = true;
                if( visited[finishA][finishB] == true){
                    break;
                }
                addNeighbours(heap,current,matrix,visited,currentDistance);
            }
        }
        if(visited[finishA][finishB] == true){
            return currentDistance[finishA][finishB];
        }else{
            return -1;
        }
    }
    private void addNeighbours(PriorityQueue<Vertex> heap,Vertex current, int[][] matrix,boolean[][] visited , int[][] currentDistance ){
        int row,col;
        row = current.a-1;
        int weigth;
        for(int i = 0 ; i < 3 ; ++i){
            col = current.b-1;
            for(int y = 0 ; y < 3 ; ++y){
                if( (row > -1) && (row < matrix.length) && (col > -1) && (col < matrix.length)){
                    if(visited[row][col] == false){
                        weigth = Math.abs ( matrix[current.a][current.b] - matrix[row][col]) +1;
                        weigth += current.weigth;
                        if( weigth < currentDistance[row][col]){
                            currentDistance[row][col] = weigth;
                            heap.offer(new Vertex(row,col,weigth));
                        }
                    }
                }
                col++;
            }
            row++;
        }
    }
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        int startRow = sc.nextInt();
        int startCol = sc.nextInt();
        int finishRow = sc.nextInt();
        int finishCol = sc.nextInt();
        int[][] matrix = new int[n][n];
        for(int i = 0 ; i < n ; ++i){
            for (int y = 0 ; y < n ; ++y){
                matrix[i][y] = sc.nextInt();
            }
        }
        VitoshaRun vr = new VitoshaRun();
        int minutes = vr.findShorthestPath(startCol, startCol, finishCol, finishCol, matrix);
        System.out.println(minutes);
    }
    public class Vertex implements Comparable<Vertex>{
        public int a;
        public int b;
        public int weigth;
        public Vertex( int a , int b, int weigth){
            this.a = a;
            this.b = b;
            this.weigth = weigth;
        }

        @Override
        public int compareTo(Vertex o) {
            if( this.weigth > o.weigth){
                return 1;
            }else if( this.weigth < o.weigth){
                return -1;
            }else{
                return 0;
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