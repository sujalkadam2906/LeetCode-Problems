class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Hamesha smaller array par Binary Search
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int left = 0;
        int right = m;

        // Left side me itne total elements chahiye
        int leftSize = (m + n + 1) / 2;

        while (left <= right) {

            // nums1 ko yaha se cut kar rahe hain
            int cut1 = left + (right - left) / 2;

            // nums2 me automatically required cut
            int cut2 = leftSize - cut1;

            // Cut ke just left wala element
            int left1 = (cut1 == 0)
                    ? Integer.MIN_VALUE
                    : nums1[cut1 - 1];

            // Cut ke just right wala element
            int right1 = (cut1 == m)
                    ? Integer.MAX_VALUE
                    : nums1[cut1];

            // Same for nums2
            int left2 = (cut2 == 0)
                    ? Integer.MIN_VALUE
                    : nums2[cut2 - 1];

            int right2 = (cut2 == n)
                    ? Integer.MAX_VALUE
                    : nums2[cut2];

            // 🎯 Correct partition
            if (left1 <= right2 && left2 <= right1) {

                // Odd total elements
                if ((m + n) % 2 == 1) {
                    return Math.max(left1, left2);
                }

                // Even total elements
                return (
                    Math.max(left1, left2) +
                    Math.min(right1, right2)
                ) / 2.0;
            }

            // nums1 ke left side me too many / too large elements
            else if (left1 > right2) {
                right = cut1 - 1;
            }

            // nums1 ke left side me too few elements
            else {
                left = cut1 + 1;
            }
        }

        return 0.0;
    }
}