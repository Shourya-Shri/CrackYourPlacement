class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        if(p == "" || p.length()>s.length()){
            return "-1";
        }
        if(s.equals(p)){
            return s;
        }
        
        Map<Character, Integer> countp = new HashMap<>();
        Map<Character, Integer> window_s = new HashMap<>();
        
        for(int i=0;i<p.length();i++){
            countp.put(p.charAt(i), countp.getOrDefault(p.charAt(i),0)+1);
        }
        int have=0;
        int need=countp.size();
        
        String res= "-1";
        int resLen=Integer.MAX_VALUE;
        int l=0;
        int r=0;
        
        while(r<s.length()){
            char c=s.charAt(r);
            window_s.put(c,window_s.getOrDefault(c,0)+1);
            if(countp.containsKey(c) && countp.get(c) == window_s.get(c)){
                have+=1;
            }
            while(have==need){
                if((r-l + 1) < resLen)
                {
                    res = s.substring(l,r+1);
                    resLen = r-l+1;
                }
                char t = s.charAt(l);
                window_s.put(t, window_s.get(t)-1);
                
                if(countp.containsKey(t) && window_s.get(t)<countp.get(t)){
                    have-=1;
                }
                
                l+=1;
            }
            r++;
        }
        return (resLen != Integer.MAX_VALUE)?res:"-1";
    }
}
