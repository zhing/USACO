/*
ID: zhing
LANG: JAVA
PROG: packrec
*/
import java.io.*;
import java.util.*;

class Rectangle{
	int short_side;
	int long_side;
	Rectangle(int short_side,int long_side){
		this.short_side=short_side;
		this.long_side=long_side;
	}
}

class packrec {
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader f = new BufferedReader(new FileReader("packrec.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("packrec.out")));
        StringTokenizer st ;//= new StringTokenizer(f.readLine());
        
        //int i1 = Integer.parseInt(st.nextToken());    // first integer
        //int i2 = Integer.parseInt(st.nextToken());    // second integer
        //out.println(i1+i2);                           // output result
        
        List<Rectangle> ls = new ArrayList<Rectangle>();
        List<Rectangle> result = new ArrayList<Rectangle>();
        for(int i=0;i<4;i++){
          st=new StringTokenizer(f.readLine());
          int side_1=Integer.parseInt(st.nextToken()),side_2=Integer.parseInt(st.nextToken());
          ls.add(new Rectangle(Math.min(side_1, side_2),Math.max(side_1, side_2)));
        }
        //condition 1
        int max_long_side=0,sum_short_side=0;
        for(int i=0;i<4;i++){
        	if(max_long_side<ls.get(i).long_side) max_long_side=ls.get(i).long_side;
        	sum_short_side +=ls.get(i).short_side;
        }
        int min_area=max_long_side*sum_short_side;
        result.add(new Rectangle(Math.min(max_long_side,sum_short_side),Math.max(max_long_side,sum_short_side)));
        
        //condition 2
        for(int )
        
        out.close();
        System.exit(0);
    }

}

