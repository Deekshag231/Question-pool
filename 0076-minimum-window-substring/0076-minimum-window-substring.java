class Solution {
    public String minWindow(String s, String t) {
        int we=0;
        int ws=0;
        int len=0;
        int minlen=Integer.MAX_VALUE;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int ucc=map.size();
        int si=-1;
        while(we<s.length()){
            char ch=s.charAt(we);
            if(map.containsKey(ch)){
                map.put(ch,map.getOrDefault(ch,0)-1);
                if(map.get(ch)==0){
                    ucc--;
                }
            }
            while(ucc==0){
                ch=s.charAt(ws);
                len=we-ws+1;
                if(len<minlen){
                    minlen=len;
                    si=ws;
                } 
                if(map.containsKey(ch)){
                    map.put(ch,map.get(ch)+1);
                    if(map.get(ch)>0){
                        ucc++;
                    }
                } 
                ws++;
            }
            we++;
        }
        if(si==-1){
            return "";
        }
        return s.substring(si,si+minlen);
    }
}