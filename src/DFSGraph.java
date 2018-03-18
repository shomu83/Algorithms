import java.util.LinkedList;
import java.util.List;

/**
 * Created by tbhambure on 3/11/18.
 */
public class DFSGraph {

    private int totalNodes;

    private List<Integer> adj[];

    public DFSGraph(int totalNodes) {

        this.totalNodes = totalNodes;

        adj = new LinkedList[totalNodes];
        for (int i = 0; i < totalNodes; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(Integer from, Integer to) {
        adj[from].add(to);
    }

    public void DFSPreorder(Integer from) {
        boolean[] visited = new boolean[totalNodes];

        DFSPreOrder(from, visited);
    }

    public void DFSPostorder(Integer from) {
        boolean[] visited = new boolean[totalNodes];

        DFSPostOrder(from, visited);
    }

    private void DFSPreOrder(Integer from, boolean[] visited) {

        System.out.print(from + "->");
        visited[from] = true;

        for(int to : adj[from]) {
            if (!visited[to]) {
                DFSPreOrder(to, visited);
            }
        }
    }

    private void DFSPostOrder(Integer from, boolean[] visited) {

        visited[from] = true;

        for(int to : adj[from]) {
            if (!visited[to]) {
                DFSPreOrder(to, visited);
            }
        }

        System.out.print(from + "->");
    }

    public static void main(String args[]) {
        DFSGraph g = new DFSGraph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");

        g.DFSPreorder(2);

        System.out.println("\nFollowing is Depth First Traversal Post Order "+
                "(starting from vertex 2)");

        g.DFSPostorder(2);
    }
}
