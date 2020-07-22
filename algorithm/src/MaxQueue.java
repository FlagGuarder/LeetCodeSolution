class MaxQueue {
    private int[] arr;
    private int begin,end;
    public MaxQueue() {
        arr = new int[15000];
        begin = end = 0;
    }

    public int max_value() {
        if (begin == end)
            return -1;
        int ans = Integer.MIN_VALUE;
        for (int i = begin;i < end;i++){
            ans = Math.max(ans,arr[i]);
        }
        return ans;
    }

    public void push_back(int value) {
        arr[end++] = value;
    }

    public int pop_front() {
        if (begin == end)
            return -1;
        return arr[begin++];
    }
}