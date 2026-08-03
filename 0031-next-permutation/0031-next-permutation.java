class Solution {
    public void nextPermutation(int[] nums) {

        int n = nums.length;

        // Step 1:Find the first decreasing element from the end
        int pivot = -1;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }

        // Step 2:If no pivot is found,current permutation is the largest
        if (pivot == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Step 3:Find the first element greater than pivot
        for (int i = n - 1; i > pivot; i--) {

            if (nums[i] > nums[pivot]) {

                swap(nums, i, pivot);
                break;
            }
        }

        // Step 4:Reverse the suffix
        reverse(nums, pivot + 1, n - 1);
    }

    // Swap two elements
    void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Reverse a part of the array
    void reverse(int[] nums, int left, int right) {

        while (left < right) {

            swap(nums, left, right);

            left++;
            right--;
        }
    }
}