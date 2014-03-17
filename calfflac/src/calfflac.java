/*
ID: zhing
LANG: JAVA
PROG: calfflac
*/
import java.io.*;
import java.util.*;

class calfflac {
	static String m;
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader f = new BufferedReader(new FileReader("calfflac.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("calfflac.out")));
        //StringTokenizer st = new StringTokenizer(f.readLine());
        
        //int i1 = Integer.parseInt(st.nextToken());    // first integer
        //int i2 = Integer.parseInt(st.nextToken());    // second integer
        //out.println(i1+i2);                           // output result
        String s="",s_;//char cha = 10;
        /*char[] text = new char[20000];
		int textLength = 0;
		while(f.ready())
			text[textLength++] = (char)f.read();
		s = new String(text, 0, textLength);*/
        //while(f.ready()) s+=(char)f.read();
        
        while((s_=f.readLine())!=null){
        	//s_.trim();
        	s+=s_;
        	s+='\n';
        	//System.out.println(s_.charAt(s_.length()-1));
        	//if(s_.length()) s=s.substring(0,s.length()-1);
        }
        //System.out.println(s);
        int max1=-1,begin1=0,end1=0;
        /*
        String p="";//System.out.println(p);
        for(int i=0;i<s.length();i++){
    		char c=s.charAt(i);
    		if(isLetter(c)) p+=c;
    	}*/
        for(int i=0;i<s.length();i++){
        	if(!isLetter(s.charAt(i))) continue;
        	int radius=0,before=before(s,i),after=after(s,i);
        	while(before>=0&&after<s.length()){
        		if(equals(s.charAt(before),s.charAt(after))) {
        			before=before(s,before);after=after(s,after);radius++;
        		}else break;
        	}
        	if(max1<radius) {max1=radius;begin1=after(s,before);end1=before(s,after);}
        }
        int max2=0,begin2=0,end2=0;
        for(int i=0;i<s.length()-1;i++){
        	if(!isLetter(s.charAt(i)))continue;
        	if(after(s,i)<s.length()&&!equals(s.charAt(i),s.charAt(after(s,i)))) continue;
        	int radius=1,before=before(s,i),after=after(s,after(s,i));
        	while(before>=0&&after<s.length()){
        		if(equals(s.charAt(before),s.charAt(after))) {
        			before=before(s,before);after=after(s,after);radius++;
        		}else break;
        	}
        	if(max2<radius) {begin2=after(s,before);end2=before(s,after);max2=radius;}
        }
        //int ms=0;
        if(max2>max1){
        	out.println(2*max2);
        	for(int i=begin2;i<=end2;i++)
        		if(s.charAt(i)=='\n') out.println();
        		else out.print(s.charAt(i));
        }else{
        	//System.out.println(max1+" "+max1_index);
        	out.println(2*max1+1);
        	for(int i=begin1;i<=end1;i++)
        		if(s.charAt(i)=='\n') out.println();
        		else out.print(s.charAt(i));
        }
        out.println("");
        out.close();
        System.exit(0);
    }/*
    public static String turntoletter(String s){
    	String p = "";
    	for(int i=0;i<s.length();i++){
    		char c=s.charAt(i);
    		if(isLetter(c)) p+=c;
    	}
    	return p;
    }*/
    public static boolean isLetter(char c){
    	if(c>='A'&&c<='Z'||c>='a'&&c<='z') return true;
    	return false;
    }
    public static boolean equals(char c1,char c2){
    	if(c1==c2||c1-c2==32||c2-c1==32) return true;
    	return false;
    }
    public static int before(String s,int index){
    	while(--index>=0){
    		if(isLetter(s.charAt(index))) return index;
    	}
    	return index;
    }
    public static int after(String s,int index){
    	while(++index<s.length()){
    		if(isLetter(s.charAt(index))) return index;
    	}
    	return index;
    }
}

