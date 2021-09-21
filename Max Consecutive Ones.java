class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i,count=0,result=0;
        for(i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                count=0;
            }
            else 
            {
                count++;
                result=Math.max(count,result);
            }
        }
        return result;
    }
}
