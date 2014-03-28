/*
ID: zhing
LANG: JAVA
PROG: frac1
*/
import java.io.*;
import java.util.*;
class Grade implements Comparable<Grade>{
	int up;
	int down;
	Grade(int up,int down){
		this.up = up;this.down =down;
	}
	//boolean equals(Grade g){
	//	return (double)up/down == (double)g.up/g.down;
	//}
	public int compareTo(Grade g){
		if((double)up/down>(double)g.up/g.down) return 1;
		else if((double)up/down<(double)g.up/g.down) return -1;
		else return 0;
	}
}


class frac1 {
	static SortedSet<Grade> ls =new TreeSet<Grade>(); 
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader f = new BufferedReader(new FileReader("frac1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        //int i1 = Integer.parseInt(st.nextToken());    // first integer
        //int i2 = Integer.parseInt(st.nextToken());    // second integer
        //out.println(i1+i2);                           // output result
        
        int N= Integer.parseInt(st.nextToken());
        for(int i=1;i<=N;i++){
        	for(int j=0;j<=i;j++){
        		Grade g= new Grade(j,i);
        		ls.add(g);
        	}
        }
        
        while(!ls.isEmpty()){
        	Grade g=ls.first();
        	out.println(g.up+"/"+g.down);
        	ls.remove(g);
        }
        out.close();
        System.exit(0);
    }

}


