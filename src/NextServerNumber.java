import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.HashSet;

public class NextServerNumber {

    public static void main(String[] args) throws Exception {

//        int[] servers = new int[] {5, 4, 1, 2};
//        int[] servers = new int[0];
//        int[] servers = new int[] {3, 1, 2};
        int[] servers = new int[] {1, 2, 4};
//        int[] servers = new int[] {5, 4, 1, 2};
//        int[] servers = new int[] {5, 4, 1, 2};
//        int[] servers = new int[] {0, 1};

//        int[] servers = new int[] {1, Integer.MAX_VALUE};

//         int[] servers = null;

        NextServerNumber nextServerNumber = new NextServerNumber();
        int result = nextServerNumber.getNextServerNumber(servers);
        System.out.println(result);
    }

    int getNextServerNumber(int[] servers) throws Exception {

        if (servers == null)
            throw new Exception("Invalid input");

        HashSet<Integer> hashSet = new HashSet<>();

        for(Integer i : servers) {
            if (i < 1)
                throw new IllegalArgumentException("Server number cannot be < 1");
            if (hashSet.contains(i))
                throw new IllegalArgumentException("Dulicate servers");

            hashSet.add(i);
        }

        for (int i = 1; i <= hashSet.size(); i++) {
            if (!hashSet.contains(i)) {
                return i;
            }
        }

        return servers.length + 1;
    }

}
