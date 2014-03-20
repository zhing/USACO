/*
ID: zhing
LANG: JAVA
PROG: milk3
*/
import java.io.*;
import java.util.*;

class milk3 {
	/*
	static Map<String,Integer> lm= new HashMap<String,Integer>();
	//static int A,B,C;
	static String[] ls={"AB","BA","BC","CB","AC","CA"};
	static Map<String,Integer> lp=new HashMap<String,Integer>();
	static Map<String,Integer> lq=new HashMap<String,Integer>();*/
	static List<Integer> si = new ArrayList<Integer>();
	static Map<String,Integer> lsi = new HashMap<String,Integer>();
	static int A,B,C;
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader f = new BufferedReader(new FileReader("milk3.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        //int i1 = Integer.parseInt(st.nextToken());    // first integer
        //int i2 = Integer.parseInt(st.nextToken());    // second integer
        //out.println(i1+i2);                           // output result
        /*
        lq.put("A",Integer.parseInt(st.nextToken()));
        lq.put("B",Integer.parseInt(st.nextToken()));
        lq.put("C",Integer.parseInt(st.nextToken()));
        
        lp.put("A", 0);lp.put("B", 0);lp.put("C", lq.get("C"));
        lm.put(0+"#"+0+"#"+lq.get("C"), 1);
        boolean flag=true;
        while(flag){
        	flag =false;
        	for(int i=0;i<6;i++){
        		if(pour(ls[i])){
        			if(!lm.containsKey(lp.get("A")+"#"+lp.get("B")+"#"+lp.get("C"))){
        				flag=true;
        				
        			}
        		}
        	}
        }*/
        //System.out.print("s"+1);
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        int a=0,b=0,c=C;
        lsi.put(0+"#"+0+"#"+C,1);si.add(c);
        dfs(a,b,c);
        
        Collections.sort(si);
        for(int i=0;i<si.size();i++){
        	out.print(si.get(i));
        	if(i!=si.size()-1) out.print(" ");
        }
        out.println();
        out.close();
        System.exit(0);
    }
    public static void dfs(int a,int b,int c){
    	for(int i=0;i<6;i++){
    		int a_=a,b_=b,c_=c;
    		switch(i){
    		case 0:
    			if(a==0||b==B) break;
    			if(a+b<=B){b+=a;a=0;}
    			else{a=a+b-B;b=B;}
    			 
    			break;
    		case 1:
    			if(b==0||a==A) break;
    			if(a+b<=A){a+=b;b=0;}
    			else{b=a+b-A;a=A;}
    			break;
    		case 2:
    			if(b==0||c==C) break;
    			if(c+b<=C){c+=b;b=0;}
    			else{b=b+c-C;c=C;}
    			break;
    		case 3:
    			if(c==0||b==B) break;
    			if(c+b<=B){b+=c;c=0;}
    			else{c=c+b-B;b=B;}
    			break;
    		case 4:
    			if(a==0||c==C) break;
    			if(a+c<=C){c+=a;a=0;}
    			else{a=a+c-C;c=C;}
    			break;
    		case 5:
    			if(c==0||a==A) break;
    			if(a+c<=A){a+=c;c=0;}
    			else{c=a+c-A;a=A;}
    			break;
    		}
    		if(!lsi.containsKey(a+"#"+b+"#"+c)){
				lsi.put(a+"#"+b+"#"+c, 1);
    			if(a==0&&!si.contains(c)) si.add(c);
    			dfs(a,b,c);
    			
			}
    		a=a_;b=b_;c=c_;
    }

    }
    /*
    static public boolean pour(String s){
    	String s1=""+s.charAt(0),s2=""+s.charAt(1);
    	int p1=lp.get(s1),p2=lp.get(s2),full=lq.get(s2);
    	if(p1==0||p2==lq.get(s2)) return false;
    	if(p2+p1<=full) {p2=p1+p2;p1=0;}
    	else{p1=p1+p2-full;p2=full;}
    	lp.put(s1, p1);lp.put(s2, p2);return true;
    }*/
}

