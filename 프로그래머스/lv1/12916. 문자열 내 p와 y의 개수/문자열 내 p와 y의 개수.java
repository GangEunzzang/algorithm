class Solution {
    boolean solution(String s) {

        String lowerOfS = s.toLowerCase();

        int countOfP = 0;
        int countOfY = 0;

        for (int i = 0; i < lowerOfS.length(); i++) {
            if (lowerOfS.charAt(i) == 'p') {
                countOfP++;
            } 
            
            if (lowerOfS.charAt(i) == 'y'){
                countOfY++;
            }
        }

        return countOfP == countOfY ? true : false;
    }
}