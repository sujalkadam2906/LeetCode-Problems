class Solution {
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            // Middle element nikaalo
            int mid = left + (right - left) / 2;

            // Target mil gaya
            if (nums[mid] == target)
                return mid;

            // Check karo ki left half sorted hai ya nahi
            if (nums[left] <= nums[mid]) {

                // Agar target left sorted range ke andar hai
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;      // Left half me search karo
                } else {
                    left = mid + 1;       // Right half me search karo
                }

            } else { // Right half sorted hai

                // Agar target right sorted range ke andar hai
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;       // Right half me search karo
                } else {
                    right = mid - 1;      // Left half me search karo
                }
            }
        }

        // Target nahi mila
        return -1;
    }
}