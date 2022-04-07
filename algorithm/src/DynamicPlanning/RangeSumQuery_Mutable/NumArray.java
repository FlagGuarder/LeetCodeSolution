package DynamicPlanning.RangeSumQuery_Mutable;

class RangeSumQuery_Mutable {
    int[] nums;
    public RangeSumQuery_Mutable(int[] nums) {
        this.nums = nums;
    }

    public void update(int index, int val) {
        if (nums == null || nums.length <= index)
            return;
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        if (left < 0 || right >=nums.length)
            return 0;
        int sum = 0;
        for (int i = left; i <= right; i++){
            sum += nums[i];
        }
        return sum;
    }
}