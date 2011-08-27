
public class test_non_ikm {
	public static void main1(String[] args) {
		double d=7/4;
		Long l=1l;
		m(l);
		System.out.println(l);
		//System.out.println(d);
	}
	static void m(Long l){
		l +=2;
		System.out.println(l);
	}
	public static void main12(String[] args) {
		boolean b = test2() || test3() && test1() || test4();
		System.out.println(b);
	}
	static boolean test1(){
		System.out.println(" 1 false ");
		return false;
	}
	static boolean test3(){
		System.out.println(" 3 true ");
		return true;
	}
	static boolean test4(){
		System.out.println(" 4 true ");
		return true;
	}
	static boolean test2(){
		System.out.println(" 2 false ");
		return false;
	}
	public static void mainn(String[] args) {
		byte b1=2;
		byte b2=0;
		//byte b3=b1+b2;
		//System.out.println(b3/b2);
		Integer i=10; 
	}
	public static void main(String[] args) {
		double d1=10;
		double d2=d1/0;
		System.out.println(d2);
		//int:s it's exception
	}
	
}
