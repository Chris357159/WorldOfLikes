package com.projetspring.WorldsOfLikes.controllers;

import com.projetspring.WorldsOfLikes.beans.*;
import com.projetspring.WorldsOfLikes.repositories.FormRepositoryInterface;
import com.projetspring.WorldsOfLikes.repositories.NetworkRepositoryInterface;
import com.projetspring.WorldsOfLikes.repositories.PostRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
    public SocialNetwork addUsername(@RequestBody Auxiliaire1 auxiliaire1){
    SocialNetwork socialNetwork=networkRepositoryInterface.findByLogin(formRepositoryInterface.findById(auxiliaire1.getId()));
    socialNetwork.setUsername(auxiliaire1.getUsername());
    networkRepositoryInterface.save(socialNetwork);
        return socialNetwork;
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
        SocialNetwork socialNetwork=networkRepositoryInterface.findByLogin(formRepositoryInterface.findById(auxliaire2.getId()));
       // SocialNetwork socialNetwork1=networkRepositoryInterface.findById(auxliaire2.getId());
        socialNetwork.setUserPhoto(auxliaire2.getUserPhoto());
        networkRepositoryInterface.save(socialNetwork);
        return socialNetwork;
    }

    @PostMapping("/sendPosts")
    public Post sendPosts(@RequestBody Auxiliaire3 auxiliaire3){
        Post post=new Post(auxiliaire3.getDate(), auxiliaire3.getContent(), auxiliaire3.getLikeCount(), auxiliaire3.getShareCount());
        postRepositoryInterface.save(post);
        SocialNetwork socialNetwork=networkRepositoryInterface.findByLogin(formRepositoryInterface.findById(auxiliaire3.getId()));
        socialNetwork.ajouterPost(post);
        networkRepositoryInterface.save(socialNetwork);
        return post;
    }

    @GetMapping("/getPosts/{id}")
    public SocialNetwork getPosts(@PathVariable int id){
        return networkRepositoryInterface.findById(id);
    }

    @GetMapping("/getAllUsers")
    public List<SocialNetwork> getAllUsers(){
        return networkRepositoryInterface.findAll();
    }

    @PostMapping("/sendRequest")
    public String sendRequest(@RequestBody Auxiliaire4 auxiliaire4){
        SocialNetwork socialNetwork=networkRepositoryInterface.findById(auxiliaire4.getId());
        SocialNetwork  socialNetwork1=networkRepositoryInterface.findById(auxiliaire4.getIdFollower());
        socialNetwork.getSubscriptions().add(socialNetwork1);
        socialNetwork1.getFollows().add(socialNetwork);
        networkRepositoryInterface.save(socialNetwork);
        networkRepositoryInterface.save(socialNetwork1);
        return "Ok";
    }

    @GetMapping("/getSubcriptions/{id}")
    public Set<SocialNetwork> getSubcriptions(@PathVariable int id){
        return networkRepositoryInterface.findById(id).getSubscriptions();
    }
   @GetMapping("/getFollows/{id}")
    public Set<SocialNetwork> getFollows(@PathVariable int id){
        return networkRepositoryInterface.findById(id).getFollows();
    }
    @GetMapping("/getSubscriptionsPost/{id}")
    public Set<SocialNetwork> getSubscriptionsPost(@PathVariable int id){

        Set<SocialNetwork> socialNetworkSet;
        socialNetworkSet=networkRepositoryInterface.findById(id).getSubscriptions();
        return socialNetworkSet;
    }

}
