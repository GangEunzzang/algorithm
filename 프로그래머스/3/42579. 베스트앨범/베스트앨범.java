import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        Map<String, List<Song>> map = new TreeMap<>();
        Map<String, Integer> genreTotalPlayTime = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            List<Song> list = map.getOrDefault(genre, new ArrayList<>());
            list.add(new Song(genre, plays[i], i));
            map.put(genre, list);

            genreTotalPlayTime.put(genre, genreTotalPlayTime.getOrDefault(genre, 0) + plays[i]);
        }
        
        List<String> sortedGenres = new ArrayList<>(genreTotalPlayTime.keySet());
        sortedGenres.sort((a, b) -> genreTotalPlayTime.get(b) - genreTotalPlayTime.get(a));

        List<Integer> answerList = new ArrayList<>();

        for (String genre : sortedGenres) {
            List<Song> songs = map.get(genre);

            songs.sort((a, b) -> b.play - a.play);

            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                answerList.add(songs.get(i).idx);
            }
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    class Song {
        String genre;
        int play;
        int idx;

        public Song(String genre, int play, int idx) {
            this.genre = genre;
            this.play = play;
            this.idx = idx;
        }
    }
}
