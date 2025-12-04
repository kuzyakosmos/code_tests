package leetcode;

@LeetcodeNumber(number = 2, level = Level.MEDIUM)
public class AddTwoNumbers {

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        double result = 0;
        double multiplicator = 1;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                result = result + l1.val * multiplicator;
                l1 = l1.next;
            }
            if (l2 != null) {
                result = result + l2.val * multiplicator;
                l2 = l2.next;
            }
            multiplicator = multiplicator * 10;
        }
        return numberToListNode(result);
    }

    static ListNode numberToListNode(double number) {
        ListNode result = new ListNode(0);
        ListNode nextNode = result;

        while (number > 0) {
            nextNode.val = (int) (number % 10);
            if (number / 10 == 0)
                break; //тут тонкий момент тк нужно и посчитать val для последнего ListNode, но при этом next не создавать
            nextNode.next = new ListNode();
            nextNode = nextNode.next;
            number = number / 10;
        }

        nextNode.next = null;
        return result;
    }

    static class ListNode {
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
    }

    // Вспомогательный метод: создаём список из массива
    public static ListNode createList(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int num : nums) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummy.next;
    }

    // Вспомогательный метод: выводим список как массив
    public static String listToString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) sb.append(",");
            head = head.next;
        }
        sb.append("]");
        return sb.toString();
    }

    // Тестируем метод addTwoNumbers
    public static void main(String[] args) {
        ListNode l1, l2, result;
     /*   // Пример 1
        l1 = createList(new int[]{2, 4, 3});
        l2 = createList(new int[]{5, 6, 4});
        result = addTwoNumbers(l1, l2);
        System.out.println("Test 1: " + listToString(result)); // ожидается [7,0,8]

        // Пример 2
        l1 = createList(new int[]{0});
        l2 = createList(new int[]{0});
        result = addTwoNumbers(l1, l2);
        System.out.println("Test 2: " + listToString(result)); // ожидается [0]

        // Пример 3
        l1 = createList(new int[]{9, 9, 9, 9, 9, 9, 9});
        l2 = createList(new int[]{9, 9, 9, 9});
        result = addTwoNumbers(l1, l2);
        System.out.println("Test 3: " + listToString(result)); // ожидается [8,9,9,9,0,0,0,1]

        // Пример 4
        l1 = createList(new int[]{9});
        l2 = createList(new int[]{1, 9, 9, 9, 9, 9, 9, 9, 9, 9});
        result = addTwoNumbers(l1, l2);
        System.out.println("Test 4: " + listToString(result)); // ожидается [0,0,0,0,0,0,0,0,0,0,1]
*/
        // Пример 5
        l1 = createList(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1});
        l2 = createList(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1});
        result = addTwoNumbers(l1, l2);
        System.out.println("Test 4: " + listToString(result)); // ожидается [2,2,2,2,2,2,2,2,2,2,2]

    }
}
