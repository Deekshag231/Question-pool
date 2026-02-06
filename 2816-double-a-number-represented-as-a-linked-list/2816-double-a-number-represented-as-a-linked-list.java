
class Solution {
    public ListNode doubleIt(ListNode head) {
        ListNode dummy = new ListNode(1);
        dummy.next = head;
        return dfs(head) == 0 ? dummy.next : dummy;
    }
    public int dfs(ListNode head){
        if(head == null)return 0;

        int val = head.val * 2 + dfs(head.next);
        head.val = val % 10;
        return val /10 ;
    }
}