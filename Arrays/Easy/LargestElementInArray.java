package Arrays.Easy;

//Q. Given an array, arr. The task is to find the largest element in it.

class Solution {
    public static int largest(int n, int[] arr) {
        // code here
        int max=arr[0];
        for(int i=1;i<n;i++){
            max=Math.max(max,arr[i]);
        }
        return max;
    }
}