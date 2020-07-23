package DynamicPlanning.Solution44;

public class Solution44 {
    //leetcode编号96：不同的二插搜索树
    public static int numTrees(int n) {
        /*
        *   我们可以设G(n)为节点数为n时的二插搜索树的不同个数，F(i,n)为以i为根结点，长度为n时，搜索二插树的不同个数
        *   那么G(n) = F(1,n) + F(2,n) + ... + F(n,n)   (1)
        *   且F(i,n) = G(i-1) * G(n-i)                  (2)
        *   所以由(1),(2)式可以推理出 ->  (2)代入(1)中，得  G(n) = G(0) * G(n-1) + G(1) * G(n-2) + ... + G(n-1) * G(0)
        *   接下来详细讲解一下(1),(2)的来源：
        *   首先是(1)，一个长度为n的序列，根结点不同，就会产生不同的二插搜索树，所以长度为n的序列产生的不同二插树个数，是不同根结点
        *   产生的二插搜索树的和，即(1)式
        *   (2) 也很好理解，我们知道，二插搜索树中，小于根结点的树会插入到左子树，大于根结点则插入右子树，所以当根节点为i时，左子树
        *   的节点为（1，i-1），右子树为（i+1，n），所以左子树节点数为（i-1），能产生不同的二插搜索树子树个数为G(i-1)，同理右子树能产生
        *   不同的二插搜索树子树个数为G(n-i)，左子树和右子树的组合有多种，总和为左子树种类和右子树的笛卡尔积，笛卡尔积不了解的自己搜索一下
        *   所以得到 G(n) = G(0) * G(n-1) + G(1) * G(n-2) + ... + G(n-1) * G(0)
        *   (3)式只需要进行简单数学运算即可得出
        *
        * */
        int[] G = new int[n+1];
        //我们知道二插搜索树中，节点数只有一个或者零个，个数只有一个
        G[1]=G[0]=1;
        for (int i = 2; i <= n; ++i){
            //依次计算G(0),G(1)...存储中间计算结果，直至G(n)
            for (int j = 0; j < i; ++j){
                G[i] += G[j] * G[i-1-j];
            }
        }
        return G[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }
}