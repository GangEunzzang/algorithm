class Solution {
    public int[] solution(int[] prices) {

        int[] answer = new int[prices.length];
        answer[prices.length - 1] = 0;

        for (int i = 0; i < prices.length; i++) {
            int count = 0;

            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] < prices[i]) {
                    count++;
                    break;
                }
                count++;
            }
            answer[i] = count;
        }
        return answer;
    }
}