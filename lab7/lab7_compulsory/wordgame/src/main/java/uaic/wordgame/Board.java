package uaic.wordgame;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author vital
 */
public class Board {

    private final Set<String> words = new HashSet<>() ;
    
    
    public synchronized void addWord(Player player, String word) {
        words.add(word);
        System.out.println(player.getName() + ": " + word);
    }

    @Override
    public String toString() {
        return words.toString();
    }
}
