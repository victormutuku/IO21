/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.
*/
//Slide 6
import java.util.Arrays;

class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int c = nums[0];
        for(int i = 0; i < nums.length; i++){
            if (nums.length == 1)
            {
                c = nums[0];
                break;
            }
            else if(nums.length > 1)
            {
                // TODO: Add a check that will allow splitting into two arrays for positive and negative numbers
                if(i+1 >= nums.length)
                {
                    break;
                }
                else
                {
                    
                    if(nums[i] == nums[i+1])
                    {
                        nums[i] = 0;
                        nums[i+1] = 0;
                        
                        Arrays.sort(nums);
                        if(nums[nums.length-1] == 0){
                            c = nums[0];
                        }
                        c = nums[nums.length -1];
                        continue;
                    }                  
                }
                
            }else{
                break;
            }
            
        }
        return c;
    }
}
