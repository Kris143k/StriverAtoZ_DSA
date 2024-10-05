package Arrays.Hard;

//Q.Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:0 <= a, b, c, d < n. a, b, c, and d are distinct.nums[a] + nums[b] + nums[c] + nums[d] == target.You may return the answer in any order.


// Approach-1: Brute force [TC:O(n^4 * logn) & SC:O(n) + O(no. of quadruplets)]
class Solution {  
    public List<List<Integer>> fourSum(int[] nums,int target) {  
        int n = nums.length;  
        List<List<Integer>> res = new ArrayList<>();  
        HashSet<List<Integer>> set = new HashSet<>();  
        
        for (int i = 0; i < n; i++) {  
            for (int j = i + 1; j < n; j++) {  
                for (int k = j + 1; k < n; k++) {  
                    for (int l = k + 1; l < n; l++) {
                        long sum = (long)nums[i] + nums[j] + nums[k] + nums[l];
                        if (sum == target) {  
                            List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            Collections.sort(list); // Sort for uniqueness  
                            set.add(list); // Add to set to avoid duplicates  
                        }  
                    }  
                }  
            }  
        }  
        
        // Add all unique quadruplets to result  
        res.addAll(set);  
        return res;  
    }  
}
//-------------------------------------------------------------------------------------------------//

// Approach-2: Better [TC: O(n^3 * logm) & SC: O(n) + O(no. of quadruplets) * 2]
class Solution {  
    public List<List<Integer>> fourSum(int[] nums, int target) {  
        int n = nums.length;  
        List<List<Integer>> res = new ArrayList<>();  
        HashSet<List<Integer>> set1 = new HashSet<>(); // To store unique quadruplets
        
        for (int i = 0; i < n; i++) {  
            for (int j = i + 1; j < n; j++) {  
                HashSet<Long> set = new HashSet<>(); // To track seen numbers for current pair
                for (int k = j + 1; k < n; k++) {
                    long sum=(long)nums[i]+nums[j]+nums[k];  
                    long fourth = target - sum; // Find the fourth element
                    if (set.contains(fourth)) {  
                        // Create a list of the quadruplet
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k], (int)fourth);  
                        Collections.sort(list); // Sort for uniqueness  
                        set1.add(list); // Add to set to avoid duplicates
                    }  
                    set.add((long)nums[k]); // Add the third element to the set
                }  
            }  
        }  
        
        // Add all unique quadruplets to result  
        res.addAll(set1);  
        return res;  
    }  
}
//-------------------------------------------------------------------------------------------------//

// Approach-3: Optimal [TC: O(n^3) & SC: O(no. of quadruplets)]
class Solution {  
    public List<List<Integer>> fourSum(int[] nums, int target) {  
        List<List<Integer>> res = new ArrayList<>();  
        Arrays.sort(nums);  // Sort the array to use the two-pointer approach  
        int n = nums.length;  

        for (int i = 0; i < n - 3; i++) {  
            // Skip duplicates for the first element  
            if (i > 0 && nums[i] == nums[i - 1]) continue;  

            for (int j = i + 1; j < n - 2; j++) {  
                // Skip duplicates for the second element  
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;  

                int k = j + 1;  
                int l = n - 1;  

                while (k < l) {  
                    // Use long to handle overflow
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];  

                    if (sum < target) {  
                        k++;  // Move left pointer to increase the sum  
                    } else if (sum > target) {  
                        l--;  // Move right pointer to decrease the sum  
                    } else {  
                        // Found a quadruplet that sums to the target  
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));  

                        // Move both pointers after finding a valid quadruplet  
                        k++;  
                        l--;  

                        // Skip duplicates for the third element  
                        while (k < l && nums[k] == nums[k - 1]) k++;  
                        // Skip duplicates for the fourth element  
                        while (k < l && nums[l] == nums[l + 1]) l--;  
                    }  
                }  
            }  
        }  
        return res;  // Return the list of quadruplets  
    }  
}
