/*
ID: zhing
LANG: JAVA
PROG: sort3
*/
import java.io.*;
import java.util.*;

class sort3 {
    public static void main(String[] args) throws IOException{
    	
    	System.out.print((int)Math.ceil(2.1));
    	
    	BufferedReader f = new BufferedReader(new FileReader("sort3.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        //int i1 = Integer.parseInt(st.nextToken());    // first integer
        //int i2 = Integer.parseInt(st.nextToken());    // second integer
        //out.println(i1+i2);                           // output result
        
        int N = Integer.parseInt(st.nextToken());
        int[] array1= new int[N];
        int[] array2=new int[N];
        for(int i=0;i<N;i++){
        	array1[i]=Integer.parseInt(f.readLine());
        	array2[i]=array1[i];
        }
        Arrays.sort(array1);
        
        int[] array=new int[6];
        for(int i=0;i<N;i++){
        	//System.out.print(array1[i]);
        	if(array1[i]==1&&array2[i]==2) array[0]++;
        	if(array1[i]==2&&array2[i]==1) array[1]++;
        	if(array1[i]==2&&array2[i]==3) array[2]++;
        	if(array1[i]==3&&array2[i]==2) array[3]++;
        	if(array1[i]==3&&array2[i]==1) array[4]++;
        	if(array1[i]==1&&array2[i]==3) array[5]++;
        }
        //for(int i=0;i<6;i++) System.out.print(array[i]);
        int count=0;
        count=Math.min(array[0], array[1])+Math.min(array[2], array[3])+Math.min(array[4],array[5]);
        count+=Math.abs(array[0]-array[1])*2;
        out.println(count);
        out.close();
        System.exit(0);
    }

}

