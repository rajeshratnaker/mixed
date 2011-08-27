import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Properties;


public  class ExecutorTest {
	private int i=10;
	public static void main1(String[]str) throws Exception{
//		String a="A";
//		String b="B";
//		String ll=null;
//		StringBuffer buf=new StringBuffer("C");
//		Formatter fmt = new Formatter(buf);
//		fmt.format("%s%s", a, b);
//		System.out.println(fmt);
//		fmt.format("%-2s", b);
//		System.out.println(fmt);
//		fmt.format("%b", ll);
//		System.out.println(fmt);
		Properties p = new Properties();
		p.load(new FileInputStream("t"));
		String a= p.getProperty("a");
		Integer b = new Integer(p.getProperty("b"));
		Integer i = 3;
		Integer j = null;
		System.out.println();
	}
		public static void main(String[]str) throws Exception{
		 byte c1[]={10,20,30,40,50};
		 byte c2[]={60,70,80,90};
		 ByteArrayOutputStream b1 = new ByteArrayOutputStream();
		 ByteArrayOutputStream b2 = new ByteArrayOutputStream(10);
		 b2.write(100);
		 System.out.println(b2.size());
		 b2.write(c1,0,c2.length);
		 System.out.println(b2.size());
		 byte b[]=b2.toByteArray();
		 System.out.println(b.length);
		 b2.flush();
		 System.out.println(b2.size());
		 b2.reset();
		 System.out.println(b2.size());
		 b1.writeTo(b2);
		 System.out.println(b1.size());
		}
	private void v(ExecutorTest t){
		System.out.println(t.i);
	}
}

	

