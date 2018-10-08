package lingofx;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class WordList {

    public String[] wordList = new String[0];
    public File wordsFile = new File("wordList.txt");

    public String ReturnWord(String str) throws FileNotFoundException {
        FillArray();
        boolean bool = true;
        String woord = null;
        int num = (int )(Math.random() * (wordList.length-1));
        while (bool) {
            woord = wordList[num];
            if (!woord.equals(str)) {
                bool = false;
            }
        }
        return woord;
    }

    private void FillArray() throws FileNotFoundException {
        wordList = new String[0];
        Scanner scan = new Scanner(wordsFile);
        while (scan.hasNextLine()) {
            String word = scan.nextLine();
            AddWord(word);
        }
    }

    public void WriteFile(String str) throws IOException {
        FileWriter fw = new FileWriter(wordsFile);
        BufferedWriter bw = new BufferedWriter(fw);
        for (int i = 0; i < wordList.length; i++) {
            bw.write(wordList[i]);
            bw.newLine();
        }
        bw.write(str);
        bw.flush();
        bw.close();
        FillArray();
    }

    private void AddWord(String str) {
        wordList = Arrays.copyOf(wordList, wordList.length + 1);
        wordList[wordList.length - 1] = str;
    }
}
