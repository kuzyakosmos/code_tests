package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverseLinkedListTest {
    ReverseLinkedList reverseLinkedList = new ReverseLinkedList();

    @Test
    void test() {
        Assertions.assertEquals(reverseLinkedList.reverseList(new ListNode(1, new ListNode(2, new ListNode(3)))),
                new ListNode(3, new ListNode(2, new ListNode(1))));
    }
}
