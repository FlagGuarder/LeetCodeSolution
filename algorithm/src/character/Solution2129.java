package character;

public class Solution2129 {


    public static String capitalizeTitle(String title) {
        int i = -1;
        char[] charArray = title.toCharArray();
        for (int ci = 0; ci < title.length(); ci++){
            if (title.charAt(ci)!=' '){
                charArray[ci] = (char) ((charArray[ci] - 32) < 65 ? (charArray[ci] +32) : charArray[ci]);
                continue;
            }
            if (ci - i > 3){
                charArray[i+1] = (char) ((charArray[i+1] - 32) < 65 ?  charArray[i+1] : charArray[i+1] -32);
            }
            i = ci;
        }
        charArray[i+1] = (title.length()-i >3 ) ? (char) ((charArray[i+1] - 32) < 65 ?  charArray[i+1] : charArray[i+1] -32) : charArray[i+1];

        return new String(charArray);
    }
    public static void main(String[] args) {
        System.out.println(capitalizeTitle("capiTalIze tHe titLe"));
        System.out.println(capitalizeTitle("First leTTeR of EACH Word"));
        System.out.println(capitalizeTitle("i lOve leetcode"));

    }
}
