class Solution {
    public boolean isAnagram(String s, String t) {

        // Anagram strings must have the same length
        if (s.length() != t.length()) {
            return false;
        }

        // Frequency array for 26 lowercase English letters
        int[] count = new int[26];

        // Count characters in s
        // and subtract characters in t
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        // If any frequency is not zero,
        // the strings are not anagrams
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }

        return true;
    }
}