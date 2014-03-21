/*
ID: zhing
LANG: JAVA
PROG: numtri
*/
import java.io.*;
import java.util.*;

class numtri {
	static int N;
	static int max=0;
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader f = new BufferedReader(new FileReader("numtri.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        //int i1 = Integer.parseInt(st.nextToken());    // first integer
        //int i2 = Integer.parseInt(st.nextToken());    // second integer
        //out.println(i1+i2);                           // output result
        
        N= Integer.parseInt(st.nextToken());
        int[][] matrix = new int[N][N];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(f.readLine());
        	for(int j=0;j<=i;j++)
        		matrix[i][j]=Integer.parseInt(st.nextToken());
        }
        for(int i=N-2;i>=0;i--){
        	for(int j=0;j<=i;j++){
               matrix[i][j]=Math.max(matrix[i+1][j], matrix[i+1][j+1])+matrix[i][j]; 	
        	}	
        }
        //cal(0,0,0,matrix);
        out.println(matrix[0][0]);
        out.close();
        System.exit(0);
    }
    static public void cal(int x,int y,int sum,int[][] matrix){
    	sum+=matrix[x][y];
    	if(x==N-1){
    		if(sum>max) max=sum;
    		return;
    	}
    	for(int i=0;i<=1;i++){
    		cal(x+1,y+i,sum,matrix);
    	}
    }

}

