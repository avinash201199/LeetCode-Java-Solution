class Solution {
    
    private char[] str;
    public int calculate(String s) {
        str = s.toCharArray();
        return getBracketValue(0)[0];
    }
    
    private int[] getBracketValue(int idx) {                                       // returns (value in bracket, index of '))
        int val = 0;
        char prev = '+';
        for (; idx < str.length && str[idx] != ')'; idx++) {
            if (str[idx] == ' ') continue;
            if (str[idx] >= '0' && str[idx] <= '9') {                              // get number starting from current index
                int num = 0;
                while (idx < str.length && str[idx] >= '0' && str[idx] <= '9')
                    num = num * 10 + str[idx++] - '0';
                idx--;
                if (prev == '+') val += num;                                       //  add current number to value in bracket
                else if (prev == '-') val -= num;
            } else if (str[idx] == '(') {                                          // recur if nested bracket found
                int[] x = getBracketValue(idx + 1);
                idx = x[1];
                if (prev == '+') val += x[0];
                else if (prev == '-') val -= x[0];
            }
            else if (str[idx] == '+') prev = '+';                                  //  update previous operator
            else prev = '-';
        }
        return new int[] {val, idx};
    }
}
