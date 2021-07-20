class Solution {
    int []nums;
    int duplicate[];
    public Solution(int[] nums) {
        this.nums=nums;
        this.duplicate=nums.clone();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        for(int i=0;i<nums.length;i++)
            nums[i]=duplicate[i];
       return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
      Random r = new Random();
        for (int i = nums.length-1; i > 0; i--) {
            int j = r.nextInt(i+1);
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }
}
