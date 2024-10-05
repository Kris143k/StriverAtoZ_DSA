package Arrays.Medium;

//Q.Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.You may assume that each input would have exactly one solution, and you may not use the same element twice.You can return the answer in any order

//Approach 1: using hashmap [TC:O(nlogn) & SC:O(n)]
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int compliment=target-nums[i];
            if(map.containsKey(compliment)){
                return new int[]{map.get(compliment),i};//return true
            }
            map.put(nums[i],i);
        }
        return new int[0];//return false;
    }
}

//Approach 2: using two pointers [TC:O(nlogn) & SC:O(1)] only optimal if return type is boolean(yes/no)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        Arrays.sort(nums);
        int i=0;
        int j=n-1;
        while(i<j){
            int temp=target-nums[j];
            if(nums[i]==temp){
                return true;
            }else if(nums[i]<temp){
                i++;
            }else{
                j--;
            }
        }
        return false;
    }
}