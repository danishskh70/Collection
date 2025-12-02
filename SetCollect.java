
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetCollect {
  public static void main(String[] args) {
    // Set<Integer> set = new HashSet<>();
    // Set<Integer> set = new LinkedHashSet<>();
    Set<Integer> set = new TreeSet<>();
    set.add(4);
    set.add(3);
    set.add(3);
    set.add(2);
    set.add(1);
    set.add(1);
    set.add(5);
    set.add(6);
    set.add(7);
    set.add(8);
    set.add(6);
    set.add(10);
    System.out.println(set);

    System.out.println(set.contains(4));

    System.out.println(set.remove(4));

    System.out.println(set);

    Iterator<Integer> itr = set.iterator();
    while (itr.hasNext()) {
      System.out.print(itr.next());
    }
  }
}
