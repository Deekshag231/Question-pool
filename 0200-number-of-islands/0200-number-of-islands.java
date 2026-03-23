class Solution {
    public int numIslands(char[][] grid) {
        int c=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    c++;
                    helper(grid,i,j);
                }
            }
        }
        return c;
    }
    public static void helper(char[][] grid,int r,int c){
        if(r<0||c<0||r>=grid.length||c>=grid[0].length||grid[r][c]=='0'){
            return;
        }
        grid[r][c]='0';
        int[][] dir={{r+1,c},{r,c+1},{r-1,c},{r,c-1}};
        for(int[] e:dir){
            helper(grid,e[0],e[1]);
        }
    }
}