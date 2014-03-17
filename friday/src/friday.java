/*
ID: zhing
LANG: JAVA
PROG: friday
*/
import java.io.*;
import java.util.*;

class friday {
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader f = new BufferedReader(new FileReader("friday.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        //int i1 = Integer.parseInt(st.nextToken());    // first integer
        //int i2 = Integer.parseInt(st.nextToken());    // second integer
        //out.println(i1+i2);                           // output result
       
       int[] times = new int[7];
       for(int i=0;i<7;i++) times[i]=0;
       int[] money_days = new int[12];
       for(int i=1;i<13;i++){
    	   switch(i){
    	   case 1:case 3:case 5:case 7:case 8:case 10:case 12:
    		   money_days[i-1] = 31;break;
    	   case 4:case 6:case 9:case 11:
    		   money_days[i-1] = 30;break;
    	   default:
    		   money_days[i-1] = 28;break;
    	   }
       }
       int N = Integer.parseInt(st.nextToken());
       int days = 13,last_month_days=0;
       for(int i=0;i<N;i++){
    	   for(int j=0;j<12;j++){
    		  days+=last_month_days;
    		  int day = days%7;
    		  times[day==0?6:day-1]++;
    		  last_month_days = money_days[j];
    		  if(j==1&&isleap(1900+i)) last_month_days+=1;
    			 
    	   }
       }
       out.println(times[5]+" "+times[6]+" "+times[0]+" "+times[1]+" "+times[2]+" "+times[3]+" "+times[4]);
        out.close();
        System.exit(0);
    }
    public static boolean isleap(int year){
    	if(year%100==0){
    		if(year%400==0) return true;
    	}else{
    		if(year%4==0) return true;
    	}
    	return false;
    }
}


