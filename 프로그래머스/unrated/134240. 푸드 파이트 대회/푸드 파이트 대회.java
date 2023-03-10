class Solution {

    public String solution(int[] food) {

        StringBuilder sb = new StringBuilder();


        for (int i = 1; i < food.length; i++) {
            if (food[i] % 2 != 0) {
                food[i] = food[i] - 1;
            }
        }

        for (int i = 1; i < food.length; i++) {
            for (int j = 1; j <= food[i] / 2; j++) {
                sb.append(i);
            }
        }

        sb.append("0");

        for (int i = food.length -1; i >= 1; i--) {
            for (int j = 1; j <= food[i] / 2; j++) {
                sb.append(i);
            }
        }

        return sb.toString();
    }
}