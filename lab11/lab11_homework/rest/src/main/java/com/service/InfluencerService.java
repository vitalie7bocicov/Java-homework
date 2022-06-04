package com.service;

import com.dao.FriendsDAO;
import com.dao.UserDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import com.model.User;
import org.springframework.stereotype.Service;

/**
 *
 * @author vital
 */
@Service
public class InfluencerService {

    public List<String> getInfluencers(int k) throws SQLException {
        FriendsDAO friendsUtil = new FriendsDAO();
        UserDAO userUtil = new UserDAO();
        Map<Integer, Integer> friends = friendsUtil.countFriends();
        Map<Integer, Integer> result = friends.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        List<String> influencers = new ArrayList<>();

        String influencer;
        int counter = 0;
        for (Integer user : result.keySet()) {
            influencer = "(id=" + user + ") " + userUtil.findById(user).getName() + " has " + result.get(user) + " friends.";
            influencers.add(influencer);
            counter++;
            if (counter == k) {
                break;
            }
        }
        return influencers;

    }
}
