class DisjointSet{
    public:
    vector<int>size;
    vector<int>parent;
    DisjointSet(int n){
        size.resize(n+1,0);
        parent.resize(n+1);
        for(int i=0;i<=n;i++){
            parent[i]=i;
        }

    }
    int findPar(int node){
        if(parent[node]==node){
            return node;
        }
        return parent[node]=findPar(parent[node]);
    }
    void UnionBySize(int u,int v){
        int ulp_u=findPar(u);
        int ulp_v=findPar(v);
        if(ulp_u==ulp_v)return;
        if(size[ulp_u]<size[ulp_v]){
            parent[ulp_v]=ulp_u;
            size[ulp_v]+=size[ulp_u];
        }else{
            parent[ulp_u]=ulp_v;
            size[ulp_u]+=size[ulp_v];
        }
    }

};

class Solution {
public:
    int findCircleNum(vector<vector<int>>& isConnected) {
        int n=isConnected.size();
        DisjointSet ds(n+1);
        for(int i=0;i<isConnected.size();i++){
            for(int j=0;j<isConnected[i].size();j++){
                if(isConnected[i][j]==1){
                    ds.UnionBySize(i,j);
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(ds.findPar(i)==i){
                count++;
            }
        }
        return count;
        
        
        
    }
};