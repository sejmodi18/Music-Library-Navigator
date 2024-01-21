package mpInterface;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class MPInterface {

	public static ArrayList<Collection> collections = new ArrayList<>();

	public static void main(String[] args) {

		Collection collection = new Collection("Collection 1", "Artist 1");

		collection.addMusic("Music 1", 5.5);
		collection.addMusic("Music 2", 4.5);
		collection.addMusic("Music 3", 3);
		collection.addMusic("Music 4", 2.5);

		collections.add(collection);

		collection = new Collection("Collection 2", "Artist 2");

		collection.addMusic("Music 1", 1.5);
		collection.addMusic("Music 2", 3.5);
		collection.addMusic("Music 3", 6);
		collection.addMusic("Music 4", 7.5);

		collections.add(collection);

		LinkedList<Music> List1 = new LinkedList();

		collections.get(0).addToList("Music 1", List1);
		collections.get(1).addToList("Music 2", List1);
		collections.get(0).addToList("Music 3", List1);
		collections.get(1).addToList("Music 4", List1);

		start(List1);

	}

	public static void chooseFrom() {
		System.out.println("******************** MUSIC PLAYER INTERFACE ***************\n" + "PRESS 1 FOR NEXT SONG \n"
				+ "PRESS 2 FOR PREVIOUS SONG \n" + "PRESS 3 TO DISPLAY ALL SONGS \n" + "PRESS 4 TO REPLAY SONG \n"
				+ "PRESS 5 FOR DELETE SONG \n" + "PRESS 6 TO DISPLAY MENU \n" + "PRESS 7 TO EXIT \n");
	}

	public static void start(LinkedList<Music> List) {
		Scanner sc = new Scanner(System.in);

		boolean stop = false;
		boolean next = true;

		ListIterator<Music> LI = List.listIterator();

		if (List.size() == 0)
			System.out.println("NO MUSIC AVAILABLE ******");
		else {
			System.out.println("CURRENT MUSIC : " + LI.next().toString());
			chooseFrom();
		}

		while (stop == false) {
			int select = sc.nextInt();

			switch (select) {
			case 1:
				if (next == false) {
					if (LI.hasNext()) {
						LI.next();
					}
					next = true;
				}
				if (LI.hasNext()) {
					System.out.println("Current Music : " + LI.next().toString());
				} else {
					System.out.println("Music not available");
					next = false;
				}
				break;
			case 2:
				if (next == true) {
					if (LI.hasPrevious()) {
						LI.previous();
					}
					next = false;
				}
				if (LI.hasPrevious()) {
					System.out.println("Current Music : " + LI.previous().toString());
				} else {
					System.out.println("Start of Playlist");
					next = false;
				}
				break;

			case 3:

				Iterator<Music> it = List.iterator();

				while (it.hasNext()) {

					System.out.println(
							"\n******************************\n" + it.next() + "\n******************************\n");
				}
				break;
			case 4:

				if (next == true) {
					if (LI.hasPrevious()) {
						System.out.println("Current Music " + LI.previous().toString());
						next = false;
					} else
						System.out.println("Start of LIST");

				} else {
					if (LI.hasNext()) {
						System.out.println("Current Music " + LI.next().toString());
						next = true;
					} else
						System.out.println("End of LIST");
				}
				break;
			case 5:

				if (List.size() > 0) {
					LI.remove();
					if (LI.hasNext()) {
						System.out.println("Current Music " + LI.next().toString());
					} else {
						if (LI.hasPrevious()) {
							System.out.println("Current Music " + LI.previous().toString());
						}
					}
				}
				break;
			case 6:
				chooseFrom();
				break;
			case 7:

				System.out.println("Thanks For Using The Music Player Interface");
				stop = true;
				break;
			}
		}

	}
}