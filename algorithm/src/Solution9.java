public class Solution9 {
    /*求最大3的倍数*/
    public static String largestMultipleOfThree(int[] digits) {
        String ans = new String();
        int[] in = new int[10];
        int[] mod = new int[3];
        int sum =0;
        int num_delete=0,num_mod=0;
        for (int temp : digits){
            sum += temp;
            ++mod[temp%3];
            ++in[temp];
        }
        if (sum % 3 == 1){
            if (mod[1]>=1){
                num_delete = 1;
                num_mod = 1;
            }else {
                num_delete =2;
                num_mod = 2;
            }
        }else if (sum % 3 == 2){
            if (mod[2] >= 1){
                num_delete = 1;
                num_mod = 2;
            }else {
                num_delete = 2;
                num_mod = 1;
            }
        }
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < in[i]; j++){
                if (num_delete!=0 && (num_mod == i % 3)){
                    num_delete--;
                }else {
                    ans = String.valueOf(i) + ans ;
                }
            }
        }
        if (ans.length() == 0 )
            return "";
        else if ( ans.charAt(0)  == '0')
            return "0";
        else
            return ans;
    }

    public static void main(String[] args) {
        int [] digits = {1};
        System.out.println(largestMultipleOfThree(digits));
    }
}
