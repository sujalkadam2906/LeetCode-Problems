class Solution {
    public boolean isAlienSorted(String[] words, String order) {

        // Stores the rank of every alien character
        int[] rank = new int[26];

        // Build the mapping
        // Example:
        // h -> 0
        // l -> 1
        // a -> 2
        
        for (int i = 0; i < order.length(); i++) {
            rank[order.charAt(i) - 'a'] = i;
        }

        // Compare every adjacent pair of words
        for (int i = 0; i < words.length - 1; i++) {

            String first = words[i];
            String second = words[i + 1];

            int j = 0;

            // Compare character by character
            while (j < first.length() && j < second.length()) {

                char c1 = first.charAt(j);
                char c2 = second.charAt(j);

                // Characters are different
                if (c1 != c2) {

                    // If first character comes after second
                    // in alien order, words are not sorted
                    if (rank[c1 - 'a'] > rank[c2 - 'a'])
                        return false;

                    // Correct order
                    break;
                }

                j++;
            }

            // Prefix case
            // Example:
            // "apple"
            // "app"
            if (j == second.length() && first.length() > second.length())
                return false;
        }

        return true;
    }
}