package com.projetspring.WorldsOfLikes.beans;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@JsonIgnoreProperties({"follows","subscriptions","posts"})
@Entity
public class SocialNetwork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String userPhoto;
    private int isLogged;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Post>posts;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Form login;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<SocialNetwork> subscriptions;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<SocialNetwork> follows;


    //constructeurs
    public SocialNetwork() {
    }
    public SocialNetwork(String username,int isLogged) {
        this.username = username;
        this.isLogged = isLogged;
    }
    //getteurs/setteurs
    public Set<SocialNetwork> getFollows() {
        return follows;
    }

    public void setFollows(Set<SocialNetwork> follows) {
        this.follows = follows;
    }
    public Set<SocialNetwork> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Set<SocialNetwork> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public int getIsLogged() {
        return isLogged;
    }

    public void setIsLogged(int isLogged) {
        this.isLogged = isLogged;
    }
    public Form getLogin() {
        return login;
    }

    public void setLogin(Form login) {
        this.login = login;
    }
    public List<Post> getPosts() {
      return posts;
   }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
    public int isLoggedIn() {
        return isLogged;
    }

    public void setLoggedIn(int loggedIn) {
        isLogged = loggedIn;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Post> getPost() {
        return posts;
    }

    public void setPost(List<Post> posts) {
        this.posts = posts;
    }
    //suppliments
    public void ajouterPost(Post post1){
        posts.add(post1);
    }
    @Override
    public String toString() {
        return "SocialNetwork{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", post=" + posts +
                '}';
    }
}
