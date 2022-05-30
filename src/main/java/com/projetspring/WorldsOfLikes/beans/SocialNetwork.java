package com.projetspring.WorldsOfLikes.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class SocialNetwork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String userPhoto;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Post>posts=new ArrayList<>();
    @JsonIgnoreProperties("socialNetwork")
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Form login;
    private int isLoggedIn;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<SocialNetwork> friends;






    //constructeurs
   public SocialNetwork() {
   }
    public SocialNetwork(String username,int isLoggedIn) {
        this.username = username;
        this.isLoggedIn = isLoggedIn;
    }
    //getteurs/setteurs
    public int getIsLoggedIn() {
        return isLoggedIn;
    }

    public void setIsLoggedIn(int isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
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
        return isLoggedIn;
    }

    public void setLoggedIn(int loggedIn) {
        isLoggedIn = loggedIn;
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
