import java.util.ArrayList;

public class IsPower {

    public static void main(String[] args) {
        IsPower isPower = new IsPower();
        boolean result = isPower.isPower(1);
        System.out.println(result);
        System.out.println((Math.pow(2,31)));
        System.out.println((int)Math.pow(2,31));
    }

    public boolean isPower(int a) {
        //1^n = 1,1,...
        //2^n = 4,8,16,32
        //3^n = 9,27,81
        //4 ignore
        //5^n = 25,125
        // is a power of prime number
        // stop when prime square > a

        if (a < 0)
            return false;
        if (a == 1)
            return true;

        for (int x = 2; x <= Math.sqrt(a); x++) {
            if (isPrime(x)) {
                for (int p=2; p < 32; p++) {
                    double val = Math.pow(x, p);
                    if (val == a)
                        return true;
                    else if (val > a)
                        break;
                }
            }
        }

        return false;

    }

    private boolean isPrime(int x) {

        ArrayList<Integer> primes = new ArrayList<>();

        for (Integer p : primes) {
            if (x % p == 0)
                return false;
        }

        primes.add(x);
        return true;
        // {2,3,5,7,11,13,17};
    }
}
