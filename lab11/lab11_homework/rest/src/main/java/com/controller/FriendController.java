package com.controller;

import com.dao.UserDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import com.service.FriendInsertService;
import com.service.FriendReadService;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vital
 */
@RestController
@RequestMapping("/friends")
public class FriendController {

    @Autowired
    private FriendReadService readService;

    @Autowired
    private FriendInsertService insertService;

    @GetMapping
    public Map<String, List<User>> getFriends() throws SQLException {
        return readService.read();
    }

    @PostMapping
    public ResponseEntity<String> createFriendship(@RequestParam int userId, @RequestParam int friendId) throws SQLException {
        UserDAO userUtil = new UserDAO();
        if (userUtil.findById(userId) == null) {
            return new ResponseEntity<>(
                    "User not found", HttpStatus.NOT_FOUND); //or GONE
        }

        if (userUtil.findById(friendId) == null) {
            return new ResponseEntity<>(
                    "Friend not found", HttpStatus.NOT_FOUND); //or GONE
        }
        return insertService.insert(userId, friendId);
    }
}
