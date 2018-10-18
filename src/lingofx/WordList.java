package lingofx;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


/*
    het doel van deze class is om het text bestand wordlist in te lezen en in een array te dumpen
    deze array kan dan gebruikt worden in andere classes zoals lingoview
    echter omdat de array niet word opgeslagen in lingo view is er de functie ReturnWord() om de array in deze class in te lezen en dan een woord hiervan te returnen
*/
public class WordList {

    public String[] wordList = new String[0];
    public File wordsFile = new File("wordList.txt");

    //returnt een random woord van het text bestand
    //de functie checkt voor een woord zodat deze niet wordt mee gegeven
    //dit voorkomt dat er 2x het zelfde woord achter mekaar gevraagd kan worden
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

    //het text bestand word ingelezen per regel en stopt dit dan in een string array
    private void FillArray() throws FileNotFoundException {
        wordList = new String[0];
        Scanner scan = new Scanner(wordsFile);
        while (scan.hasNextLine()) {
            String word = scan.nextLine();
            AddWord(word);
        }
    }

    //hierdoor is het mogelijk om binnen de applicatie het textbestand aan te passen zonder dat de orginele lijst wordt verweidert en zonder het text bestand te openen
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

    //dit vergroot de array met 1 en stopt daar een nieuw woord in zodat de array (tot de max) oneindig vergroot kan worden
    private void AddWord(String str) {
        wordList = Arrays.copyOf(wordList, wordList.length + 1);
        wordList[wordList.length - 1] = str;
    }
}
