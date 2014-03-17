/*
ID: zhing
LANG: JAVA
PROG: milk2
*/
import java.io.*;
import java.util.*;

class milk2 {
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        //int i1 = Integer.parseInt(st.nextToken());    // first integer
        //int i2 = Integer.parseInt(st.nextToken());    // second integer
        //out.println(i1+i2);                           // output result
        int N = Integer.parseInt(st.nextToken());
        int[][] time = new int[N][2];
        for(int i=0;i<N;i++){
        	st=new StringTokenizer(f.readLine());
        	time[i][0]=Integer.parseInt(st.nextToken());
        	time[i][1]=Integer.parseInt(st.nextToken());
        	int j=i;
        	while(j>0){
        		if(time[j][0]<time[j-1][0]){
        			int tmp=time[j][0];time[j][0]=time[j-1][0];time[j-1][0]=tmp;
        			tmp=time[j][1];time[j][1]=time[j-1][1];time[j-1][1]=tmp;
        		}
        		j--;
        	}
        }
        int inv1=time[0][1]-time[0][0],inv2=0,end=time[0][1];
        for(int i=1;i<N;i++){
        	int j=i-1;
        	while(time[j][0]==0&&time[j][1]==0){j--;}
        	if(time[i][0]<=time[j][1]){
        		time[i][0]=time[j][0];
        		time[i][1]=Math.max(time[i][1], time[j][1]);
        		time[j][0]=0;time[j][1]=0;
        		if(time[i][1]-time[i][0]>inv1) inv1=time[i][1]-time[i][0];
        		
        	}else{
        		if(time[i][0]-end>inv2) inv2=time[i][0]-end;
        	}
        	end = time[i][1];
        	if(time[i][1]-time[i][0]>inv1) inv1=time[i][1]-time[i][0];
        }
        out.println(inv1+" "+inv2);
        out.close();
        System.exit(0);
    }
  
}

