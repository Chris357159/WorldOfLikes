package com.projetspring.WorldsOfLikes.controllers;

import com.projetspring.WorldsOfLikes.beans.Post;
import com.projetspring.WorldsOfLikes.beans.SocialNetwork;
import com.projetspring.WorldsOfLikes.repositories.FormRepositoryInterface;
import com.projetspring.WorldsOfLikes.repositories.NetworkRepositoryInterface;
import com.projetspring.WorldsOfLikes.repositories.PostRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Network")
public class Controller_SocialNetwork {
    @Autowired
    private NetworkRepositoryInterface networkRepositoryInterface;
    @Autowired
    private FormRepositoryInterface formRepositoryInterface;
    @Autowired
    private PostRepositoryInterface postRepositoryInterface;
    @PostMapping("/ModifyUsername")
    public SocialNetwork addUsername(@RequestBody SocialNetwork socialNetwork){
    SocialNetwork socialNetwork1=networkRepositoryInterface.findById(socialNetwork.getId());
    socialNetwork1.setUsername(socialNetwork.getUsername());
    networkRepositoryInterface.save(socialNetwork1);
        return socialNetwork1;
    }
    @PostMapping("/sendUsername")
    public SocialNetwork sendUsername(@RequestBody int id)
    {
        return networkRepositoryInterface.findById(id);
    }

    @PostMapping("/sendUserProfilePhoto")
    public SocialNetwork sendUserProfilePhoto(@RequestBody int id){
        return networkRepositoryInterface.findById(id);
    }
    @PostMapping("/ModifyUserProfilePhoto")
    public String ModifyUsernamePhoto(@RequestBody SocialNetwork socialNetwork){
        SocialNetwork socialNetwork1=networkRepositoryInterface.findById(socialNetwork.getId());
        socialNetwork1.setUserPhoto(socialNetwork.getUserPhoto());
        networkRepositoryInterface.save(socialNetwork1);
        System.out.println(socialNetwork);
        return "Ok";
    }
    @PostMapping("/sendPosts")
    public Post sendPosts(@RequestBody Post post){
        postRepositoryInterface.save(post);
        SocialNetwork socialNetwork=networkRepositoryInterface.findById(1);
        socialNetwork.ajouterPost(post);
        networkRepositoryInterface.save(socialNetwork);
        return post;
    }
    @PostMapping("/getPosts")
    public List<Post>getPosts(@RequestBody int id){
        SocialNetwork socialNetwork=networkRepositoryInterface.findById(id);
        return socialNetwork.getPosts();
    }
    @GetMapping("/recupAll")
    public SocialNetwork recupAll(){
        return networkRepositoryInterface.findById(1);
    }

}
