class Solution {
    public int findLUSlength(String[] strs) {
        int max = -1;
        for(int i = 0; i<strs.length; i++){
            boolean isSub = false;
            int j = 0;
            for(; j<strs.length; j++){
                if(i != j){
                    if(isSubSequence(strs[i], strs[j])){     // to check whether strs[i] is a subsequence of strs[j]
                        break;
                    }
                }
            }
            if(j == strs.length){      // if the strs[i] is not a subsequence of any string in the array 
                max = Math.max(max, strs[i].length()); 
            }
        }
        return max;
    }
    public boolean isSubSequence(String str1, String str2){
        int i = 0, j = 0;
        for(; i<str1.length() && j<str2.length(); j++){
            if(str1.charAt(i) == str2.charAt(j)){
                i++;    
            }
        }
        return i == str1.length();
    }
}
