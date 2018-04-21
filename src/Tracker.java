import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Tracker {

    HashMap<String, ArrayList<Integer>> hostServerMap = new HashMap<>();
    NextServerNumber nextServerNumber = new NextServerNumber();

    public static void main(String[] args) throws Exception {
        Tracker tracker = new Tracker();
        String host = tracker.allocate("host");
        System.out.println(host);

        host = tracker.allocate("host");
        System.out.println(host);

        host = tracker.allocate("another");
        System.out.println(host);

        tracker.deallocate("host1");
        System.out.println("Removed host1");

        host = tracker.allocate("host");
        System.out.println(host);

        host = tracker.allocate("host");
        System.out.println(host);
    }

    String allocate(String host) throws Exception {

        if (!hostServerMap.containsKey(host)) {
            hostServerMap.put(host, new ArrayList<>());
        }

        int size  = hostServerMap.get(host).size();
        int[] arr = new int[size];

        for(int i = 0; i < size; i++) {
            if (hostServerMap.get(host) != null) {
                arr[i] = hostServerMap.get(host).get(i);
            }
        }
        int nextServer = nextServerNumber.getNextServerNumber(arr);

        hostServerMap.get(host).add(nextServer);

        return host + nextServer;
    }

    void deallocate(String host) {

        Scanner scanner = new Scanner(host).useDelimiter("[^0-9]+");
        Integer server = scanner.nextInt();
        host = host.replaceAll(server.toString(), "");
        hostServerMap.get(host).remove(server);
    }
}
