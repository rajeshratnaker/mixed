package rajesh.examples.test.questions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 Problems with the current implementation:
 1) No input validation
 2) No initialisation of counters values before increment
 3) Classes not thread safe
 4) Can't write testcase to test it in multithreaded environment as this is not going to work 
 	even in single thread application as it's going to throw NullPointerException in Counters.getCount()
 5) Synchronisation not been done 
 6) Runtime errors as call of wait() and notify() methods without ensuring lock on that object.
 */

public class AsymilateTaskTwo {
	final static String COUNTER="counter";
	/**
	 * Test program tests for the counter increment using 3 threads accessing same counter
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		RajeshCounters counter = new RajeshCounters();
		RajeshCounters.CountListener countListener = counter.new CountListener(COUNTER);
		Thread thread = new Thread(new Tester(counter, COUNTER));
		thread.start();
		Thread thread2 = new Thread(new Tester(counter, COUNTER));
		thread2.start();
		Thread thread3 = new Thread(new Tester(counter, COUNTER));
		thread3.start();
		try{
			while(thread.isAlive() || thread2.isAlive()){
				synchronized (countListener) {
					System.out.println(countListener.waitForIncrement());	
				}
			}
		}catch (InterruptedException e) {
			System.out.println(e);
		}
		counter.addListener(countListener);
		
		
	}
}

class Tester implements Runnable{
	final private RajeshCounters counters;
	final private String COUNTER_NAME;
	public Tester(RajeshCounters counter, String counterName){
		this.counters = counter;
		this.COUNTER_NAME = counterName;
	}
	@Override
	public void run() {
		for(int i=0;i<10;i++){
			try{
				Thread.sleep(100);
				counters.increment(COUNTER_NAME);
			}catch (InterruptedException e) {
				System.out.println(e);
			}
		}
		
	}
	
}

class RajeshCounters {
	// Stores the counters and their associated counts
	private Map<String, Long> storage = Collections.synchronizedMap(new HashMap<String, Long>());
	private List<CountListener> listeners = Collections.synchronizedList(new ArrayList<CountListener>());
	/**
	* Increments the specified counter, notifying any listeners
	* @param counter The key of the counter to increment
	*/
	public void increment(String counter) {
		synchronized (storage) {
			long count = (storage.get(counter)==null)? 0 : storage.get(counter);
			storage.put(counter, ++count);
			System.out.println("Calling increment for "+count);
			storage.notify();
		}
	}
	/**
	* Gets the count for the specified key
	* @param counter The key of the counter
	* @return The count for the specified counter key
	*/
	synchronized public long getCount(String counter) {
		return (storage.get(counter)==null)?0:storage.get(counter);
	}
	/**
	* Resets all of the counters managed by this <code>Counters</code> object to zero.
	*/
	synchronized public void reset() {
		storage = Collections.synchronizedMap(new HashMap<String, Long>());
	}
	/**
	* Adds a listener. The listener is notified when its counter is incremented
	* @param listener The listener to add
	*/
	public void addListener(CountListener listener) {
		listeners.add(listener);
	}
	/**
	* A listener for a specific counter.
	*
	* This class is thread-safe.
	*/
	public class CountListener {
		final private String counter;
		/**
		* Creates a <code>CountListener</code> which listens for increments to the
		* specified counter.
		* @param counter The counter to listen for
		*/
		public CountListener(final String counter) {
			this.counter = counter;
		}
		/**
		* Waits for an increment to occur to this listener's counter. This method will
		* return the value of the counter only when an increment occurs to this counter
		* (or the calling thread is interrupted)
		* @return The value of the counter
		* @throws InterruptedException When the calling thread is interrupted
		*/
		public long waitForIncrement() throws InterruptedException {
			synchronized(storage){
				storage.wait();
				return (storage.get(counter)==null)?0:storage.get(counter);
			}
		}
	}
}

/**
* Maintains a set of counters. Counters are uniquely identified by a <code>String</code>
* key, and can be incremented, and their value retrieved. Listeners can be added for a
* specific counter which will return the value of a counter when it is incremented.
*
* This class is thread-safe.
*/
class Counters {
	// Stores the counters and their associated counts
	private Map<String, Long> storage = new HashMap<String, Long>();
	private List<CountListener> listeners = new ArrayList<CountListener>();
	/**
	* Increments the specified counter, notifying any listeners
	* @param counter The key of the counter to increment
	*/
	public void increment(String counter) {
		long count = storage.get(counter);
		storage.put(counter, count++);
		storage.notify();
	}
	/**
	* Gets the count for the specified key
	* @param counter The key of the counter
	* @return The count for the specified counter key
	*/
	public long getCount(String counter) {
		return storage.get(counter);
	}
	/**
	* Resets all of the counters managed by this <code>Counters</code> object to zero.
	*/
	public void reset() {
		storage = new HashMap<String, Long>();
	}
	/**
	* Adds a listener. The listener is notified when its counter is incremented
	* @param listener The listener to add
	*/
	public void addListener(CountListener listener) {
		listeners.add(listener);
	}
	/**
	* A listener for a specific counter.
	*
	* This class is thread-safe.
	*/
	public class CountListener {
		private String counter;
		/**
		* Creates a <code>CountListener</code> which listens for increments to the
		* specified counter.
		* @param counter The counter to listen for
		*/
		public CountListener(String counter) {
			this.counter = counter;
		}
		/**
		* Waits for an increment to occur to this listener's counter. This method will
		* return the value of the counter only when an increment occurs to this counter
		* (or the calling thread is interrupted)
		* @return The value of the counter
		* @throws InterruptedException When the calling thread is interrupted
		*/
		public long waitForIncrement() throws InterruptedException {
			storage.wait();
			return storage.get(counter);
		}
	}
}