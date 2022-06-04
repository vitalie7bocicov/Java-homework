package com.controller;

import java.sql.SQLException;
import java.util.List;
import com.service.InfluencerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vital
 */
@RestController
@RequestMapping("/influencers")
public class InfluencerController {

    @Autowired
    private InfluencerService influencerService;

    @GetMapping("/{id}")
    public List<String> read(@PathVariable int id) throws SQLException {
        return influencerService.getInfluencers(id);
    }
}
