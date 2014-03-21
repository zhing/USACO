/*
ID: zhing
LANG: JAVA
PROG: packrec
*/
import java.io.*;
import java.util.*;

class Rect implements Comparable<Rect>{
	int lon;
	int width;
	Rect(int lon,int width){
		this.lon = lon;
		this.width=width;
	}
	public int compareTo(Rect r){
		if(width<r.width) return -1;
		else if(width>r.width) return 1;
		else if(lon<r.lon) return -1;
		else if(lon>r.lon) return 1;
		else return 0;
	}
}

class packrec {
	
	static SortedSet<Rect> result = new TreeSet<Rect>();
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader f = new BufferedReader(new FileReader("packrec.in"));
    	//BufferedReader dic = new BufferedReader(new FileReader("dict.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("packrec.out")));
        StringTokenizer st; //= new StringTokenizer(f.readLine());
        
        //int i1 = Integer.parseInt(st.nextToken());    // first integer
        //int i2 = Integer.parseInt(st.nextToken());    // second integer
        //out.println(i1+i2);                           // output result
       /*
        int[] warray = new int[4];
        int[] larray = new int[4];
        for(int i=0;i<4;i++){
        	st=new StringTokenizer(f.readLine());
        	int a1=Integer.parseInt(st.nextToken()),a2=Integer.parseInt(st.nextToken());
        	warray[i]=Math.min(a1, a2);larray[i]=Math.max(a1, a2);
        	//System.out.println(warray[i]+" "+larray[i]);
        }
        int min_area=0;
        //condition 1
        int lon=0,wsum=0,lsum=0,width=0;
        for(int i=0;i<4;i++){
        	if(larray[i]>lon) lon=larray[i];
        	wsum+=warray[i];lsum+=larray[i];
        }
        min_area=lon*wsum;
        result.add(new Rect(Math.max(lon, wsum),Math.min(lon, wsum)));
        System.out.println(1+" "+lon+" "+wsum);
        
        //condition 2
        int area=0;
        for(int i=0;i<4;i++){
        	lon=larray[i];width=0;
        	if(lon<wsum-warray[i]) lon=wsum-warray[i];
        	for(int j=0;j<4;j++){
        		if(j!=i&&larray[j]>width) width=larray[j];
        	}//System.out.println(width);
        	width+=warray[i];
        	area=lon*width;
        	if(area==min_area){
        		result.add(new Rect(Math.max(lon, width),Math.min(lon, width)));
        	}else if(area<min_area){
        		result.clear();
        		result.add(new Rect(Math.max(lon, width),Math.min(lon, width)));
        		min_area=area;
        	}
        	System.out.println(2+" "+lon+" "+width);
        }
        
        //condition 3
        int i_l=0;
        	int lonp=larray[0];
        	for(int j=1;j<4;j++){
        		if(larray[j]>lonp) {lonp=larray[j];i_l=j;}
        	}
        	for(int j=0;j<4;j++){
        		if(i_l==j) continue;
        		width=0;int lon_=0;lon=lonp;
        		for(int k=0;k<4;k++){
        			if(k!=i_l&&k!=j){width+=warray[k];
        			if(larray[k]>lon_) lon_=larray[k];
        			}
        		}
        		if(width<larray[j]) width=larray[j];
        		width +=warray[i_l];
        		if(lon<lon_+warray[j]) lon=lon_+warray[j];
        		area=width*lon;
        		
        		if(area==min_area){
            		result.add(new Rect(Math.max(lon, width),Math.min(lon, width)));
            	}else if(area<min_area){
            		result.clear();
            		result.add(new Rect(Math.max(lon, width),Math.min(lon, width)));
            		min_area=area;
            	}
        		System.out.println(3+" "+lon+" "+width);
        	}
        
        	//condition 4&&5
        	int i_1=i_l,lon_1=larray[i_1];int lon_2=0,i_2=0;
        	for(int i=0;i<4;i++){
        		if(i!=i_1&&lon_2<larray[i]){lon_2=larray[i];i_2=i;}
        	}
        	width=0;int lon_3=0;
        	for(int i=0;i<4;i++){
        		if(i==i_1||i==i_2)continue;
        		if(width<warray[i]) width=warray[i];
        		lon_3+=larray[i];
        	}
        	width+=warray[i_1]+warray[i_2];
        	lon=Math.max(lon_1, lon_3);
        	area=lon*width;
        	
        	if(area==min_area){
        		result.add(new Rect(Math.max(lon, width),Math.min(lon, width)));
        	}else if(area<min_area){
        		result.clear();
        		result.add(new Rect(Math.max(lon, width),Math.min(lon, width)));
        		min_area=area;
        	}
        	System.out.println("4&5"+" "+lon+" "+width);
        	
        	//condition 6
        	int h=0,s=0;
        	for(int i=0;i<4;i++){
        		if(i==i_1||i==i_2) continue;
        		h=i;s=6-i_1-i_2-i;
        		lon=Math.max(lon_1+warray[h], lon_2+larray[s]);
        		width =Math.max(larray[h]+warray[s], warray[i_1]+warray[i_2]);
        		area=lon*width;
        		
        		if(area==min_area){
            		result.add(new Rect(Math.max(lon, width),Math.min(lon, width)));
            	}else if(area<min_area){
            		result.clear();
            		result.add(new Rect(Math.max(lon, width),Math.min(lon, width)));
            		min_area=area;
            	}
        		System.out.println(6+" "+lon+" "+width);
        	}
        	*/
        int[][] array = new int[4][2];int sum_area=0; 
        for(int i=0;i<4;i++){
        	st=new StringTokenizer(f.readLine());
        	array[i][0]=Integer.parseInt(st.nextToken());
        	array[i][1]=Integer.parseInt(st.nextToken());
        	sum_area+=array[i][0]*array[i][1];
        }
        int min_area=~0x80000000;//System.out.print(min_area);
        int area=0;
        for(int i=0;i<2;i++)
        	for(int j=0;j<2;j++)
        		for(int k=0;k<2;k++)
        			for(int m=0;m<2;m++){
        			int lon=array[0][1-i]+array[1][1-j]+array[2][1-k]+array[3][1-m];
        			int width=bigger(array[0][i],array[1][j],array[2][k],array[3][m]);
        			area=lon*width;
        			if(area<min_area&&area>=sum_area) result.clear();
        			if(area<=min_area&&area>=sum_area){result.add(new Rect(Math.max(lon, width),Math.min(lon, width)));min_area=area;}
        			}
        
        
        for(int i=0;i<4;i++)
        	for(int j=0;j<4;j++){
                if(i==j) continue;
        		for(int k=0;k<4;k++){
        			if(k==i||k==j) continue;
        			for(int m=0;m<4;m++){
        				if(m==i||m==j||m==k) continue;
        				for(int c=0;c<16;c++){
        					int lon,width;
        					
        					//condition 2
        					 int lon_1=array[i][1-c/8]+array[j][1-(c%8)/4]+array[k][1-(c/2)%2],lon_2=array[m][1-c%2];
        					 lon=Math.max(lon_1, lon_2);
        					 width=Math.max(array[i][c/8], Math.max(array[j][(c%8)/4], array[k][(c/2)%2]));
        					 width+=array[m][c%2];
        					 area=lon*width;
        	        			if(area<min_area&&area>=sum_area) result.clear();
        	        			if(area<=min_area&&area>=sum_area){result.add(new Rect(Math.max(lon, width),Math.min(lon, width)));min_area=area;}
        	        			
        				    //condition 3
                            lon=Math.max(array[k][1-(c/2)%2], Math.max(array[i][1-c/8], array[j][1-(c%8)/4])+array[m][1-c%2]);
                            width=Math.max(array[i][c/8]+array[j][(c%8)/4],array[m][c%2])+array[k][(c/2)%2];
                            area=lon*width;
    	        			if(area<min_area&&area>=sum_area) result.clear();
    	        			if(area<=min_area&&area>=sum_area){result.add(new Rect(Math.max(lon, width),Math.min(lon, width)));min_area=area;}
    	        			
    	        			//condition 4&5
    	        			lon=array[i][1-c/8]+Math.max(array[j][1-(c%8)/4], array[k][1-(c/2)%2])+array[m][1-c%2];
                            width=Math.max(array[j][(c%8)/4]+array[k][(c/2)%2],Math.max(array[i][c/8],array[m][c%2]));
                            area=lon*width;
    	        			if(area<min_area&&area>=sum_area) result.clear();
    	        			if(area<=min_area&&area>=sum_area){result.add(new Rect(Math.max(lon, width),Math.min(lon, width)));min_area=area;}
    	        			
    	        			//condition 6
    	        			/*
    	        			lon=Math.max(array[i][1-c/8]+array[j][1-(c%8)/4],array[k][1-(c/2)%2]+array[m][1-c%2]);
    	        			width=Math.max(array[i][c/8]+array[k][(c/2)%2],array[j][(c%8)/4]+array[m][c%2]);
    	        			if()
    	        			*/
    	        			width=Math.max(array[i][c/8]+array[k][(c/2)%2],array[j][(c%8)/4]+array[m][c%2]);
    	        			if(array[m][c%2]==array[k][(c/2)%2]){
    	        				lon=Math.max(array[i][1-c/8]+array[j][1-(c%8)/4],array[k][1-(c/2)%2]+array[m][1-c%2]);
        	        			//width=Math.max(array[i][c/8]+array[k][(c/2)%2],array[j][(c%8)/4]+array[m][c%2]);
    	        			}
    	        			if(array[m][c%2]<array[k][(c/2)%2]&&array[k][(c/2)%2]<array[j][(c%8)/4]+array[m][c%2]){
    	        				lon=Math.max(array[i][1-c/8]+array[j][1-(c%8)/4],Math.max(array[j][1-(c%8)/4]+array[k][1-(c/2)%2],array[k][1-(c/2)%2]+array[m][1-c%2]));
    	        				//width=array[k][1-(c/2)%2]+Math.max(array[j][1-(c%8)/4],array[m][1-c%2]);
    	        			}
    	        			if(array[k][(c/2)%2]<array[m][c%2]&&array[m][c%2]<array[i][c/8]+array[k][(c/2)%2]){
    	        				lon=Math.max(array[i][1-c/8]+array[j][1-(c%8)/4],Math.max(array[i][1-c/8]+array[m][1-c%2],array[k][1-(c/2)%2]+array[m][1-c%2]));
    	        			}
    	        			area=lon*width;//if(area==36)System.out.println(i+" "+j+" "+k+" "+m+" "+c);
    	        			if(area<min_area&&area>=sum_area) result.clear();
    	        			if(area<=min_area&&area>=sum_area){result.add(new Rect(Math.max(lon, width),Math.min(lon, width)));min_area=area;}
    	        			
        				}
        			}
        		}
        	}
        	
        	
        out.println(min_area);
        while(!result.isEmpty()){
        	Rect r=result.first();
        	out.println(r.width+" "+r.lon);
        	result.remove(r);
        }
        out.close();
        System.exit(0);
    }  	
    static int bigger(int m1,int m2,int m3,int m4){
    	return Math.max(m1, Math.max(m2, Math.max(m4,m3)));
    }
}



