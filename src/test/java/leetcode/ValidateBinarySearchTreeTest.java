package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@LeetcodeNumber(number = 98, level = Level.MEDIUM)
public class ValidateBinarySearchTreeTest {
    private ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();

    @Test
    void test() {
        Assertions.assertFalse(validateBinarySearchTree
                .isValidBST(new TreeNode(5,
                        new TreeNode(4), new TreeNode(6, new TreeNode(3), new TreeNode(7)))));
    }
}
