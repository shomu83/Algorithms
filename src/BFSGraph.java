import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by tbhambure on 3/11/18.
 */
public class BFSGraph {

    private int numberOfNodes;

    private List<Integer> adjList[];

    public BFSGraph(int numberOfNodes) {
        this.numberOfNodes = numberOfNodes;

        adjList = new LinkedList[numberOfNodes];
        for (int i = 0; i < numberOfNodes; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int from, int to) {
        adjList[from].add(to);
    }

    public void BFS(Integer from) {
        boolean[] visited = new boolean[numberOfNodes];

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(from);

        BFS(queue, visited);
    }

    private void BFS(LinkedList<Integer> queue, boolean[] visited) {

        while(!queue.isEmpty()) {
            Integer from = queue.poll();
            System.out.print(from + "->");
            visited[from] = true;

            for (Integer to : adjList[from]) {
                if (!visited[to]) {
                    queue.add(to);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFSGraph g = new BFSGraph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.BFS(2);
    }
}
