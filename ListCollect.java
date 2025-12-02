
// import java.util.ArrayList;
// import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListCollect {
  public static void main(String[] args) {

    /*
     * capacity is initially 10 it increased by n+(n/2)+1
     */
    /*
     * Method -->
     * Get Method
     * Set Method (index,element)
     * 
     */
    // Interface<DataType> name= new className<>();
    // List<Integer> list = new ArrayList<>();
    List<Integer> list = new LinkedList<>();

    list.add(5007);
    list.add(5002);
    list.add(5005);
    list.add(5006);
    list.add(5003);
    list.add(5001);
    list.add(5005);
    System.out.println(list);

    System.out.println(" Size of List  --> " + list.size());

    list.remove(0);

    list.remove(Integer.valueOf(5005));
    System.out.println(list);

    System.out.println(" Size of List --> " + list.size());

    System.out.println(list.contains(5001));

    System.out.println(list.get(4));

    System.out.println(list.set(4, 5010));

    System.out.println(list);

    // Traversing

    Iterator<Integer> itr = list.iterator();
    while (itr.hasNext()) {
      System.out.println(itr.next());
    }
    System.out.println();

    // Iterator<Integer> itr = list.listIterator();

    // while (itr.hasNext()) {
    // System.out.println(itr.next());
    // // if(itr.hasPrevious()){
    // // System.out.println(itr.hasPrevious());
    // // break;
    // // }
    // }
    // System.out.println();

    // Sorting

    // list.sort(new Comparator<Integer>() {
    // public int compare(Integer A, Integer B) {
    // // return A - B; // Ascending
    // return B - A; // Decending/
    // }
    // });
    // System.out.println(list);
  }
}
