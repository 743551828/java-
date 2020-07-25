package leetCode.两数相加;
//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 4642 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Temp = l1;
        ListNode l2Temp = l2;
        ListNode result = new ListNode(0);
        ListNode currentNode = result;
        int j = 0;
        int x;
        int y;
        while (l1Temp != null || l2Temp != null){
            if (l1Temp == null){
                l1Temp = new ListNode(0);
            }
            if (l2Temp == null){
                l2Temp = new ListNode(0);
            }
            x = l1Temp.val;
            y = l2Temp.val;
            int temp = x + y + j;
            if (temp/10 == 1) {
                j = 1;
            }else {
                j = 0;
            }
            currentNode.val = temp % 10;
            if (l1Temp.next != null){
                l1Temp = l1Temp.next;
            }else {
                l1Temp = null;
            }
            if (l2Temp.next != null){
                l2Temp = l2Temp.next;
            }else {
                l2Temp = null;
            }
            if (l1Temp != null || l2Temp != null){
                currentNode.next = new ListNode(0);
                currentNode = currentNode.next;
            }
        }
        if(j == 1){
            currentNode.next = new ListNode(1);
        }
        return result;
    }


    public static void main(String[] args) {

        ListNode a1 = new ListNode(1);
//        ListNode b1 = new ListNode(8);
//        ListNode c1 = new ListNode(3);

        ListNode a2 = new ListNode(9);
        ListNode b2 = new ListNode(9);
//        ListNode c2 = new ListNode(4);

//        a1.next = b1;
//        b1.next = c1;
//
        a2.next = b2;
//        b2.next = c2;

        Solution solution = new Solution();
        ListNode listNode = solution.addTwoNumbers(a1, a2);
        System.out.println(listNode);


    }
}
//leetcode submit region end(Prohibit modification and deletion)
