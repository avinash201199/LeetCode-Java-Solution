class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n]; //this array is used to maintain the maximum till now from left and minimum till now from right
        arr[0] = nums[0];
        for (int i = 1; i < n; i++) { //finding the maximum till now from left
            arr[i] = (nums[i] > arr[i-1]) ? nums[i] : arr[i-1];
        }
        arr[n-1] = nums[n-1];
        int res = 0;
        for(int i = n-2; i >= 0; i--) {            
            if(arr[i] <= arr[i+1]) res = i+1; //checking whether the maximum to i's left is greater than or equal to minimum to i's right
            arr[i] = (nums[i] < arr[i+1]) ? nums[i] : arr[i+1]; //update the minimum till now from right
        }
        return res;
    }
}
