/*
ID: zhing
LANG: JAVA
PROG: holstein
*/
import java.io.*;
import java.util.*;

class holstein {
	static int N,P;
	static boolean flag;
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader f = new BufferedReader(new FileReader("holstein.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("holstein.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        //int i1 = Integer.parseInt(st.nextToken());    // first integer
        //int i2 = Integer.parseInt(st.nextToken());    // second integer
        //out.println(i1+i2);                           // output result
        
         N = Integer.parseInt(st.nextToken());
        int[] array = new int[N];
        st=new StringTokenizer(f.readLine());
        for(int i=0;i<N;i++){
        	array[i]=Integer.parseInt(st.nextToken());
        }
        int B = Integer.parseInt(f.readLine());
        int[][] la = new int[B][N];double min =~0x08000000;int index=0;
        for(int i=0;i<B;i++){
           st=new StringTokenizer(f.readLine());
           double max=0;
           for(int j=0;j<N;j++){
        	   la[i][j]=Integer.parseInt(st.nextToken());
        	   if(la[i][j]!=0&&array[j]/la[i][j]>max) max=array[j]/la[i][j];
           }
           if(max<min){ min =max;index=i;}
        }
        P=(int)Math.ceil(min);
        
        for(int i=1;i<=P;i++){
        	int[] a =new int[B];a[0]=i;
        	dfs(a);
        	if(flag) {
        		out.print();
        		break;
        	}
        }
        
        out.close();
        System.exit(0);
    }
    public static void dfs(int[] a){
    	
    }
}

