/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> ls=new ArrayList<>();
        if(root==null){
            return ls;
        }
        Stack<TreeNode> st1=new Stack<>();
        Stack<TreeNode> st2=new Stack<>();
        st1.push(root);
        while(!st1.isEmpty()||!st2.isEmpty()){
            if(!st1.isEmpty()){
                List<Integer> ans=new ArrayList<>();
                while(!st1.isEmpty()){
                    TreeNode temp=st1.pop();
                    ans.add(temp.val);
                    
                    if(temp.left!=null) st2.push(temp.left);
                    if(temp.right!=null) st2.push(temp.right);
                }
                ls.add(new ArrayList<>(ans));
            }
            else if(!st2.isEmpty()){
                List<Integer> ans=new ArrayList<>();
                while(!st2.isEmpty()){
                    TreeNode temp=st2.pop();
                    ans.add(temp.val);
                    
                    if(temp.right!=null) st1.push(temp.right);
                    if(temp.left!=null) st1.push(temp.left);
                }
                ls.add(new ArrayList<>(ans));
            }
        }
        return ls;
    }
}