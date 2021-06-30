package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class SearchController {
    String path;
    File folder;
    String word;

    public SearchController(String path, String word) {
        this.path = path;
        this.folder = new File(path);
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public int countWord() throws IOException {
        int counter = 0;
        File[] files = this.getFiles();
        for (File file : files) {
            if (file.isFile()) {
                BufferedReader abc = new BufferedReader(new FileReader(this.path + file.getName()));
                String line;
                while ((line = abc.readLine()) != null) {
                    if (line.equals(this.word)) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

    public int countWord(int start, int end) throws IOException {
        int counter = 0;
        File[] files = this.getFiles();
        File[] slices = Arrays.copyOfRange(files, start, end);
        for (File file : slices) {
            if (file.isFile()) {
                BufferedReader abc = new BufferedReader(new FileReader(this.path + file.getName()));
                String line;
                while ((line = abc.readLine()) != null) {
                    if (line.equals(this.word)) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

    public String getPath() {
        return this.path;
    }

    public File[] getFiles() {
        return this.folder.listFiles();
    }
}
