/**
 * Created by tbhambure on 3/17/18.
 */
public class ReverseInteger {

    public static void main(String[] args) {
        int num = -123450;
//        int num = 1534236469;

        ReverseInteger reverseInteger = new ReverseInteger();

        System.out.println(reverseInteger.reverse(num));
    }

    public int reverse(int x) {

        int multiple = 1;
        if (x < 0) {
            multiple = -1;
            x = x * multiple;
        }

        long result = 0;
        while(x > 0) {
            int remainder = x % 10;
            x = x / 10;
            long current = result * 10 + remainder;
            if (current > Integer.MAX_VALUE)
                return 0; // out of integer range
            result = current;
        }

        return (int)result * multiple;
    }
}
