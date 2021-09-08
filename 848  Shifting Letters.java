class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        // calculate the total shifts
		for(int i=shifts.length-1; i>0; --i){
            shifts[i-1] += shifts[i];
            shifts[i-1] %= 26;
        }
        char[] charArr = s.toCharArray();
        for(int i=0; i<s.length(); ++i){
            charArr[i] = (char)('a'+(charArr[i]-'a' + shifts[i])%26);
        }
        return String.valueOf(charArr);
    }
}
