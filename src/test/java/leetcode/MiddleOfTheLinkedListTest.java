package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MiddleOfTheLinkedListTest {
    private MiddleOfTheLinkedList middleOfTheLinkedList = new MiddleOfTheLinkedList();

    @Test
    void test() {
        Assertions.assertEquals(middleOfTheLinkedList.middleNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))),
                new ListNode(3, new ListNode(4, new ListNode(5))));
    }
}
