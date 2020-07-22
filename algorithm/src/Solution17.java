public class Solution17 {
    /*合并排序的数组
    * 尾插法，由于A有足够的空间，从两数组末端开始遍历，插入数组A的末端，直至数组B结束
    * */
    public void merge(int[] A, int m, int[] B, int n) {
        //A.B均为空指针
        if (A == null && B == null || m == 0 && n == 0)
            return;
        //B为空指针或者B长度为0
        if (B == null || n == 0)
            return;

        int M = m+n-1;
        m--;

        n--;
        while (n >= 0){
            if (m < 0){
                while (n >= 0)
                    A[M--] = B[n--];
                break;
            }
            A[M] = B[n] > A[m] ? B[n--] : A[m--];
            M--;
        }



    }
}
