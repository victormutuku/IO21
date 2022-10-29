import java.util.Arrays;

class MediumSolution {
    public int rob(int[] nums) {
        
        int dp[]=new int[nums.length];
        Arrays.fill(dp,-1);

        // return solve(nums,0,dp);
        // return solveTab(nums);  
        return solve1(nums);
    }
    
    // recursion
    private int solve(int nums[],int i,int dp[]){
        
        if(i>=nums.length) return 0;
        
        if(dp[i]!=-1) return dp[i];
        
        int a=nums[i]+solve(nums,i+2,dp);
        int b=solve(nums,i+1,dp);
        
        return dp[i]=Math.max(a,b);
        
        
    }
    
    // tabular
    private int solveTab(int nums[]){
        
        int len=nums.length;
        int dp[]=new int[len+2];
        
        for(int i=len-1;i>=0;i--){
            int a=nums[i]+dp[i+2];
            int b=dp[i+1];
            dp[i]=Math.max(a,b);
        }
        return dp[0];
        
        
        
    }
    
    // SC = (1)
    private int solve1(int nums[]){
        
        int len=nums.length;
        
        int prev=0;
        int curr=0;
        
        for(int i=len-1;i>=0;i--){
            
            int a=nums[i]+prev;
            int b=curr;
            prev=curr;
            curr=Math.max(a,b);
            
        }
        
        return curr;
        
        
    }
    
}