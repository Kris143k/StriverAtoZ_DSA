package Arrays.Medium;

//Q.Given an array nums of size n, return the majority element.The majority element is the element that appears more than ⌊n / 2⌋ times

class Solution {
    // Using Moore's Voting Algorithm
    public int majorityElement(int[] nums) {
        int n = nums.length;
        // first step: Counting and Cancelling
        int count = 0;
        int el = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                el = nums[i];
                count = 1;
            } else if (el == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        // Second step: Verify
        count = 0;
        for (int i = 0; i < n; i++) {
            if (el == nums[i]) {
                count++;
            }
        }
        if (count > n / 2) {
            return el;
        }
        return -1;
    }
}