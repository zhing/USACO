/*
ID: zhing
LANG: JAVA
PROG: crypt1
*/
import java.io.*;
import java.util.*;

class crypt1 {
	static List<Integer> ls =new ArrayList<Integer>();
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader f = new BufferedReader(new FileReader("crypt1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        //int i1 = Integer.parseInt(st.nextToken());    // first integer
        //int i2 = Integer.parseInt(st.nextToken());    // second integer
        //out.println(i1+i2);                           // output result
        
        
        int N= Integer.parseInt(st.nextToken());
        st=new StringTokenizer(f.readLine());
        for(int i=0;i<N;i++)
        	ls.add(Integer.parseInt(st.nextToken()));
        
        int count=0;
        for(int i=0;i<N;i++){
        	for(int j=0;j<N;j++){
        		for(int k=0;k<N;k++){
        			for(int m =0;m<N;m++)
        				for(int n=0;n<N;n++){
        					if(isok(ls.get(i),ls.get(j),ls.get(k),ls.get(m),ls.get(n))) 
        							count++;
        				}
        		}
        	}
        }
        out.println(count);
        
        out.close();
        System.exit(0);
    }
  public static boolean isok(int i,int j,int k,int m,int n){
	  int num1=i*100+j*10+k,num2=m*10+n;
	  int result1=num1*m,result2=num1*n,result3=num1*num2;
	  
	  if(result1>=1000||result2>=1000||result3>=10000) return false;
	  return isok2(result1)&&isok2(result2)&&isok2(result3);
  }
  public static boolean isok2(int p){
	  while(p>0){
		  int mod=p%10;
		  if(!ls.contains(mod)) return false; 
		  p/=10;
	  }
	  return true;
  }
}

