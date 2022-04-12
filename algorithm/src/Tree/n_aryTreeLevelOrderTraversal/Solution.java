package Tree.n_aryTreeLevelOrderTraversal;

import java.util.List;
import java.util.Stack;

public class Solution {
    private Stack<Node> stack = new Stack<>();
    public List<List<Integer>> levelOrder(Node root) {
        return null;
    }

    private void initStack(Node root){
        if (root == null)
            return;
        stack.add(root);
        if (root.children==null)
            return;
        for (int i = 0; i < root.children.size(); i++){
            initStack(root.children.get(i));
        }
    }
}
