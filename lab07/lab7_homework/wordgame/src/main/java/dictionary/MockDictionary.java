package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author vital
 */
public class MockDictionary implements Dictionary {

    private final Set<String> words = new HashSet<>();

    private void init() {
        try {
            File engDictionary = new File("dictionary.txt");
            try ( Scanner myReader = new Scanner(engDictionary)) {
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    words.add(data.toLowerCase());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public MockDictionary() {
        init();
    }

    @Override
    public boolean isWord(String str) {
        return words.contains(str);
    }
}
