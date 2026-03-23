class Solution {
    public int findCircleNum(int[][] arr) {
        boolean[] vis=new boolean[arr.length];
        int c=0;
        for(int i=0;i<arr.length;i++){
            if(!vis[i]){
                dfs(arr,i,vis,vis.length);
                c++;
            }
        }
        return c;
    }
    public static void dfs(int[][] arr,int r,boolean[] vis,int n){
        vis[r]=true;
        for(int i=0;i<n;i++){
            if(arr[r][i]==1&&!vis[i]){
                dfs(arr,i,vis,n);
            }
        }
    }
}