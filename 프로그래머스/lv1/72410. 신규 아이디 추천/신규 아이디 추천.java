class Solution {
    public String solution(String new_id) {
        String answer = "";

        answer = new_id.toLowerCase();
        answer = answer.replaceAll("[^\\w\\-_.]*", "");
        answer = answer.replaceAll("\\.{2,}", ".");
        answer = answer.replaceAll("^[.]|[.]$", "");
        answer = answer.length() == 0 ? "a" : answer;

        if (16 <= answer.length()) answer = answer.substring(0, 15).replaceAll("^[.]|[.]$", "");

        answer = minLength(answer);

        return answer;
    }

    private String minLength(String target) {
        if (2 < target.length()) return target;

        target += target.charAt(target.length() - 1);

        return minLength(target);
    }
}