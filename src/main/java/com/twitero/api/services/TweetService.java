package com.twitero.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.twitero.api.dto.TwitterDTO;
import com.twitero.api.model.Tweet;
import com.twitero.api.model.User;
import com.twitero.api.repositories.TwitterRepository;
import com.twitero.api.repositories.UserRepository;


@Service
public class TweetService {
    
    @Autowired
    TwitterRepository Tweetrepository;

    @Autowired 
    UserRepository UserRepository;

    public Page<Tweet> getTweets(Pageable pageable){
        return Tweetrepository.findAllByOrderByIdDesc(pageable);
    }

    public Tweet createTweet(TwitterDTO data) {
        
        User user = UserRepository.findByUsername(data.username());
        String avatar = user.getAvatar();
        
        return Tweetrepository.save(new Tweet(data,avatar));
    }

    public List<Tweet> getTweetsByUserName(String username){
        return Tweetrepository.findByUsernameOrderByIdDesc(username);
    }
}
