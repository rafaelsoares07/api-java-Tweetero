package com.twitero.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twitero.api.dto.TwitterDTO;
import com.twitero.api.model.Tweet;
import com.twitero.api.services.TweetService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/tweets") 

public class TweetController {

    @Autowired
    TweetService tweetService;
    
    @GetMapping
    public List<Tweet> getTweets(){
        return tweetService.getTweets();
    }

    @PostMapping
    public Tweet createTweet(@RequestBody TwitterDTO data){
        return tweetService.createTweet(data);
    }

    @GetMapping("/{username}")
    public List<Tweet> getTweetsByUserName(@PathVariable String username){
        
        return tweetService.getTweetsByUserName(username);
    }
}
