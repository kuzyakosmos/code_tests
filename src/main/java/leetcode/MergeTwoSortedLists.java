package leetcode;

import java.util.Objects;

@LeetcodeNumber(number = 21)
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }


        //создаем первый элемент
        int val;
        if (list1.val < list2.val) {
            val = list1.val;
            list1 = list1.next;
        } else {
            val = list2.val;
            list2 = list2.next;
        }
        ListNode temp = new ListNode(val);
        //result ссылается на первый элемент
        ListNode result = temp;

        while (true) {
            if (list1 == null && list2 == null) {
                break;
            } else if (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    temp.next = new ListNode(list1.val);
                    temp = temp.next;
                    list1 = list1.next;
                } else {
                    temp.next = new ListNode(list2.val);
                    temp = temp.next;
                    list2 = list2.next;
                }
            } else if (list1 != null && list2 == null) {
                temp.next = new ListNode(list1.val);
                temp = temp.next;
                list1 = list1.next;
            } else if (list1 == null && list2 != null) {
                temp.next = new ListNode(list2.val);
                temp = temp.next;
                list2 = list2.next;
            }
        }
        return result;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val && Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}