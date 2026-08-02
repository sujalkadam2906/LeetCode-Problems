class Solution {
    public boolean isAlienSorted(String[] words, String order) {

        // Stores the rank of every alien character
        HashMap<Character, Integer> map = new HashMap<>();

        // Build the alien dictionary
        // Example:
        // h -> 0
        // l -> 1
        // a -> 2
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        // Compare every adjacent pair of words
        for (int i = 0; i < words.length - 1; i++) {

            String first = words[i];
            String second = words[i + 1];

            int j = 0;

            // Compare characters one by one
            while (j < first.length() && j < second.length()) {

                char c1 = first.charAt(j);
                char c2 = second.charAt(j);

                // If characters are different,
                // compare their alien ranks
                if (c1 != c2) {

                    // Wrong order
                    if (map.get(c1) > map.get(c2))
                        return false;

                    // Correct order, no need to compare further
                    break;
                }

                j++;
            }

            // Prefix Case
            // Example:
            // "apple"
            // "app"
            // Invalid because longer word comes first
            if (j == second.length() && first.length() > second.length())
                return false;
        }

        return true;
    }
}