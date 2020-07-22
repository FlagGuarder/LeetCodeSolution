public class Solution37 {

    public static void main(String[] args) {

        System.out.printf(""+isPrime(10000000));
    }
    public static boolean isPrime(int num){
        //传入参数为整型，小于等于3的素数只有2、3；利用判断条件可以以下判断参数是否为素数，
        if (num <= 3){
            return num > 1;
        }
        //素数有个规律，它的值总是与6的倍数相差1，利用以下逻辑控制，可以筛选出不符合特点的数据，实现优化
        if ((num % 6) != 1 && (num % 6) != 5){
            return false;
        }
        //数字进行因式分解，其中因式分解最小的值不会超过，数字的平方根，遍历至平方根即可，再次优化
        int n = (int) Math.sqrt(num);

        for (int i = 5; i < n; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
