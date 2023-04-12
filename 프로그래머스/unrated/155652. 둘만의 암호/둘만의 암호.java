class Solution {
    public String solution(String s, String skip, int index) {

        boolean[] skipArrays = new boolean[27];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < skip.length(); i++) {
            skipArrays[skip.charAt(i) - 96] = true;
        }


        for (int i = 0; i < s.length(); i++) {

            int num = s.charAt(i) - 96;
            
            for (int j = 0; j < index; j++) {
                
                num++;
                
                if (num > 26) {
                    num = num % 26;
                }

                if (skipArrays[num]) {
                    j--;
                }
            }
            
            sb.append(Character.toString(num + 96));
        }

        return sb.toString();
    }
}