
class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        ListNode current = this;
        while (current != null) {
            result.append(current.val).append(" -> ");
            current = current.next;
        }
        result.append("null");
        return result.toString();
    }
}

public class SingleLinkedList {
    public static ListNode find_middle(ListNode head) {
        ListNode curr = head;

        ListNode sp = curr;
        ListNode fp = curr;

        while (fp != null && fp.next != null) {
            sp = sp.next;
            fp = fp.next.next;
        }

        return sp;

    }

    public static ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static boolean cycle(ListNode head) {
        ListNode sp = head;
        ListNode fp = head;
        while (fp != null & fp.next != null) {
            sp = sp.next;
            fp = fp.next.next;
            if (sp == fp) {
                return true;
            }
        }
        return false;
    }

    public static Boolean isPalindrome(ListNode head) {
        ListNode firstHalf = head;
        ListNode secondHalf = reverse(find_middle(head));
        System.out.println("First:" + firstHalf);
        System.out.println("Second:" + secondHalf);
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val)
                return false;
            secondHalf = secondHalf.next;
            firstHalf = firstHalf.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(1);

        System.out.println(head1);
        System.out.println("Middle_ListNode:" + find_middle(head1));
        System.out.println(isPalindrome(head1));

        System.out.println();
        System.out.println(head2);
        System.out.println("Middle_ListNode:" + find_middle(head2));
        System.out.println(isPalindrome(head2));

    }
}