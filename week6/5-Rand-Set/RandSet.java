
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


/**
 *
 * @author qvka
 */
public class RandSet {
    private ArrayList<Pair>[] hashTable;
    private int mod;
    private ArrayList<Integer> inserted;
    public RandSet(){
        this.mod = 1_300_021;
        this.inserted = new ArrayList();
        this.hashTable = new ArrayList[mod]; 
    }
    public int hash(int a){
        a = a%mod;
        return Math.abs(a);
    }
    public void insert(int a){
        int hash = hash(a);
        if(hashTable[hash] == null){
            hashTable[hash]= new ArrayList();
        }else{
            for(int i = 0 ; i < hashTable[hash].size(); ++i){
                if(hashTable[hash].get(i).number == a){
                    // duplicate
                    return;
                }
            }// if the cicle above completes it means no duplicate
            // we proceed and insert
        }
        // we add the element with his position to hashTable
        // we add element at that position in the inserted vector
        hashTable[hash].add(new Pair(a,inserted.size()));
        inserted.add(a);
         
    }
    public boolean contains(int a){
        //if inserted is empty its false
        if(inserted.isEmpty()){ 
            return false;
        }
        int hash = hash(a);
        if(hashTable[hash] == null){
            return false;
        }
        // check all collisions, if we find it return true
        for(int i = 0 ; i < hashTable[hash].size() ; ++i){
            if( hashTable[hash].get(i).number == a){
                return true;
            }
        }
       
        return false;
    }
    public void remove(int a){
        if(inserted.isEmpty()){
            return;
        }
        int hash = hash(a);
        int pos = -1;
        if( hashTable[hash] == null){
            return;
        }
        for(int i = 0 ; i < hashTable[hash].size() ; ++i){
            // if we find the element we get its position in the inserted
            // and we delete it
            if( hashTable[hash].get(i).number == a){
                pos = hashTable[hash].get(i).position;
                hashTable[hash].remove(i);
                break;
            }
        }
        
        // if its the last element , we just delete it
        if( pos == inserted.size()-1 ){
            inserted.remove(inserted.size()-1);
        }else{
            //else we swap inserted[pos] with inserted[last]
            // and update his position in the hash table;
            // size--;
            inserted.set(pos, inserted.get(inserted.size() -1) ); //set the last element at the deleted position
            inserted.remove(inserted.size()-1);
            hash = hash( inserted.get(pos));
            changePos(inserted.get(pos),hash,pos);
        }
    }
    public int random(){
        if(inserted.isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        int rndm = (int)(Math.random() * inserted.size());
        return inserted.get(rndm);
    }
    private void changePos(int num, int hash, int pos){
        for(int i = 0 ; i < hashTable[hash].size() ; ++i  ){
            if(  hashTable[hash].get(i).number == num){
                hashTable[hash].get(i).position = pos;
                break;
            }
        }
    }
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out),true);
        RandSet set = new RandSet();
        int n = sc.nextInt();
        String command;
       
        for(int i = 0 ; i < n ; ++i){
            command = sc.next();
            
            switch(command){
                case "insert" :{
                    set.insert(sc.nextInt());
                }break;
                case "remove" :{
                    set.remove(sc.nextInt());
                }break;
                case "contains" :{
                    out.println(set.contains(sc.nextInt()));
                }break;
                case "random" :{
                    out.println(set.random());
                }break;
            }
        }
    }
    public class Pair{
        public int number;
        public int position;
        public Pair(int a , int b){
            this.number = a;
            this.position = b;
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