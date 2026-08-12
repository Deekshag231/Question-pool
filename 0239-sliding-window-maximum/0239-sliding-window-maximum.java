class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        Deque<Integer> q= new LinkedList<>();
       List<Integer> res=new ArrayList<>();
     
        for(int i=0;i<arr.length;i++){
            while(!q.isEmpty()&&q.getLast()<arr[i]){
                q.pollLast();
            }
            q.addLast(arr[i]);
            if(i>=k&&arr[i-k]==q.getFirst()){
                q.pollFirst();
            }
            if(i>=k-1){
                res.add(q.getFirst());
            }
        }
        int[] arr1=new int[res.size()];
        for(int i=0;i<res.size();i++){
            arr1[i]=res.get(i);
        }
        return arr1;
    }
}