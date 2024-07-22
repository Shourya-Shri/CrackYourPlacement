class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String a="";
        String b=strs[0];
        String c=strs[strs.length-1];

        int i=0;
        int d=Math.min(b.length(),c.length());

        while(i<d){
            if(b.charAt(i)==c.charAt(i)){
                a=a+b.charAt(i);
            }else{
                break;
            }
            i++;
        }
        return a;
    }
}
