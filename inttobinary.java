import java.util.*;

public class inttobinary {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        int number;
        Scanner sc = new Scanner(System.in);

        number = sc.nextInt();

        while (number != 0) {
            stack.push(number % 2);
            number /= 2;
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res = res * 10 + stack.pop();
        }
        System.out.println(res);
        sc.close();
    }
}