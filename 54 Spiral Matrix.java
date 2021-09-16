class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int size = matrix.length * matrix[0].length;
        int count = 0;
        
        int colleft = 0,colright = matrix[0].length - 1;
        int rowstart = 0,rowend = matrix.length - 1;
        List<Integer> ans = new ArrayList<>();
       
        while(count < size){
            //left to right
             for(int j = colleft;j<= colright;j++){//traverse in all cols from colleft to colright(->)
                 ans.add(matrix[rowstart][j]);
                 count++;
             }
             rowstart++;
             if(count == size) break;
            
            //top to down
            
            for(int i = rowstart;i<=rowend;i++){ //traverse in all rows from rowstart to rowend
                ans.add(matrix[i][colright]);
                count++;
            }
            
            colright--;
            if(count == size) break;
            
            for(int j = colright;j>= colleft;j--){ //traverse from colright to colleft (<-)
                ans.add(matrix[rowend][j]);
                count++;
            }
            rowend--;
            if(count == size) break;
            
            for(int i = rowend;i>= rowstart;i--){ //traverse from rowend  to rowstart
                ans.add(matrix[i][colleft]);
                count++;
            }
            colleft++;
           
        }
        
        return ans;
    }
}
