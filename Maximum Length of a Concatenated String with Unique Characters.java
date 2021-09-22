class Solution {
    private int dfs(int[][] a, int n, int pos, int set, int len) {
        int res = len;
        for(int i = pos; i < n; i++) {
            if((set & a[i][0]) == 0) {
                res = Math.max(res, dfs(a, n, i + 1, set | a[i][0], len + a[i][1]));
            }
        }
        return res;
    }
    public int maxLength(List<String> arr) {
        int[][] a = new int[arr.size()][2];
        int n = 0;
        for(String s: arr) {
            int set = 0;
            for(char ch: s.toCharArray()) {
                int c = 1 << (ch - 'a');
                if((set & c) == 0) {
                    set |= c;
                } else {
                    set = 0;
                    break;
                }
            }
            if(set != 0) {
                a[n][0] = set;
                a[n++][1] = s.length();
            }
        }
        return dfs(a, n, 0, 0, 0);
    }
}
