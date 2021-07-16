class Solution {
    public List<List<Integer>> fourSum(int[] n, int target){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(n);
        for (int i = 0; i < n.length; i++){
            int first_target = target - n[i];
            for (int j = i+1; j < n.length;j++){
                int second_target = first_target - n[j];
                int start = j+1;
                int end = n.length-1;
                while (start<end){
                    List<Integer> sumToTarget = new ArrayList<Integer>();
                    if (n[start]+n[end]==second_target){
                        sumToTarget.add(n[i]);
                        sumToTarget.add(n[j]);
                        sumToTarget.add(n[start]);
                        sumToTarget.add(n[end]);
                        if (!result.contains(sumToTarget)){
                            result.add(sumToTarget);
                        }
                        start++;
                    }
                    else if (n[start]+n[end]<second_target){
                        start++;
                    }
                    else if (n[start]+n[end]>second_target){
                        end--;
                    }
                }
            }
        }
        return result;
    }
}
