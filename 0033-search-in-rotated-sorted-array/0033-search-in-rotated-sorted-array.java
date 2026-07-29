class Solution {
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Target found
            if (nums[mid] == target)
                return mid;

            // Check which half is sorted
            if (nums[left] <= nums[mid]) {

                // Left half is sorted.

                // If the target lies inside the sorted left half,
                // discard the right half and search on the left.
                if (target >= nums[left] && target < nums[mid])
                    right = mid - 1;

                // Otherwise, search in the right half.
                else
                    left = mid + 1;

            } else {

                // Right half is sorted.

                // If the target lies inside the sorted right half,
                // discard the left half and search on the right.
                if (target > nums[mid] && target <= nums[right])
                    left = mid + 1;

                // Otherwise, search in the left half.
                else
                    right = mid - 1;
            }
        }

        // Target not found
        return -1;
    }
}