package rajesh.examples.test.questions;
import java.util.HashMap;
import java.util.Map;


public class MapExperiments {
	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		System.out.println(map.put(null, 1));
		System.out.println(map.put(null, 2));
		System.out.println(map.put(null, 3));
	}
}
