class Solution {
    
    // BFS
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        Map<String, List<String>> prev = new HashMap<>();
        Set<String> dict = new HashSet<>(wordList);
        if (dict.contains(beginWord)) dict.remove(beginWord);
        if (!dict.contains(endWord)) return new ArrayList<>(); // not reachable
        Set<String> s = new HashSet<>();
        s.add(beginWord);
        while (!s.isEmpty()) {
            s = getNext(s, dict, prev);
        }
        
        if (!prev.containsKey(endWord)) return new ArrayList<>(); // endWord is not reachable from beginWord
        return reconstruct(beginWord, endWord, prev);
    }
    
    // reconstruct the answer by recursion using the prev
    private List<List<String>> reconstruct(String beginWord, String endWord, Map<String, List<String>> prev) {
        List<List<String>> res = new ArrayList<>();
        
        if (endWord.equals(beginWord)) { // base case: beginWord == endWord
            List<String> l = new ArrayList<>();
            l.add(beginWord);
            res.add(l);
            return res;
        }
        
        List<String> precursors = prev.get(endWord);
        for (String p: precursors) {
            List<List<String>> temp = reconstruct(beginWord, p, prev);
            for (List<String> l: temp) {
                l.add(endWord);
                res.add(l);
            }
        }
        return res;
    }
        
    // update next layer based on the curr layer
    // keep track of the precursors of each reachable word from beginWord in prev
    private Set<String> getNext(Set<String> curr, Set<String> dict, Map<String, List<String>> prev) {
        
        Set<String> next = new HashSet<>(); // next layer to update
        
        for (String str: curr) { // find all possible next words from str
            char[] s = str.toCharArray(); 
            for (int i = 0; i < s.length; i++) {
                for (int j = 0; j < 26; j++) {
                    s[i] = (char) ('a' + j);
                    String temp = String.valueOf(s);
                    if (dict.contains(temp)) {
                        next.add(temp);
                        dict.remove(temp);
                        updatePrev(prev, temp, str); // update precursor list of temp
                    } else if (next.contains(temp)) { // temp is not explored yet, meaning it has multiple precursors
                        updatePrev(prev, temp, str); // update precursor list of temp
                    }
                }
                s[i] = str.charAt(i);     
            }          
        }
        return next;
    }
    
    // update a word's precursor list
    private void updatePrev(Map<String, List<String>> prev, String key, String p) {
        if (!prev.containsKey(key)) prev.put(key, new ArrayList<>());
        List<String> precursors = prev.get(key);
        precursors.add(p);
    }
}
