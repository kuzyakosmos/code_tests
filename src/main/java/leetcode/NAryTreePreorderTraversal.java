package leetcode;

import java.util.ArrayList;
import java.util.List;

@LeetcodeNumber(number = 589)
public class NAryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            getValue(root, result);
        }
        return result;
    }

    void getValue(Node node, List<Integer> result) {
        result.add(node.val);
        if (node.children != null || !node.children.isEmpty()) {
            node.children.forEach(x -> getValue(x, result));
        }
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
