package com.projetspring.WorldsOfLikes.controllers;

import com.projetspring.WorldsOfLikes.beans.*;
import com.projetspring.WorldsOfLikes.repositories.UserDataRepositoryInterface;
import com.projetspring.WorldsOfLikes.repositories.UserProfileRepositoryInterface;
import com.projetspring.WorldsOfLikes.repositories.PostRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/Network")
public class Controller_UserProfile {
    @Autowired
    private UserProfileRepositoryInterface userProfileRepositoryInterface;
    @Autowired
    private UserDataRepositoryInterface userDataRepositoryInterface;
    @Autowired
    private PostRepositoryInterface postRepositoryInterface;

    @PostMapping("/ModifyUsername")
    public String ModifyUsername(@RequestBody Auxiliaire1 auxiliaire1){
    UserProfile userProfile = userProfileRepositoryInterface.findByLogin(userDataRepositoryInterface.findById(auxiliaire1.getId()));
    userProfile.setUsername(auxiliaire1.getUsername());
    userProfileRepositoryInterface.save(userProfile);
        return "oK";
    }

    @GetMapping("/sendUsername/{id}")
    public UserProfile sendUsername(@PathVariable int id)
    {
        return userProfileRepositoryInterface.findById(id);
    }

    @GetMapping("/sendUserProfilePhoto/{id}")
    public UserProfile sendUserProfilePhoto(@PathVariable int id){
        return userProfileRepositoryInterface.findById(id);
    }

    @PostMapping("/ModifyUserProfilePhoto")
    public UserProfile ModifyUsernamePhoto(@RequestBody Auxiliaire2 auxliaire2){
        UserProfile userProfile = userProfileRepositoryInterface.findByLogin(userDataRepositoryInterface.findById(auxliaire2.getId()));
       // SocialNetwork socialNetwork1=networkRepositoryInterface.findById(auxliaire2.getId());
        userProfile.setUserPhoto(auxliaire2.getUserPhoto());
        userProfileRepositoryInterface.save(userProfile);
        return userProfile;
    }

    @PostMapping("/sendPosts")
    public Post sendPosts(@RequestBody Auxiliaire3 auxiliaire3){
        Post post=new Post(auxiliaire3.getDate(), auxiliaire3.getContent(), auxiliaire3.getLikeCount(), auxiliaire3.getShareCount());
        postRepositoryInterface.save(post);
        UserProfile userProfile = userProfileRepositoryInterface.findByLogin(userDataRepositoryInterface.findById(auxiliaire3.getId()));
        userProfile.ajouterPost(post);
        userProfileRepositoryInterface.save(userProfile);
        return post;
    }

    @GetMapping("/getPosts/{id}")
    public UserProfile getPosts(@PathVariable int id){
        return userProfileRepositoryInterface.findById(id);
    }

    @GetMapping("/getAllUsers")
    public List<UserProfile> getAllUsers(){
        return userProfileRepositoryInterface.findAll();
    }

    @PostMapping("/sendRequest")
    public int sendRequest(@RequestBody Auxiliaire4 auxiliaire4){
        UserProfile userProfile = userProfileRepositoryInterface.findById(auxiliaire4.getId());
        UserProfile userProfile1 = userProfileRepositoryInterface.findById(auxiliaire4.getIdFollower());
        userProfile.getSubscriptions().add(userProfile1);
        userProfile1.getFollows().add(userProfile);
        userProfileRepositoryInterface.save(userProfile);
        userProfileRepositoryInterface.save(userProfile1);
        return userProfile1.getFollows().size();
    }


    @GetMapping("/getSubcriptions/{id}")
    public Set<UserProfile> getSubcriptions(@PathVariable int id){
        return userProfileRepositoryInterface.findById(id).getSubscriptions();
    }
   @GetMapping("/getFollows/{id}")
    public Set<UserProfile> getFollows(@PathVariable int id){
        return userProfileRepositoryInterface.findById(id).getFollows();
    }
    @GetMapping("/getSubscriptionsPost/{id}")
    public Set<UserProfile> getSubscriptionsPost(@PathVariable int id){

        Set<UserProfile> userProfileSet;
        userProfileSet = userProfileRepositoryInterface.findById(id).getSubscriptions();
        return userProfileSet;
    }
    @PostMapping("/handleLikes")
    public Post handleLikes(@RequestBody Auxiliaire6 auxiliaire6){
       Post post= postRepositoryInterface.findById(auxiliaire6.getId());
       UserProfile userProfile = userProfileRepositoryInterface.findById(auxiliaire6.getIdLogin());
        int likeCount=0;
        int likeGlobal= userProfile.getLikes()+10;
       if(auxiliaire6.getIsLike()==1){
           likeCount=post.getLikeCount()+10;
           userProfile.setLikes(likeGlobal);
       }
       else {
           likeCount=post.getLikeCount()-10;
       }
       post.setLikeCount(likeCount);
       postRepositoryInterface.save(post);
       return post;
    }
    @GetMapping("/getLikes/{id}")
    public int getLikes(@PathVariable int id){
        return userProfileRepositoryInterface.findById(id).getLikes();
    }


}
