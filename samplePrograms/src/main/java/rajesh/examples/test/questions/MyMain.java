package rajesh.examples.test.questions;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.ZipOutputStream;
abstract class abs{
	
}
class EnhancedFor{
	public static void main(String[] args) {
		byte arr[]=new byte[]{2,3,4,5};
		for(final int i:getCherArray(arr))
			System.out.println(i+ " ");
	}
	static char[] getCherArray(byte[] arr){
		char[] carr=new char[4];
		int i=0;
		for(byte c:arr){
			carr[i]=(char)c++;
			i++;
		}
		return carr;
	}
}
class ListIntro{
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <=3; i++) 
			list.add(i);
			for(Object obj : list)
				System.out.println(obj + " ");
		
	}
}
class ForLoop{
	public static void main1(String[] args) {
		int j=0;
		int a[]={2,4};
		
		do for(int i:a)
			System.out.println(i+" ");
		while (j++<1) ;
	}
}
class SubString{
	public static void main1(String[] args) {
		StringBuilder sb = new StringBuilder("buffering");
		sb.replace(2,7, "BUFFER");
		sb.delete(2,4);
		System.out.println(sb.substring(1, 5));
	}
}
class xx{
	public static void main1(String[] args)throws Exception {
		new RandomAccessFile("file", "r");
		new InputStreamReader(new FileInputStream("test"));
		//new FileReader(new FileInputStream("t"));
	
	}
}
class threadTest extends Thread{
	public static void mainn(String[] args) {
		ThreatTest t = new ThreatTest();
		t.run();
	}
	public void start(){
		System.out.println("hello");
	}
}

class me{
	protected int getMe(){return 1;} 
}
class p extends me{
	@Override
	public int getMe(){return 1;}
	public static void a(ArrayList<?> c, Object o) {
		//c.add(o.toString());
		
	}
	
	public static void main10(String[] args) {
		ArrayList<String> c=new ArrayList<String>();
		a(c,"one");
		System.out.println(c.size());
		byte b=0;b++;
		int [] l={};
		for(final int i:l){
			
		}
		ZipOutputStream z=null;
		//Deflater;
		//z.putNextEntry(new ZipEntry("hi"));
		
	}
	public static void main11(String[] args) {
		Date aDate=null;
		Calendar aCalendar = Calendar.getInstance();
		aCalendar.setTimeInMillis(1450000000000L);
		aDate = aCalendar.getTime();
		System.out.println(new SimpleDateFormat("dd-MMM-yyyy").format(aDate));
		aCalendar.add(Calendar.DAY_OF_MONTH, 60);
		aDate = aCalendar.getTime();
		System.out.println(new SimpleDateFormat("dd-MMM-yyyy").format(aDate));
	}
}
class ThreatTest implements Runnable{
	static StringBuilder m= new StringBuilder("Hello");
	public static void main11(String[] args) {
		ThreatTest t = new ThreatTest();
		t.m(m);
		try {
			Thread.sleep(Integer.parseInt(args[0]));
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(m);
	}
	public void  m(StringBuilder m) {
		m.append(" World");
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.execute(this);
		executor.execute(this);
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<2;i++){
			try{
				Thread.sleep(1000);
			}catch (InterruptedException e) {
				// TODO: handle exception
			}
			m.append(" "+i);
		}
	}
	
}


class s{
	s(){
		this(0);
		System.out.println("1");
	}
	s(int x){
		System.out.println("2"+x);
	}
}
class ss extends s{
	ss(int x){
		System.out.println("3"+x);
	}
	ss(int x, int y){
		this(x);
		System.out.println("4"+x+y);
	}
	public static void mainn(String[] args) {
		new ss(2,3);
	}
}

class StringSort implements Comparator<String>{

	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return o1.charAt(1)-o2.charAt(1);
	}
	
}
class z extends Error implements Comparable<String>{
	@Override
	public String getMessage(){
		return null;
	}

	@Override
	public int compareTo(String o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
enum e{
	INSTANCE;
	private Map<Integer, String> r = new HashMap<Integer, String>();
	public String get(Integer name){
		return r.get(name);
	}

}

class x{}
class Pine extends x{}
class Oak extends x{}
public class MyMain implements a{
	public static void main13(String[] args) {
		String s1= "My";
		String s2=new String("My");
		System.out.println(s1.matches(s2));
		System.out.println(s1== new String(s2));
		
		System.out.println(s1.hashCode()==s2.hashCode());
		System.out.println(s1=s2);
	}
	public static void main12(String[] args) {
		int [] a={};
		System.out.println(a.length);
		Object arr[]=new Integer[5];
		System.out.println(arr.length);
	}
	public static void mainn(String[] args) {
		File file = new File("c:\\temp\\test.txt");
		File b = new File("c:\\temp\\test2.txt");
		b.delete();
		file.renameTo(b);
	}
	public static void main11(String[] args) {
		int j=0;
		int a[]={2,4};
		do for(int i:a)
			System.out.print(i+" ");
		while(j++<1);
	}
	public static void main9(String[] args) {
		Set<String> set= new LinkedHashSet<String>();
		set.add("3");
		set.add("1");
		set.add("3");
		set.add("2");
		set.add("3");
		set.add("1");
		for(Iterator<String> it= set.iterator();it.hasNext();){
			System.out.println((String)it.next()+"-");
		}
	}
	public static void main1(String[] args) {
		int [][] a2 = new int[5][];
		//int [][]a1= new int[5][]{1,2,3,4,5};
		int i=2; int j=0;
		j=(i++ + i++)* --i;
		System.out.println(j);
	}
	
	public static void main20(String[] args) {
		x tree=new Pine();
		if(tree instanceof Pine)
			System.out.println("Pine");
		if(tree instanceof x)
			System.out.println("tree");
		if( tree instanceof Oak)
			System.out.println("Oak");
		else
			System.out.println("Oops");
	}
	
	public static void main6(String[] args) {
		System.out.println(Math.ceil(-27.2345));;
	}
	public static void main4(String[] args) {
		ArrayList<String> o = new ArrayList<String>();
		o.add("Two");
		o.add("One");
		o.add("Three");
		o.add("Four");
		Collections.sort(o, new StringSort());
		System.out.println(o);
	}
	private int i=10;
	class a{
		void m(){i=20;}
	}
	public static void main2(String[] args) {
		Long i= new Long(10);
		//Long j= (Long)(new Integer(10));
		//if(i.equals(j)) System.out.println();
		//Boolean b= Boolean.parseBoolean(true);
		BufferedReader b= new BufferedReader(null);
				
	}
	public static void mainx(String[] args) {
		double n=98765.4321;
		System.out.println(new DecimalFormat().format(n));
		//System.out.println(DecimalFormat.getInstance("00.0").format(n));
		System.out.println(new DecimalFormat("0.0").format(n));
		System.out.println(n);
		System.out.println(n%98765.00);
		if(0>=0);
			if(0==0);
			System.out.println("1");
			//else System.out.println(" 2 ");
			System.out.println(" 3 ");
			
			
	 String b="t";
	 if("t" == b) System.out.println("t");
	 else System.out.println("f");
	 
	
	}
	 public  void m() throws Exception {};
	MyMain(){
		super();
		
	}
}
 interface a{
	   public  void m()throws Exception;
}
