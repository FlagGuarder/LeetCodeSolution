public class Solution8 {
    private int[][] Month = {
            {0,31,28,31,30,31,30,31,31,30,31,30,31},
            {0,31,29,31,30,31,30,31,31,30,31,30,31}
    };
    private int[] Day = {365,366};
    public int daysBetweenDates(String date1, String date2) {
        int ans = -1;
        String[] s1 = date1.split("-");
        String[] s2 = date2.split("-");
        int year1 = Integer.valueOf(s1[0]); int year2 = Integer.valueOf(s2[0]);
        int month1 = Integer.valueOf(s1[1]); int month2 = Integer.valueOf(s2[1]);
        int day1 = Integer.valueOf(s1[2]); int day2 = Integer.valueOf(s2[2]);
        int an1 = gap(year1,month1,day1); int an2 = gap(year2,month2,day2);
        ans = (an1-an2) >= 0? an1-an2 : an2-an1;
        return ans;

    }
    public int isleapyear(int year){
        if ((year % 4 == 0 && year % 100 !=0) || (year % 400 == 0))
            return 1;
        return 0;
    }
    public int gap(int year, int month, int day){
        int sum =0;
        int flag = isleapyear(year);
        for (int i = 1971; i < year; i++){
            sum += Day[isleapyear(i)];
        }
        for (int i =1; i < month; i++){
            sum+=Month[flag][i];
        }

        sum +=day;
        return sum;
    }
}
