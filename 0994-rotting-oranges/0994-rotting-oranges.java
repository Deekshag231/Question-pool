class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null||grid.length==0) return -1;
        int rows=grid.length, cols=grid[0].length;
        int[][] time=new int[rows][cols];
        for(int i=0;i<rows;i++){
            Arrays.fill(time[i],Integer.MAX_VALUE);
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==2){
                    dfs(grid,time,i,j,0);
                }
            }
        }
        int timeR=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                    if(time[i][j]==Integer.MAX_VALUE) return -1;
                    timeR=Math.max(timeR,time[i][j]);
                }
            }
        }
        return timeR;
    }
    public static void dfs(int[][] grid,int[][] time,int r,int c,int currTime){
        if(r<0||c<0||r>=grid.length||c>=grid[0].length||grid[r][c]==0||currTime>=time[r][c]){
            return;
        }
        time[r][c]=currTime;
        int[][] dir={{r+1,c},{r,c+1},{r-1,c},{r,c-1}};
        for(int[] e:dir){
            dfs(grid,time,e[0],e[1],currTime+1);
        }
    }
}