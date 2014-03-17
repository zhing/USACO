/*
ID: zhing
LANG: JAVA
PROG: gift1
*/
import java.io.*;
import java.util.*;

class gift1 {
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        //StringTokenizer st = new StringTokenizer(f.readLine());
        
        //int i1 = Integer.parseInt(st.nextToken());    // first integer
        //int i2 = Integer.parseInt(st.nextToken());    // second integer
        //out.println(i1+i2);                           // output result
        int NP = Integer.parseInt(f.readLine());
        String[] names = new String[NP];
        Map<String,Integer> incomemap = new HashMap<String,Integer>();
        for(int i=0;i<NP;i++){
           names[i]=f.readLine();
           incomemap.put(names[i], 0);
        }
        //int[] income =new int[NP];
        for(int i=0;i<NP;i++){
        	String name = f.readLine();
            StringTokenizer st = new StringTokenizer(f.readLine());
            int money = Integer.parseInt(st.nextToken()),giveto = Integer.parseInt(st.nextToken());
            if(giveto == 0) continue;
            int average = money/giveto;
            for(int j=0;j<giveto;j++){
            	String na = f.readLine();
            	incomemap.put(na,(incomemap.get(na)+average));
            }
            incomemap.put(name,(incomemap.get(name)-money+money%giveto));
        }
        for(int i=0;i<NP;i++){
        	out.println(names[i]+" "+incomemap.get(names[i]));
        }
        out.close();
        System.exit(0);
    }
    
}


