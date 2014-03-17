/*
ID: zhing
LANG: JAVA
PROG: ride
*/
import java.io.*;
import java.util.*;

class ride {
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader f = new BufferedReader(new FileReader("ride.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        //int i1 = Integer.parseInt(st.nextToken());    // first integer
        //int i2 = Integer.parseInt(st.nextToken());    // second integer
        //out.println(i1+i2);                           // output result
        
        String comet = st.nextToken();
        st=new StringTokenizer(f.readLine());
        String group = st.nextToken();
        
        
        int comet_product=1,mod;
        for(int i=0;i<comet.length();i++){
        	comet_product*=(comet.charAt(i)-'A'+1);
        }
        mod = comet_product % 47;
        
        if(mod == mod(group)){
        	out.println("GO");
        }else{
        	out.println("STAY");
        }
        out.close();
        System.exit(0);
    }
    public static int mod(String s){
    	int p=1;
    	for(int i=0;i<s.length();i++){
    		p*=(s.charAt(i)-'A'+1);
    	}
    	return p%47;
    }
}

