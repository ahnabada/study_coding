package study.ahnabada.programmers.code.hash.베스트앨범;

import java.util.*;
import java.util.stream.Collectors;

class Solution_jh {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genre_cnt = new HashMap<>();
        Map<String, TreeSet<Song>> song_selected = new HashMap<>();
        TreeSet<Genre> genre_tree;
        List<Integer> result = new ArrayList<>();

        for(int i =0; i < genres.length; i++){
            genre_cnt.put(genres[i], plays[i] + genre_cnt.getOrDefault(genres[i], 0));
            TreeSet<Song> temp = song_selected.getOrDefault(genres[i], new TreeSet<>());
            temp.add(new Song(i, plays[i]));
            song_selected.put(genres[i], temp);
        }
        genre_tree = (TreeSet<Genre>) genre_cnt.entrySet().stream().map(e->new Genre(e.getKey(), e.getValue())).collect(Collectors.toCollection(TreeSet::new));


        for(Genre genre: genre_tree){
            TreeSet<Song> selected = song_selected.get(genre.getName());
            Iterator itr = selected.iterator();
            int cnt = 0;
            while(itr.hasNext()){
                cnt++;
                result.add(((Song)itr.next()).getSong());
                if(cnt == 2) break;
            }
        }

        return result.stream().mapToInt(i->i).toArray();
    }

    class Genre implements Comparable<Genre> {
        private String name;
        private Integer plays;

        public Genre(String name, Integer plays){
            this.name = name;
            this.plays = plays;
        }
        public String getName(){
            return name;
        }

        @Override
        public int compareTo(Genre s){
            return -1*Integer.compare(plays, s.plays);
        }
    }

    class Song implements Comparable<Song> {
        private Integer song;
        private Integer plays;

        public Song(Integer song, Integer plays){
            this.song = song;
            this.plays = plays;
        }
        public Integer getSong(){
            return song;
        }
        @Override
        public int compareTo(Song s){
            if(s.plays < plays){
                return -1;
            } else if(s.plays > plays){
                return 1;
            }
            if(s.song < song){
                return 1;
            } else if(s.song > song){
                return -1;
            }
            return 0;
        }
    }
}
