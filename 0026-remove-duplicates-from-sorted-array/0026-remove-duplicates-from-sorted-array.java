
class Solution {
    public int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) return 0; // Edge cases

        int i = 0; // Last unique element index

        for (int j = 1; j < nums.length; j++) {

            if (nums[j] != nums[i]) {
                i++;          // Next unique position
                nums[i] = nums[j]; // Unique element ko place karo
            }
        }

        return i + 1; // Total unique elements
    }
}
