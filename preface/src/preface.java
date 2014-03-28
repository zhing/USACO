/*
ID: zhing
LANG: JAVA
PROG: preface
*/
import java.io.*;
import java.util.*;

class preface {
    //static Map<String,Integer> ms= new HashMap<String,Integer>();
	public static void main(String[] args) throws IOException{
    	
    	BufferedReader f = new BufferedReader(new FileReader("preface.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("preface.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        //int i1 = Integer.parseInt(st.nextToken());    // first integer
        //int i2 = Integer.parseInt(st.nextToken());    // second integer
        //out.println(i1+i2);                           // output result
        
        
        int N = Integer.parseInt(st.nextToken());
        int[][] array=new int[N+1][7];
        for(int i=1;i<=N;i++){
           	//if(i==1){array[1][0]=1;continue;}
           	for(int m=0;m<7;m++){array[i][m]=array[i-1][m];}
           	int j=i-1,res=1,pos=1;
           	while(res>0){
           		int last = j%10;
           		switch(last){
           		   case 0:case 1:case 2:
           			   array[i][getindex(pos)]+=1;res=0;
           			   break;
           		   case 3:
           			   array[i][getindex(pos)]-=2;
           			   array[i][gethalf(pos)]+=1;res=0;
           			   break;
           		   case 4:
           			   array[i][getindex(pos)]-=1;res=0;
           			   break;
           		   case 5:case 6:case 7:
           			   array[i][getindex(pos)]+=1;res=0;
           			   break;
           		   case 8:
           			   array[i][getindex(pos+1)]+=1;
           			   array[i][getindex(pos)]-=2;res=0;
           			   array[i][gethalf(pos)]-=1;
           			   break;
           		   case 9:
           			   res=1;
           			   array[i][getindex(pos+1)]-=1;
           			   array[i][getindex(pos)]-=1;
           			   pos++;
           			   break;
           		}
           		j/=10;
           	}
        }
        
        for(int i=0;i<7;i++){
        	int sum=0;
        	for(int j=1;j<=N;j++){
        		sum+=array[j][i];
        	}
        	if(sum==0) continue;
        	
        	switch(i){
        	case 0: out.print("I");break;
        	case 1: out.print("V");break;
        	case 2: out.print("X");break;
        	case 3: out.print("L");break;
        	case 4: out.print("C");break;
        	case 5: out.print("D");break;
        	case 6:out.print("M");break;
        	}
        	out.println(" "+sum);
        }
        
        out.close();
        System.exit(0);
    }
	static int getindex(int pos){
		if(pos==1) return 0;
		if(pos==2) return 2;
		if(pos==3) return 4;
		if(pos==4) return 6;
		return -1;
	}
	static int gethalf(int pos){
		if(pos==1) return 1;
		if(pos==2) return 3;
		if(pos==3) return 5;
		return -1;
	}
}

