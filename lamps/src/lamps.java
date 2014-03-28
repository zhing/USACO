/*
ID: zhing
LANG: JAVA
PROG: lamps
*/
import java.io.*;
import java.util.*;

class lamps {
	static int N;
	static int C; 
	static boolean flag;
	static List<Integer> lon = new ArrayList<Integer>();
	static List<Integer> loff = new ArrayList<Integer>();
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader f = new BufferedReader(new FileReader("lamps.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lamps.out")));
        //StringTokenizer st = new StringTokenizer(f.readLine());
        
        //int i1 = Integer.parseInt(st.nextToken());    // first integer
        //int i2 = Integer.parseInt(st.nextToken());    // second integer
        //out.println(i1+i2);                           // output result
        N= Integer.parseInt(f.readLine());
        C=Integer.parseInt(f.readLine());
        

        StringTokenizer st = new StringTokenizer(f.readLine());
        int p = Integer.parseInt(st.nextToken());
        while(p!=-1){
        	lon.add(p);
        	p=Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(f.readLine());
        p = Integer.parseInt(st.nextToken());
        while(p!=-1){
        	loff.add(p);
        	p=Integer.parseInt(st.nextToken());
        }
        
        int[][] array = new int[8][N+1];
        for(int i=1;i<=N;i++){
        	array[0][i] =1;
        }
        
        for(int i=2;i<=N;i+=2){array[2][i]=1;}
        for(int i=1;i<=N;i+=2){array[3][i]=1;}
        for(int i=1;i<=N;i++){
        	if((i-1)%3!=0) array[4][i]=1;
        }
        for(int i=1;i<=N;i++){
        	if((i-1)%3==0) array[5][i]=1;
        }
        for(int i=1;i<=N;i+=1){
        	if((i-1)%3==0){array[6][i]=1-array[2][i];}
        	else array[6][i]=array[2][i];
        }
        for(int i=1;i<=N;i+=1){
        	if((i-1)%3==0) array[7][i]=1-array[3][i];
        	else array[7][i]=array[3][i];
        }
        /*
        for(int i=0;i<8;i++){
        	print(out, array[i]);
        }
        */
        if(C==0){
        	if(suf(array[0])) print(out,array[0]);
        }
        if(C==1){
        	if(suf(array[1])) print(out,array[1]);
        	if(suf(array[2])) print(out,array[2]);
        	if(suf(array[4])) print(out,array[4]);
        	if(suf(array[3])) print(out,array[3]);
        }
        if(C==2){
        	if(suf(array[1])) print(out,array[1]);
        	if(suf(array[7])) print(out,array[7]);
        	if(suf(array[2])) print(out,array[2]);
        	if(suf(array[5])) print(out,array[5]);
        	if(suf(array[3])) print(out,array[3]);
        	if(suf(array[6])) print(out,array[6]);
        	if(suf(array[0])) print(out,array[0]);
        }
        if(C>=3){
        	if(suf(array[1])) print(out,array[1]);
        	if(suf(array[7])) print(out,array[7]);
        	if(suf(array[2])) print(out,array[2]);
        	if(suf(array[4])) print(out,array[4]);
        	if(suf(array[5])) print(out,array[5]);
        	if(suf(array[3])) print(out,array[3]);
        	if(suf(array[6])) print(out,array[6]);
        	if(suf(array[0])) print(out,array[0]);
        }
        if(!flag){ out.println("IMPOSSIBLE");}
        out.close();
        System.exit(0);
    }
    public static boolean suf(int[] arr){
    	for(int i=0;i<lon.size();i++){
    		if(arr[lon.get(i)]==0) return false; 
    	}
    	for(int i=0;i<loff.size();i++){
    		if(arr[loff.get(i)]==1) return false;
    	}
    	return true;
    } 
    public static void print(PrintWriter out,int[] arr){
    	if(!flag) flag = true;
    	
    	for(int i=1;i<=N;i++){
    		out.print(arr[i]);
    	}
    	out.println();
    }
}

