import java.util.*;

public class SortedMap {
  public static void main(String[] args) {

    /*
     * Operations are for insert
     * put(key,value)
     * putIfAbsent(key,value)
     * get(key,value)
     * getorDefault(key,value)
     * containsKey(key,value)
     * containsValue(key,value)
     * 
     * 
     */
    // Map<Integer, String> hmap = new HashMap<>(); // No Insertion Order
    Map<Integer, String> hmap = new TreeMap<>(Collections.reverseOrder()); // Insertion Order maintained
    System.out.println(hmap + " " + hmap.size());
    hmap.put(1, "Name");
    hmap.put(2, "Name1");
    hmap.put(3, "Name2");
    hmap.put(4, "Name3");
    System.out.println(hmap + " " + hmap.size());
    hmap.put(1, "Danish");
    hmap.put(50, "Matin");
    hmap.put(5, "Vaibhav");
    hmap.put(12, "Naman");
    System.out.println(hmap + " " + hmap.size());
    hmap.putIfAbsent(58, "Vivek");
    hmap.putIfAbsent(45, "Numan");
    hmap.putIfAbsent(52, "Shubham");
    hmap.putIfAbsent(56, "Shubham");
    System.out.println(hmap + " " + hmap.size());

    System.out.println("Access data  --> " + hmap.get(4));
    System.out.println("Access data  --> " + hmap.get(52));
    System.out.println("Access or Default data  --> " + hmap.getOrDefault(6, "Mr. Nobody"));
    hmap.put(1, hmap.getOrDefault(1, "No One") + " Shaikh");
    System.out.println(hmap + " " + hmap.size());
  }

}
