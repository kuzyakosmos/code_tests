package leetcode;

@LeetcodeNumber(number = 237, level = Level.MEDIUM)
public class DeleteNodeInALinkedList {

    public void deleteNode(ListNode node) {
        while (true) {
            node.val = node.next.val;
            if (node.next.next == null) {
                node.next = null;
                return;
            }
            node = node.next;
        }
    }
}
