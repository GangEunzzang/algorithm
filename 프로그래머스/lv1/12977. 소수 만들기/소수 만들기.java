class Solution {
    public int solution(int[] nums) {

        boolean[] prime = new boolean[3000];

        prime[0] = prime[1] = true;


        for (int i = 2; i <= Math.sqrt(3000); i++) {
            if (prime[i] == true) {
                continue;
            }

            for (int j = i * i; j < prime.length; j = j + i) {
                prime[j] = true;
            }
        }

        int count = 0;

        for (int i = 0; i <= nums.length - 3; i++) {

            for (int j = i +1; j <= nums.length -2; j++) {

                for (int k = j + 1; k <= nums.length -1; k++) {
                    int val = nums[i] + nums[j] + nums[k];
                    if (!prime[val]) {
                        count++;
                    }
                }

            }
        }

        return count;
    }
}