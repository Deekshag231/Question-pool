class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ans=image[sr][sc];
        dfs(image,sr,sc,color,ans);
        return image;
    }
    public void dfs(int[][] image, int r,int c,int color,int ans){
        if(r<0||c<0||r>=image.length||c>=image[0].length||image[r][c]!=ans||image[r][c]==color){
            return;
        }
        image[r][c]=color;
        int[][] dir={{r,c+1},{r+1,c},{r-1,c},{r,c-1}};
        for(int[] e:dir){
            dfs(image,e[0],e[1],color,ans);
        }
    }
}