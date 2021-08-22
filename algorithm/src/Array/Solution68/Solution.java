package Array.Solution68;

public class Solution {
    /**
     * @ClassName:
     * @Author:     flagGuarder
     * @Description:
     * 789. 逃脱阻碍者
     *
     * 你在进行一个简化版的吃豆人游戏。你从 [0, 0] 点开始出发，你的目的地是arget = [xtarget, ytarget] 。地图上有一些阻碍者，以数组 ghosts 给出，第 i 个阻碍者从ghosts[i] = [xi, yi]出发。所有输入均为 整数坐标 。
     *
     * 每一回合，你和阻碍者们可以同时向东，西，南，北四个方向移动，每次可以移动到距离原位置 1 个单位 的新位置。当然，也可以选择 不动 。所有动作 同时 发生。
     *
     * 如果你可以在任何阻碍者抓住你 之前 到达目的地（阻碍者可以采取任意行动方式），则被视为逃脱成功。如果你和阻碍者同时到达了一个位置（包括目的地）都不算是逃脱成功。
     *
     * 只有在你有可能成功逃脱时，输出 true ；否则，输出 false 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/escape-the-ghosts
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 示例1：
     * 输入：ghosts = [[1,0],[0,3]], target = [0,1]
     * 输出：true
     * 解释：你可以直接一步到达目的地 (0,1) ，在 (1, 0) 或者 (0, 3) 位置的阻碍者都不可能抓住你。
     *
     *
     * @Date:    2021/8/22
     */

    /**
     解题思路：
     我们知道，糖豆人（题目中的目标 S）和ghost（G），到达终点（target T）都有一个最短距离，最短距离为曼哈顿；例如糖豆人S到终点T
     的曼哈顿距离则为dist(S,T) = |xS - xT| + | yS - yT| ；如果ghost到达终点的距离 小于 糖豆人到终点的距离，那么糖豆人是一
     定会被抓住，通不了关的。

     那如果糖豆人到达终点的距离 小于 ghost的距离，糖豆人是否有可能会被ghost拦截下来？
     利用反证法，我们可以假设即使即使糖豆人到终点的距离 小于 ghost到终点的距离
     dist(S,T) < dist(G,T)
     ，他还是有可能在X点被ghost拦截。 因为糖豆人是按着最短距离移动，所以X点一定是在糖豆人去终点最短距离的路径上的。即：
     dist(S,X) + dist(X,T) = dist(S,T)
     由于X是拦截点，那么ghost到达X点的时间肯定要 等于或早于 糖豆人的到达时间，即
     dist(S,X) >= dist (G,X), 故 dist(S,X) + dist(X,T) >= dist(G,X) + dist(X,T)  即
     dist(S,T) >= dist(G,T) ,
     这显然是与假设 dist(S,T) < dist(G,T)相矛盾，所以可知
     糖豆人到达终点的距离 小于 ghost到终点的距离时，是不可能被拦截的。
     */
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int[] source = {0,0};
        int sourceDistance = manhattanDistance(source,target);
        for (int i = 0; i < ghosts.length; i++){
            int[] ghost = ghosts[i];
            if (sourceDistance >= manhattanDistance(ghost,target)){
                return false;
            }
        }
        return true;
    }

    public int manhattanDistance(int[] point1, int[] point2){
        return Math.abs(point2[0] - point1[0]) + Math.abs(point2[1] - point1[1]);
    }
}
