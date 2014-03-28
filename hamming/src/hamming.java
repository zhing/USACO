/*
ID: zhing
LANG: JAVA
PROG: hamming
*/
import java.io.*;
import java.util.*;

class hamming {
	static int N,B,D;
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader f = new BufferedReader(new FileReader("hamming.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hamming.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        //int i1 = Integer.parseInt(st.nextToken());    // first integer
        //int i2 = Integer.parseInt(st.nextToken());    // second integer
        //out.println(i1+i2);                           // output result
         N =Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
         D = Integer.parseInt(st.nextToken());
        
        int count=1;
        int[] array = new int[N];array[0]=0;
        for(int i=1;i<(int)Math.pow(2, B);i++){
        	boolean flag=true;
        	for(int j=0;j<count;j++){
        		if(!big(array[j],i)) flag=false;
        	}
        	if(flag) array[count++]=i;
        	if(count>=N) break;
        }
        int num=0;
        for(int i=0;i<N;i++){
        	if(num!=9&&i!=N-1){out.print(array[i]+" ");
        	num++;}
        	else {
        		out.println(array[i]);num=0;
        	}
        }
        out.close();
        System.exit(0);
    }
    public static boolean big(int a,int b){
    	String sa=ten2two(a),sb=ten2two(b);
    	int distance=0;
    	for(int i=0;i<B;i++){
    		if(sa.charAt(i)!=sb.charAt(i)) distance++;
    		if(distance>=D) return true;
    	}
    	return false;
    }
    public static String ten2two(int n){
    	String s="";
    	while(n>1){
    		s=n%2+s;
    		n/=2;
    	}
    	s=n+s;
    	while(s.length()<B){s=0+s;}
    	return s;
    }
}


