class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ans=image[sr][sc];
        dfs(image,sr,sc,color,ans);
        return image;
    }
    public void dfs(int[][] img,int r,int c,int co,int ans){
        if(r<0||c<0||r>=img.length||c>=img[0].length||img[r][c]==co||img[r][c]!=ans){
            return;
        }
        img[r][c]=co;
        int[][] adj={{r-1,c},{r,c+1},{r+1,c},{r,c-1}};
        for(int[] e:adj){
            dfs(img,e[0],e[1],co, ans);
        }
    }
}