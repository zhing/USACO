
/*
ID: zhing
LANG: JAVA
PROG: ariprog
*/
import java.io.*;
import java.util.*;
class Point implements Comparable<Point>{
	int x;int y;
	Point(int x,int y){
		this.x=x;this.y=y;
	}
	public int compareTo(Point p){
		if(this.y<p.y) return -1;
		else if(this.y>p.y) return 1;
		else if(x<p.x) return -1;
		else if(x>p.x) return 1;
		else return 0;
	}
}
class ariprog {
	
	//static PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
	
	//static List<Integer> q = new ArrayList<Integer>();
	static SortedSet<Point> lp = new TreeSet<Point>();
	static int x_init,value;
	static SortedSet<Integer> li = new TreeSet<Integer>();
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader f = new BufferedReader(new FileReader("ariprog.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
        //StringTokenizer st = new StringTokenizer(f.readLine());
        
        //int i1 = Integer.parseInt(st.nextToken());    // first integer
        //int i2 = Integer.parseInt(st.nextToken());    // second integer
        //out.println(i1+i2);                           // output result
       
        int N = Integer.parseInt(f.readLine());
        int M = Integer.parseInt(f.readLine());
        
        //int[] ls= new int[M*M*2+1];int count=1;ls[0]=0;
        boolean[] bool =new boolean[M*M*2+1];
        //System.out.print(bool[0]);
        for(int i=0;i<=M;i++){
        	for(int j=i;j<=M;j++){
        	    int num=i*i+j*j;
        	    li.add(num);bool[num]=true;
        	    //if(!q.contains(num)) q.add(num);
        	}
        }
        
        int count=li.size();
        int[] ls=new int[count];
        for(int i=0;i<count;i++){
        	ls[i]=li.first();
        	li.remove(ls[i]);
        }
        //Collections.sort(ls);
        //Arrays.sort(ls,0,count);
        //System.out.print(count+" "+q.size());
        //System.out.println(Arrays.binarySearch(ls, 0,count,0));
        /*
        for(int i=0;i<ls.size()-1;i++){
        	ls.set(i, ls.get(i+1)-ls.get(i));
        }
        ls.remove(ls.size()-1);
        //System.out.println(ls);
        int L= ls.size();
        int[][] array = new int[L][L+1];
        for(int i=0;i<L;i++){
        	for(int j=i;j<L+1;j++){
        		if(i==j) array[i][j]=0;
        		else array[i][j]=array[i][j-1]+ls.get(j-1);
        		//System.out.print(array[i][j]);
        	}
        	//System.out.println();
        }
        for(int i=0;i<=L-N+1;i++){
        	for(int j=i+1;j<=L-N+2;j++){
        		x_init=i;value=array[i][j];
        		dfs(j,array,L,N-2);
        	}
        }
        if(lp.size()==0) out.println("NONE");
        else{
        	Collections.sort(lp);
        	for(int i=0;i<lp.size();i++){
        		out.println(lp.get(i).x+" "+lp.get(i).y);
        	}
        }

        out.close();
        System.exit(0);
    }
    
   static void dfs(int y,int[][] array,int L,int deep){
    	for(int i=y+1;i<=L;i++){
    		if(value==array[y][i]){
    			if(deep==1) {lp.add(new Point(x_init,value));return;}
    			else dfs(i,array,L,deep-1);
    		}
    	}*/
        
        for(int i=0;i<=count-N;i++)
        	for(int intv=1;intv<=(M*M*2-ls[i])/(N-1);intv++){
        		int length=1,begin=ls[i]+intv;
        		while(bool[begin]){
        			length++;begin+=intv;
        			if(length==N){
        				lp.add(new Point(ls[i],intv));
        				break;
        			}
        		}
        	}
        count=lp.size();
        if(lp.size()==0) out.println("NONE");
        else{
        	//Collections.sort(lp);
        	for(int i=0;i<count;i++){
        		Point p= lp.first();
        		out.println(p.x+" "+p.y);
        		lp.remove(p);
        	}
        }
        out.close();
        System.exit(0);
    }
}




