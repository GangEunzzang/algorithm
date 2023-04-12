class Solution {
    public int[] solution(int[] answers) {

        int[] oneArr = {1, 2, 3, 4, 5};
        int[] twoArr = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] threeArr = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int oneIndex = 0;
        int twoIndex = 0;
        int threeIndex = 0;
        int oneCount = 0;
        int twoCount = 0;
        int threeCount = 0;


        for (int i = 0; i < answers.length; i++) {

            if (oneIndex > 4) {
                oneIndex = 0;
            }

            if (twoIndex > 7) {
                twoIndex = 0;
            }

            if (threeIndex > 9) {
                threeIndex = 0;
            }


            if (answers[i] == oneArr[oneIndex]) {
                oneCount++;
            }

            if (answers[i] == twoArr[twoIndex]) {
                twoCount++;
            }

            if (answers[i] == threeArr[threeIndex]) {
                threeCount++;
            }

            oneIndex++; twoIndex++; threeIndex++;

        }



        if (oneCount == twoCount && oneCount == threeCount) {
            return new int[]{1, 2, 3};
        } else if (oneCount == twoCount && oneCount != threeCount && oneCount > threeCount) {
            return new int[]{1, 2};
        } else if (oneCount == threeCount && twoCount != oneCount && oneCount > twoCount) {
            return new int[]{1, 3};
        } else if (twoCount == threeCount && oneCount != threeCount && twoCount > oneCount) {
            return new int[]{2, 3};
        } else {
            
            int max = Math.max(threeCount, Math.max(oneCount, twoCount));

           if (max == oneCount) {
                return new int[]{1};
            } else if (max == twoCount) {
                return new int[]{2};
            } else {
                return new int[]{3};
            }
            
        }
        
    }
}
