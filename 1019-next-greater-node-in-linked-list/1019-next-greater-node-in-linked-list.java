/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        Stack<Integer> st=new Stack<>();
        
        ArrayList<Integer> ls=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null){
            ls.add(temp.val);
            temp=temp.next;
        }
        int[] arr=new int[ls.size()];
        for(int i=ls.size()-1;i>=0;i--){
            while(!st.isEmpty()&&st.peek()<=ls.get(i)){
                st.pop();
            }
            if(st.isEmpty()){
                arr[i]=0;
            }
            else{
                arr[i]=st.peek();
            }
            st.push(ls.get(i));
           
        }
        return arr;
    }
}