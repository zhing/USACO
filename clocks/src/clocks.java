/*
ID: zhing
LANG: JAVA
PROG: clocks
*/
import java.io.*;
import java.util.*;
/*
class Clock{
	List<Integer> a;
	List<Integer> b;
	Clock(Clock p){
		//this=p;
	}
	Clock(List<Integer> a,List<Integer> b){
		this.a=a;this.b=b;
	}
	boolean equals(Clock p){
		for(int i=0;i<9;i++){
			if(this.a.get(i)!=p.a.get(i)) return false;
		}
		return true;
	}
}*/
class clocks {
	//static String[] ls={"ABDE","ABC","BCEF","ADG","BDEFH","CFI","DEGH","GHI","EFHI"};
	
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader in = new BufferedReader(new FileReader("clocks.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("clocks.out")));
        StringTokenizer st = new StringTokenizer(in.readLine());
        
        //int i1 = Integer.parseInt(st.nextToken());    // first integer
        //int i2 = Integer.parseInt(st.nextToken());    // second integer
        //out.println(i1+i2);  
        /*// output result
        List<Integer> la = new ArrayList<Integer>();
        List<Integer> lb = new ArrayList<Integer>();
        for(int i=0;i<3;i++){
        	st = new StringTokenizer(f.readLine());
        	la.add(Integer.parseInt(st.nextToken()));
        	la.add(Integer.parseInt(st.nextToken()));
        	la.add(Integer.parseInt(st.nextToken()));
        }
        Clock p = new Clock(la,lb);
        List<Integer> lp = new ArrayList<Integer>();
        for(int i=0;i<9;i++) lp.add(12);
        Clock end=new Clock(lp,new ArrayList<Integer>());
        Queue<Clock> Q=new LinkedList<Clock>();
        Q.offer(p);
        while(!Q.isEmpty()){
        	Clock c= Q.poll();
        	if(c.equals(end)){
        		for(int i=0;i<c.b.size();i++){
        			out.print(c.b.get(i));
        		    if(i!=c.b.size()-1) out.print(" ");
        		}
        		out.println();
        		break;
        	}
        	for(int i=1;i<=9;i++){
        		Clock q=trans(c,i);
        		if(q!=null)Q.offer(q);
        	}
        }
        */
        
        int[] array=new int[9];
        int[] p=new int[9];
        for(int i=0;i<9;i++){
        	if(i%3==0&&i!=0) st= new StringTokenizer(in.readLine());
        	array[i]=Integer.parseInt(st.nextToken());
        	if(array[i]==3) array[i]=3;
        	else if(array[i]==6) array[i]=2;
        	else if(array[i]==9) array[i]=1;
        	else array[i]=0;
        	}
        String s="";
        for(int a=0;a<=3;a++)
        	for(int b=0;b<=3;b++)
        		for(int c=0;c<=3;c++)
        			for(int d=0;d<=3;d++)
        				for(int e=0;e<=3;e++)
        					for(int f=0;f<=3;f++)
        						for(int g=0;g<=3;g++)
        							for(int h=0;h<=3;h++)
        								for(int i=0;i<=3;i++){
        if((a+b+d)%4==array[0]&&(a+b+c+e)%4==array[1]&&
        	(b+c+f)%4==array[2]&&(a+d+e+g)%4==array[3]&&	
        	(a+c+e+g+i)%4==array[4]&&(c+e+f+i)%4==array[5]&&	
        	(d+g+h)%4==array[6]&&(e+g+h+i)%4==array[7]&&	
        	(f+h+i)%4==array[8]){
        	p[0]=a;p[1]=b;p[2]=c;p[3]=d;p[4]=e;p[5]=f;p[6]=g;p[7]=h;p[8]=i;
            String str="";
            for(int j=0;j<9;j++){
            	for(int k=0;k<p[j];k++){
            		str+=(j+1);
            	}
            }
            if(str.length()<s.length()||s=="") s=str;
            else if(str.length()==s.length()&&str.compareTo(s)<0) s=str;
        }								
        							}
        boolean frist = true;
       for(int i=0;i<s.length();i++){
    	   out.print(s.charAt(i));
    	   if(i==s.length()-1) out.println();
    	   else out.print(" ");
       }
        out.close();
        System.exit(0);
    }
    /*
    public static Clock trans(Clock c,int m){
    	String s= ls[m-1];Clock p=new Clock(new ArrayList(c.a),new ArrayList(c.b));
    	for(int i=0;i<s.length();i++){
    		int num = c.a.get(s.charAt(i)-'A');
    		p.a.set(s.charAt(i)-'A',num==9?12:(num+3)%12);
    	}
    	p.b.add(m);s="";
    	for(int i=0;i<p.b.size();i++){
    		s+=ls[p.b.get(i)-1];
    	}
    	if(is(s)) return p;
    	else return null;
    }
    public static boolean is(String s){
    	int[] c={0,0,0,0,0,0,0,0,0};
    	for(int i=0;i<s.length();i++){
    		c[s.charAt(i)-'A']++;
    		if(c[s.charAt(i)-'A']>4) return false;
    	}
    	return true;
    }
    /*
    public static int to(int n){
    	if(n==9) return 12;
    	else return (n+3)%12;
    }*/
    
}

