package Solution28;

public class Solution28 {
    public boolean canThreePartsEqualSum(int[] A) {
        boolean ans = false;
        if (A.length < 3)
            return ans;
        int left = 0, right = 0, mid = 0;
        int n = A.length;
        int i = 0,j = 0;
        for (int k = 0; k < n; k++)
            mid += A[k];
        if (mid % 3 != 0)
            return ans;
        int temp = mid/3;
        while (i < n){
            left += A[i++];
            if (left == temp)
                break;
        }
        if (left != temp)
            return ans;
        j = i;
        while (j+1 < n){
            right += A[j++];
            if (right == temp)
                return true;
        }

        return ans;
    }
}
