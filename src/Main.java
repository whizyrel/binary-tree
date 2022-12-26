import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        List<Integer> valueList = new ArrayList<>();
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
    }
}