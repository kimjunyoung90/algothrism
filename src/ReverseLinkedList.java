import java.util.Stack;

/**
 * @link https://leetcode.com/problems/reverse-linked-list/description/
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        //stack 활용
        Stack<ListNode> stack = new Stack<>();
        ListNode nextNode = head;
        while (nextNode != null) {
            stack.push(nextNode);
            nextNode = head.next;
        }

        //stack 에서 꺼내서 거꾸로
        ListNode preNode = new ListNode(-1);
        ListNode startNode = preNode;
        while (!stack.isEmpty()) {
            ListNode popped = stack.pop();
            startNode.next = popped;
            startNode = popped;
        }

        return preNode.next;
    }
}
