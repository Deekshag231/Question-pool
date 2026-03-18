class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ans=image[sr][sc];
        dfs(image,sr,sc,color,ans);
        return image;
    }
    public void dfs(int[][] image,int sr,int sc,int color,int ans){
        if(sr<0||sc<0||sr>=image.length||sc>=image[0].length||image[sr][sc]==color||image[sr][sc]!=ans){
            return;
        }
        image[sr][sc]=color;
        int[][] dir={{sr,sc-1},{sr+1,sc},{sr,sc+1},{sr-1,sc}};
        for(int[] e:dir){
            dfs(image,e[0],e[1],color,ans);
        }
    }
}