class Solution {
    public static int[] twoSum(int[] nums, int target) {
    // key: index number , value : values --> hash table
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    // put nums, index number to map
    for (int i = 0; i < nums.length; i++) {
        map.put(nums[i], i);
    }
    
    // coparing to target
    for (int i = 0; i < nums.length; i++) {
        Integer remainder = map.get(target - nums[i]);
        if (remainder != null && remainder != i)
            return new int[]{i, remainder};
    }
    return null;
}
}