class Solution {
   public int lengthOfLongestSubstring(String s) {
       int start=0;
     int end=0;
     int length=0;
        HashSet<Character> set = new HashSet<>();
        while (end < s.length()){
        if(!set.contains(s.charAt(end))){
            set.add(s.charAt(end));
            end++;
            length=Math.max(set.size(), length);
        }
        else{
            set.remove(s.charAt(start));
            start++;
        }
        }
        return length;
}
}
