class Solution {
   public int minPatches(int[] nums, int n) {
	int miss = 1, result = 0, i = 0;
	// 'miss' might overflow to negative number
	while (miss <= n && miss > 0) {
		if (i < nums.length && nums[i] <= miss) {
			miss += nums[i++];
		} else {
			miss += miss;
			result++;
		}
	}

	return result;
}
}
