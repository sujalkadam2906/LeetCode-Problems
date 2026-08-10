class Solution {
    public boolean isAnagram(String s, String t) {

        // Anagrams must have the same length
        if (s.length() != t.length()) {
            return false;
        }

        /*
         * Frequency array for 26 lowercase English letters.
         *
         * index 0  -> 'a'
         * index 1  -> 'b'
         * ...
         * index 25 -> 'z'
         */
        int[] count = new int[26];

        // Count characters from s
        // and remove characters from t
        for (int i = 0; i < s.length(); i++) {

            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        /*
         * If s and t are anagrams,
         * every frequency should become 0.
         */
        for (int frequency : count) {

            if (frequency != 0) {
                return false;
            }
        }

        return true;
    }
}