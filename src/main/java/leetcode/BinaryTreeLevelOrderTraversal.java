package leetcode;

import java.util.ArrayList;
import java.util.List;

@LeetcodeNumber(number = 102, level = Level.MEDIUM)
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            writeValues(root, result, 0);
        }
        return result;
    }

    private void writeValues(TreeNode node, List<List<Integer>> result, int depth) {
        if (result.size() < depth + 1) {
            List<Integer> level = new ArrayList<>();
            level.add(node.val);
            result.add(level);
        } else {
            result.get(depth).add(node.val);
        }
        //записать значение
        depth++;
        if (node.left != null) {
            writeValues(node.left, result, depth);
        }
        if (node.right != null) {
            writeValues(node.right, result, depth);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
