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

        if (current == null)
            return;

        System.out.println("current: " + current.getValue());

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
