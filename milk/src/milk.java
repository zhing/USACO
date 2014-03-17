/*
ID: zhing
LANG: JAVA
PROG: milk
*/
import java.io.*;
import java.util.*;
class Provider implements Comparable<Provider>{
	int price;
	int num;
	public Provider(int price,int num){
		this.price = price;
		this.num = num;
	}
	public int compareTo(Provider pro){
		if(this.price==pro.price) return 0;
		else if(this.price<pro.price) return -1;
		return 1;
	}
}
class milk {
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader f = new BufferedReader(new FileReader("milk.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        //int i1 = Integer.parseInt(st.nextToken());    // first integer
        //int i2 = Integer.parseInt(st.nextToken());    // second integer
        //out.println(i1+i2);                           // output result
        
        List<Provider> ls = new ArrayList<Provider>();
        
        int total = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++){
        	st = new StringTokenizer(f.readLine());
        	Provider pro = new Provider(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            ls.add(pro);
        }
        Collections.sort(ls);
        //for(int i=0;i<N;i++) System.out.println(ls.get(i).price+" "+ls.get(i).num);
        
        int sum =0;
        for(int i=0;i<N;i++){
        	int num = ls.get(i).num,price=ls.get(i).price;
        	if(num>=total){
        		sum+=price*total;break;
        	}else{
        		sum+=price*num;total-=num;
        	}
        }
        out.println(sum);
        out.close();
        System.exit(0);
    }

}

