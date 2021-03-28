package Tree.Solution61;

import java.util.LinkedList;
import java.util.Stack;

public class BSTIterator {
    TreeNode cur;
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        cur = root;
        stack = new Stack<>();
    }

    public int next() {
        while (cur != null){
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int res = cur.val;
        cur = cur.right;
        return res;
    }

    public boolean hasNext() {
        return stack.isEmpty() || cur == null;
    }
}
