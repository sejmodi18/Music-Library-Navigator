package mpInterface;

import java.util.ArrayList;
import java.util.LinkedList;

public class Collection {
	String album_name;
	String album_creator;
	ArrayList<Music> music;

	public Collection(String album_name, String album_creator) {
		this.album_name = album_name;
		this.album_creator = album_creator;
		this.music = new ArrayList<Music>();
	}

	public Collection() {

	}

	public boolean addMusic(String music_name, double music_time) {
		if (findMusic(music_name) == null) {
			music.add(new Music(music_name, music_time));
			System.out.println("\n MUSIC IS ADDED ");
			return true;
		} else {
			System.out.println("\n " + music_name + " IS ALREADY PRESENT");
			return false;
		}
	}

	public Music findMusic(String music_name) {
		for (Music verify : music) {
			if (verify.getName().equals(music_name))
				return verify;
		}
		return null;
	}

	public boolean addToList(String music_name, LinkedList<Music> List) {

		for (Music verify : this.music)
			if (verify.getName().equals(music_name)) {
				List.add(verify);
				System.out.println("\n MUSIC IS ADDED ");
				return true;
			}
		System.out.println("\n " + music_name + " NOT FOUND");
		return false;
	}

	public boolean addToList(int order, LinkedList<Music> List) {
		int position = order - 1;

		if (position <= this.music.size() && position > 0) {
			List.add(this.music.get(position));
			return true;
		} else {
			System.out.println("ORDER IS INVALID");
			return false;
		}
	}
}