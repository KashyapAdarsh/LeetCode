public class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        StringBuilder temp = new StringBuilder();
        int len = 0;

        if(strs.length < 1)
            return "";
        if(strs.length == 1)
            return strs[0];
        if(strs[0].length() < strs[strs.length - 1].length())
            len = strs[0].length();
        else
            len = strs[strs.length - 1].length();
        
        for(int i=0;i<len;i++){
            if(strs[0].charAt(i) == strs[strs.length - 1].charAt(i)){
                temp.append(strs[0].charAt(i));
            }else{
                break;
            }
        }
        return temp.toString();
    }
}