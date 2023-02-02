package study.ahnabada.programmers.code.hash.베스트앨범;

import java.util.*;

public class Solution_sj {
    
    HashMap<String, Genre> genreMap = new HashMap<>();
    TreeSet<Genre> genreSet = new TreeSet<>();
    
    public int[] solution(String[] genres, int[] plays) {
        for (int i=0; i<genres.length; i++){
            String genreType = genres[i];
            int countOfPlay = plays[i];
                
            Genre genre = genreMap.get(genreType);    
            if (genre == null){
                genre = new Genre(genreType);
                genreMap.put(genreType, genre);
            }
            
            genre.add(new Song(i, countOfPlay));
        }
    
        genreSet.addAll( genreMap.values() );
 
        List<Integer> songIds = new ArrayList<>();
        for (Genre genre : genreSet){
            
            int c = 0;
            for (Song song : genre.getSongSet()){
                songIds.add(song.getId());    
                if (++c == 2)
                    break;
            }
            
        }
        
        int[] answer = new int[songIds.size()];
        for (int i=0; i<songIds.size(); i++){
            answer[i] = songIds.get(i);
        }
        
        return answer;
    }
    
    
    
    public static class Song implements Comparable<Song> {
        Song(int id, int playCount){
            this.id = id;
            this.playCount = playCount;
        }
        int id;
        int playCount;
        @Override
        public int compareTo(Song o){
            int sort = o.playCount - this.playCount;
            return sort == 0 ? this.id - o.id : sort;
        }
        public int getId(){
            return this.id;
        }
    }
    
    public static class Genre implements Comparable<Genre> {
        Genre(String genre){
            this.type = type;
            this.playCount = 0;
            this.songSet = new TreeSet<>();
        }
        String type;
        int playCount;
        TreeSet<Song> songSet;
        @Override
        public int compareTo(Genre o){
            return Integer.compare(o.playCount, this.playCount);
        }
        public void add(Song song){
            this.playCount += song.playCount;
            this.songSet.add(song);
        }
        public TreeSet<Song> getSongSet(){
            return this.songSet;
        }
    }
    
}