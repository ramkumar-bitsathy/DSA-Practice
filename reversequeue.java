import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class reversequeue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(List.of(1,2,3,4,5));

        Stack<Integer> stack = new Stack<>();
        System.out.println("Before reverse:"+queue);
        while (!queue.isEmpty()){
            stack.push(queue.poll());
        }
        while (!stack.isEmpty()){
            queue.add(stack.pop());
        }
        System.out.println("After  reverse:"+queue);
        

    }
}
