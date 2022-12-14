package leetcode;

import org.junit.jupiter.api.Test;

public class BinaryTreeLevelOrderTraversalTest {
    private BinaryTreeLevelOrderTraversal obj = new BinaryTreeLevelOrderTraversal();

    @Test
    void test() {
        System.out.println(obj.levelOrder(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
    }
}
