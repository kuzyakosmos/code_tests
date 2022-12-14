package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MergeTwoSortedListsTest {
    private static MergeTwoSortedLists task;

    @BeforeAll
    static void init() {
        task = new MergeTwoSortedLists();
    }

    @Test
    void test() {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode result = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(4))))));
        Assertions.assertEquals(task.mergeTwoLists(list1, list2), result);
    }
}
