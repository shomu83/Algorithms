
import java.util.ArrayList;
import java.util.*;

class SortedArrayOfArrays {

    public static void main(String[] args) {
        //m * n: O(m * n):
        // remove heap O(1)
        // add heap ln(m) * (m * n)

        int data[][] = {
                {2, 5, 7, 10, 12}, //1
                {3, 4, 8, 9, 13}, //0
                {12, 15, 16, 17, 19, 21, 200, 300, 301, 400}, //0
                {11, 14, 20} //0
        };

        SortedArrayOfArrays solution = new SortedArrayOfArrays();
        int[] result = solution.merge(data);

        Arrays.asList(result).stream().forEach(System.out::print);
    }

    int[] merge(int[][] data) {

        ArrayList<Integer> result = new ArrayList<>();
//        Queue<Node> queue = new PriorityQueue<>(4, new Comparator<Node>() {
//            @Override
//            public int compare(Node o1, Node o2) {
//                o1.value.compareTo(o2.value);
//            }
//        });
        Queue<Node> queue = new PriorityQueue<>();
        initializeMinHeap(data, queue);

        while (!queue.isEmpty()) {
            Node min = queue.poll();

            result.add(min.value);
            int i = min.parentIndex;
            int j = min.childIndex;
            if (j + 1 < data[i].length) {
                queue.add(new Node(data[i][j+1], i, j + 1));
            }
        }

        return toPrimitive(result);
    }

    private void initializeMinHeap(int[][] data, Queue<Node> queue) {
        for (int i = 0; i < data.length; i++) {
            Node node = new Node(data[i][0], i, 0);
            queue.add(node);
        }
    }

    private int[] toPrimitive(ArrayList<Integer> result) {
        int[] sorted = new int[result.size()];
        for (int i = 0; i< result.size(); i++)
            sorted[i] = result.get(i);
        return sorted;
    }

    class Node implements Comparable<Node> {
        Integer value;
        int parentIndex;
        int childIndex;

        public Node(int value, int parentIndex, int childIndex) {
            this.value = value;
            this.parentIndex = parentIndex;
            this.childIndex = childIndex;
        }

        @Override
        public int compareTo(Node o) {
            return value.compareTo(o.value);
        }
    }
}



