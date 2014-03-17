/*
ID: zhing
LANG: JAVA
PROG: beads
*/
import java.io.*;
import java.util.*;

class beads {
	static int N;
	static String s;
	public static void main(String[] args) throws IOException{
    	
    	BufferedReader f = new BufferedReader(new FileReader("beads.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
        //StringTokenizer st = new StringTokenizer(f.readLine());
        
        //int i1 = Integer.parseInt(st.nextToken());    // first integer
        //int i2 = Integer.parseInt(st.nextToken());    // second integer
        //out.println(i1+i2);                           // output result
        
        N= Integer.parseInt(f.readLine());
        s = f.readLine();
       
        s+=s;//System.out.println(s);
        int last=0,now=1,last_b=0,last_r=0,max=0,common=0;
        char direction = s.charAt(0);
        for(int i=1;i<2*N;i++){
        	char ch = s.charAt(i);
        	switch(ch){
        	case 'w':now++;break;
        	case 'r':
        		last_r =i;
        		if(direction=='b'){
        			if(last!=0&&last+now-common>max){ max=last+now-(i-last_b-1);}
        			//System.out.println(last+ " "+now);
        			last=now;now=i-last_b;
        			common = i-last_b-1;
        			direction='r';
        		}else if(direction=='r'){
        			now++;
        		}else{
        			direction ='r';now++;
        		}
        		break;
        	case 'b':
        		last_b =i;
        		if(direction=='r'){
        			if(last!=0&&last+now-common>max){ 
        				max=last+now-(i-last_r-1);//System.out.println(i+" "+last_r+" "+last+" "+now);
        			}
        			//System.out.println(last+ " "+now);
        			last=now;now=i-last_r;
        			common=i-last_r-1;
        			direction = 'b';
        		}else if(direction=='b'){
        			now++;
        		}else{
        			direction ='b';now++;
        		}
        		
        		break;
        	}
        	if(now>max) max=now;
        }
        if(max>N) max=N;
        out.println(max);
        out.close();
        System.exit(0);
    }

}


