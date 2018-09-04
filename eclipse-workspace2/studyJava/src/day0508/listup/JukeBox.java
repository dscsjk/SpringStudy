package day0508.listup;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class JukeBox {
	//제목을 담을 어레이
	//ArrayList<String> songList = new ArrayList<String>();
	ArrayList<Song> songList = new ArrayList<>();
	
	public void go(int type) {
		
		getSongs();
		// 익명 함수식 구현
		Comparator<Song> compType = new Comparator<>() {
			public int compare(Song one, Song two) {
				switch(type) {
				case 1:
					return one.getTitle().compareTo(two.getTitle());
				case 2:
					return one.getArtist().compareTo(two.getArtist());
				case 3:
					return one.getRating().compareTo(two.getRating());
				case 4:
					return one.getBpm().compareTo(two.getBpm());
				default:
					return 0;
				}
			}
		};
		Collections.sort(songList, compType);
		System.out.println("정렬타입["+type+"]"+songList);
		
		/*
		ArtistCompare artistCompare = new ArtistCompare();
		Collections.sort(songList, artistCompare);
		System.out.println("아티스트정렬 "+songList);

		//람다식표현
		Comparator<Song> ramdaArtistCom = (Song one, Song two)->{
			return one.getArtist().compareTo(two.getArtist());
		};
		Collections.sort(songList, ramdaArtistCom);
		System.out.println("람다식 아티스트정렬 "+songList);
		*/
	}
	public void getSongs() {
		//1.
		try {
			File file = new File("C:\\jukebox.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while((line=reader.readLine())!=null){
				
				addSong(line);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	public void addSong(String lineToParse) {
		//2.
		String[] tokens = lineToParse.split("/");
		songList.add(new Song(tokens[0],tokens[1],tokens[2],tokens[3]));
	}

}
