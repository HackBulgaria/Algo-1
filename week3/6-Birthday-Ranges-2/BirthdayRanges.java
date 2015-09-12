import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 *
 * @author qvka
 */
public class BirthdayRanges {
    private class Query{
        private int size;
        private int[] tree;
        private int realSize;
        public Query(int[] sequence){
          //  this.arr=new int[sequence.length];
          //  System.arraycopy(sequence, 0, arr, 0, sequence.length);
            size=sequence.length;
            setRealSize();
            this.tree = new int[realSize*2];
            buildTree(sequence);

        }
       private void setRealSize(){
           int temp= 1;
           while(temp < size){
               temp*=2;
           }
           this.realSize=temp;
       }
       private void buildTree(int[] arr){
          //first element of the array is at position realSize
           System.arraycopy(arr, 0, tree, realSize, size);

           // starting from the parent of the first element
           int nodeIndex=realSize-1;
           while(nodeIndex >=1){
                //the number of elements on each depth are equal to the first index 
               // on that depth
               
            
                   tree[nodeIndex]=tree[nodeIndex*2]+tree[nodeIndex*2+1];
             
               
               nodeIndex--;
           }

       }
       public void addAtIndex(int index ,int value){
           int position=realSize+index;
           int temp = tree[position];
           int difference;
           tree[position] += value;
           if(tree[position]<0){
               tree[position] = 0;
               difference = -temp;
           }else{
               difference = value;
           }
           position/=2; // going up to the parent till root
           while(position >= 1 ){
               tree[position] += difference;
               position/=2;
           }
       }
       // start inclusive , end exclusive
       public int sumAtRange(int start,int end){

           int totalSum=0; // from 0 to end-1
           int redundancySum=0; //from 0 to begin;
           // calculate total sum
           totalSum = sumAtRange(end);
           redundancySum = sumAtRange(start);

           return totalSum-redundancySum;
       }
       private int sumAtRange(int end){
           int totalSum=0;
           if(end >= size){
               totalSum = tree[1]; // the root
           }else{

               int index = realSize+end;
                   while(index >= 1 ){ 
                   if(index%2!=0){ // is right child
                       totalSum += tree[index-1]; // we add left child to the sum
                   }
                   index= index/2; // going up
               }
           }
           return totalSum;
       }
       public void printTree(){
           for(int i = 1 ; i < tree.length ; i++){
               System.out.print(tree[i]+ " ");
           }
           System.out.println("");
       }
    }
    private Query qr;
    private int[] birthdays;
    public BirthdayRanges(int[] a){
        birthdays=new int[366];
        buildArray(a);
        qr=new Query(birthdays);
    }
    private void buildArray(int[] a){
        int day;
        for(int i = 0 ; i < a.length ; i++){
            day=a[i];
            birthdays[day]++;
    }
         
      
    
        
    }
    // adds people who are born on a specific day
    public void add(int day, int numberOfPeople) {
      qr.addAtIndex(day,numberOfPeople);
    }

    // removes people who are born on a specific day
    public void remove(int day, int numberOfPeople) {
      //  int temp=-1*numberOfPeople;
        qr.addAtIndex(day,-numberOfPeople);
      // ...
    }

    // returns the number of people born in a range
    /**
     * 
     * @param startDay inclusive
     * @param endDay inclusive
     * @return 
     */
    public int count(int startDay, int endDay) {
        return qr.sumAtRange(startDay, endDay+1);
    }
    public void print(){
        qr.printTree();
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
    
    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out),true);
        int size;
        int commands;
        String command;
        size = sc.nextInt();
        commands = sc.nextInt();
        int[] arr = new int[size];
        for(int i = 0 ; i < size ; i++){
            arr[i]= sc.nextInt();
        }
        BirthdayRanges br= new BirthdayRanges(arr);
        
        int temp1,temp2;

        for(int i = 0 ; i < commands; i++){
            command = sc.next();
            temp1 = sc.nextInt();
            temp2 = sc.nextInt();
            switch(command){
                case "count" :{
                    out.println(br.count(temp1, temp2));
                }break;
                case "add" : {
                    br.add(temp1, temp2);
                }break;
                case "remove" : {
                    br.remove(temp1, temp2);
                }break;
            }
        } 
        
    }
    
    
}