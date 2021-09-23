class Solution {
    public String breakPalindrome(String palindrome) {
        int N = palindrome.length();
        
        if(N == 1)
            return "";
        
        int pointer = 0, ignorePos = N % 2 == 0 ? -1 : N / 2;
        char[] arr = palindrome.toCharArray();
        // Three conditions
        // Convert first Non a to a
        // But if it's mid of the element and array size is odd then it would create a palindrome again so ignore
        // If at the end if we can't make the change, then set the last one to b
        
        while(pointer < N) {
            if(arr[pointer] != 'a' && pointer != ignorePos) {
                arr[pointer] = 'a';
                return String.valueOf(arr);
            }
            pointer++;
        }
        arr[N - 1] = 'b';
        return String.valueOf(arr);
    }
}
