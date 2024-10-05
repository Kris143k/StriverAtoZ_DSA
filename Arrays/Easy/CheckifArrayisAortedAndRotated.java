package Arrays.Easy;

//Q.Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.There may be duplicates in the original array.Note: An array A rotated by x positions results in an array B of the same length such that A[i] == B[(i+x) % A.length], where % is the modulo operation.

class Solution {
    public boolean check(int[] nums) {
        int n=nums.length;
        int pivot=nums[n-1];
        int x=1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<=pivot){
                pivot=nums[i];
                x++;
            }else{
                break;
            }
        }
        x=n-x;
        int end=x+n;
        x++;
        while(x<end){
            if(nums[(x-1)%n]>nums[x%n]){
                return false;
            }
            x++;
        }
        return true;
    }
}