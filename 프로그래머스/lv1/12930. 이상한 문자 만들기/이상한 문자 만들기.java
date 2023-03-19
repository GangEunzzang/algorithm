class Solution {
    public String solution(String s) {

        String[] splitOfS = s.split(" ", -1);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < splitOfS.length; i++) {

            String data = splitOfS[i];

            for (int j = 0; j < data.length(); j++) {

                if (j % 2 == 0) {
                    sb.append(Character.toUpperCase(data.charAt(j)));
                } else {
                    sb.append(Character.toLowerCase(data.charAt(j)));
                }
            }
            if (i != splitOfS.length -1){
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}