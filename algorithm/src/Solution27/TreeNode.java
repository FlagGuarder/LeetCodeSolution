package Solution27;

import java.util.Iterator;

class TreeNode {
    private   int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }


}
class Solution {
     private int max = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null || root.left == null && root.right == null)
            return 0;
        dfs(root);
        return max;
    }
    public int dfs(TreeNode root){
        if (root == null)
            return -1;
        if (root.left == null & root.right == null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        max = (right+1+left+1) > max ? (right+1 + left+1) : max;
        return  left > right ? (left+1) : (right+1);
    }
}
