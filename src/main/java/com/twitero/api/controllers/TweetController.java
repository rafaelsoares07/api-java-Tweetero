package com.twitero.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public List<Tweet> getTweets(@RequestParam String page){
        int numPage = Integer.parseInt(page);
        Pageable sortedByIdDesc = PageRequest.of(numPage, 5, Sort.by("id").descending());
        return tweetService.getTweets(sortedByIdDesc).getContent();
    }

    @PostMapping
    public ResponseEntity<Tweet> createTweet(@RequestBody TwitterDTO data){
        
        Tweet tweet = tweetService.createTweet(data);

        if(tweet!=null){
            return ResponseEntity.status(201).build();
        }else{
            return ResponseEntity.noContent().build();
        }

    }

    @GetMapping("/{username}")
    public List<Tweet> getTweetsByUserName(@PathVariable String username){
        
        return tweetService.getTweetsByUserName(username);
    }
}
