class Solution {
    public int removeDuplicates(int[] nums) {

        // If array has only one element
        if (nums.length == 1)
            return 1;

        // i points to the last unique element
        int i = 0;

        // j scans the entire array
        for (int j = 1; j < nums.length; j++) {

            // New unique element found
            if (nums[j] != nums[i]) {

                // Move i to the next position
                i++;

                // Place the unique element here
                nums[i] = nums[j];
            }
        }

        // Number of unique elements
        return i + 1;
    }
}