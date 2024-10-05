package Arrays.Easy;

//Q. Given an array arr, return the second largest distinct element from an array. If the second largest element doesn't exist then return -1.

class Solution {
    public int print2largest(List<Integer> arr) {
        // Code Here
        int max=arr.get(0);
        int n=arr.size();
        for(int i=1;i<n;i++){
            max=Math.max(max,arr.get(i));
        }
        
        int secondMax=-1;
        for(int i=0;i<n;i++){
            int num=arr.get(i);
            if(num!=max){
                secondMax=Math.max(secondMax,num);
            }
        }
        return secondMax;
    }
}
