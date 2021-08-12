class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {        
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        for (String string:strs){
            char[] chars = string.toCharArray();
            Arrays.sort(chars);
            String sortedString = new String(chars);            
            map.putIfAbsent(sortedString, new ArrayList<String>());            
            map.get(sortedString).add(string);
        }
        return new ArrayList(map.values());
    }
}
