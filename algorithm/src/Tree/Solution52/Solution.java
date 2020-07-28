package Tree.Solution52;

public class Solution {
    //104. Maximum Depth of Binary Tree 二叉树的最大深度
    public int maxDepth(TreeNode root) {
        /*
        * 思路：就是进行简单的先序遍历，比较左右子树哪一个深度较深，然后返回较深的一边
        * */
        if (root == null)
            return 0;
        //查找左子树深度
        int n = 1 + maxDepth(root.left);
        //查找右子树深度
        int m = 1 + maxDepth(root.right);
        //比较返回
        return  n > m ? n : m;
    }
}
