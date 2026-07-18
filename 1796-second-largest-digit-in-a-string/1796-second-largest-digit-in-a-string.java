class Solution {
    public int secondHighest(String s) {
        int max, smax;
        max = smax = -1;
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (Character.isDigit(ch)){
                int num = ch - '0';
                if (num > max) {
                    smax = max;
                    max = num;
                }
                else if (num > smax && num != max) {
                 smax = num;
                }

            }
        }
        return smax;
    }
}