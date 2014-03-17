/*
ID: zhing
LANG: JAVA
PROG: dualpal
*/
import java.io.*;
import java.util.*;

class dualpal {
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        //int i1 = Integer.parseInt(st.nextToken());    // first integer
        //int i2 = Integer.parseInt(st.nextToken());    // second integer
        //out.println(i1+i2);                           // output result
        
        int N=Integer.parseInt(st.nextToken());
        int S=Integer.parseInt(st.nextToken());
        
        while(N>0){
           S++;
           int count=0;
           for(int i=2;i<=10;i++){
        	   if(ispalsquare(ten2N(S,i))){ 
        		   count++;
        		   if(count==2) break;   
        	   }
           }
           if(count==2){ out.println(S);N--;}
        }
      
        out.close();
        System.exit(0);
    }
    public static String ten2N(int p,int N){
    	String s = "",s1="";
    	while(p>=N){
    		int m = p%N;
    		if(N>10&&m>=10) s+=(char)('A'+(m-10));
    		else s+= Integer.toString(m);
    		p/=N;
    	}
    	if(p>=10)s+=(char)('A'+(p-10));
    	else s+=Integer.toString(p);
    	int index=s.length()-1;
    	while(index>=0)
    		s1+=s.charAt(index--);
    	return s1;
    }
    public static boolean ispalsquare(String s){
    	for(int i=0;i<s.length()/2;i++){
    		if(s.charAt(i)!=s.charAt(s.length()-i-1)) return false;
    	}
    	return true;
    }
}

