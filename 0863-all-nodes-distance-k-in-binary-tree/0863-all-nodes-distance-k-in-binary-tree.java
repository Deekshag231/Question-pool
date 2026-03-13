/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans=new ArrayList<>();
        Map<TreeNode,TreeNode> map=new HashMap<>();
        mark(root,map,root);
        Map<TreeNode,Boolean> vis=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.offer(target);
        vis.put(target,true);
        int curr=0;
        while(!q.isEmpty()){
            int size=q.size();
            if(curr==k) break;
            curr++;
            for(int i=0;i<size;i++){
                TreeNode temp=q.poll();
                if(temp.left!=null&&vis.get(temp.left)==null){
                    q.offer(temp.left);
                    vis.put(temp.left,true);
                }
                if(temp.right!=null&&vis.get(temp.right)==null){
                    q.offer(temp.right);
                    vis.put(temp.right,true);
                }
                if(map.get(temp)!=null&&vis.get(map.get(temp))==null){
                    q.offer(map.get(temp));
                    vis.put(map.get(temp),true);
                }
            }
        }
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            ans.add(temp.val);
        }
        return ans;

    }
    public void mark(TreeNode root,Map<TreeNode,TreeNode> map,TreeNode target){
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp.left!=null){
                map.put(temp.left,temp);
                q.offer(temp.left);
            }
            if(temp.right!=null){
                map.put(temp.right,temp);
                q.offer(temp.right);
            }
        }
    }

}