import java.util.Stack;

public class Solution6 {
    //接雨水
    public static int trap(int[] height) {
        int ans=0;
        int current = 0;
        Stack<Integer> stack = new Stack<Integer>();
        while (current < height.length){
            while (!stack.empty() && height[current]>height[stack.peek()]){
                int top = stack.peek();
                stack.pop();
                if (stack.empty())
                    break;

                int distance = current - stack.peek() -1;
                int bound_height = Integer.min(height[current],height[stack.peek()]) - height[top];
                ans += distance*bound_height;
            }
            stack.push(current++);
        }


        return ans;




    }

    public static void main(String[] args) {
        int a[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        int temp = trap(a);
        System.out.println(temp);
    }

}
