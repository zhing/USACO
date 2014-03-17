/*
ID: zhing
LANG: JAVA
PROG: barn1
*/
import java.io.*;
import java.util.*;

class barn1 {
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader f = new BufferedReader(new FileReader("barn1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        //int i1 = Integer.parseInt(st.nextToken());    // first integer
        //int i2 = Integer.parseInt(st.nextToken());    // second integer
        //out.println(i1+i2);                           // output result
    
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        int[] array = new int[C];
        
        for(int i=0;i<C;i++){
        	array[i]=Integer.parseInt(f.readLine());
        }
        if(M>=C){
        	out.println(C);
        }else {
           int[] array_1 = new int[C-1];
           Arrays.sort(array);
           for(int i=0;i<C-1;i++){
        	   array_1[i]=array[i+1]-array[i]-1;
           }
           Arrays.sort(array_1);
           int max =0,index=C-2;
           for(int i=0;i<M-1;i++){
        	   max+=array_1[index--];
           }
           out.println(array[C-1]-array[0]+1-max);
        }
        out.close();
        System.exit(0);
    }

}

