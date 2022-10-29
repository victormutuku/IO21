class EasySolution {
    public int singleNumber(int[] nums) {
        
        // do XOR operation on all element using bit wise operator concept 
        
        // for dry run take table of 1 to 9 base10 to binary 
        // XOR all element u will get unique element 
        
        int ans =0; 
        for (int i =0; i<nums.length; i++){
            ans ^=nums[i];
        }
        return ans;
    }
}