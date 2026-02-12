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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int lev=0;
        while(!q.isEmpty()){
            int size=q.size();
            ArrayList<Integer> ls=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                ls.add(curr.val);
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }

            }
            if(lev%2==0){
                if(!even(ls)) return false;
                
            }
            else{
                if(!odd(ls)) return false;
            }
            lev++;
        }
        return true;
    }
    public static boolean even(ArrayList<Integer> ls){
        for(int i=0;i<ls.size();i++){
            if(ls.get(i)%2==0){
                return false;
            }
            if(i>0&&ls.get(i)<=ls.get(i-1)) return false;
        }
        return true;
    }
     public static boolean odd(ArrayList<Integer> ls){
        for(int i=0;i<ls.size();i++){
            if(ls.get(i)%2==1){
                return false;
            }
            if(i>0&&ls.get(i)>=ls.get(i-1)) return false;
        }
        return true;
    }
}