import java.util.Iterator;
import java.util.NoSuchElementException;

// This class supports iteration of the 
// characters that comprise a string.
class IterableString implements Iterable<Character>, Iterator<Character> {
  private String str;

  private int count = 0;

  public IterableString(String s) {
    str = s;
  }
  // The next three methods implement Iterator.
  public boolean hasNext() {
    if (count < str.length()){
      return true;
    }  
    return false;
  }

  public Character next() {
    if (count == str.length())
      throw new NoSuchElementException();

    count++;
    return str.charAt(count - 1);
  }

  public void remove() {
    throw new UnsupportedOperationException();
  }

  // This method implements Iterable.
  public Iterator<Character> iterator() {
    return this;
  }
}

public class MainClass {
  public static void main(String args[]) {
    IterableString x = new IterableString("This is a test.");

    for (char ch : x){
      System.out.println(ch);
    }
  }
}