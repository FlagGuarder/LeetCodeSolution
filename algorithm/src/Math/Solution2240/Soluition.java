package Math.Solution2240;

public class Soluition {
    /*
    *给你一个整数 total ，表示你拥有的总钱数。同时给你两个整数 cost1 和 cost2 ，分别表示一支钢笔和一支铅笔的价格。
    * 你可以花费你部分或者全部的钱，去买任意数目的两种笔。请你返回购买钢笔和铅笔的 不同方案数目 。
    *
    * */

    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        if (cost1 < cost2)
            return waysToBuyPensPencils(total,cost2,cost1);
        int cnt=0; long res =0;
        while (cnt * cost1 < total){
            res += (total - cost1 * cnt )/cost2 + 1;
            cnt++;
        }
        return res;
    }
}
