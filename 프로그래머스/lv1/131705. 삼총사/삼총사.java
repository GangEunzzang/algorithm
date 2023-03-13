
class Solution {
    public int solution(int[] number) {
        int answer = 0;

        for (int i = 0; i < number.length; i++) {

            for (int j = i + 1; j < number.length; j++) {

                for (int k = j + 1; k < number.length; k++) {
                    
                    int one = number[i];
                    int two = number[j];
                    int three = number[k];

                    if (one + two + three == 0) {
                        answer++;
                    }

                }

            }

        }

        return answer;
    }
}