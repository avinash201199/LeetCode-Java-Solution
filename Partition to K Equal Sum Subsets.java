class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(k > nums.length)
            return false;
        int[] arr = new int[k];
        int sum = 0;
        for(int x : nums){
            sum += x;
        }
        if(sum % k != 0)
            return false;
        if(find(nums, arr, 0, sum/k))
        	return true;
        return false;
    }
    
    public boolean find(int[] nums, int[] arr, int pos, int tar) {
    	if(pos == nums.length) {
    		return true;
    	}
    	for(int i = 0; i < arr.length; i++) {
    		if(arr[i] + nums[pos] <= tar) {
        		arr[i] = arr[i] + nums[pos];
    			if(find(nums, arr, pos + 1, tar))
                    return true;
        		arr[i] -= nums[pos];
    		}
    	}
        return false;
    }
}
