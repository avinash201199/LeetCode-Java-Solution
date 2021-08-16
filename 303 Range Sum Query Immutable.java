class NumArray {
    int[] nums;
    public NumArray(int[] nums) {
        this.nums=nums;
        for(int i=1;i<nums.length;i++){
            nums[i]=nums[i]+nums[i-1];
        }
    }
    
    public int sumRange(int left, int right) {
        if(left==0){
            return nums[right];
        }
        return nums[right]-nums[left-1];
    }
}
