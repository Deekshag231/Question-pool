class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
       
        int ans=helper(0,0,dp);
        return ans;
    }
    public static int helper(int r,int c,int[][] dp){
        if(r>dp.length-1||c>dp[0].length-1){
            return 0;
        }
        if(r==dp.length-1&&c==dp[0].length-1){
            return 1;
        }
        if(dp[r][c]!=-1){
            return dp[r][c];
        }
        
        int ans=0;
        ans+=helper(r+1,c,dp);
        ans+=helper(r,c+1,dp);
        
        dp[r][c]=ans;
        return dp[r][c];
    }
}