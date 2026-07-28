class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
       int ans = nums[0];

        while (left <= right) {

            // Current search space is already sorted
            if (nums[left] <= nums[right]) {
                ans = Math.min(ans, nums[left]);
                break;
            }

            int mid = (left + right) / 2;

            ans = Math.min(ans, nums[mid]);

            if (nums[left] <= nums[mid]) {
                // Left half is sorted
                left = mid + 1;
            } else {
                // Right half is sorted, minimum is in left half
                right = mid - 1;
            }
        }

        return ans;

        // while (left < right){
        //     int mid = (left + right) / 2;

        //     if (nums[mid] > nums[right]){
        //         left = mid + 1;
        //     }
        //     else {
        //         right = mid;
        //     }
        // }
        // return nums[right];






        // Arrays.sort(nums);      .. -> O (nlogn)
        // return nums [0];
    }
}