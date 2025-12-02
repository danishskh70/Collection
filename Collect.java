import java.util.*;

public class Collect {
  public static void main(String[] args) {

    /*
     * Common Methods used by collection Interface
     * 
     * 1.size()
     * 2.isEmpty()
     * 3.clear()
     * add(element)
     * addAll(Collection)
     * contains(element)
     * containsAll(Collection)
     * remove(element)
     * removeAll(element)
     * iterator()
     * toArray()
     * 
     * Autoboxing --> To Converting to wrap int char float into Integer
     * 
     * x=1
     * Integer.valueOf(x)
     */
    /*
     * List -->ArrayList -->LinkedList 
           !--> -->Vector -->Stack
    stored in insertion order
    duplicate allowed
    positional access
    
     */
    // Interface<DataType> name= new className<>();
    List<Integer> listed = new ArrayList<>();
    listed.add(5001);
    System.out.println(listed);
    System.out.println(listed.size());
  }
}
