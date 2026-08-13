class Solution {
    public int search(int[] nums, int k) {
        int low = 0, high = nums.length - 1;

        // Applying binary search algorithm
        while (low <= high) {
            int mid = (low + high) / 2;

            // Check if mid points to the target
            if (nums[mid] == k)
                return mid;

            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low = low + 1;
                high = high - 1;
                continue;
            }
            // Check if the left part is sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= k && k <= nums[mid]) {
                    // Target exists in the left sorted part
                    high = mid - 1;
                } else {
                    // Target does not exist in the left sorted part
                    low = mid + 1;
                }
            } else {
                // Check if the right part is sorted
                if (nums[mid] <= k && k <= nums[high]) {
                    // Target exists in the right sorted part
                    low = mid + 1;
                } else {
                    // Target does not exist in the right sorted part
                    high = mid - 1;
                }
            }
        }
        // If target is not found
        return -1;
    }
}
