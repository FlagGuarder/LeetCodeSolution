package Tree.Solution1161;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
/*
* 本题解题思路在于层序遍历，只需要将所得到的二叉树进行层序遍历，保留计算过程中的最大值和最低层数即可。
*
*
* */
public class Solution {

    Integer floor = 0;

    Integer sumMax = Integer.MIN_VALUE;

    List<TreeNode> treeNodes = new ArrayList<>();


    public int maxLevelSum(TreeNode root) {
        int floorTemp = 0;
        if (root == null)
            return 0;
        treeNodes.add(root);
        while (!treeNodes.isEmpty()){
            floorTemp++;
            Integer floorSum = calculateFloorSum();
            if (floorSum > sumMax){
                sumMax = floorSum;
                floor = floorTemp;
            }
            putSonNode();
        }
        return floor;
    }

    private Integer calculateFloorSum(){
        Integer floorSum = 0;
        for (int i = 0; i < treeNodes.size();i++){
            TreeNode treeNode = treeNodes.get(i);
            floorSum += treeNode.val;
        }
        return floorSum;
    }

    private void putSonNode(){
        List<TreeNode> newTreeNodes = new ArrayList<>();

        for (int i = 0; i < treeNodes.size(); i++) {
            TreeNode treeNode = treeNodes.get(i);
            if (treeNode.left!=null){
                newTreeNodes.add(treeNode.left);
            }
            if (treeNode.right!=null){
                newTreeNodes.add(treeNode.right);
            }
        }
        treeNodes = newTreeNodes;
    }


}
