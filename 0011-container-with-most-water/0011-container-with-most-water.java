class Solution {
    public int maxArea(int[] height) {

        int max = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {

            // Distance between the two lines
            int width = right - left;

            // Area = Width × Smaller Height
            int area = Math.min(height[left], height[right]) * width;

            // Update maximum area
            max = Math.max(max, area);

            // Move the pointer having the smaller height
            // because only that can potentially increase the area
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}