class Solution {
    public int findClosestNumber(int[] nums) {
        int nearByZero = Integer.MAX_VALUE;
        int answer = Integer.MIN_VALUE;

        for (int num : nums) {
            if (Math.abs(num) < nearByZero) {
                nearByZero = Math.abs(num);
                answer = num;
            } else if (Math.abs(num) == nearByZero){
                answer = Math.max(num, answer);
            }
        }

        return answer;
    }
}