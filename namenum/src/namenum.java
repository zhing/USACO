/*
ID: zhing
LANG: JAVA
PROG: namenum
*/
import java.io.*;
import java.util.*;

class namenum {
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
    	BufferedReader dict = new BufferedReader(new FileReader("dict.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
        //StringTokenizer st = new StringTokenizer(f.readLine());
        
        //int i1 = Integer.parseInt(st.nextToken());    // first integer
        //int i2 = Integer.parseInt(st.nextToken());    // second integer
        //out.println(i1+i2);                           // output result
        
       char[][] name_char={{'A','B','C'},{'D','E','F'},{'G','H','I'},{'J','K','L'},{'M','N','O'},
    		   {'P','R','S'},{'T','U','V'},{'W','X','Y'}};
       List<String> dictionary = new ArrayList<String>();
       String s;int count=0;
       while((s=dict.readLine())!=null){
    	   dictionary.add(s);
    	   count++;
       }
       s=f.readLine();int[] index=new int[2];
       for(int i=0;i<s.length();i++){
    	   
       }
       
       //System.out.println(count);
        out.close();
        System.exit(0);
    }
 
}

