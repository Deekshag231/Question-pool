class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set=new HashSet<>();
        int we=0;
        int ws=0;
        int maxlen=0;
        while(we<s.length()){
            char ch=s.charAt(we);
            if(set.contains(ch)){
               while(set.contains(ch)&&ws<we){
                    set.remove(s.charAt(ws));
                    ws++;
               }
            }
            set.add(ch);
            maxlen=Math.max(we-ws+1,maxlen);
            we++;

        }
        return maxlen;
    }
}