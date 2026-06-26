class Solution {
    public int characterReplacement(String s, int k) {
        int[] map=new int[26];
        int we=0;
        int ws=0;
        int maxlen=0;
        int maxfreq=0;
        while(we<s.length()){
            int idx=s.charAt(we)-'A';
            map[idx]++;
            maxfreq=Math.max(maxfreq,map[idx]);
            if(we-ws+1-maxfreq>k){
                while(we-ws+1-maxfreq>k){
                    map[s.charAt(ws)-'A']--;
                    ws++;
                }
            }
        maxlen=Math.max(maxlen,we-ws+1);
        we++;
        }
        return maxlen;

    }
}