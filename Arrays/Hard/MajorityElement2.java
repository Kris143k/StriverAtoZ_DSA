package Arrays.Hard;

//Q.Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

class Solution {
    //Using Moore's Voting Algorithm
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        //first step: Counting and Cnacelling
        int count1=0;
        int el1=Integer.MIN_VALUE;
        int count2=0;
        int el2=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(count1==0 && nums[i]!=el2){
                el1=nums[i];
                count1=1;
            }else if(count2==0 && nums[i]!=el1){
                el2=nums[i];
                count2=1;
            }else if(nums[i]==el1){
                count1++;
            }else if(nums[i]==el2){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        //Second step: Verify
        count1=0;
        count2=0;
        for(int i=0;i<n;i++){
            if(el1==nums[i]){
                count1++;
            }else if(el2==nums[i]){
                count2++;
            }
        }
        List<Integer> res=new ArrayList<>();
        if(count1>n/3){
            res.add(el1);
        }
        if(count2>n/3){
            res.add(el2);
        }
        return res;
    }
}