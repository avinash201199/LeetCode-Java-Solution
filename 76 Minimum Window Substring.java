class Solution {
    static final int noofchar=256;
    public String minWindow(String str, String pat) {
        int len1=str.length();
		int len2=pat.length();
		if(len1<len2) {
			System.out.println("No such window exist");
			return "";
		}
		
		int hash_str[]=new int[noofchar];
		int hash_pat[]=new int[noofchar];
		
		for(int i=0;i<len2;i++)
			hash_pat[pat.charAt(i)]++;
		
		int start=0,start_index=-1,minlen=Integer.MAX_VALUE;
		
		int count=0;
		
		for(int j=0;j<len1;j++) {
			hash_str[str.charAt(j)]++;
			
			if(hash_str[str.charAt(j)]<=hash_pat[str.charAt(j)])
				count++;
			
			if(count==len2) {
				while(hash_str[str.charAt(start)]>hash_pat[str.charAt(start)]||hash_pat[str.charAt(start)]==0) {
					if(hash_str[str.charAt(start)]>hash_pat[str.charAt(start)])
						hash_str[str.charAt(start)]--;
					start++;
				}
				int len_window=j-start+1;
				if(minlen>len_window) {
					minlen=len_window;
					start_index=start;
				}
			}
		}
		if(start_index==-1) {
			System.out.println("No such window exists");
			return "";
		}
		
		return str.substring(start_index,start_index+minlen);
    }
}
