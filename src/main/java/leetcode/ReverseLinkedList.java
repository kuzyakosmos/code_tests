package leetcode;

@LeetcodeNumber(number = 206)
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = new ListNode(head.val);
        head = head.next;
        while (head != null) {
            temp = new ListNode(head.val, temp);
            head = head.next;
        }

        return temp;
    }
}