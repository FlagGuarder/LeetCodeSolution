package string.ratateString;

public class Solution {
    public boolean rotateString(String s, String goal) {
        int m = s.length();
        int n = goal.length();
        if (m != n)
            return false;
        for (int i = 0; i < n; i++){
            boolean flag = true;
            for (int j = 0; j < n; j++){
                if (s.charAt((i+j)%n) != goal.charAt(j)){
                    flag = false;
                    break;
                }
            }
            if (flag)
                return true;
        }
        return false;
    }
}
