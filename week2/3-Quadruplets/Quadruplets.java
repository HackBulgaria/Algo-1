import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 *
 * @author qvka
 */

public class Week2Quadruplets {
     
     public static int binarySearch(int[] a,int num,int l,int r){
        int mid;
        while(l <= r) {
            mid=  l+ (r-l)/2;
            if(a[mid] > num){
                r=mid-1;
            }else if(a[mid] < num){
                l=mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }
    public static int get(int[] a, int[] b,int[] c,int[] d){
        int index=0;
        int temp;
        int firstIndex,lastIndex,range,midIndex;
        int counter=0;
        int[] store = new int[a.length*b.length];
        for(int a1=0; a1<b.length; a1++){
            for(int b2=0; b2<a.length;b2++){
                store[index]=a[a1] + b[b2];
                index++;
            }
        }
        Arrays.sort(store);
        for(int c3=0; c3<c.length; c3++){
            for(int d4=0; d4<d.length; d4++){
                temp =  ( c[c3]+d[d4]);
                midIndex=binarySearch(store, -temp,0,store.length-1);
                if( midIndex == -1){
                    continue;
                }
                firstIndex=midIndex;
                // if its not the 0-th element and the left one is the same
                // we continue binary searching to the left
                while(firstIndex > 0 && (store[firstIndex] == store[firstIndex-1])){
                    firstIndex=binarySearch(store, -temp, 0, firstIndex-1);

                }
                 lastIndex=midIndex;
                 //we do the same check but for the right

                 while(lastIndex < store.length-1 && (store[lastIndex] == store[lastIndex+1]) ){
                     lastIndex=binarySearch(store, -temp, lastIndex+1, store.length-1);
                 }

               range = (lastIndex-firstIndex) +1;

                counter+= range;

            }
        }

        return counter;
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
        MyScanner sc= new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out),true);
        int n;
        n=sc.nextInt();
        int[][] matrix=new int[4][n]; 
        for(int i = 0 ; i< 4 ; i++){
            for(int y=0 ; y < n ; y++){
                matrix[i][y]=sc.nextInt();
            }
        }
  
        out.println(get(matrix[0], matrix[1], matrix[2], matrix[3]));

    }
    
}