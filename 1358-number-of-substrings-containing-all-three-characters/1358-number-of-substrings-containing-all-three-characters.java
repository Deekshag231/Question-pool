class Solution {
    public int numberOfSubstrings(String s) {
        int we=0;
        int ws=0;
        int maxlen=0;
        int ucc=0;
        int[] freq=new int[3];
        while(we<s.length()){
            char ch=s.charAt(we);
            int idx=s.charAt(we)-'a';
            if(ch=='a'){
                freq[0]++;
            }
            else if(ch=='b'){
                freq[1]++;
            }
            else{
                freq[2]++;
            }
            while(freq[0]>=1&&freq[1]>=1&&freq[2]>=1){
                maxlen+=s.length()-we;
                if(s.charAt(ws)=='a') freq[0]--;
                else if(s.charAt(ws)=='b') freq[1]--;
                else freq[2]--;
                ws++;
            }
            we++;
        }
        return maxlen;
    }
}