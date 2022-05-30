package com.projetspring.WorldsOfLikes.controllers;

import com.projetspring.WorldsOfLikes.beans.*;
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
    public SocialNetwork addUsername(@RequestBody Auxliaire1 auxliaire1){
    SocialNetwork socialNetwork1=networkRepositoryInterface.findById(auxliaire1.getId());
    socialNetwork1.setUsername(auxliaire1.getUsername());
    networkRepositoryInterface.save(socialNetwork1);
        return socialNetwork1;
    }
    @GetMapping("/sendUsername/{id}")
    public SocialNetwork sendUsername(@PathVariable int id)
    {
        return networkRepositoryInterface.findById(id);
    }

    @GetMapping("/sendUserProfilePhoto/{id}")
    public SocialNetwork sendUserProfilePhoto(@PathVariable int id){
        return networkRepositoryInterface.findById(id);
    }
    @PostMapping("/ModifyUserProfilePhoto")
    public SocialNetwork ModifyUsernamePhoto(@RequestBody Auxiliaire2 auxliaire2){
        SocialNetwork socialNetwork1=networkRepositoryInterface.findById(auxliaire2.getId());
        socialNetwork1.setUserPhoto(auxliaire2.getUserPhoto());
        networkRepositoryInterface.save(socialNetwork1);
        return socialNetwork1;
    }
    @PostMapping("/sendPosts")
    public Post sendPosts(@RequestBody Auxliaire3 auxliaire3){
        Post post=new Post(auxliaire3.getDate(),auxliaire3.getContent(),auxliaire3.getLikeCount(),auxliaire3.getShareCount());
        postRepositoryInterface.save(post);
        SocialNetwork socialNetwork=networkRepositoryInterface.findById(1);
        socialNetwork.ajouterPost(post);
        networkRepositoryInterface.save(socialNetwork);
        return post;
    }
    @GetMapping("/getPosts/{id}")
    public List<Post> getPosts(@PathVariable int id){
        SocialNetwork socialNetwork=networkRepositoryInterface.findById(id);
        //Post post=socialNetwork.getPosts().get(0);
        return socialNetwork.getPosts();
    }
    @GetMapping("/recupAll")
    public SocialNetwork recupAll(){
        return networkRepositoryInterface.findById(1);
    }

    @GetMapping("/getAllUsers")
    public List<SocialNetwork> getAllUsers(){
        return networkRepositoryInterface.findAll();
    }
}
