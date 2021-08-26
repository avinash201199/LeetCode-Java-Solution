class Solution {
    int i = 0;
    public boolean isValidSerialization(String preorder) {
        String[] arr = preorder.split(",");
        construct(arr);
        return i == arr.length - 1;
    }
    
    private void construct(String[] arr){
        if(i >= arr.length || arr[i].equals("#")){
            return;
        }
        i++;
        construct(arr);
        i++;
        construct(arr);
    }

}
