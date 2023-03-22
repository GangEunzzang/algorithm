class Solution {
    public String solution(String s) {

        if (s.length() == 1) {
            return s.toUpperCase();
        }
        String[] splitOfS = s.toLowerCase().split(" ", -1);

        StringBuilder sb = new StringBuilder();

        for (String splitOf : splitOfS) {

            for (int i = 0; i < splitOf.length(); i++) {
                if (i == 0) {
                    if (Character.isDigit(splitOf.charAt(0))) {
                        sb.append(splitOf.charAt(i));
                    } else {
                        sb.append(Character.toUpperCase(splitOf.charAt(i)));
                    }
                } else {
                    sb.append(splitOf.charAt(i));
                }
            }
            sb.append(" ");
        }

        return sb.toString().substring(0, sb.length() -1);
    }
}