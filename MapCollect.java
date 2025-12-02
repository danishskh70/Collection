import java.util.*;

public class MapCollect {
  public static void main(String[] args) {
    /*
     * No Parent Class Interface
     * |- Map
     * |--> SortedMap -Interface
     * |--> TreeMap - Class
     * |--> HashMap -Class
     * |-->LinkedHashMap -Interface
     */
    /*
     * In Hash Map there is Key Value Pair
     * Where Key used for hashcode
     * No Duplication Allowed
     * Duplication get overwritten
     * 
     */
    /*
     * Operation in HashMap -->
     * To Insert Values in MAp
     * put(key,element)
     * putIfAbsent(key,element)
     * To Get Access Data
     * get(key);
     * getOrDefault(index,"Default Value"); both get and put together
     * To find the Key or Value
     * containsKey(key)
     * containsValue(value)
     */
    // Map<Integer, String> hmap = new HashMap<>(); // No Insertion Order
    Map<Integer, String> hmap = new LinkedHashMap<>();  // Insertion Order maintained
    System.out.println(hmap + " " + hmap.size());
    hmap.put(1, "Name");
    hmap.put(2, "Name1");
    hmap.put(3, "Name2");
    hmap.put(4, "Name3");
    System.out.println(hmap + " " + hmap.size());
    hmap.put(1, "Danish");
    hmap.put(2, "Matin");
    hmap.put(3, "Vaibhav");
    hmap.put(4, "Naman");
    System.out.println(hmap + " " + hmap.size());
    hmap.putIfAbsent(3, "Vivek");
    hmap.putIfAbsent(4, "Numan");
    hmap.putIfAbsent(5, "Shubham");
    System.out.println(hmap + " " + hmap.size());

    System.out.println("Access data  --> " + hmap.get(4));
    System.out.println("Access data  --> " + hmap.get(6));
    System.out.println("Access or Default data  --> " + hmap.getOrDefault(6, "Mr. Nobody"));

    System.out.println("Find data  --> " + hmap.containsKey(5));
    System.out.println("Find data  --> " + hmap.containsValue("Danish"));

    // Traversing

    for (Map.Entry<Integer, String> entry : hmap.entrySet()) {
      System.out.println("Key " + entry.getKey() + ", Value -->" + entry.getValue());
    }

    for (Integer key : hmap.keySet()) {
      System.out.println("Key " + key);
    }

    for (String str : hmap.values()) {
      System.out.println("Value --> " + str);
    }
  }
}
