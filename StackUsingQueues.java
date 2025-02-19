import java.util.*;

public class StackUsingQueues {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();
    
    public void push(int x) {
        queue2.add(x);
        while (!queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }
    
    public int pop() {
        return queue1.isEmpty() ? -1 : queue1.remove();
    }
    
    public int top() {
        return queue1.isEmpty() ? -1 : queue1.peek();
    }
    
    public boolean isEmpty() {
        return queue1.isEmpty();
    }
    
    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
    }
}
