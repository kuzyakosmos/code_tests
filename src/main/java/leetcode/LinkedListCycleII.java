package leetcode;

import java.util.ArrayList;
import java.util.List;

@LeetcodeNumber(number = 142)
public class LinkedListCycleII {
    public ListNode1 detectCycle(ListNode1 head) {
        List<ListNode1> arrayList = new ArrayList<>();
        while (true) {
            if (head == null) {
                return null;
            }
            if (arrayList.contains(head)) {
                return head;
            }
            arrayList.add(head);
            head = head.next;
        }
    }
}

class ListNode1 {
    int val;
    ListNode1 next;

    ListNode1(int x) {
        val = x;
        next = null;
    }
}