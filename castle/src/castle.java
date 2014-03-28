/*
ID: zhing
LANG: JAVA
PROG: castle
*/
import java.io.*;
import java.util.*;

class castle {
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader f = new BufferedReader(new FileReader("castle.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        //int i1 = Integer.parseInt(st.nextToken());    // first integer
        //int i2 = Integer.parseInt(st.nextToken());    // second integer
        //out.println(i1+i2);                           // output result
        int M =Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        int[][] array =new int[N][M];
        int[][] area = new int[N][M];area[0][0]=0;
        for(int i=0;i<N;i++){
        	st = new StringTokenizer(f.readLine());
        	for(int j=0;j<M;j++){
        		array[i][j]=Integer.parseInt(st.nextToken());
        		if(i==0){}
        	}
        }
        
        out.close();
        System.exit(0);
    }

}

