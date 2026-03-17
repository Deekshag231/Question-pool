class Solution {
    public int findCenter(int[][] e) {
    ArrayList<Integer> list=new ArrayList<>();
    list.add(e[0][0]);
    for(int i=0;i<e.length;i++){
        for(int j=0;j<e[i].length;j++){
            if(i!=0&&j!=0){
            if(list.contains(e[i][j])){
             return e[i][j];
            }
            }
            if(i==0&&j==0){
               continue;
            } 
            else{
            list.add(e[i][j]);
            }
        }
    }
    return 0;
    }
}