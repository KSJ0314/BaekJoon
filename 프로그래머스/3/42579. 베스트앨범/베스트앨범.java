import java.util.*;

class Solution {
	public class Music implements Comparable<Music>{
		int no, play;

		public Music(int no, int play) {
			super();
			this.no = no;
			this.play = play;
		}

		@Override
		public int compareTo(Music o) {
			if (this.play != o.play) return Integer.compare(this.play, o.play) * -1;
			return Integer.compare(this.no, o.no);
		}
	}
	
	public class Genre implements Comparable<Genre>{
		String genreStr;
		int play;
		
		public Genre(String genreStr, int play) {
			this.genreStr = genreStr;
			this.play = play;
		}
		
		@Override
		public int compareTo(Genre o) {
			if (this.play != o.play) return Integer.compare(this.play, o.play) * -1;
			return this.genreStr.compareTo(o.genreStr);
		}
	}
	
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genreMap = new HashMap<>();
        HashMap<String, TreeSet<Music>> musicMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
        	String genre = genres[i];
			genreMap.merge(genre, plays[i], Integer::sum);
			if (!musicMap.containsKey(genre)) {
				musicMap.put(genre, new TreeSet<>());
			}
			musicMap.get(genre).add(new Music(i, plays[i]));
		}
        ArrayList<Genre> genreList = new ArrayList<>();
        for (String key : genreMap.keySet()) {
			genreList.add(new Genre(key, genreMap.get(key)));
		}
        Collections.sort(genreList);
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int i = 0; i/2 < genreList.size(); i++) {
        	TreeSet<Music> music = musicMap.get(genreList.get(i/2).genreStr);
        	result.add(music.pollFirst().no);
        	if (i%2 == 0 && music.isEmpty()) i++;
		}
        
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}