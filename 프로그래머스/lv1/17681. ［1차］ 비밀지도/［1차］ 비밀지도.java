class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {

        boolean[][] arr = new boolean[n][n];

        for (int i = 0; i < arr1.length; i++) {
            StringBuilder binary = new StringBuilder(Integer.toBinaryString(arr1[i]));

            if (binary.length() < n) {
                int div = n - binary.length();

                for (int k = 0; k < div; k++) {
                    binary.insert(0, "0");
                }
            }

            for (int j = 0; j < binary.length(); j++) {
                if (binary.charAt(j) == '1') {
                    arr[i][j] = true;
                }
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            StringBuilder binary = new StringBuilder(Integer.toBinaryString(arr2[i]));

            if (binary.length() < n) {
                int div = n - binary.length();

                for (int k = 0; k < div; k++) {
                    binary.insert(0, "0");
                }
            }

            for (int j = 0; j < binary.length(); j++) {
                if (binary.charAt(j) == '1') {
                    arr[i][j] = true;
                }
            }
        }


        String[] answer = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {

            StringBuilder sb = new StringBuilder();
            boolean[] booleans = arr[i];

            for (int j = 0; j < booleans.length; j++) {
                if (booleans[j]) {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }

            answer[i] = sb.toString();
        }

        return answer;
    }
}