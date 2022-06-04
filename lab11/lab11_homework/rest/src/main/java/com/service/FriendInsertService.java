package com.service;

import com.dao.FriendsDAO;
import java.sql.SQLException;
import com.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author vital
 */
@Service
public class FriendInsertService {

    public ResponseEntity<String> insert(int user, int friend) throws SQLException {
        FriendsDAO friendUtil = new FriendsDAO();
        friendUtil.create(user, friend);
        return new ResponseEntity<>(
                "Friendship created successfully", HttpStatus.CREATED);
    }
}
