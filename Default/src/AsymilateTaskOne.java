import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.google.common.collect.ImmutableList;

/**
 * Main client Program to test the implementation
 * @author rajesh
 */
public class AsymilateTaskOne {
	public static void main(String[] args) {
		PrimeFinder primeFinder = new ConcretePrimeFinder();
		Iterator<Integer> iterator = primeFinder.findPrimeNumber(2, 7);
		try{
			Thread.sleep(11000);
		}catch (InterruptedException e) {
			System.out.println("Thread interrupted "+e);
		}
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
}
//Main Interface
interface PrimeFinder{
	/**
	 * @param lowerBound 
	 * @param uppderBound
	 */
	Iterator<Integer> findPrimeNumber(int lowerBound, int uppderBound);
}
/**
 * implementation of Interface PrimeFinder 
*/
class ConcretePrimeFinder implements PrimeFinder{
	final private Map<Integer, Object> primeNumMap = new ConcurrentHashMap<Integer, Object>();
	
	/**
	 * @param lowerBound
	 * @param uppderBound
	 * @return Iterator : lazy iterator
	 */
	@Override
	public Iterator<Integer> findPrimeNumber(int lowerBound, int uppderBound) throws IllegalArgumentException{
		if(lowerBound > uppderBound) throw new IllegalArgumentException("Illegal range ["+lowerBound+", "+uppderBound+"]to find prime numbers");
		int firstPrime = MathUtilForPrimes.firstPrimeNumber(lowerBound, uppderBound);
		Thread finder1 = new Thread(new Finder(primeNumMap, lowerBound, firstPrime));
		Thread finder2 = new Thread(new Finder(primeNumMap, firstPrime, uppderBound));
		finder1.start();
		finder2.start();
		return new CustomIterator(primeNumMap,  ImmutableList.of(finder1,finder2));
	}
	
	/**
	 * Lazy iterator which keeps refreshing itself every 10 millis
	 * @author rajesh
	 *
	 */
	class CustomIterator implements Iterator<Integer>{
		final Map<Integer, Object> map;
		Iterator<Integer> iterator; 
		public CustomIterator(final Map<Integer, Object> map, final List<Thread> finders){
			this.map = map;
			this.iterator = map.keySet().iterator();
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try{
						while(isAlive(finders)){
							Thread.sleep(10);
							iterator = map.keySet().iterator();
						}
					}catch (InterruptedException e) {
						System.out.println("Refresh thread interrupted" +e);
					}
				}

				private boolean isAlive(List<Thread> finders) {
					for(Thread thread:finders){
						if(thread.isAlive())
							return true;
					}
					return false;
				}
			}).start();
		}
		@Override
		public boolean hasNext() {
			return iterator.hasNext();
		}

		@Override
		public Integer next() {
			return iterator.next();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException(" Remove on Iterator unsupported");
			
		}
		
	}
	
	/**
	 * Prime finder thread
	 *
	 */
	class Finder implements Runnable{
		final private Map<Integer, Object> primeNumMap ;
		private int lower;
		private int higher;
		/**
		 * 
		 * @param map
		 * @param l
		 * @param u
		 */
		public Finder(final Map<Integer, Object> map, final int l, final int u){
			primeNumMap = map;
			lower = l;
			higher = u;
		}
		@Override
		public void run() {
			while(lower <= higher){
				if(MathUtilForPrimes.isPrime(lower++)){
					primeNumMap.put(lower-1, new Object());
				}
			}
		}
		
	}
	
}


/**
 * Helper class
 *
 */
class MathUtilForPrimes{
	/**
	 * 
	 * @param num
	 * @return
	 * @throws IllegalArgumentException
	 */
	static boolean isPrime(int num) throws IllegalArgumentException{
		boolean flag=true;
		if(num<1){
			throw new IllegalArgumentException("Illeagal Argument to check for prime number of "+num);
		}
		for(int i=2 ; i<=Math.sqrt(num) ; i++){
			if(num%i == 0){
				flag=false;
				break;
			}
		}
		return flag;
	}
	
	/**
	 * 
	 * @param lower
	 * @param higher
	 * @return
	 * @throws IllegalArgumentException
	 */
	static Integer firstPrimeNumber(int lower, int higher) throws IllegalArgumentException{
		Integer firstPrimeNumber = null;
		if(lower>=higher){
			throw new IllegalArgumentException("Illegal argument to find out first prime number as lower boundary "+lower+" is greater/equals to higher bounday "+higher);
		}
		while(lower<higher){
			if(isPrime(lower++)){
				firstPrimeNumber = lower-1;
				break;
			}
		}
		return firstPrimeNumber;
	}
}

