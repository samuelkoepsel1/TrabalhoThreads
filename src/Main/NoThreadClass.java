package Main;

import java.io.IOException;
import java.util.Scanner;

import controller.SearchController;

public class NoThreadClass {

	public static void main(String[] args) throws IOException {
		Scanner word = new Scanner(System.in);
		System.out.println("Insert the word.");
		long start = System.currentTimeMillis();
		SearchController search = new SearchController("./src/dataset/", word.next());
		System.out.println(search.getWord() + " appear " + search.countWord() + " times.");
		System.out.println(System.currentTimeMillis() - start);
	}

}
