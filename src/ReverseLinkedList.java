import java.util.Stack;

/**
 * Created by tbhambure on 3/17/18.
 */
public class ReverseLinkedList {

    public static void main(String[] args) {

        Node<Integer> root = new Node<>(1);
        root.next = new Node<>(2);
        root.next.next = new Node<>(3);
        root.next.next.next = new Node<>(4);

        ReverseLinkedList list = new ReverseLinkedList();
        list.printList(root);

        Node newRoot = list.newRoot(root);
        Node first = list.reverse(root);
        first.next = null;

        list.printList(newRoot);

        Node newRoot2 = list.reverseUsingStack(newRoot);
        list.printList(newRoot2);
    }

    public void printList(Node root) {
        System.out.println();

        Node node = root;
        while (node != null) {
            System.out.print(node.value + "->");
            node = node.next;
        }
    }

    public Node newRoot(Node root) {
        while (true) {
            if (root.next == null)
                return root;
            root = root.next;
        }
    }

    public Node reverse(Node root) {

        // 1->2->3

        if (root == null)
            return null;

        Node later = reverse(root.next);
        if (later != null) {
            later.next = root;
        }

        return root;
    }

    public Node reverseUsingStack(Node root) {

        Stack<Node> stack = new Stack();

        while (root != null) {
            stack.push(root);
            root = root.next;
        }

        //2
        //1

        Node newRoot = stack.pop(); //2
        Node top = newRoot;
        while(!stack.isEmpty()) {
            Node node = stack.pop(); //1
            top.next = node; // 2->1
            top = node; // 1
        }
        top.next = null;

        return newRoot;
    }
}

class Node<T> {

    Node next;
    T value;

    public Node(T t) {
        value = t;
    }

}
