class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int j=0,k=0;
        int min=Integer.MAX_VALUE,ans=0;
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            j = i+1;
            k = n-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                int diff = Math.abs(target - sum) +1;
                if(diff < min){
                    min = diff;
                    ans = sum;
                }
                if(sum == target) return sum;
                else if(sum > target) k--;
                else j++;
            }
        }
        return ans;
    }

}
