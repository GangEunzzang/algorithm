/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode();
        ListNode answer = listNode; // 초기 참조 위치를 기억하기 위함
        int roundCheck = 0;

        while (l1 != null || l2 != null) {
            int sum = roundCheck;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            roundCheck = sum / 10;
            sum %= 10;

            listNode.next = new ListNode(sum);
            listNode = listNode.next;
        }

        if (roundCheck > 0) {
            listNode.next = new ListNode(roundCheck);
        }

        return answer.next;
    }
}