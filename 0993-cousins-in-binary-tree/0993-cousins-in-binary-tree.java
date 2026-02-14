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

    // Returns true if the nodes with values 'a' and 'b' are cousins. Else returns false
    public boolean isCousins(TreeNode root, int a, int b) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int l1=-1;
        int l2=-1;
        int level=0;
        while(!q.isEmpty()){
            int n=q.size();
            while(n-->0){
                TreeNode temp=q.poll();
                if(temp.val==a) l1=level;
                if(temp.val==b) l2=level;
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }
            level++;
            if(l1!=l2) return false;
            if(l1!=-1&&l2!=-1) break;
        }
        return !parent(root,a,b);
        
    }
    boolean parent(TreeNode root,int a,int b){
        if(root==null) return false;
        if(root.left!=null&&root.right!=null){
            if(root.left.val==a&&root.right.val==b||root.left.val==b&&root.right.val==a) return true;    
            
        }
        
        return parent(root.left,a,b)||parent(root.right,a,b);
    }
}






