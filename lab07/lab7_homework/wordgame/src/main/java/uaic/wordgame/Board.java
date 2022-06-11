package uaic.wordgame;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author vital
 */
public class Board {

    private final Set<String> words = new HashSet<>();
    private final Map<String, Integer> players = new HashMap<>();

    public synchronized void addWord(Player player, String word) {
        words.add(word);
        System.out.println(player.getName() + ": " + word);
    }

    public Map<String, Integer> getPlayers() {
        return players;
    }

    public void setPlayer(String player) {
        players.put(player, 0);
    }

    public void setScore(String player, int score) {
        players.put(player, score);
    }

    public void showScore() {

        Map<String, Integer> winners = sortByValue(players);
        System.out.println("");
        System.out.println("Winners:");
        for (String player : winners.keySet()) {
            System.out.println(player + ": " + winners.get(player));
        }

    }

    @Override
    public String toString() {
        return words.toString();
    }

    private Map<String, Integer> sortByValue(Map<String, Integer> map) {

        List<Entry<String, Integer>> list = new LinkedList<>(map.entrySet());

        Collections.sort(list, (player1, player2) -> {
            return player2.getValue().compareTo(player1.getValue());
        });

        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
}
