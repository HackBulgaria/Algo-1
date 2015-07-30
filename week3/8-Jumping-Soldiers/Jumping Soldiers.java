import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author qvka
 */
public class JumpingSoldiers {

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
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        int k = sc.nextInt();
        int temp;
        int num;
        int index;
        int counter;
        int maxCounter=0;
        int maxIndex=0;
        int[][] arr = new int[k][n];
        
        for(int i = 0 ; i < k ; ++i){
            counter = 0;
            arr[i][0] = sc.nextInt();
            for(int y = 1 ; y < n ; y++){
                arr[i][y] = sc.nextInt();
                index = y;
                while( (index > 0) && (arr[i][index-1] > arr[i][index])){
                    temp = arr[i][index-1];
                    arr[i][index-1] = arr[i][index];
                    arr[i][index] = temp;
                    counter++;
                    index--;
                }
            }
            if(maxCounter < counter){
                maxCounter = counter;
                maxIndex = i;
            }
        }
        System.out.println(maxIndex+1);
    }
    
}