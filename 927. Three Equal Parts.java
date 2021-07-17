class Solution {
    public int[] threeEqualParts(int[] arr) {
        
        int[] failed = new int[]{-1, -1};
        int ones = 0;
        for (int n : arr) {
            if (n == 1){
                ones++;//count the total number of ones
            }
        }
        if (ones % 3 != 0) {//total number of one's are divisible by three ?
            return failed;
        }
        
        if (ones == 0) {//no one in the input// literally any two pair of valid indices would work
            return new int[]{0,2};
        }
        
        int equalOnes = ones/3;
        
        int trailingZeros = 0;
        int index = arr.length-1;
        
        while (index >= 0 && arr[index] == 0) {//count the number of trailing zeros at the end
            index--;
            trailingZeros++;
        }
        
        int firstStart = indexOfNthOne(arr, 0, 1);
        int firstPartEnd = indexOfNthOne(arr, firstStart, equalOnes) + trailingZeros;
        
        int secondStart = indexOfNthOne(arr, firstPartEnd+1, 1);
        int secondPartEnd = indexOfNthOne(arr, secondStart, equalOnes) + trailingZeros;
        
        int thirdStart = indexOfNthOne(arr, secondPartEnd + 1, 1);
        int thirdPartEnd = indexOfNthOne(arr, thirdStart, equalOnes) + trailingZeros;
        
        if (thirdPartEnd >= arr.length){
            return failed;
        }
        
        int pointer1 = firstStart;
        int pointer2 = secondStart;
        int pointer3 = thirdStart;
        
        while (pointer1 <= firstPartEnd) {//checks whether the three parts are identical
            if(!(arr[pointer1] == arr[pointer2] && arr[pointer2] == arr[pointer3])) {
                return failed;
            }
            pointer1++;
            pointer2++;
            pointer3++;
        }
        
        return new int[]{firstPartEnd, secondPartEnd+1};
    }
    
    // returns the index that contains n number of ones from start index
    // if less than n number of ones present, returns the length of the input array
    private int indexOfNthOne(int[] arr, int start, int n) {
        int counts = 0;
        while (start < arr.length){
            if (arr[start] == 1) {
                counts++;
                if (counts == n) {
                    break;
                }
            }
            start++;
        }
        
        return start;
    }
}
