package day0508.list;

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
	
	public void go() {
		getSongs();
		System.out.println("비정렬 "+songList);
//		Collections.sort(songList);
		
		//songList.sort(null);
		System.out.println("정렬 "+songList);
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
