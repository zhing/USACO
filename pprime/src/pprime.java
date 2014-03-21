/*
ID: zhing
LANG: JAVA
PROG: pprime
*/
import java.io.*;
import java.util.*;

class pprime {
	static SortedSet<Integer> ls=new TreeSet<Integer>();
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader f = new BufferedReader(new FileReader("pprime.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        //int i1 = Integer.parseInt(st.nextToken());    // first integer
        //int i2 = Integer.parseInt(st.nextToken());    // second integer
        //out.println(i1+i2);                           // output result
        Integer a,b;
        a=Integer.parseInt(st.nextToken());
        b=Integer.parseInt(st.nextToken());
        //if(a%2==0) a+=1;if(b%2==0) b-=1;
        
        int pow=(a.toString().length()+1)/2;
        int down=(int)Math.pow(10,pow-1);
        int up=b/(int)Math.pow(10,(b.toString().length()+1)/2-1);
        
        for(int i=down;i<=up;i+=1){
        	if(i<10&&i<=b&&i>=a) {
        		if(isprime(i)) ls.add(i);
        		int p=turn2p(i);
        		if(isprime(p)) ls.add(p);
        	}
        	int p=turn1p(i);
        	if(p>=a&&p<=b&&isprime(p)) ls.add(p);
        	p=turn2p(i);
        	if(p>=a&&p<=b&&isprime(p)) ls.add(p);
        }
        while(!ls.isEmpty()){
        	Integer p=ls.first();
        	out.println(p);
        	ls.remove(p);
        }
        out.close();
        System.exit(0);
    }
   static boolean isprime(int p){
	   for(int i=2;i<=(int)Math.sqrt(p);i++)
		   if(p%i==0) return false;
	   return true;
   }
   static int turn2p(Integer q){
	   String p=q.toString();
	   for(int i=p.length()-1;i>=0;i--)
		   p+=p.charAt(i);
	   return Integer.parseInt(p);
   }
   static int turn1p(Integer q){
	   String p=q.toString();
	   for(int i=p.length()-2;i>=0;i--)
		   p+=p.charAt(i);
	   return Integer.parseInt(p);
   }
}


