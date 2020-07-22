public class Solution18 {
    /*粉糖果*/
    public int[] distributeCandies(int candies, int num_people) {

        int ans[] = new int[num_people ];
        int i =0;
        int curGivenCan = 1;
        if (candies <= 0)
            return ans;
        while (candies > 0){
            if (i == num_people)
                i = 0;
            if (candies < curGivenCan)
                curGivenCan = candies;

            ans[i] += curGivenCan;
            candies -= curGivenCan;
            curGivenCan++;
            i++;
        }

        return ans;
    }
}
