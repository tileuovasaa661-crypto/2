import java.util.Deque;
import java.util.ArrayDeque;

class MinStack {
    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> min = new ArrayDeque<>();

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty() || x <= min.peek()) {
            min.push(x);
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;

        int val = stack.pop();
        if (val == min.peek()) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}