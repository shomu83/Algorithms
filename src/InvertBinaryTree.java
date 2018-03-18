/**
 * Created by tbhambure on 3/10/18.
 */
public class InvertBinaryTree {

    public static void main(String[] args) {
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();

        TreeNode root = new TreeNode();
        buildTree(root);
        System.out.println();
        invertBinaryTree.print(root);

        invertBinaryTree.invert(root);
        System.out.println();
        invertBinaryTree.print(root);
    }

    public static void buildTree(TreeNode root) {
        TreeNode left = new TreeNode();
        TreeNode right = new TreeNode();
        root.left = left;
        root.right = right;

        root.value = 5;
        left.value = 2;
        right.value = 8;

        TreeNode rightright = new TreeNode();
        rightright.value = 10;
        right.right = rightright;
    }

    public void invert(TreeNode root) {
        if (root == null)
            return;

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;

        invert(root.left);
        invert(root.right);
    }

    public void print(TreeNode root) {
        if (root == null)
            return;

        print(root.left);
        System.out.print(root.value + ".");
        print(root.right);
    }
}

class TreeNode {
    public TreeNode left, right;
    public int value;
}

