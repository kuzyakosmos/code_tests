package leetcode;

@LeetcodeNumber(number = 98, level = Level.MEDIUM)
public class ValidateBinarySearchTree {
     private boolean result = true;

    public boolean isValidBST(TreeNode root) {
        check(root);
        return result;
    }

    private void check(TreeNode node) {
        if (node.left != null) {
            if (node.left.val >= node.val) {
                result = false;
            } else {
                check(node.left);
            }
        }
        if (node.right != null) {
            if (node.right.val <= node.val) {
                result = false;
            } else {
                check(node.right);
            }
        }
    }
}
