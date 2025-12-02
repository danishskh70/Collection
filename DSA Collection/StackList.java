import java.util.Stack;

public class StackList {
  public static void main(String[] args) {

    /*
     * 
     * Operations
     * 
     * push(element)
     * 
     * 
     */
    Stack<Integer> stack = new Stack<>();
    stack.push(5);
    stack.push(10);
    stack.push(55);
    stack.push(25);
    stack.push(15);
    stack.push(56);
    stack.push(51);

    System.out.println(stack);

    System.out.println("Peek in Stack " + stack.peek());

    System.out.println(stack);
    System.out.println("Pop in Stack " + stack.pop());
    System.out.println(stack);
    System.out.println("Size in Stack " + stack.size());

    
  }
}
