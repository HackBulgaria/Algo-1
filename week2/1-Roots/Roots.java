public class Roots {

  // Finds the square root of a number using binary search.
  public static double findRoot(int n){
       double left = 1;
       double right = n;
       double mid = left + (right-left)/2;
       int counter=0;
       while (Math.abs((mid * mid) - n) > 0.000001) {
            mid = left + ( right - left ) / 2;
           if( (mid * mid) > n ){
                   right=mid;
           }else{
                  left= mid;
           }
           counter++;
       }
       if(counter >= 68){
           System.out.println(n +" steps : " + counter);
       }
       return mid;
  
    }
}
