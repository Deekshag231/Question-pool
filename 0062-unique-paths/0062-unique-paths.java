class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        boolean[][] vis=new boolean[m][n];
        int ans=helper(0,0,dp,vis);
        return ans;
    }
    public static int helper(int r,int c,int[][] dp,boolean[][] vis){
        if(r>dp.length-1||c>dp[0].length-1||vis[r][c]){
            return 0;
        }
        if(r==dp.length-1&&c==dp[0].length-1){
            return 1;
        }
        if(dp[r][c]!=-1){
            return dp[r][c];
        }
        vis[r][c]=true;
        int ans=0;
        ans+=helper(r+1,c,dp,vis);
        ans+=helper(r,c+1,dp,vis);
        vis[r][c]=false;
        dp[r][c]=ans;
        return dp[r][c];
    }
}