/*
ID: zhing
LANG: JAVA
PROG: sprime
*/
import java.io.*;
import java.util.*;

class sprime {
	static int[] array1={2,3,5,7};
	static int[] array2={1,3,7,9};
	static int N;
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader f = new BufferedReader(new FileReader("sprime.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        //int i1 = Integer.parseInt(st.nextToken());    // first integer
        //int i2 = Integer.parseInt(st.nextToken());    // second integer
        //out.println(i1+i2);                           // output result
        
        N=Integer.parseInt(st.nextToken());
        
        dfs(0,0,out);
        
        out.close();
        System.exit(0);
    }
    static boolean isprime(int p){
 	   for(int i=2;i<=(int)Math.sqrt(p);i++)
 		   if(p%i==0) return false;
 	   return true;
    }
    static void dfs(int digit,int deep,PrintWriter out){
    	if(deep==0){
    		for(int i=0;i<4;i++)
    			dfs(array1[i],1,out);
    	}else if(deep==N){
    	    out.println(digit);
    	}else {
    		for(int i=0;i<4;i++){
    			int p=digit*10+array2[i];
    			if(isprime(p)) dfs(p,deep+1,out);
    		}
    	}
    }
}

