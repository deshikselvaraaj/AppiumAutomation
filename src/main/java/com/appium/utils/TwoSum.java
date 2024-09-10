package com.appium.utils;

public class TwoSum {
	
	public int[] twoSum(int[] nums, int target) {
        
		for(int i=0;i<nums.length;i++)
			        {
			            for(int j=1;j<nums.length;j++)
			            {
			            
			                if(nums[i]+nums[j]==target && i!=j) 
			                	return new int[]{i,j};
			            }
			        }
							return nums;
				}
	 
	 public static void main(String[] args) {
		TwoSum ts = new TwoSum();
		int[] num = {3,2,4};
		ts.twoSum(num, 6);
	}

}
