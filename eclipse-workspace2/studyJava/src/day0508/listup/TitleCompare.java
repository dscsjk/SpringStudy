package day0508.listup;

import java.util.Comparator;

public class TitleCompare implements Comparator<Song>{

	@Override
	public int compare(Song one, Song two) {
		return one.getTitle().compareTo(two.getTitle());
	}
}	

class ArtistCompare implements Comparator<Song>{

	@Override
	public int compare(Song one, Song two) {
		return one.getArtist().compareTo(two.getArtist());
	}
}	


