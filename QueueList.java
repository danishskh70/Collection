import java.util.*;
// import java.util.Comparator;

public class QueueList {
  public static void main(String[] args) {

    /*
     * Methods are -->
     * 
     * offer(element) --add element
     * peek() -- see who is first element
     * poll() -- remove the first element
     * 
     * Using Deque Inteface
     * 
     * peek()
     * peekFirst()
     * peekLast()
     * 
     * poll()
     * pollFirst()
     * pollLast()
     * 
     * offer()
     * offerFirst()
     * offerLast()
     * 
     */
    // Queue<Integer> queue = new LinkedList<>();
    // Queue<Integer> queue = new ArrayDeque<>();
    Deque<Integer> queue = new LinkedList<>();

    queue.offer(50);
    queue.offer(51);
    queue.offer(52);
    queue.offer(53);
    queue.offer(54);
    queue.offer(54);

    // Deque adding
    queue.offerFirst(52);
    queue.offerFirst(53);
    queue.offerLast(59);
    queue.offerLast(58);

    // System.out.println(queue);
    // System.out.println("Size " + queue.size());

    // System.out.println("Peek " + queue.peek());
    // System.out.println("Poll " + queue.poll());

    // // Deque peek and poll

    // System.out.println("Peek " + queue.peekFirst());
    // System.out.println("Poll " + queue.pollFirst());

    // System.out.println("Peek " + queue.peekLast());
    // System.out.println("Poll " + queue.pollLast());

    // System.out.println(queue);
    // System.out.println("Size " + queue.size());

    /*
     * Priority Queue
     * Use min heap
     * Can convert to max heap
     * 
     * 
     * 
     */

    // Queue<Integer> que = new PriorityQueue<>(); // min heap
    // Queue<Integer> que = new PriorityQueue<>(Comparator.reverseOrder()); // max
    // heap
    Queue<Integer> que = new PriorityQueue<>(Collections.reverseOrder()); // max
    // heap

    que.add(5);
    que.add(2);
    que.add(17);
    que.add(8);
    System.out.println(que);
    System.out.println("Peek " + que.peek());
    System.out.println("Poll " + que.poll());
    System.out.println(que);
  }
}
