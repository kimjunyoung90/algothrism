package 해시;

import java.util.*;

/**
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42579?language=java
 */
public class 베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<Play>> playsByGenre = new HashMap<>();
        Map<String, Integer> totalPlaysByGenre = new HashMap<>();

        //장르별 노래 분류
        for (int i = 0; i < plays.length; i++) {
            String genre = genres[i];
            List<Play> eachPlays = playsByGenre.getOrDefault(genre, new ArrayList<>());
            Play play = new Play(i, genre, plays[i]);
            eachPlays.add(play);
            playsByGenre.put(genre, eachPlays);
            totalPlaysByGenre.put(genre, totalPlaysByGenre.getOrDefault(genre, 0) + plays[i]);
        }

        //장르별 총 재생 수 기준으로 내림차순
        List<String> genreOrder = new ArrayList<>(playsByGenre.keySet());
        genreOrder.sort((a, b) -> totalPlaysByGenre.get(b) - totalPlaysByGenre.get(a));

        //장르별 노래 재생 수 최대 2곡 뽑기
        List<Integer> result = new ArrayList<>();
        for (String genre : genreOrder) {
            List<Play> songs = playsByGenre.get(genre);

            //장르 내 노려 종렬
            songs.sort(
                    Comparator.comparingInt((Play p) -> -p.plays)
                            .thenComparingInt(p -> p.id)
            );

            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                result.add(songs.get(i).id);
            }
        }


        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        베스트앨범 test = new 베스트앨범();
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] result = test.solution(genres, plays);
        System.out.println(Arrays.toString(result));
    }
}

class Play {
    int id;
    String genre;
    int plays;

    public Play(int id, String genre, int plays) {
        this.id = id;
        this.genre = genre;
        this.plays = plays;
    }
}