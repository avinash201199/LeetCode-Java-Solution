class Solution {
    public int maxProduct(TreeNode root) {
       long mod=(long) 1e9+7;
        
        long ans=0;
        List<Integer>allsum=new ArrayList<>();
         long totalsum=treesum(root,allsum);
        
        for( long sum:allsum)
            ans=Math.max(ans,sum*(totalsum-sum));
        
        return (int) (ans % mod);
     
    }
    public int treesum(TreeNode root,List<Integer> allsum){
        if(root==null)
            return 0;
        
        int leftsum=treesum(root.left,allsum);
        int rightsum=treesum(root.right,allsum);
        
        int sum=root.val+leftsum+rightsum;
        
        allsum.add(sum);
        return sum;
    }
}
