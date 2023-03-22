class Solution {
    public String solution(String X, String Y) {

        int[] arraysOfX = new int[10];
        int[] arraysOfY = new int[10];

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < X.length(); i++) {
            arraysOfX[Character.getNumericValue(X.charAt(i))]++;
        }

        for (int i = 0; i < Y.length(); i++) {
            arraysOfY[Character.getNumericValue(Y.charAt(i))]++;
        }

        for (int i = 9; i >= 0; i--) {
            while (arraysOfX[i] > 0 && arraysOfY[i] > 0) {
                sb.append(i);
                arraysOfX[i]--;
                arraysOfY[i]--;
            }
        }

        if(sb.length() != 0 && sb.toString().charAt(0) == '0') return "0";

        return sb.length() == 0 ? "-1" :sb.toString();
    }
}