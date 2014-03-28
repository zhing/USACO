/*
ID: zhing
LANG: JAVA
PROG: subset
*/
import java.io.*;
import java.util.*;

class subset {
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader f = new BufferedReader(new FileReader("subset.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("subset.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        //int i1 = Integer.parseInt(st.nextToken());    // first integer
        //int i2 = Integer.parseInt(st.nextToken());    // second integer
        //out.println(i1+i2);                           // output result
        
        int N= Integer.parseInt(st.nextToken());
        int[][] array = new int[40][800];
        
        int bsum=(N*(N+1))/2;
        if(bsum%2==1){
        	out.println(0);
        }else{
        	for(int i=1;i<=N;i++){
        		if(i==1){ array[1][1]=1;continue;}
        		for(int j=0;j<=(i*i-i)/2;j++){
        			if(j==0) array[i][i]=array[i-1][0]*2;
        			else{
        				array[i][j+i]+=array[i-1][j];
        				array[i][Math.abs(j-i)]+=array[i-1][j];
        			}
        		}
        		
        	}
        	out.println(array[N][0]);
        }
        out.close();
        System.exit(0);
    }

}

