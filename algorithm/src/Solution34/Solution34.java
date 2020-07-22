package Solution34;

public class Solution34 {
    public String compressString(String S) {
        String str = new String();
        int time = 1;
        int index = 0;
        int n = S.length();
        if (S == null || S.length() == 0)
            return null;
        str = str + S.charAt(0);
        while (index < n - 1) {
            if (S.charAt(index) == S.charAt(index + 1))
                time++;
            else {

                str = str + time;
                str = str + S.charAt(index + 1);
                time = 1;

            }
            index++;
        }
        str = str + time;
        if (str.length() < S.length())
            return str;
        return S;

    }

}
