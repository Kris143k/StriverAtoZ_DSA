package Arrays.Hard;

//Q.Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.Notice that the solution set must not contain duplicate triplets.

//Approach-1: Brute force [TC:O(n^3 * logn) & SC:O(n)+O(no. of triplets)]
class Solution {  
    public List<List<Integer>> threeSum(int[] nums) {  
        int n = nums.length;  
        List<List<Integer>> res = new ArrayList<>();  
        HashSet<List<Integer>> set = new HashSet<>();  
        for (int i = 0; i < n; i++) {  
            for (int j = i + 1; j < n; j++) {  
                for (int k = j + 1; k < n; k++) {    
                    if (nums[i] + nums[j] + nums[k] == 0) {  
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);  
                        Collections.sort(list); // Sort for uniqueness  
                        set.add(list); // Add to set to avoid duplicates  
                    }  
                }  
            }  
        }  
        // Add all unique triplets to result  
        res.addAll(set);  
        return res; 
    }  
}
//-------------------------------------------------------------------------------------------------//
//Approach-2: Better [TC:O(n^2 * logm) & SC:O(n)+O(no. of triplets)*2]
class Solution {  
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        List<List<Integer>> res = new ArrayList<>();
        HashSet<List<Integer>> set1=new HashSet<>();
        for(int i=0;i<n;i++){
            HashSet<Integer> set=new HashSet<>();
            for(int j=i+1;j<n;j++){
                int third=-(nums[i]+nums[j]);
                if(set.contains(third)){
                    List<Integer> list = Arrays.asList(nums[i], nums[j], third);  
                    Collections.sort(list); // Sort for uniqueness  
                    set1.add(list); // Add to set to avoid duplicates
                }
                set.add(nums[j]);
            }
        }
        // Add all unique triplets to result  
        res.addAll(set1);  
        return res; 
    }
}

//-------------------------------------------------------------------------------------------------//
//Approach-3: Optimal [TC:O(nlogn)+O(n^2) & SC:O(no. of triplets)]
class Solution {  
    public List<List<Integer>> threeSum(int[] nums) {  
        List<List<Integer>> res = new ArrayList<>();  
        Arrays.sort(nums);  // Sort the array to facilitate the two-pointer approach  
        int n = nums.length;  

        for (int i = 0; i < n - 2; i++) {  
            // Skip duplicates for first element  
            if (i > 0 && nums[i] == nums[i - 1]) continue;  

            int j = i + 1;  // Second pointer  
            int k = n - 1;  // Third pointer  

            while (j < k) {  
                int sum = nums[i] + nums[j] + nums[k];  
                if (sum < 0) {  
                    j++;  // Move the second pointer to the right to increase the sum  
                } else if (sum > 0) {  
                    k--;  // Move the third pointer to the left to decrease the sum  
                } else {  
                    // Found a triplet that sums to zero  
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));  
                    j++;  
                    k--;  

                    // Skip duplicates for the second element  
                    while (j < k && nums[j] == nums[j - 1]) j++;  
                    // Skip duplicates for the third element  
                    while (j < k && nums[k] == nums[k + 1]) k--;  
                }  
            }  
        }  
        return res;  // Return the list of triplets  
    }  
}

