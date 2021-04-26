package Array.Solution67;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: John
 * @create: 2021-04-26 09:46
 **/
public class Solution {
    /*
    * 题目：在 D 天内送达包裹的能力
        链接：链接：https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days

        传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送

        带上装载包裹。我们装载的重量不会超过船的最大运载重量。返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
        *
        *
        *
        思路：

        能在 D 天内将传送带上的所有包裹送达的船的最低运载能力，这个完成送达包裹的最低运载力我们称之为理论运载力下限（设为X）如果运载力小于X，

        则无法完成送达包裹的目标，反之运载力大于X，则可以完成运载目的。为了找出X的准确值，我们可以利用二分查找。

        在二分查找的过程中，我们要思考的问题是，我们当前假设的运载力x能否在当天完成送货，此时我们可以利用贪心算法进行问题的检验。

        确认二分查找的边界，我们使用了二分查找，我们就需要确定左边界和右边界；船只的最小运载力必须满足能够运输最大的包裹，即左边界为做大包裹。船的

        运输力不需要大于所有包裹之和，所以二分查找右边界为所有包裹之和即可。

      示例：
        输入：weights = [3,2,2,4,1,4], D = 3
        输出：6
        解释：
        船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
        第 1 天：3, 2
        第 2 天：2, 4
        第 3 天：1, 4

    *
    *
    *
    *
    * */
    public int shipWithinDays(int[] weights, int D) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        int mid;
        // 二叉搜索
        while (left < right){
            // mid为当前假设地
            mid = (left + right) / 2;
            // need为当前二叉搜索所进行运输的天数，currentWeight为当前二叉搜索已运输重量
            int need = 1,currentWeight = 0;
            for (int weight : weights){
                // 如果当天当前重量大于当前船当前假设的负载量
                if (currentWeight + weight > mid){
                    // 当天地运载数量已经大于运载力，转到下一天
                    need++;
                    // 重置一天地运载数量
                    currentWeight = 0;
                }
                currentWeight += weight;
            }
            // 缩小搜索区间
            if (need <= D){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
}

