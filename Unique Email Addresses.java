class Solution {
public int numUniqueEmails(String[] emails) {
    HashSet<String> set = new HashSet<>();
    
    for(int i=0; i<emails.length; i++){
        String str[] = emails[i].split("@");
        String local = str[0];
        
        StringBuilder sB = new StringBuilder();
        for(char ch : local.toCharArray()){
            if(ch != '+'){
                if(ch != '.'){
                    sB.append(ch + "");
                }
            }else{
                break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(sB.toString());
        sb.append("@");
        sb.append(str[1]);
        set.add(sb.toString());
    }
    
    return set.size();
}
}
