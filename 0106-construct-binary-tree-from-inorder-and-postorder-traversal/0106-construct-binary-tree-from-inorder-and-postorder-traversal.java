class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root=tree(inorder,postorder,0,postorder.length-1,postorder.length-1);
        return root;
    }
    public static TreeNode tree(int[] inorder,int[] postorder,int start,int end,int idx){
        if(start>end){
            return  null;
        }
        TreeNode root=new TreeNode(postorder[idx]);
        int pos=find(inorder,start,end,postorder[idx]);
        root.right=tree(inorder,postorder,pos+1,end,idx-1);
        root.left=tree(inorder,postorder,start,pos-1,idx-(end-pos)-1);
        return root;
    }
    static int find(int[] inorder,int start,int end,int target){
        for(int i=start;i<=end;i++){
            if(inorder[i]==target){
                return i;
            }
        }
        return -1;
    }
}