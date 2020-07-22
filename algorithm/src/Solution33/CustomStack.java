package Solution33;

public class CustomStack {
    private int[] stack;
    //private int start = 0;
    private int end = 0;
    public CustomStack(int maxSize) {
        stack = new int[maxSize];
    }

    public void push(int x) {
        if (end == stack.length)
            return;;
        stack[end++] = x;
    }

    public int pop() {
        if (0 == end)
            return -1;
        return stack[--end];

    }

    public void increment(int k, int val) {
        int n;
        if (k > stack.length)
            k = stack.length;
        for (int i = 0; i < k; i++)
            stack[i] += val;
    }
}
