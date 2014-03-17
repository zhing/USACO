/*
ID: zhing
LANG: JAVA
PROG: namenum
*/
import java.io.*;
import java.util.*;

class LetterIndex{
	int begin;
	int end;
	public LetterIndex(int begin,int end){
		this.begin=begin;
		this.end=end;
	}
}
class namenum {
	static char[][] table ={{'A','B','C'},{'D','E','F'},{'G','H','I'},{'J','K','L'},{'M','N','O'},{'P','R','S'},
    		{'T','U','V'},{'W','X','Y'}};
	static String p;
	//static PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
	
	static List<String> s = new ArrayList<String>();
	static Map<String,LetterIndex> d = new HashMap<String,LetterIndex>();
	static boolean is = true;
	
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
    	BufferedReader dic = new BufferedReader(new FileReader("dict.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
        //StringTokenizer st = new StringTokenizer(f.readLine());
        
        //int i1 = Integer.parseInt(st.nextToken());    // first integer
        //int i2 = Integer.parseInt(st.nextToken());    // second integer
        //out.println(i1+i2);                           // output result
       
        //List<String> s = new ArrayList<String>();
        //Map<String,LetterIndex> d = new HashMap<String,LetterIndex>();
        String line;
        int begin=0,index=0;char ch='A';
        while((line=dic.readLine())!=null){
        	if(line.charAt(0)!=ch){
        		d.put(""+ch, new LetterIndex(begin,index-1));
        		ch = line.charAt(0);
        		begin = index;
        	}
        	index++;
        	s.add(line);
        }
        
        p = f.readLine();//System.out.println(p);
        for(int i=0;i<3;i++){
        	ch=table[p.charAt(0)-'2'][i];
        	if(p.length()==1){
        		for(int j=d.get(""+ch).begin;j<=d.get(""+ch).end;j++){
        			if(s.get(i)==p) {out.println(p);is=false;break;}
        		}
        		continue;
        	}
        	dfs(""+ch,1,out,d.get(""+ch));
        }
        if(is) out.println("NONE");
        out.close();
        System.exit(0);
    }
    
    public static void dfs(String ls,int index,PrintWriter out,LetterIndex li){
    	if(index==p.length()){
    		for(int i=li.begin;i<li.end;i++){
    			if(s.get(i).equals(ls)) {
    				out.println(ls);is=false;
    			    //System.out.print(ls);
    			    break;}
    		}
    		return;
    	}
    	for(int i=0;i<3;i++){
    		ls+=table[p.charAt(index)-'2'][i];
    		int begin=-1,end=-1,outbreak=0;
    		//if(ls.equals("KRIST")){ System.out.println(li.begin+" "+li.end);
    		//System.out.println(s.get(2341));}
    		for(int j=li.begin;j<=li.end;j++){
    			//System.out.println(li.begin+" "+li.end);
    			String t = s.get(j);
    			if(t.length()<ls.length()) continue;
    			if(begin==-1&&t.charAt(index)==ls.charAt(index)) begin =j;
    			if(begin!=-1&&t.charAt(index)>ls.charAt(index)) {end=j;outbreak=j;break;}
    			if(begin==-1&&t.charAt(index)>ls.charAt(index)) {outbreak=j;break;}
    		}
    		if(begin==-1) {ls=ls.substring(0,ls.length()-1);li.begin=outbreak;continue;}
    		if(end==-1) end=li.end;
    		dfs(ls,index+1,out,new LetterIndex(begin,end));
    		ls=ls.substring(0,ls.length()-1);
    	}
    	
    }
}



