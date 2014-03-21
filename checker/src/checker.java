/*
ID: zhing
LANG: JAVA
PROG: checker
*/
import java.io.*;
import java.util.*;

class checker {
	static int N,count=0;
	static int[] clo=new int[13];
	static int[] ls = new int[13*2];
	static int[] lp =new int[13*2];
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader f = new BufferedReader(new FileReader("checker.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("checker.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        //int i1 = Integer.parseInt(st.nextToken());    // first integer
        //int i2 = Integer.parseInt(st.nextToken());    // second integer
        //out.println(i1+i2);                           // output result
        N=Integer.parseInt(st.nextToken());
        
        //System.out.print(ls[0][0]);
        int[] array = new int[N];
        //for(int i=0;i<N;i++) array[i] =-1;
        dfs(array,0,out);    
        out.println(count);
        out.close();
        System.exit(0);
    }
    static void dfs(int[] array,int deep,PrintWriter out){
    	if(deep==N){
    		count++;
    		if(count<=3){
    			for(int i=0;i<N-1;i++){
    				out.print(array[i]+1+" ");
    			}
    			out.println(array[N-1]+1);
    		}
    	}
    	for(int i=0;i<N;i++){
    		if(safe(deep,i)){
    			array[deep]=i;
    			dfs(array,deep+1,out);
    			clo[i]=0;ls[deep+i]--;lp[deep-i+N]--;
    		}
    	}
    }
    static boolean safe(int x,int y){
    	if(clo[y]!=0||ls[x+y]!=0||lp[x-y+N]!=0) return false;
    	
    	clo[y]=1;ls[x+y]++;lp[x-y+N]++;
    	
    	return true;
    }
}

