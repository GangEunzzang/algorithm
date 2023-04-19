class Solution {

    private static int[] numberArrays;

    private static int targetNumber;

    public int solution(int[] numbers, int target) {

        numberArrays = numbers;
        targetNumber = target;
        return dfs(0, 0);
    }

    private static int dfs(int i, int sum) {
        
        int count = 0;
        
        if (i == numberArrays.length){

            if (sum == targetNumber) {
                return 1;
            } else {
                return 0;
            }
        }

        count += dfs(i + 1, sum + numberArrays[i]);
        count += dfs(i + 1, sum + numberArrays[i] * -1);

        return count;

    }
    

}