package leetcode;

@LeetcodeNumber(number = 876)
public class MiddleOfTheLinkedList {

    public static void main(String[] args) {
        System.out.println(6 / 2 + 1);
    }

    public ListNode middleNode(ListNode head) {
        int counter = 0;
        ListNode temp = head;
        while (temp != null) {
            counter++;
            temp = temp.next;
        }

        System.out.println(counter);

        for (int i = 0; i < counter / 2; i++) {
            head = head.next;
        }
        return head;
    }
}
