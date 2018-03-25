import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;

public class PrimeSum {

    public static void main(String[] args) {

        PrimeSum primeSum = new PrimeSum();
//        ArrayList<Integer> result = primeSum.primesum(2000000000);
        ArrayList<Integer> result = primeSum.primesum(Integer.MAX_VALUE - Integer.MAX_VALUE / 2);

        System.out.println("The two integers are:");
        result.stream().forEach(System.out::println);
    }

    private BitSet primes;

    public ArrayList<Integer> primesum(int a) {

        primes = new BitSet(a);
        fillSievePrimes(a);

        for (int i = 2; i <= a / 2; i++) {
            if (isPrime(i) && isPrime(a - i)) {
                return new ArrayList<>(Arrays.asList(i, a - i));
            }
        }

        //should not be reachable as per Goldbach’s conjecture
        return new ArrayList<>(Arrays.asList(0, 0));
    }

    private boolean isPrime(int num) {
        return primes.get(num);
    }

    private void fillSievePrimes(int n) {
        for (int i=2; i<n; i++)
            primes.set(i);

        for (int i=2; i < Math.sqrt(n); i++) {
            if (primes.get(i)) {
                for (int j = i * 2; j < n && j > 0; j = j + i) {
                    primes.clear(j);
                }
            }
        }
    }

    private boolean isPrimeSimple(int num) {
        if (num == 2)
            return true;

        if (num % 2 == 0)
            return false;

        for (int i = 3; i * i < num; i = i + 2) {
            if (num % i == 0)
                return false;
        }

        return true;
    }
}
