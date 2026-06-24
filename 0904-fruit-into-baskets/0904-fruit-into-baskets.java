class Solution {
    public int totalFruit(int[] arr) {
        int we=0;
        int ws=0;
        int maxlen=0;
        int ucc=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(we<arr.length){
            if(!map.containsKey(arr[we])){
                ucc++;
                //map.put(arr[we],map.getOrDefault(arr[we],0)+1);
                if(ucc>2){
                    while(ucc>2){
                        map.put(arr[ws],map.getOrDefault(arr[ws],0)-1);
                        if(map.get(arr[ws])==0){
                            ucc--;
                            map.remove(arr[ws]);
                        }
                        ws++;
                    }
                }

            }
            map.put(arr[we],map.getOrDefault(arr[we],0)+1);
            maxlen=Math.max(maxlen,we-ws+1);
            we++;
        }
        return maxlen;
    }
}