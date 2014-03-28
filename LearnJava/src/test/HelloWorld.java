package test;
import java.util.*;

public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        /*List<Integer> a= new ArrayList<Integer>();
       
        List<Integer> b= new ArrayList<Integer>();
        for(int i=0;i<=5;i++){
        	a.add(i);b.add(i+3);
        }
        a.remove(1);
        b.remove((Integer)6);
        
        Collections.sort(a);
        
        //Object[] c= a.toArray();
        
        Integer[] c=new Integer[5];
        a.toArray(c);
        
        //Object[] d=Arrays.copyOf(c, c.length);
        Object[] d = c;
        
        List<Integer> e=Arrays.asList(c);
        
        System.out.println(a);
        System.out.println(b);
        System.out.println(e);
        for(int i=0;i<d.length;i++)
        	System.out.print(d[i]+" ");
        
        System.out.println("");
        ListIterator<Integer> ptr=b.listIterator();
        while(ptr.hasNext()){
        	System.out.print(ptr.next());
        }
        System.out.print(" ");
        while(ptr.hasPrevious()){
        	System.out.print(ptr.previous());
        }
        System.out.print(" ");
        ptr.add((Integer)9);
        while(ptr.hasPrevious()){
        	System.out.print(ptr.previous());
        }*/
        
		
		List<Integer> a= new ArrayList<Integer>();
		List<Integer> b=new LinkedList<Integer>();
		Random rd = new Random();
		for(int i=0;i<Math.pow(10,5);i++){
			a.add(rd.nextInt());
			b.add(rd.nextInt());
		}
		long startMili=System.currentTimeMillis();
		for(int i=0;i<1000;i++){
			a.add(0,rd.nextInt());
		}
		long stopMili=System.currentTimeMillis();
		System.out.println("use time1: "+(stopMili-startMili));
		
		startMili=System.currentTimeMillis();
		for(int i=0;i<1000;i++){
			b.add(0,rd.nextInt());
		}
		stopMili=System.currentTimeMillis();
		System.out.println("use time2: "+(stopMili-startMili));
		
		
		/*
		Map<Inte,String> a=new HashMap<Inte,String>();
		Map<Inte,String> b=new HashMap<Inte,String>();
		Inte n1=new Inte(1);
		a.put(n1, n1.toString());
		Inte n2=new Inte(1);
		System.out.println(a.get(n2));
		System.out.println(n1+"'s hashcode: "+n1.hashCode());
		System.out.println(n2+"'s hashcode: "+n2.hashCode());
		*/
		
		/*
		Map<Integer,String> a=new HashMap<Integer,String>(); 
		Map<Integer,String> b=new TreeMap<Integer,String>(); 
		Random rd=new Random();
		
		for(int i=0;i<30;i++){
			//int n1=rd.nextInt(30);
			a.put(30-i,((Integer)(30-i)).toString());
			b.put(30-i,((Integer)(30-i)).toString());
		}
		Set<Integer> _a=a.keySet();
		Set<Integer> _b=b.keySet();
		Object[] __a=_a.toArray();
		Object[] __b=_b.toArray();
		
		for(int i=0;i<__a.length;i++){
			System.out.print(__a[i]+ " ");
		}
		System.out.println();
		
		System.out.println(Arrays.binarySearch(__b, 17));
		
		System.out.println();
		System.out.println(_a);
		System.out.println(_b);	
		*/
		
		/*
		Set<Integer> a = new HashSet<Integer>();
		Set<Integer> b =new TreeSet<Integer>();
		Random rd=new Random();
		for(int i=0;i<30;i++){
			int n1=rd.nextInt(100);
			a.add(n1);b.add(n1);
		}
		System.out.println(a);
		System.out.println(b);
		*/
		
		/*
		Queue<Integer> a=new LinkedList<Integer>();
		for(int i=0;i<30;i++){
			a.offer(i);
		}
		while(!a.isEmpty()){
			System.out.print(a.poll()+" ");
		}
		*/
		
		//stack
		/*
		LinkedList<Integer> a= new LinkedList<Integer>();
		for(int i=0;i<30;i++){
			a.addFirst(i);
		}
		while(!a.isEmpty()){
			System.out.print(a.getFirst()+" ");
			a.removeFirst();
		}
		*/
		
		
	}
	/*
	public static class Inte{
		private int i;
		public Inte(int i){
			this.i=i;
		}
		public boolean equals(Object o){
			return o instanceof Inte && (i == ((Inte)o).i);
		}
		public int hashCode(){
			return i*1000;
		}
		public String toString(){
			return ((Integer)i).toString();
		}
	}
	*/
	
}
