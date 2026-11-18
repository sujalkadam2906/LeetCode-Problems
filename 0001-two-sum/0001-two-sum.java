import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        // Store number and its index
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            // Find the number needed to complete the target
            int complement = target - nums[i];

            // Check if complement already exists
            if (map.containsKey(complement)) {

                // Return both indices
                return new int[] { map.get(complement), i };
            }

            // Store current number and its index
            map.put(nums[i], i);
        }

        return new int[] {};
    }
}