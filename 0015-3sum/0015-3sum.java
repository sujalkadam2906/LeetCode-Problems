class Solution {

    public List<List<Integer>> threeSum(int[] nums) {

        // Sort the array for Two Pointer approach
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        // Fix the first element of the triplet
        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate first elements
            if (i == 0 || nums[i] != nums[i - 1]) {
                twoSum2(nums, i, result);
            }
        }

        return result;
    }

    // Find the remaining two numbers using Two Pointers
    private void twoSum2(int[] nums, int i, List<List<Integer>> result) {

        int left = i + 1;
        int right = nums.length - 1;

        while (left < right) {

            int sum = nums[i] + nums[left] + nums[right];

            // Need a larger sum
            if (sum < 0) {
                left++;
            }

            // Need a smaller sum
            else if (sum > 0) {
                right--;
            }

            // Triplet found
            else {

                result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                left++;
                right--;

                // Skip duplicate values from the left
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }

                // Skip duplicate values from the right
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            }
        }
    }
}