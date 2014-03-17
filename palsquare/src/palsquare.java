/*
ID: zhing
LANG: JAVA
PROG: palsquare
*/
import java.io.*;
import java.util.*;

class palsquare {
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
        //StringTokenizer st = new StringTokenizer(f.readLine());
        
        //int i1 = Integer.parseInt(st.nextToken());    // first integer
        //int i2 = Integer.parseInt(st.nextToken());    // second integer
        //out.println(i1+i2);                           // output result
        System.out.println('A'+0);
        int N = Integer.parseInt(f.readLine());
        for(int i=1;i<=300;i++){
        	int square = (int)Math.pow(i, 2);
            String s = ten2N(square,N);
            if(ispalsquare(s)) out.println(ten2N(i,N)+" "+s);
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

