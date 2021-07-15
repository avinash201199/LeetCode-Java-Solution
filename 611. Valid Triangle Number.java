class Solution {
    public int triangleNumber(int[] nums) {
        int count=0;
               Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++) {
            for(int a = i+1; a < nums.length-1; a++) {
                for(int j = a+1; j < nums.length; j++) {
                    if(nums[i] + nums[a] > nums[j])
                        count++;
                }
            }
        }
        

        return count;
    }
}
