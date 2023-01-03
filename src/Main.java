import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> valueList = Arrays.asList(10, 5, 15, 6, 1, 8, 12, 18, 17);
//        [10, 5, 15, 6, 1, 8, 12, 18, 17]
//               10
//        5              15
//      1   6        12     18
//             8           17

        BinaryTree tree = new BinaryTree();
        valueList.forEach(tree::insert);
        tree.levelOrderTraversal();
        System.out.println("[find] 18 : " + tree.find(18));
        System.out.println("[find] 10 : " + tree.find(10));
        System.out.println("[find] 20 : " + tree.find(20));
        System.out.println("[find] 25 : " + tree.find(25));
        System.out.println("[find] 18 : " + tree.find(18));
        System.out.println("===== Pre-Order Traversal =====");
        tree.preOrderTraversal();
        System.out.println("===== Post-Order Traversal =====");
        tree.postOrderTraversal();
        System.out.println("===== In-Order Traversal =====");
        tree.inOrderTraversal();
        System.out.println("===== Height of root =====");
        System.out.println("height of root: " + tree.height());
        System.out.println("===== Minimum value in a tree =====");
        System.out.println("Minimum value in a tree: " + tree.min());
    }
}