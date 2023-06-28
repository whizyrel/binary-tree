import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    Node root;

    public static class Node {
        public int value;
        public Node left = null;
        public Node right = null;
        Node(int data) {
            this.value = data;
        }

        @Override
        public String toString() {
            return "Node=" + this.value;
        }

        public int getValue() {
            return value;
        }
    }

    public boolean equals(BinaryTree other) {
        if(other == null)
            return false;

        return equals(root, other.root);
    }

    private boolean equals(Node first, Node second) {
//        INFO both are null
        if (first == null && second == null)
            return true;

        if (first != null && second != null)
//            INFO Visit root
            return first.value == second.value
//                    INFO Visit left
                && equals(first.left, second.left)
//                     INFO Visit right
                && equals(first.right, second.right);

//            INFO any one of both is null
        return false;
    }

// INFO MINIMUM BY ITERATION
    public int min() {
        if (root == null)
            throw new IllegalStateException("Cannot find minimum value of an empty tree");
        Node current = root;
        int lastValue = current.getValue();

        while (current != null) {
            lastValue = current.getValue();
            current = current.left;
        }

        return lastValue;
    }

// INFO MINIMUM BY RECURSION
//    public int min() {
//        if (root == null)
//            throw new IllegalStateException("Cannot find minimum value of an empty tree");
//        return min(root);
//    }

    private int min(Node root) {
        if (isLeaf(root))
            return root.getValue();

        if (root.left == null || root.right == null)
            return root.getValue();

//        INFO POSTORDER TRAVERSAL
//        INFO LEFT
        int leftValue = min(root.left);
//        INFO RIGHT
        int rightValue = min(root.right);

//        INFO ROOTa
//        INFO MAX OF LEFT, RIGHT AND ROOT
        return Math.min(Math.min(leftValue, rightValue), root.value);
    }

    public boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null)
            return -1;

        if (root.left == null && root.right == null)
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node root) {
        if (root == null)
            return;

        inOrderTraversal(root.left);
        System.out.println("[inOrderTraversal][value] " + root.value);
        inOrderTraversal(root.right);
    }

    public void postOrderTraversal() {
        postOrderTraversal(root);
    }

    private void postOrderTraversal(Node root) {
        if (root == null)
            return;

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println("[postOrderTraversal][value] " + root.value);
    }

    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    private void preOrderTraversal(Node root) {
        if (root == null)
            return;

        System.out.println("[preOrderTraversal][value] " + root.value);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public void levelOrderTraversal() {
        if (root == null)
            return;

        List<Node> queue = new ArrayList<>();
        queue.add(root);
        levelOrderTraversal(queue);
    }

    private void levelOrderTraversal(List<Node> queue) {
        if(queue == null || queue.size() == 0)
            return;

        Node current = queue.remove(0);

        System.out.println("[levelOrderTraversal] " + current.getValue());

        if (current.left != null)
            queue.add(current.left);

        if (current.right != null)
            queue.add(current.right);

        levelOrderTraversal(queue);
    }

    public boolean find(int value) {
        return find(value, root);
    }

    private boolean find(int value, Node root) {
        if (root == null) return false;
        if (root.value == value)
            return true;
        else {
            if (root.value > value)
                return find(value, root.left);
            else
                return find(value, root.right);
        }
    }

    public void insert(int value) {
        Node newNodeOfValue = new Node(value);
        if (root == null) {
            root = newNodeOfValue;
            return;
        }
        Node current = root;
//        INFO Infinite loop that breaks later
        while (true) {
//                INFO go left
            if (current.value > value) {
//                INFO found the parent to add ro
                if (current.left == null) {
                    current.left = newNodeOfValue;
//                    INFO end now
                    break;
                }
                current = current.left;
            } else {
//                INFO go right
//                INFO found the parent to add ro
                if (current.right == null) {
                    current.right = newNodeOfValue;
//                    INFO end now
                    break;
                }
                current = current.right;
            }
        }
    }
}
