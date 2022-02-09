package ru.rblednov.leetcode.lists;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import static ru.rblednov.leetcode.lists.MergekSortedLists.Solution.mergeKLists;

public class MergekSortedLists {


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

    static class Solution {
        public static ListNode mergeKLists(ListNode[] lists) {
            if(lists.length==0){
                return null;
            }
            if(lists.length==1){
                return lists[0];
            }
            PriorityQueue<ListNode> priorityQueue =
                    new PriorityQueue<>(lists.length * 2, Comparator.comparingInt(listNode -> listNode.val));

            for (ListNode listNode : lists) {
                ListNode current = listNode;
                while (current != null) {
                    priorityQueue.add(current);
                    current = current.next;
                }
            }

            ListNode head = new ListNode();
            ListNode current = head;
            while (true){
                ListNode tmp = priorityQueue.poll();
                if(tmp==null){
                    break;
                }

            }
            current.next=null;
            return head.next;
        }
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(-2, new ListNode(-1, new ListNode(-1, new ListNode(-1))));
        ListNode b = null;
//        ListNode c = new ListNode(2, new ListNode(6));
        ListNode[] input = {a,b};
        mergeKLists(input);
    }
}
