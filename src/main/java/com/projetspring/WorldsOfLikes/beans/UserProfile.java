package com.projetspring.WorldsOfLikes.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
@JsonIgnoreProperties({"follows","subscriptions","posts","login"})
@Entity
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String userPhoto;
    private int isLogged;
    private int likes;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Post>posts;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private UserData login;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<UserProfile> subscriptions;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<UserProfile> follows;


    //constructeurs
    public UserProfile() {
    }
    public UserProfile(String username, int isLogged) {
        this.username = username;
        this.isLogged = isLogged;
    }

    public UserProfile(String username, String userPhoto, int isLogged, int likes, UserData login) {
        this.username = username;
        this.userPhoto = userPhoto;
        this.isLogged = isLogged;
        this.likes = likes;
        this.login = login;
    }

    //getteurs/setteurs
    public Set<UserProfile> getFollows() {
        return follows;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setFollows(Set<UserProfile> follows) {
        this.follows = follows;
    }
    public Set<UserProfile> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Set<UserProfile> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public int getIsLogged() {
        return isLogged;
    }

    public void setIsLogged(int isLogged) {
        this.isLogged = isLogged;
    }
    public UserData getLogin() {
        return login;
    }

    public void setLogin(UserData login) {
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
