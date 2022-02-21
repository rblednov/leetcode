package ru.rblednov.leetcode.lists;

import java.util.Objects;

public class SwapNodesInPairs {
    public static class ListNode {
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

    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        return switchNodes(head, head.next);
    }

    private static ListNode switchNodes(ListNode p1, ListNode p2) {
        if (p1 == null) {
            return null;
        }
        if (p2 == null) {
            return p1;
        }
        if (p2.next != null) {
            p1.next = switchNodes(p2.next, p2.next.next);
        } else {
            p1.next = null;
        }
        p2.next = p1;
        return p2;
    }
    public class Tuple{
        int i1;
        int i2;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Tuple)) {
                return false;
            }
            Tuple tuple = (Tuple) o;
            return (i1 == tuple.i1 && i2 == tuple.i2) || (i1 == tuple.i2 && i2 == tuple.i1);
        }

        @Override
        public int hashCode() {
            return Objects.hash(i1, i2);
        }
    }
    public static void main(String[] args) {


        ListNode head = swapPairs(
                new ListNode(1
                )
        );
        System.out.println("qq");
    }
}
