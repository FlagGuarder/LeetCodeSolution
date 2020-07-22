package Solution38;

public class Solution38 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;

        if (n%2 == 0){
            n /= 2;
        }else {
            n = n/2+1;
        }
        if (nums1.length==0)
            return nums2[n];
        if (nums2.length==0)
            return nums1[n];
        int i = 1;
        int index1 = 1, index2 = 1;
        int sin = 0;
        while (i<=n){
            if (index1 <= nums1.length && index2 <= nums2.length){
                if (nums1[index1] > nums2[index2]){
                    index2++;
                    sin = 2;
                }else {
                    index1++;
                    sin = 1;
                }
            }else if (index1 <= nums1.length){
                index1++;
                sin = 1;
            }else {
                index2++;
                sin = 2;
            }
            i++;
        }
        if (sin == 1){
            return nums1[index1-1];
        }else {
            return nums2[index2-1];
        }
    }
}
