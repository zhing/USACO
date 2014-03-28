/*
ID: zhing
LANG: JAVA
PROG: runround
*/
import java.io.*;
import java.util.*;

class runround {
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader f = new BufferedReader(new FileReader("runround.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("runround.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        //int i1 = Integer.parseInt(st.nextToken());    // first integer
        //int i2 = Integer.parseInt(st.nextToken());    // second integer
        //out.println(i1+i2);                           // output result
        
        long s = Integer.parseInt(st.nextToken());
        //System.out.print(increase("999"));
        s++;
        while(!judge(s)||!runaround(String.valueOf(s))){
        	s++;
        }
        out.println(s);
        out.close();
        System.exit(0);
    }
    /*
    public static String increase(String s){
    	String s1="";
    	int pre=1;
    	for(int i=s.length()-1;i>=0;i--){
    		char ch =s.charAt(i);
    		if(ch=='9'&&pre==1) {s1=0+s1;pre=1;}
    		else{
    			s1=(char)(ch+pre)+s1;
    			pre=0;
    		}
    	}
    	if(pre==1) s1=1+s1;
    	return s1;
    }*/
    public static boolean judge(long p){
    	int[] array = new int[9];
    	while(p>0){
    		int q=(int)(p%10);
    		if(q==0) return false;
    		if(array[q-1]!=0) return false;
    		array[q-1]=1;
    		p/=10;
    	}
    	return true;
    }
    public static boolean runaround(String s){
    	int[] array=new int[s.length()];
    	int begin=0;array[0]=1;
    	for(int i=1;i<s.length();i++){
    		int step = s.charAt(begin)-'0';
    		begin = (begin+step)%s.length();
    		if(array[begin]!=0) return false;
    		array[begin]=1;
    	}
    	int step = s.charAt(begin)-'0';
    	if((begin+step)%s.length()!=0) return false;
    	return true;
    }
}


