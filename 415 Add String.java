class Solution {
    public String addStrings(String num1, String num2) {
          StringBuilder sb = new StringBuilder();
    
    int i = num1.length()-1;
    int j = num2.length()-1;
    
    int c = 0;
    int sum = 0;
    
    while(i >= 0 || j >= 0){
        sum = c;
        if(i >= 0){
            sum += num1.charAt(i--) - '0';
        }
        
        if(j >= 0){
            sum += num2.charAt(j--) - '0';
        }
        
        sb.append(sum % 10);
        c = sum / 10;
    }
    
    if(c > 0){
        sb.append(c);
    }
    
    return sb.reverse().toString();
    }
}
