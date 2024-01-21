package mpInterface;

public class Music {
	String music_name;
	double music_time;

	public Music(String music_name, double music_time) {
		this.music_name = music_name;
		this.music_time = music_time;

	}

	public Music() {

	}

	@Override
	public String toString() {
		return "Music Name: " + music_name + " || " + "Time: " + music_time;
	}

	public double getTime() {
		return music_time;
	}

	public String getName() {
		return music_name;

	}
}
