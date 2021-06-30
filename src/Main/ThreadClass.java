package Main;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import controller.SearchController;

public class ThreadClass {

	public static void main(String[] args) throws InterruptedException {
		AtomicInteger count = new AtomicInteger();
		Scanner word = new Scanner(System.in);
		System.out.println("Insert the word.");
		SearchController search = new SearchController("./src/dataset/", word.next());
		long start = System.currentTimeMillis();
		int length = search.getFiles().length;
		Thread firstThread = new Thread(() -> {
			try {
                int a = search.countWord(0, length / 2);
                count.addAndGet(a);
            } catch (IOException e) {
                e.printStackTrace();
            }
		});
        Thread secondThread = new Thread(() -> {
            try {
                int a = search.countWord((length / 2), length);
                count.addAndGet(a);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        firstThread.start();
        secondThread.start();
        firstThread.join();
        secondThread.join();
        System.out.println(search.getWord() + " appear " + count + " times");
        System.out.println(System.currentTimeMillis() - start);
	}

}
