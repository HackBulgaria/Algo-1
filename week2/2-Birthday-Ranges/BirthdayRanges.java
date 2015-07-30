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
public class BirthdayRanges {
     public static int[] getRanges(int[] list, int[] from, int[] to){
        int[] birthdays = new int[366];  
        int sum;
        int temp;
        int index;
        for(int i = 0 ; i <list.length ; i++){   // n = list.length
            index = list[i];
            birthdays[index]++;
        }
        sum=0;
        for(int i = 0 ; i <birthdays.length ; i++){
            sum+=birthdays[i];
            birthdays[i]=sum;
        }
        int[] result = getValuesInRange(birthdays,from,to );
       /* int min,max;
        int[] result = new int[pairs.length]; 
        for(int i = 0 ; i< pairs.length;i++){  // m*365
            min=pairs[i].a;
            max=pairs[i].b;
            sum=0;
            for(int m=min ; m <= max ; m++){   //
                sum+= birthdays[m];
            }
            result[i]=sum;
        }*/
       // return result;   // n + 365m
        return result;
    }
    private static int[] getValuesInRange(int[] array,int[] from,int[] to){
        int begin,end; // indexes of the range;
        int[] result=new int[from.length];
        for(int i = 0 ; i < from.length; i++){
            begin=from[i];
            end=to[i];
            if(begin==0){
               result[i]=array[end]; 
            }else{
                result[i]=array[end]-array[begin-1];
            }
        }
        return result;
    }
    public class Pair {
    public int a;
    public int b;
    public Pair(){
        
    }
    public Pair(int a,int b){
        this.a=a;
        this.b=b;
    }
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            Scanner sc= new Scanner (System.in);
        int m,n;
        
            n=sc.nextInt();
            m=sc.nextInt();
            int[] sequence = new int[n];
            for(int i = 0 ; i < n ; i++){
                sequence[i]=sc.nextInt();
                }
            //int temp1,temp2;
     //       BirthdayRanges br=new BirthdayRanges(sequence);
            //Pair[] pairs=new Pair[m];
            int[] arr1=new int[m];
            int[] arr2=new int[m];
            for(int i = 0; i<m ;i++){
                arr1[i]=sc.nextInt();
                arr2[i]=sc.nextInt();
            //    Pair temp = new Pair();
              //  pairs[i]=new Pair(temp1,temp2);
              //pairs[i].a= sc.nextInt();
              //pairs[i].b=sc.nextInt();
                
            //    System.out.println( br.count(temp1, temp2));
            }
            //BirthdayRanges br = new BirthdayRanges();
          int[] a= BirthdayRanges.getRanges(sequence, arr1,arr2);
        for(int r: a){
            System.out  .println(r);
        }
    }
    
}