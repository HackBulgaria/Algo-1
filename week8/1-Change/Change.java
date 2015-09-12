
import java.util.Scanner;


/**
 *
 * @author qvka
 */
public class ChangeCoins {
    private int[][] visited;
    private int[] arr = {1,2,5,10,20,50,100};
    private int totalSum;
   
    public  void possiblePermutations(int n){
        totalSum = 0;
        Scanner sc = new Scanner(System.in);
        visited = new int[n+1][arr.length];
        
        int sum = n; //sc.nextInt();
        
        sum(sum,6);
        System.out.println(totalSum);
    }
   
    public void sum(int sum , int coin){
        if( sum == 0 || coin == 0){
            totalSum++;
            return;
        }
        for(int i = 0 ; i<= coin ; ++i){
            if( sum >= arr[i]){
                sum( sum-arr[i] , i);
            }
        }
       
    }
    public int sum2(int n){
        visited = new int[n+1][arr.length];
        return sum2(n,6);
    }
    public int sum2(int sum , int coin){
        if( sum == 0 || coin == 0){
            visited[sum][coin] = 1;
            return 1;
        }
        if(visited[sum][coin] != 0 ){
            return visited[sum][coin];
        }else{
            int total = 0;
            for(int i = 0 ; i<= coin ; ++i){
                if( sum >= arr[i]){
                   total += sum2( sum-arr[i] , i);
                }
            }
            visited[sum][coin] = total;
            return total;
        }
    }
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            ChangeCoins cc = new ChangeCoins();
       
            int n = sc.nextInt();
            int a = cc.sum2(n);
            System.out.println(a);
     
    }
        
    
}