/*
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected
 * and it will automatically contact the police if two adjacent houses were broken into on the same night. 
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.
 * 
 * Example 1:
        Input: nums = [1,2,3,1]
        Output: 4
        Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
        Total amount you can rob = 1 + 3 = 4.

* Example 2:
        Input: nums = [2,7,9,3,1]
        Output: 12
        Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
        Total amount you can rob = 2 + 9 + 1 = 12.
 
* Constraints:
        1 <= nums.length <= 100
        0 <= nums[i] <= 400
*/

//Slide 7
class MediumQuestion {
    public int rob(int[] nums){
        int sum = 0;
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        if(nums.length == 1)
        {
            sum = nums[0];
        }
        else if(nums.length == 2){
            if(nums[0] >= nums[1]){
                sum = nums[0];
            } else {
                sum = nums[1];
            }

        }else if(nums.length == 3){
            sum = nums[0] + nums[2];
            if(nums[1] > sum){
                sum = nums[1];
            }
        }else if(nums.length == 4){
            sum1 = nums[0] + nums[2];
            sum2 = nums[1] + nums[3];
            sum3 = nums[0] + nums[3];
            if(sum1 >= sum2 && sum1 >= sum3){
                sum = sum1;
            }else if(sum2 >= sum1 && sum2 >= sum3){
                sum = sum2;
            }else{
                sum = sum3;
            }
        }else
        {
            for(int i = 0; i<nums.length; i+=2){
                if(i >= nums.length)
                {
                    break;
                }
                else
                {
                    int k = nums[i];
                    sum1 = sum1 + k;

                }
            }
            for(int i = 1; i<nums.length; i+=2){
                if(i >= nums.length)
                {
                    break;
                }
                else
                {
                    int k = nums[i];
                    sum2 = sum2 + k;

                }
            }
            if(sum1 > sum2){
                sum = sum1;
            }else{
            sum = sum2;
            }

        }
        return sum;
    }
}
