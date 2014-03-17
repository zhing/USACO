/*
ID: zhing
LANG: JAVA
PROG: transform
*/
import java.io.*;
import java.util.*;

class transform {
	static int N;
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader f = new BufferedReader(new FileReader("transform.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
        //StringTokenizer st = new StringTokenizer(f.readLine());
        
        //int i1 = Integer.parseInt(st.nextToken());    // first integer
        //int i2 = Integer.parseInt(st.nextToken());    // second integer
        //out.println(i1+i2);                           // output result
        
        N= Integer.parseInt(f.readLine());
        char[][] martix = new char[N][N];
        for(int i=0;i<N;i++){
        	String s=f.readLine();
        	for(int j=0;j<N;j++){
        	  martix[i][j]=s.charAt(j);
        	}
        }
        
        char[][] mart = new char[N][N];
        for(int i=0;i<N;i++){
        	String s=f.readLine();
        	for(int j=0;j<N;j++){
        	  mart[i][j]=s.charAt(j);
        	}
        }
        
        if(ro90(martix,mart))out.println("1");
        else if(ro180(martix,mart))out.println("2");
        else if(ro270(martix,mart))out.println("3");
        else if(reflect(martix,mart))out.println("4");
        else if(ref_ro(martix,mart))out.println("5");
        else if(staysame(martix,mart))out.println("6");
        else out.println("7");
        
        out.close();
        System.exit(0);
    }
    public static boolean ro90(char[][] a,char[][] b){
    	for(int i=0;i<N;i++)
    		for(int j=0;j<N;j++){
    			if(a[i][j]!=b[j][N-1-i]) return false;
    		}
    	return true;
    }
    public static boolean ro180(char[][] a,char[][] b){
    	for(int i=0;i<N;i++)
    		for(int j=0;j<N;j++){
    			if(a[i][j]!=b[N-i-1][N-j-1]) return false;
    		}
    	return true;
    }
    public static boolean ro270(char[][] a,char[][] b){
    	for(int i=0;i<N;i++)
    		for(int j=0;j<N;j++){
    			if(a[i][j]!=b[N-i-1][i]) return false;
    		}
    	return true;
    }
    public static boolean reflect(char[][] a,char[][] b){
    	for(int i=0;i<N;i++)
    		for(int j=0;j<N;j++){
    			if(a[i][j]!=b[i][N-j-1]) return false;
    		}
    	return true;
    }
    public static boolean ref_ro(char[][] a,char[][] b){
    	char[][] c=new char[N][N];
    	for(int i=0;i<N;i++)
    		for(int j=0;j<N;j++){
    			c[i][j]=a[i][N-j-1];
    		}
    	if(ro90(c,b)||ro180(c,b)||ro270(c,b)) return true;
    	return false;
    }
    public static boolean staysame(char[][] a,char[][] b){
    	for(int i=0;i<N;i++)
    		for(int j=0;j<N;j++){
    			if(a[i][j]!=b[i][j]) return false;
    		}
    	return true;
    }
}


