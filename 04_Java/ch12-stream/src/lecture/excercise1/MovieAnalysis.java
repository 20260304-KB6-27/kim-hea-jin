package lecture.excercise1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MovieAnalysis {
  public static void main(String[] args) {
    List<Movie> movies = Arrays.asList(
            new Movie("인셉션", "SF", 2010, 8.8),
            new Movie("어벤져스", "액션", 2012, 8.0),
            new Movie("기생충", "드라마", 2019, 8.6),
            new Movie("매트릭스", "SF", 1999, 8.7),
            new Movie("인터스텔라", "SF", 2014, 8.6),
            new Movie("다크나이트", "액션", 2008, 9.0),
            new Movie("어바웃타임", "로맨스", 2013, 8.3),
            new Movie("라라랜드", "뮤지컬", 2016, 8.1)
    );

    // 1. 장르가 "SF"인 영화의 평균 평점 구하기
    // 결과 : 약 8.7
    double averageRating = movies.stream()
            .filter(movie -> "SF".equals(movie.getGenre()))
            .mapToDouble(movie -> movie.getRating())
            .average()
            .orElse(0.0);
    System.out.println("1. " + averageRating);

    // 2. 2010년 이후 개봉된 영화를 평점 내림차순으로 정렬하여 제목 리스트를 반환하기
    // 결과 : [인셉션, 기생충, 인터스텔라, 어바웃타임, 라라랜드, 어벤져스]
    List<String> sortedMovies = movies.stream()
            .filter(movie -> movie.getReleaseYear() > 2010)
            .sorted((m1, m2) -> Double.compare(m2.getRating(), m1.getRating()))
            .map(movie -> movie.getTitle())
            .collect(Collectors.toList());
    System.out.println("2. " + sortedMovies);

    // 3. 가장 최근에 개봉된 영화 3개의 제목을 반환하기
    //  결과 : [기생충, 라라랜드, 인터스텔라]
    List<String> lastMovies = movies.stream()
            .sorted((m1, m2) -> Integer.compare(m2.getReleaseYear(), m1.getReleaseYear()))
            .limit(3)
            .map(movie -> movie.getTitle())
            .collect(Collectors.toList());
    System.out.println("3. " + lastMovies);

    // 4. 각 장르별로 영화를 그룹화하고, 장르별 영화 수를 맵으로 반환하기
    // 결과 : {SF=3, 액션=2, 드라마=1, 로맨스=1, 뮤지컬=1}
    Map<String, Long> groupMovies = movies.stream()
            .collect(Collectors.groupingBy(
                    movie -> movie.getGenre(),
                    Collectors.counting()
            ));
    System.out.println("4. " + groupMovies);

    // 5. 평점이 8.5 이상인 영화들의 장르를 중복 없이 알파벳 순으로 정렬하여 반환하기
    // 결과 : [SF, 드라마, 액션]
    List<String> sortedGenres = movies.stream()
            .filter(movie -> movie.getRating() >= 8.5)
            .map(movie -> movie.getGenre())
            .distinct()
            .sorted()
            .collect(Collectors.toList());
    System.out.println("5. " + sortedGenres);
  }
}